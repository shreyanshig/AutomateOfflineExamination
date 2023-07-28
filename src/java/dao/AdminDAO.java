/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import dto.IVDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Shreyanshi
 */
public class AdminDAO
{
    private static PreparedStatement ps;
    static
    {
        try
        {
            ps = DBConnection.getConnection().prepareStatement("Select * from Admin where username=? and password=?");
        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Some exception occured in IVAppDAO while creating statement and preparedstatement"+ex);
        }
    }
    public static boolean searchAdmin(IVDTO admin)throws SQLException
    {
        ps.setString(1, admin.getUsername());
        ps.setString(2, admin.getPassword());
        ResultSet rs = ps.executeQuery();
        if(rs.next())
            return true;
        return false;
    }
}
