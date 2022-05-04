/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languageapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MrCra
 */


public class user {
    // connection to the database
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    
    private String username;
    private String userType;
    private String password;

    private String email;
    private String firstName;
    private String lastName;
    
    //private Date loginTime;
    //private Date logoutTime ;
    //private Date dateRegistered;
    public user(String firstName, String lastName, String userType,String email , String username, String password ){
        this.username = username;
        this.userType = userType;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        con = DbConnection.connectionDB();
       try{
          String sql = "INSERT INTO User VALUES (null,?,?,?,?,?,?,?,null,null);";
           pst = con.prepareStatement(sql);
           pst.setString(1, firstName);
           pst.setString(2, lastName);
           pst.setString(3, userType); 
           pst.setString(4, email);
           pst.setString(5, username);
           pst.setString(6, password);
          
           pst.execute();
           System.out.println("Registeration Succesful");
       }catch(Exception e){
           System.out.println("Registeration failed!");
       }
       
    }
    public user(String username){
        this.username = username;
        con = DbConnection.connectionDB();
        try{
            String sqlQuery = "INSERT INTO TempUser VALUES (null,?);";
            pst = con.prepareStatement(sqlQuery);
            pst.setString(1, username);
            pst.execute();
            System.out.println("Added to the tempUser table");
        }catch(Exception e){
           System.out.println(e);
       }
    }
    public user(){
        
    }
    public String getUsername() {
        return username;
    }
    public String getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
