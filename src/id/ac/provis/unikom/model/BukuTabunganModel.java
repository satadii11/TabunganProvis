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

enum enumSTATUS{
    Aktif  ("Aktif"),
    Ditutup ("Ditutup");
    
    private String string;
    
    private enumSTATUS(String s){
       this.string = s;
    }
    public String getString(){
        return string;
    }
}
public class BukuTabunganModel extends MySQLConnection{
    
    private String nomerRekening;
    private String pin;
    private int saldo;
    private int idNasabah;
    private int saldoTambahan;
    private int SaldoYangDikurangi;
    private enumSTATUS status;
    

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

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getIdNasabah() {
        return idNasabah;
    }

    public void setIdNasabah(int idNasabah) {
        this.idNasabah = idNasabah;
    }
    public void increaseSaldo(int saldoTambahan){
        this.saldoTambahan = saldoTambahan;
    }
    public int decreaseSaldo(int SaldoYangDikurangi){
        return SaldoYangDikurangi;
    }
    public String getStatus(){
        return status.getString();
    }
    
    /**
     * 
     * @param stat 
     */
    public void setStatus(String stat){
        if(stat.equalsIgnoreCase("Aktif") || stat.equalsIgnoreCase("Aktif")){
           this.status = enumSTATUS.Aktif;
        }else if (stat.equalsIgnoreCase("Ditutup")){
            this.status = enumSTATUS.Ditutup;
        }else{
            this.status = null;
        }
    }
    
    public boolean save(){
        String sql = "INSERT INTO BukuTabungan (idNasabah, nomorRekening, pin, status, saldo, saldoTambahan, SaldoYangDikurangi)"
                +"VALUES (?, ?, ?, ?, ?, ?, ?)";
        
            try {
                PreparedStatement statement = openConnection().prepareStatement(sql);
                statement.setInt(1, idNasabah);
                statement.setString(2, nomerRekening);
                statement.setString(3, pin);
                statement.setObject(4, status);
                statement.setInt(5, saldo);
                statement.setInt(6, saldoTambahan);
                statement.setInt(7, SaldoYangDikurangi);                 
                statement.execute();              
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erorr ketika menyimpan : "+ex.getMessage());
                return false;
            } finally{               
                closeConnection();           
            }
             return true;
    }

    public boolean update(){
        String sql = "UPDATE BukuTabungan"
                +"SET nomorRekening = '?' , pin = '?' , status = '?' , saldo = '?' , saldoTambahan = '?' , SaldoYangDikurangi = '?' "
                +"WHERE idNasabah = '?'";
            try {
                PreparedStatement statement = openConnection().prepareStatement(sql);
                statement.setString(1, nomerRekening);
                statement.setString(2, pin);
                statement.setString(3, status);
                statement.setInt(4, saldo);
                statement.setInt(5, saldoTambahan);
                statement.setInt(6, SaldoYangDikurangi);  
                statement.setInt(7, idNasabah);
                statement.execute();            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erorr ketika mengupdate : "+ex.getMessage());
                return false;
            } finally{
                closeConnection();            
            }   
            return true;
    }
    public boolean tutupTabungan(){
        String sql = "UPDATE BukuTabungan"
                +"SET  status = '?'"
                +"WHERE idNasabah = '?'";
            try {
                PreparedStatement statement = openConnection().prepareStatement(sql);
                statement.setString(1, status);              
                statement.setInt(2, idNasabah);
                statement.execute();            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erorr ketika menutup tabungan : "+ex.getMessage());
                return false;
            } finally{
                closeConnection();            
            }   
            return true;    
    }
    public ArrayList<BukuTabunganModel> findAllByIdNasabah(){
      ArrayList<BukuTabunganModel> result = new ArrayList<>();
            String sql = "SELECT * from BukuTabungan";
        try {
             PreparedStatement statement = openConnection().prepareStatement(sql);
             ResultSet rs = statement.executeQuery();
        while(rs.next()){
            BukuTabunganModel row = new BukuTabunganModel();
            row.setIdNasabah(rs.getInt("idNasabah"));
            row.setNomerRekening(rs.getString("nomerRekening"));
            row.setPin(rs.getString("pin"));
            row.setStatus(rs.getString("status"));
            row.setSaldo(rs.getInt("saldo"));
            row.setSaldo(rs.getInt("saldoTambahan"));
            row.setSaldo(rs.getInt("SaldoYangDikurangi"));
            result.add(row);
        }
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erorr ketika mengambil data nasabah : "+ex.getMessage());
             
            } finally{
                closeConnection();            
            }   
        return  result;
    }
       
    public static void main(String[] args){
        BukuTabunganModel bukutabungan = new BukuTabunganModel();
        bukutabungan.setStatus("Aktif");
        System.out.println(bukutabungan.getStatus());
    }
}
 
