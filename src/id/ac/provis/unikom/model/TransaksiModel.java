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
/**
 *
 * @author LENOVO
 */
enum enumTransaksi {
    Setor,
    Pengembalian;
}

public class TransaksiModel extends MySQLConnection{
    private int id;
    private enumTransaksi tipe;
    private int jumlah;
    private String nomerRekening;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public String getTipe(){
        return tipe.name();
    }
    
    public void setTipe(String tipe){
        if (tipe.equalsIgnoreCase("Setor")) {
            this.tipe = enumTransaksi.Setor;
        }else if(tipe.equalsIgnoreCase("Pengembalian")){
            this.tipe = enumTransaksi.Pengembalian;
        }else{
            this.tipe = null;
        }
    }

    
    public boolean save(){
        String sql = "INSERT INTO Transaksi (id_transaksi, tipe, jumlah) "+
                     "VALUES(?, ?, ?)";
        try {
            PreparedStatement statement = openConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, tipe.name());
            statement.setInt(3, jumlah);            
            statement.execute();            
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Error ketika menyimpan :" + e.getMessage());
            return false;
        }finally{
            closeConnection();
        }
        return true;
    }

  public ArrayList<TransaksiModel> findAllByNomerRekening(){
      ArrayList<TransaksiModel> result = new ArrayList<>();
            String sql = "SELECT  * FROM Transaksi "
                    +"WHERE nomer_rekening = '?'";
        try {
             PreparedStatement statement = openConnection().prepareStatement(sql);
             statement.setString(1, nomerRekening);
             ResultSet rs = statement.executeQuery();
        while(rs.next()){
            TransaksiModel row = new TransaksiModel();           
            row.setId(rs.getInt("id_transaksi"));
            row.setNomerRekening(rs.getString("nomer_rekening"));
            row.setTipe(rs.getString("tipe"));
            row.setJumlah(rs.getInt("jumlah"));
            result.add(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erorr ketika mengambil data rekening: "+ex.getMessage());
            } finally{
                closeConnection();            
            }   
        return  result;
    }
  
  public ArrayList<TransaksiModel> findAllByTipeAndIdBukuTabungan(){
      ArrayList<TransaksiModel> result = new ArrayList<>();
            String sql = "SELECT  * FROM Transaksi "
                    +"WHERE tipe = '?' AND nomer_rekening = '?'";
        try {
             PreparedStatement statement = openConnection().prepareStatement(sql);
             statement.setString(1, tipe.name());
             statement.setString(2, nomerRekening);
             ResultSet rs = statement.executeQuery();
        while(rs.next()){
            TransaksiModel row = new TransaksiModel();           
            row.setId(rs.getInt("id_transaksi"));
            row.setNomerRekening(rs.getString("nomer_rekening"));
            row.setTipe(rs.getString("tipe"));
            row.setJumlah(rs.getInt("jumlah"));
            result.add(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erorr ketika mengambil data rekening: "+ex.getMessage());
            } finally{
                closeConnection();            
            }   
        return  result;
    }
  
}