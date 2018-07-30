package id.ac.provis.unikom.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author satadii11
 */
public abstract class MySQLConnection {    
    
    private final String URL = "jdbc:mysql://localhost:3306/provis_tabungan?useSSl=false";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    
    private Connection conn;
    
    public Connection openConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException ex) {
                System.out.println("Error ketika membuka koneksi: " + ex.getMessage());
            }
        }
        
        return conn;
    }
    
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException ex) {
                System.out.println("Error ketika menutup koneksi: " + ex.getMessage());
            }
        } 
    }
    
}
