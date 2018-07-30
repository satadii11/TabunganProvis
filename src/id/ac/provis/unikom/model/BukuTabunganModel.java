/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.provis.unikom.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Akhsan
 */
enum Status {
    AKTIF, DITUTUP
}

public class BukuTabunganModel extends MySQLConnection {
    private static final String TABLE_NAME = "buku_tabungan";

    private String nomerRekening;
    private String pin;
    private int saldo;
    private Status status;
    private String namaNasabah;
    private int idNasabah;
    private int saldoTambahan;
    private int SaldoYangDikurangi;

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }
    
    public String getNomerRekening() {
        return nomerRekening;
    }

    public void setNomerRekening(String nomerRekening) {
        this.nomerRekening = nomerRekening;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getIdNasabah() {
        return idNasabah;
    }

    public void setIdNasabah(int idNasabah) {
        this.idNasabah = idNasabah;
    }

    public void increaseSaldo(int saldoTambahan) {
        this.saldo += saldoTambahan;
    }

    public void decreaseSaldo(int SaldoYangDikurangi) {
        this.saldo -= SaldoYangDikurangi;

    }

    public String getStatus() {
        String status = this.status.toString().toLowerCase();
        return Character.toUpperCase(status.charAt(0)) + status.substring(1);
    }

    public void setStatus(String stat) {
        this.status = Status.valueOf(stat.toUpperCase());
    }

    public boolean save() {
        String sql = "INSERT INTO " + TABLE_NAME + " (nomer_rekening, pin, "
                + "saldo, status, id_nasabah) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            statement.setString(1, nomerRekening);
            statement.setString(2, pin);
            statement.setInt(3, saldo);
            statement.setString(4, getStatus());
            statement.setInt(5, idNasabah);
            statement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erorr ketika menyimpan : " + ex.getMessage());
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }

    public boolean update() {
        String sql = "UPDATE " + TABLE_NAME + " SET nomer_rekening = ?, "
                + "pin = ?, saldo = ?, status = ? WHERE id_nasabah = ?";
        
        boolean error = false;
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            statement.setString(1, nomerRekening);
            statement.setString(2, pin);
            statement.setInt(3, saldo);
            statement.setString(4, getStatus());
            statement.setInt(5, idNasabah);
            statement.execute();
        } catch (SQLException ex) {
            error = true;
        } finally {
            closeConnection();
        }
        return !error;
    }

    public boolean tutupTabungan() {
        return updateStatus("Ditutup");
    }
    
    public boolean bukaKembaliTabungan() {
        return updateStatus("Aktif");
    }
    
    private boolean updateStatus(String status) {
        String sql = "UPDATE " + TABLE_NAME + " SET status = ? WHERE "
                + "id_nasabah = ?";
        
        boolean error = false;
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            statement.setString(1, status);
            statement.setInt(2, idNasabah);
            statement.execute();
        } catch (SQLException ex) {
            error = true;
        } finally {
            closeConnection();
        }
        return !error;
    }

    public ArrayList<BukuTabunganModel> findAllByIdNasabah() {
        ArrayList<BukuTabunganModel> result = new ArrayList<>();
        String sql = "SELECT nomer_rekening, status, saldo, pin, nama_nasabah, "
                + "id_nasabah FROM " + TABLE_NAME + " JOIN nasabah USING "
                + "(id_nasabah) WHERE id_nasabah = ?";
        
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            statement.setInt(1, idNasabah);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                BukuTabunganModel row = new BukuTabunganModel();
                row.setNomerRekening(rs.getString("nomer_rekening"));
                row.setPin(rs.getString("pin"));
                row.setStatus(rs.getString("status"));
                row.setSaldo(rs.getInt("saldo"));
                row.setIdNasabah(rs.getInt("id_nasabah"));
                row.setNamaNasabah("nama_nasabah");
                result.add(row);
            }
        } catch (SQLException ex) {
            result = null;
        } finally {
            closeConnection();
        }
        return result;
    }
}
