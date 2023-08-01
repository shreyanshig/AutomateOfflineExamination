/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import dto.IVDTO;
import dto.StudentCredDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

/**
 *
 * @author Shreyanshi
 */
public class AdminDAO
{
    private static PreparedStatement ps1, ps2, ps3, ps4, ps5;
    static
    {
        try
        {
            ps1 = DBConnection.getConnection().prepareStatement("Select * from Admin where username=? and password=?");
            ps2 = DBConnection.getConnection().prepareStatement("Insert into Invigilators values(?,?)");
            ps3 = DBConnection.getConnection().prepareStatement("Insert into Evaluators values(?,?)");
            ps4 = DBConnection.getConnection().prepareStatement("Select * from Student where roll_no=? and name=?");
            ps5 = DBConnection.getConnection().prepareStatement("Select subject,marks from Student_marks where roll_no=?");
        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Some exception occured in IVAppDAO while creating statement and preparedstatement"+ex);
        }
    }
    public static boolean searchAdmin(IVDTO admin)throws SQLException
    {
        ps1.setString(1, admin.getUsername());
        ps1.setString(2, admin.getPassword());
        ResultSet rs = ps1.executeQuery();
        if(rs.next())
            return true;
        return false;
    }
    public static boolean addinvig(IVDTO invig)throws SQLException
    {
        ps2.setString(1, invig.getUsername());
        ps2.setString(2, invig.getPassword());
        return ps2.executeUpdate() == 1;
    }
    public static boolean addeval(IVDTO eval)throws SQLException
    {
        ps3.setString(1, eval.getUsername());
        ps3.setString(2, eval.getPassword());
        return ps3.executeUpdate() == 1;
    }
    public static boolean searchStudent(StudentCredDTO student)throws SQLException
    {
        ps4.setString(1, student.getRoll_no());
        ps4.setString(2, student.getName());
        return ps4.executeUpdate() == 1;
    }
    public static LinkedHashMap<String, Float> getMarksByRoll_no(String roll_no)throws SQLException
    {
        ps5.setString(1, roll_no);
        LinkedHashMap<String, Float> hm = new LinkedHashMap<String, Float>();
        ResultSet rs = ps5.executeQuery();
        while(rs.next()){
            hm.put(rs.getString(1), rs.getFloat(2));
        }
        return hm;
    }
    
}
