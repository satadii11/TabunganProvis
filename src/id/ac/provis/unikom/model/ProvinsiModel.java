package id.ac.provis.unikom.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author satadii11
 */
public class ProvinsiModel extends MySQLConnection {
    private int idProvinsi;
    private String namaProvinsi;

    public int getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(int idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }
    
    
    
    public ArrayList<ProvinsiModel> getAllProvinsi() {
        String sql = "SELECT * FROM provinsi";
        Connection conn = openConnection();

        ArrayList<ProvinsiModel> provinsiList = new ArrayList<>();
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();
            
            
            while (rs.next()) {
                ProvinsiModel provinsi = new ProvinsiModel();
                provinsi.setIdProvinsi(rs.getInt("id"));
                provinsi.setNamaProvinsi(rs.getString("nama"));
                provinsiList.add(provinsi);
            }
        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan saat membuka koneksi: " + ex.getMessage());
        }
        
        return provinsiList;
    }
}
