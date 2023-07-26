/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import dto.EVStudentDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Shreyanshi
 */
public class EVAppDAO
{
    private static PreparedStatement ps1, ps2, ps3;
    static
    {
        try
        {
            ps1 = DBConnection.getConnection().prepareStatement("Select * from Evaluators where username=? and password=?");
            ps2 = DBConnection.getConnection().prepareStatement("Select roll_no from Student_answersheet where sheet_no=?");
            ps2 = DBConnection.getConnection().prepareStatement("Select subject from Student_answersheet where sheet_no=?");
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
    public static EVStudentDTO getStudentDetails(String roll_no, String sheet_no)throws SQLException
    {
        ps3.setString(1, sheet_no);
        ResultSet rs = ps3.executeQuery();
        String subject = rs.getString(1);
    }
}
