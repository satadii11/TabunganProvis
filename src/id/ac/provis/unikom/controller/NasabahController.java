package id.ac.provis.unikom.controller;

import id.ac.provis.unikom.model.NasabahModel;
import id.ac.provis.unikom.view.NasabahView;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 * @author satadii11
 */
public class NasabahController {
    private NasabahModel nasabah = new NasabahModel();
    
    public ArrayList<NasabahModel> findAllNasabah() {
        return nasabah.findAll();
    }
    
    public void save(NasabahView view) {
        String nama = view.getNama().getText();
        String telepon = view.getTelepon().getText();
        String alamat = view.getAlamat().getText();
        String jenisKelamin = view.getJenisKelamin()
                .getSelectedItem().toString();
        
        if(!validateInput(view, nama, telepon, alamat)) {
            return;
        }
        
        nasabah.setNama(nama);
        nasabah.setNoTelepon(telepon);
        nasabah.setAlamat(alamat);
        nasabah.setJenisKelamin(jenisKelamin);
        if (!nasabah.save()) {
            view.showDialog("Terjadi kesalahan saat menyimpan data!");
        } else {
            view.showDialog("Berhasil menambahkan data baru untuk nasabah "
                    + "bernama " + nama);
        }
    }

    public void edit(NasabahView view) {
        JTable table = view.getTable();
        int selectedRow = table.getSelectedRow();
        nasabah.setId((int) table.getValueAt(selectedRow, 0));
        view.getNama().setText(table.getValueAt(selectedRow, 1).toString());
        view.getJenisKelamin().setSelectedItem(table.getValueAt(selectedRow, 2));
        view.getTelepon().setText(table.getValueAt(selectedRow, 3).toString());
        view.getAlamat().setText(table.getValueAt(selectedRow, 4).toString());
    }
    
    public void update(NasabahView view) {
        String nama = view.getNama().getText();
        String telepon = view.getTelepon().getText();
        String alamat = view.getAlamat().getText();
        String jenisKelamin = view.getJenisKelamin()
                .getSelectedItem().toString();
        
        if(!validateInput(view, nama, telepon, alamat)) {
            return;
        }
        
        nasabah.setNama(nama);
        nasabah.setNoTelepon(telepon);
        nasabah.setAlamat(alamat);
        nasabah.setJenisKelamin(jenisKelamin);
        if (!nasabah.update()) {
            view.showDialog("Terjadi kesalahan saat menyimpan data!");
        } else {
            view.showDialog("Berhasil merubah data untuk nasabah "
                    + "bernama " + nama);
        }
    }
    
    public void hapus(NasabahView view) {
        JTable table = view.getTable();
        int selectedRow = table.getSelectedRow();
        nasabah.setId((int) table.getValueAt(selectedRow, 0));
        if (!nasabah.delete()) {
            view.showDialog("Terjadi kesalahan saat menghapus data!");
        } else {
            view.showDialog("Berhasil menghapus data!");
        }
    }
    
    private boolean validateInput(NasabahView view, String nama, String telepon, String alamat) {
        if (nama.isEmpty()) {
            view.showDialog("Isi dulu form untuk nama");
            return false;
        }
        
        if (telepon.isEmpty()) {
            view.showDialog("Isi dulu form untuk nomer telepon");
            return false;
        }
        
        if (alamat.isEmpty()) {
            view.showDialog("Isi dulu form untuk alamat");
            return false;
        }
        
        return true;
    }

    public ArrayList<NasabahModel> cari(NasabahView view) {
        return nasabah.cari(view.getCari().getText());
    }
}
