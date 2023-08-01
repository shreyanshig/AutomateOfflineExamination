/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import dto.IVDTO;
import dto.StudentDTO;
import dto.StudentDetails;
import dto.Subjects;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

/**
 *
 * @author Shreyanshi
 */
public class IVAppDAO
{
    private static PreparedStatement ps1, ps2, ps3, ps4, ps5, ps6, ps7, ps8, ps9, ps10;
    static
    {
        try
        {
            ps1 = DBConnection.getConnection().prepareStatement("Select * from Invigilators where username=? and password=?");
            ps2 = DBConnection.getConnection().prepareStatement("Select * from Student where roll_no=?");
            ps3 = DBConnection.getConnection().prepareStatement("Insert into Student values(?,?,?,?,?,?,?,?,?)");
            ps4 = DBConnection.getConnection().prepareStatement("Select subject from Student_subject where roll_no=? and exam_date=?");
            ps5 = DBConnection.getConnection().prepareStatement("Select sheet_no from Student_answersheet where roll_no=? and subject=?");
            ps6 = DBConnection.getConnection().prepareStatement("Insert into Student_answersheet values(?,?,?)");
            ps7 = DBConnection.getConnection().prepareStatement("Select inv_cred from incorrect_cred where username=?");
            ps8 = DBConnection.getConnection().prepareStatement("Delete from incorrect_cred where username=?");
            ps9 = DBConnection.getConnection().prepareStatement("Insert into incorrect_cred values(?,?)");
            ps10 = DBConnection.getConnection().prepareStatement("Insert into Student_subject values(?,?,?)");
        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Some exception occured in IVAppDAO while creating statement and preparedstatement"+ex);
        }
    }
    public static boolean searchInvig(IVDTO invig) throws SQLException
    {
        ps1.setString(1, invig.getUsername());
        ps1.setString(2, invig.getPassword());
        System.out.println("IVAppDao"+" "+invig.getUsername()+" "+invig.getPassword());
        ResultSet rs = ps1.executeQuery();
        if(rs.next())
            return true;
        return false;
    }
    public static boolean searchStudent(StudentDTO student) throws SQLException
    {
        ps2.setString(1, student.getRoll_no());
        ResultSet rs = ps2.executeQuery();
        if(rs.next())
            return true;
        return false;
    }
    public static boolean addStudent(StudentDTO student) throws SQLException
    {
        ps3.setString(1, student.getRoll_no());
        ps3.setString(2, student.getName());
        ps3.setString(3, student.getGrade());
        ps3.setString(4, student.getBoard());
        ps3.setString(5, student.getCenter_id());
        ps3.setString(6, student.getSchool());
        ps3.setString(7, student.getFather_name());
        ps3.setString(8, student.getMother_name());
        ps3.setBinaryStream(9, student.getPhoto());
        return ps3.executeUpdate() != 0;
    }
    public static StudentDetails getDetailsByRoll_No(String roll_no) throws Exception
    {
        ps2.setString(1, roll_no);
        ResultSet rs = ps2.executeQuery();
        StudentDetails student = new StudentDetails();
        Blob blob;
        InputStream inputStream;
        byte[] buffer;
        byte[] imageBytes;
        int byteRead;
        String base64Image;
        ByteArrayOutputStream outputStream;
        if(rs.next()){
            blob = rs.getBlob(9);
            inputStream = blob.getBinaryStream();
            outputStream = new ByteArrayOutputStream();
            buffer = new byte[4096];
            byteRead = -1;
            while((byteRead = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, byteRead);
            }
            imageBytes = outputStream.toByteArray();
            Base64.Encoder en = Base64.getEncoder();
            base64Image = en.encodeToString(imageBytes);
            student.setPhoto(base64Image);
            student.setRoll_no(rs.getString(1));
            student.setName(rs.getString(2));
            student.setGrade(rs.getString(3));
            student.setBoard(rs.getString(4));
            student.setCenter_id(rs.getString(5));
            student.setSchool(rs.getString(6));
            student.setFather_name(rs.getString(7));
            student.setMother_name(rs.getString(8));
        }
        return student;
    }
    public static String getSubjectByRoll_No(String roll_no, String exam_date) throws SQLException
    {
        ps4.setString(1, roll_no);
        ps4.setString(2, exam_date);
        ResultSet rs = ps4.executeQuery();
        if(rs.next())
            return rs.getString(1);
        return "no";
    }
    public static boolean searchGivenSubject(String roll_no, String subject)throws SQLException
    {
        ps5.setString(1, roll_no);
        ps5.setString(2, subject);
        ResultSet rs = ps5.executeQuery();
        if(rs.next())
            return true;
        return false;
    }
    public static boolean addSheet(String roll_no, String subject, String sheet_no)throws SQLException
    {
        ps6.setString(1, roll_no);
        ps6.setString(2, subject);
        ps6.setString(3, sheet_no);
        return ps6.executeUpdate() == 1;
    }
    public static int addInvCredDetail(String username)throws SQLException
    {
        ps7.setString(1, username);
        ResultSet rs = ps7.executeQuery();
        System.out.println("retrieved the num");
        if(rs.next()){
            int num = rs.getInt(1);
            ps8.setString(1, username);
            ps8.executeUpdate();
            System.out.println("deleted the entry");
            ps9.setString(1, username);
            ps9.setInt(2, num+1);
            ps9.executeUpdate();
            System.out.println("inserted upadetd value");
            return num+1;
        }
        else{
            ps9.setString(1, username);
            ps9.setInt(2, 1);
            ps9.executeUpdate();
            return 1;
        }
    }
    public static void removeInvCred(String username)throws SQLException
    {
        ps8.setString(1, username);
        ps8.executeUpdate();
    }
    public static boolean addSubjects(Subjects subArr[])throws SQLException
    {
        for(Subjects s : subArr){
            ps10.setString(1, s.getRoll_no());
            ps10.setString(2, s.getS());
            ps10.setString(3, s.getD());
            if(ps10.executeUpdate() == 0)
                return false;
        }
        return true;
    }
}
