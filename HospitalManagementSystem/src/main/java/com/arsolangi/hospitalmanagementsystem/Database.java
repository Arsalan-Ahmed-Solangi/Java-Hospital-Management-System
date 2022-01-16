/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arsolangi.hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Database {
    
    //***start of variables******//
    final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String DB_NAME = "jdbc:mysql://localhost:3306/java_hospital?zeroDateTimeBehavior=CONVERT_TO_NULL";
    final static String DB_USER = "root";
    final static String DB_PASS = "";
    //***end of variables******//
    
    
    //***start of Connection********//
    public static Connection connection() throws SQLException{
        
        try {
            Class.forName(DB_DRIVER);
            Connection connection_status = DriverManager.getConnection(DB_NAME,DB_USER,DB_PASS);
            return connection_status;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null , ex);
            return null;
        } 
    }
    //***end of Connection********//
    
    
    //****Start of Select All******//
    public ResultSet selectAll(String table){

         try {
             Connection connection_status = Database.connection();
             Statement statement = connection_status.createStatement();
             String query = "SELECT * FROM "+table+"";
             ResultSet resultSet = statement.executeQuery(query);
             return resultSet;
         } catch (SQLException ex) {
             Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
              return null;
         } 
    }
    //***End of Select All*******//
    
    //***start of Select Where********//
     public ResultSet selectWhere(String query){

         try {
             Connection connection_status = Database.connection();
             Statement statement = connection_status.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
             return resultSet;
         } catch (SQLException ex) {
             Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
              return null;
         } 
    }
    //***End of Select Where*******//
        
    //***start of Insert*******//
    public Integer SqlQuery(String query){
        
         try {
             Connection connection_status = Database.connection();
             Statement statement = connection_status.createStatement();
             int result = statement.executeUpdate(query);
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
              return 0;
         } 
    
    }
    //***end of Insert*******//
    
}
