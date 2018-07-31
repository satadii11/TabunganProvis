package id.ac.provis.unikom.controller;

import id.ac.provis.unikom.model.BukuTabunganModel;
import id.ac.provis.unikom.model.NasabahModel;
import id.ac.provis.unikom.view.TabunganView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import javax.swing.JTable;

/**
 * @author satadii11
 */
public class TabunganController {
    private BukuTabunganModel tabungan = new BukuTabunganModel();
    private NasabahModel nasabah = new NasabahModel();

    public ArrayList<BukuTabunganModel> findAllTabungan() {
        return tabungan.findAll();
    }

    public ArrayList<NasabahModel> findAllNasabah() {
        return nasabah.findAll();
    }
    
    public void save(TabunganView view) {
        String pin = String.valueOf(view.getPin().getPassword());
        String saldo = view.getSaldo().getText();
        
        if(!validateInput(view, pin, saldo)) {
            return;
        }
        
        NasabahModel nasabah = view.findNasabah(view.getNasabah().getSelectedIndex());
        
        tabungan.setPin(pin);
        tabungan.setIdNasabah(nasabah.getId());
        tabungan.setSaldo(Integer.parseInt(saldo));
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String date = sdf.format(new Date());
        int count = tabungan.count(date) + 1;
        int randNumber = (int) (Math.random() * 999 + 1);
        
        tabungan.setNomerRekening(date + String.format("%03d", randNumber)
                + String.format("%03d", count));
        
        if(!tabungan.save()) {
            view.showDialog("Terjadi kesalahan saat menyimpan data!");
        } else {
            view.showDialog("Berhasil membuka rekening baru untuk " + 
                    nasabah.getNama());
        }
    }

    public void edit(TabunganView view) {
        JTable table = view.getTable();
        String nomerRekening = table.getValueAt(table.getSelectedRow(), 1)
                .toString();
        tabungan.setNomerRekening(nomerRekening);
        BukuTabunganModel bukuTabungan = tabungan.findByNomerRekening();
        nasabah.setNama(bukuTabungan.getNamaNasabah());
        view.getNasabah().setSelectedItem(bukuTabungan.getIdNasabah() 
                + " - " + bukuTabungan.getNamaNasabah());
        view.getSaldo().setText(String.valueOf(bukuTabungan.getSaldo()));
    }
    
    public void update(TabunganView view) {
        String pin = String.valueOf(view.getPin().getPassword());
        String saldo = view.getSaldo().getText();
        
        if(!validateInput(view, pin, saldo)) {
            return;
        }
        
        tabungan.setPin(pin);
        tabungan.setSaldo(Integer.parseInt(saldo));
        
        if(!tabungan.update()) {
            view.showDialog("Terjadi kesalahan saat menyimpan data!");
        } else {
            view.showDialog("Berhasil merubah buku tabungan untuk " + 
                    nasabah.getNama());
        }
    }
    
    private boolean validateInput(TabunganView view, String pin, String saldo) {
        if (pin.isEmpty()) {
            view.showDialog("Isi dulu form untuk pin");
            return false;
        }
        
        if (saldo.isEmpty()) {
            view.showDialog("Isi dulu form untuk saldo");
            return false;
        }
        
        return true;
    }

    public void tutupTabungan(TabunganView view) {
        JTable table = view.getTable();
        int selectedRow = table.getSelectedRow();
        String status = table.getValueAt(selectedRow, 3).toString();
        
        if (!status.equals("Aktif")) {
            return;
        }
        
        String nomerRekening = table.getValueAt(selectedRow, 1).toString();
        tabungan.setNomerRekening(nomerRekening);
        if(!tabungan.tutupTabungan()) {
            view.showDialog("Terjadi kesalahan saat menutup buku tabungan");
        } else {
            view.showDialog("Berhasil menutup buku tabungan dengan nomer "
                    + "rekening " + tabungan.getNomerRekening());
        }
    }
    
    public void bukaTabungan(TabunganView view) {
        JTable table = view.getTable();
        int selectedRow = table.getSelectedRow();
        String status = table.getValueAt(selectedRow, 3).toString();
        
        if (status.equals("Aktif")) {
            return;
        }
        
        String nomerRekening = table.getValueAt(selectedRow, 1).toString();
        tabungan.setNomerRekening(nomerRekening);
        if(!tabungan.bukaKembaliTabungan()) {
            view.showDialog("Terjadi kesalahan saat membuka kembali buku tabungan");
        } else {
            view.showDialog("Berhasil membuka kembali buku tabungan dengan "
                    + "nomer rekening " + tabungan.getNomerRekening());
        }
    }
}
