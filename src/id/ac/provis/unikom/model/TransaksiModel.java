package id.ac.provis.unikom.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author satadii11
 */
public class TransaksiModel extends MySQLConnection {
    private static final String TABLE_NAME = "transaksi";
    
    private int id;
    private String tipe;
    private int jumlah;
    private String nomerRekening;

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
        String sql = "INSERT INTO " + TABLE_NAME + "  VALUES(NULL, ?, ?, ?)";

        boolean error = false;
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            statement.setString(1, tipe);
            statement.setInt(2, jumlah);
            statement.setString(3, nomerRekening);
            statement.execute();
        } catch (SQLException e) {
            error = true;
        } finally {
            closeConnection();
        }

        return !error;
    }
}
