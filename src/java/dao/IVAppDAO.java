/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import dto.IVDTO;
import dto.StudentDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Shreyanshi
 */
public class IVAppDAO
{
    private static PreparedStatement ps1, ps2;
    static
    {
        try
        {
            ps1 = DBConnection.getConnection().prepareStatement("Select * from Invigilators where username=? and password=?");
            ps2 = DBConnection.getConnection().prepareStatement("Select * from Student where roll_no=?");
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
    
}
