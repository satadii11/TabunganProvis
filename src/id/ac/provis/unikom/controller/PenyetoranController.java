package id.ac.provis.unikom.controller;

import id.ac.provis.unikom.model.BukuTabunganModel;
import id.ac.provis.unikom.model.TransaksiModel;
import id.ac.provis.unikom.view.PenyetoranView;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author satadii11
 */
public class PenyetoranController {
    private TransaksiModel transaksi = new TransaksiModel();
    private BukuTabunganModel tabungan = new BukuTabunganModel();
    
    public void insertPenyetoran(PenyetoranView view) {
        String nomerRekening = view.getNomerRekening().getText();
        String namaNasabah = view.getNamaNasabah().getText();
        String pin = String.valueOf(view.getPin().getPassword());
        String jumlah = view.getJumlah().getText();
        
        if (namaNasabah.isEmpty()) {
            view.showDialog("Nomer Rekening tidak diketahui");
            return;
        }
        
        if (pin.isEmpty()) {
            view.showDialog("Isi dulu form untuk pin");
            return;
        }
        
        if (jumlah.isEmpty()) {
            view.showDialog("Isi dulu form untuk jumlah");
            return;
        }
        
        int totalAmbil = Integer.parseInt(jumlah);
        
        if (!pin.equals(tabungan.getPin())) {
            view.showDialog("Pin salah, pastikan telah memasukkan pin yang benar.");
            return;
        }
        
        transaksi.setJumlah(totalAmbil);
        transaksi.setNomerRekening(nomerRekening);
        transaksi.setTipe("Setor");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        transaksi.setTanggal(sdf.format(new Date()));
        if (transaksi.save()) {
            view.showDialog("Berhasil melakukan penyetoran uang sejumlah " 
                    + jumlah);
            tabungan.setNomerRekening(nomerRekening);
            tabungan.increaseSaldo(totalAmbil);
            tabungan.update();
            view.clearForm();
        } else {
            view.showDialog("Gagal melakukan penyetoran uang");
        }
    }
    
    public void findByNomerRekening(PenyetoranView view) {
        tabungan.setNomerRekening(view.getNomerRekening().getText());
        BukuTabunganModel bukuTabungan = tabungan.findByNomerRekening();
        
        String namaNasabah = "";
        if (bukuTabungan != null) {
            namaNasabah = bukuTabungan.getNamaNasabah();
            tabungan = bukuTabungan;
        }
        
        view.getNamaNasabah().setText(namaNasabah);
    }
}
