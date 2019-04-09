/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author damia
 */
public class ConnectionClass {
    public Connection connection;
    
    public Connection getConnection() throws SQLException{
        
        String dbName = "przychodnia";
        String username = "root";
        String password = "";
        
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/"+dbName;
            
            Class.forName(driver);
            
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connected");
            
            
            
            return connection;
            
        } catch (ClassNotFoundException ex) {
            System.out.println("nie uudalo sie nawiazac oplaczenia z baza");
        }
        
        return null;
    }
    
   
    
}
