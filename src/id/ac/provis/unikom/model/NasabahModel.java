package id.ac.provis.unikom.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author BENO
 */
enum JenisKelamin {
    PRIA, WANITA;
}

public class NasabahModel extends MySQLConnection {

    private static final String TABLE_NAME = "nasabah";

    private int id;
    private String nama;
    private String alamat;
    private String noTelepon;
    private JenisKelamin jenisKelamin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        String jk = this.jenisKelamin.toString().toLowerCase();
        return Character.toUpperCase(jk.charAt(0)) + jk.substring(1);
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = JenisKelamin.valueOf(jenisKelamin.toUpperCase());
    }

    public boolean save() {
        String sql = "INSERT INTO " + TABLE_NAME + " (nama_nasabah, "
                + "jenis_kelamin, alamat, no_telepon) VALUES(?, ?, ?, ?)";

        boolean error = false;
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            statement.setString(1, nama);
            statement.setString(2, getJenisKelamin());
            statement.setString(3, alamat);
            statement.setString(4, noTelepon);
            statement.execute();
        } catch (SQLException e) {
            error = true;
        } finally {
            closeConnection();
        }

        return !error;
    }

    public boolean update() {
        String sql = "UPDATE " + TABLE_NAME + " SET nama_nasabah = ?, "
                + "jenis_kelamin = ?, alamat = ?, no_telepon = ? "
                + "WHERE id_nasabah = ?";
        try {
            PreparedStatement statement = openConnection().prepareCall(sql);
            statement.setString(1, nama);
            statement.setString(2, getJenisKelamin());
            statement.setString(3, alamat);
            statement.setString(4, noTelepon);
            statement.setInt(5, id);
            statement.execute();
        } catch (SQLException e) {
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }

    public boolean delete() {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id_nasabah = ?";
        
        boolean error = false;
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            error = true;
        } finally {
            closeConnection();
        }
        
        return !error;
    }

    public ArrayList<NasabahModel> findAll() {
        ArrayList<NasabahModel> result = new ArrayList<>();
        String sql = "SELECT id_nasabah, nama_nasabah, jenis_kelamin, alamat, "
                + "no_telepon FROM " + TABLE_NAME;
        
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                NasabahModel row = new NasabahModel();
                row.setId(rs.getInt("id_nasabah"));
                row.setNama(rs.getString("nama_nasabah"));
                row.setJenisKelamin(rs.getString("jenis_kelamin"));
                row.setAlamat(rs.getString("alamat"));
                row.setNoTelepon(rs.getString("no_telepon"));
                result.add(row);
            }
        } catch (SQLException e) {
            result = null;
        } finally {
            closeConnection();
        }
        return result;
    }
}