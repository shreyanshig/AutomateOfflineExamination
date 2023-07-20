/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Shreyanshi
 */
public class DBConnection
{
    private static Connection conn = null;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-LVFSOAV:1521/xe", "pqruser", "pqruser");
            System.out.println("Driver loaded and connection opened");
        }
        catch(ClassNotFoundException cnf){
            cnf.printStackTrace();
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try{
            if(conn != null)
                    conn.close();
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
    }
}

/*here, controller conatins all the servlets, dao package contains dao classes ie the classes whcih actually interact with the database(all the queries will be kept in
dao classes, dbutil package contains a DBConnection class whcih is responsible to create connmection with the databse and ndestroy the connection with the databse. 
And, dto package contains all the POJO classes ie classes which have private data memebers as the entries of columns of database tabel and it also provides setters
and getters to initialize the data memebers and access these data memeber*/