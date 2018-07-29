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
    
    private final String string;
    
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
    private enumSTATUS status;
    private int idNasabah;
    private int saldoTambahan;
    private int SaldoYangDikurangi;
    
    
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
    public int getSaldo(){
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
    public void increaseSaldo(int saldoTambahan){
        this.saldo += saldoTambahan;
    }
    
    public void decreaseSaldo(int SaldoYangDikurangi){
        this.saldo -= SaldoYangDikurangi;
        
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
        String sql = "INSERT INTO buku_tabungan (nomer_rekening, pin, saldo, status, id_nasabah)"
                +"VALUES (?, ?, ?, ?, ?)";
        
            try {
                PreparedStatement statement = openConnection().prepareStatement(sql);
                statement.setString(1, nomerRekening);
                statement.setString(2, pin);
                statement.setInt(3, saldo);
                statement.setString(4, status.getString());
                statement.setInt(5, idNasabah);                
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
        String sql = "UPDATE buku_tabungan"
                +"SET nomor_rekening = '?' , pin = '?' , saldo = '?' , status = '?' "
                +"WHERE id_nasabah = '?'";
            try {
                PreparedStatement statement = openConnection().prepareStatement(sql);
                statement.setString(1, nomerRekening);
                statement.setString(2, pin);                
                statement.setInt(3, saldo);   
                statement.setString(4, status.getString());
                statement.setInt(5, idNasabah);
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
        String sql = "UPDATE buku_tabungan"
                +"SET  status = '?'"
                +"WHERE id_nasabah = '?'";
            try {
                PreparedStatement statement = openConnection().prepareStatement(sql);
                statement.setString(1, status.getString());              
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
            String sql = "SELECT  * FROM buku_tabungan"
                    +"WHERE id_nasabah= '?'";
        try {
             PreparedStatement statement = openConnection().prepareStatement(sql);
             ResultSet rs = statement.executeQuery();
        while(rs.next()){
            BukuTabunganModel row = new BukuTabunganModel();           
            row.setNomerRekening(rs.getString("nomer_rekening"));
            row.setPin(rs.getString("pin"));
            row.setStatus(rs.getString("status"));
            row.setSaldo(rs.getInt("saldo"));
            row.setIdNasabah(rs.getInt("id_nasabah"));
            result.add(row);
        }
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erorr ketika mengambil data nasabah : "+ex.getMessage());
             
            } finally{
                closeConnection();            
            }   
        return  result;
    }
}
