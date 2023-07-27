/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import dto.EVStudentDTO;
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
public class EVAppDAO
{
    private static PreparedStatement ps1, ps2, ps3, ps4, ps5;
    static
    {
        try
        {
            ps1 = DBConnection.getConnection().prepareStatement("Select * from Evaluators where username=? and password=?");
            ps2 = DBConnection.getConnection().prepareStatement("Select roll_no from Student_answersheet where sheet_no=?");
            ps3 = DBConnection.getConnection().prepareStatement("Select subject from Student_answersheet where sheet_no=?");
            ps4 = DBConnection.getConnection().prepareStatement("Select photo,board from Student where roll_no=?");
            ps5 = DBConnection.getConnection().prepareStatement("Insert into Student_marks values(?,?,?)");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            System.out.println("Some exception occured in EVAppDAO while creating statement and preparedstatement"+ex);
        }
    }
    public static boolean searchEvaluator(String username, String password)throws SQLException
    {
        ps1.setString(1, username);
        ps1.setString(2, password);
        ResultSet rs = ps1.executeQuery();
        if(rs.next())
            return true;
        return false;
    }
    public static String searchStudent(String sheet_no)throws SQLException
    {
        ps2.setString(1, sheet_no);
        ResultSet rs = ps2.executeQuery();
        if(rs.next())
            return rs.getString(1);
        return "no";
    }
    public static EVStudentDTO getStudentDetails(String roll_no, String sheet_no)throws Exception
    {
        ps3.setString(1, sheet_no);
        ResultSet rs = ps3.executeQuery();
        rs.next();
        String subject = rs.getString(1);
        ps4.setString(1, roll_no);
        rs = ps4.executeQuery();
        EVStudentDTO student = new EVStudentDTO();
        Blob blob;
        InputStream inputStream;
        byte[] buffer;
        byte[] imageBytes;
        int byteRead;
        String base64Image;
        ByteArrayOutputStream outputStream;
        if(rs.next()){
            blob = rs.getBlob(1);
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
            student.setBoard(rs.getString(2));
            student.setSubject(subject);
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
    public static boolean addMarks(String roll_no, String subject, float marks)throws SQLException
    {
        ps5.setString(1, roll_no);
        ps5.setString(2, subject);
        ps5.setFloat(3, marks);
        return ps5.executeUpdate() == 1;
    }
}
