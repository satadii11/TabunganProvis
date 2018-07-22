package id.ac.provis.unikom.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author satadii11
 */
public class KabKotaModel extends MySQLConnection {
    private int idKabkota;
    private int idProvinsi;
    private String namaKabkota;

    public int getIdKabkota() {
        return idKabkota;
    }

    public void setIdKabkota(int idKabkota) {
        this.idKabkota = idKabkota;
    }

    public int getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(int idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getNamaKabkota() {
        return namaKabkota;
    }

    public void setNamaKabkota(String namaKabkota) {
        this.namaKabkota = namaKabkota;
    }
    
    public ArrayList<KabKotaModel> getAllByProvinsiId(int idProvinsi) {
        String sql = "SELECT * FROM kabkota WHERE id_provinsi = ?";
        Connection conn = openConnection();

        ArrayList<KabKotaModel> kabkotaList = new ArrayList<>();
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, idProvinsi);
            
            ResultSet rs = pStatement.executeQuery();
            
            
            while (rs.next()) {
                KabKotaModel kabkota = new KabKotaModel();
                kabkota.setIdKabkota(rs.getInt("id"));
                kabkota.setIdProvinsi(rs.getInt("id_provinsi"));
                kabkota.setNamaKabkota(rs.getString("nama"));
                kabkotaList.add(kabkota);
            }
        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan saat membuka koneksi: " + ex.getMessage());
        }
        
        return kabkotaList;
    }
    
}
