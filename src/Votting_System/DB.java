/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Votting_System;

import java.sql.*;
import javax.swing.JOptionPane;



/**
 *
 * @author ROHIT TIWARI
 */
public class DB {
    public static Connection db()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection con =DriverManager.getConnection("jdbc:sqlite:Database\\Register.sqlite");
            return con;
        }catch(ClassNotFoundException | SQLException e)
        {
            return null;
        }
    }
}
