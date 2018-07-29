/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.provis.unikom.model;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BENO
 */

enum enumJK {
    LakiLaki("Laki-laki"),
    Perempuan("Perempuan");

    private final String string;
    
    private enumJK(String s){
        this.string = s;
    }
    public String getString(){
        return string;
    }
}

public class NasabahModel extends MySQLConnection{
    private int id;
    private String nama;
    private String alamat;
    private String noTelepon;
    private enumJK jenisKelamin;
    
    

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
        
    public String getJenisK() {
        return jenisKelamin.getString();
    }

    /**
     *
     * @param jenisKelamin
     */
    public void setJenisKelamin(String jenisKelamin) {
        if (jenisKelamin.equalsIgnoreCase("Laki-laki") || jenisKelamin.equalsIgnoreCase("LakiLaki")) {
            this.jenisKelamin = enumJK.LakiLaki;
        }else if (jenisKelamin.equalsIgnoreCase("Perempuan")){
            this.jenisKelamin = enumJK.Perempuan;
        }else{
            this.jenisKelamin = null;
        }
    }

    public boolean save(){
        String sql = "INSERT INTO Nasabah (nama, jenis_kelamin, alamat, no_telepon) "+
                     "VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);            
            statement.setString(1, nama);
            statement.setString(2, jenisKelamin.getString());
            statement.setString(3, alamat);
            statement.setString(4, noTelepon);            
            statement.execute();            
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Error ketika menyimpan :" + e.getMessage());
            return false;
        }finally{
            closeConnection();
        }
        return true;
    }
    
    public boolean update(){
        String sql = "UPDATE Nasabah SET "
                + "nama = '?', jenis_kelamin = '?', alamat = '?', no_telepon = '?' "+
                "WHERE id_nasabah = '?'";
        try {
            PreparedStatement statement = openConnection().prepareCall(sql);
            statement.setString(1, nama);
            statement.setString(2, jenisKelamin.getString());
            statement.setString(3, alamat);
            statement.setString(4, noTelepon);
            statement.setInt(5, id);
            statement.execute();
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Error ketika mengupdate :" + e.getMessage());
            return false;
        }finally{
            closeConnection();
        }
        return true;
    }
    
    public boolean delete(){
        String sql = "DELETE FROM Nasabah WHERE id_nasabah = ?";
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error ketika menghapus : "+e.getMessage());
            return false;
        }finally{
            closeConnection();
        }
        return true;
    }

    public ArrayList<NasabahModel> findAll(){
        ArrayList<NasabahModel> result = new ArrayList<>();
        String sql = "SELECT id_nasabah, nama, jenis_kelamin, alamat, no_telepon FROM Nasabah";        
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                NasabahModel row = new NasabahModel();
                row.setId(rs.getInt("id_nasabah"));
                row.setNama(rs.getString("nama"));
                row.setJenisKelamin(rs.getString("jenis_kelamin"));
                row.setAlamat(rs.getString("alamat"));
                row.setNoTelepon(rs.getString("no_telepon"));
                result.add(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Ketika Mengambil Data Nasabah : "+e.getMessage());
        }finally{
            closeConnection();
        }
        return result;
    }
}
