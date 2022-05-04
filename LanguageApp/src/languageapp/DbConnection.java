/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languageapp;
import java.sql.*;

/**
 *
 * @author shaaf
 */
public class DbConnection {
    Connection con = null;
    
    public static Connection connectionDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:langdb.db");
            System.out.println("Connecttion done!");
            return con;
        
        
        
        }catch(Exception e){
            System.out.println("Error Connection failed" + e);
            return null;
        
        }
    
    
    
    }
    
    
    
}
