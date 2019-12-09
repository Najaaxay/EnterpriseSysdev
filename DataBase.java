/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author najah
 */
public class DataBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection myconObj = null;
        Statement mystatObj = null;
        ResultSet myresObj = null;
        String query = "Select * from najahjama.MyTable1 ";
        
        
        
        
        try{
            myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDatabase", "najahjama", 
                    "123456");
                    
            mystatObj = myconObj.createStatement();
            myresObj  = mystatObj.executeQuery(query);
            while(myresObj.next()){
              
                int id = myresObj.getInt("ID");
                String name = myresObj.getString("Name");
                Date date = myresObj.getDate("DateOfBirth");
                String phone = myresObj.getString("PhoneNumber");
                System.out.println(id  + "\t" + name + "\t " + date + "\t"+ phone);
                
                
                        
            }
            
            
        }
        catch (SQLException e){
            e.printStackTrace();
        
    }
        
    }
    
}
