package id.ac.provis.unikom.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author satadii11
 */
public class TransaksiModel extends MySQLConnection {
    private static final String TABLE_NAME = "transaksi";
    
    private int id;
    private String tipe;
    private int jumlah;
    private String nomerRekening;
    private String namaNasabah;
    private String tanggal;

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getNomerRekening() {
        return nomerRekening;
    }

    public void setNomerRekening(String nomerRekening) {
        this.nomerRekening = nomerRekening;
    }
    
    public boolean save() {
        String sql = "INSERT INTO " + TABLE_NAME + "  VALUES(NULL, ?, ?, ?, ?)";

        boolean error = false;
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            statement.setString(1, tipe);
            statement.setInt(2, jumlah);
            statement.setString(3, nomerRekening);
            statement.setString(4, tanggal);
            statement.execute();
        } catch (SQLException e) {
            error = true;
        } finally {
            closeConnection();
        }

        return !error;
    }
    
    public ArrayList<TransaksiModel> findAll() {
        ArrayList<TransaksiModel> result = new ArrayList<>();
        String sql = "SELECT tipe, jumlah, nomer_rekening, tanggal, "
                + "nama_nasabah FROM " + TABLE_NAME + " JOIN buku_tabungan "
                + "USING (nomer_rekening) JOIN nasabah USING (id_nasabah)";
        
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                TransaksiModel row = new TransaksiModel();
                row.setTipe(rs.getString("tipe"));
                row.setTanggal(rs.getString("tanggal"));
                row.setJumlah(rs.getInt("jumlah"));
                row.setNomerRekening(rs.getString("nomer_rekening"));
                row.setNamaNasabah(rs.getString("nama_nasabah"));
                result.add(row);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            result = null;
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public ArrayList<TransaksiModel> cari(String query) {
        ArrayList<TransaksiModel> result = new ArrayList<>();
        String sql = "SELECT tipe, jumlah, nomer_rekening, tanggal, "
                + "nama_nasabah FROM " + TABLE_NAME + " JOIN buku_tabungan "
                + "USING (nomer_rekening) JOIN nasabah USING "
                + "(id_nasabah) WHERE tipe LIKE ? OR jumlah LIKE ? "
                + "OR nomer_rekening LIKE ? OR nama_nasabah LIKE ? OR tanggal "
                + "LIKE ?";
        
        String queryLike = "%" + query + "%";
        
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            statement.setString(1, queryLike);
            statement.setString(2, queryLike);
            statement.setString(3, queryLike);
            statement.setString(4, queryLike);            
            statement.setString(5, queryLike);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                TransaksiModel row = new TransaksiModel();
                row.setTipe(rs.getString("tipe"));
                row.setTanggal(rs.getString("tanggal"));
                row.setJumlah(rs.getInt("jumlah"));
                row.setNomerRekening(rs.getString("nomer_rekening"));
                row.setNamaNasabah(rs.getString("nama_nasabah"));
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
