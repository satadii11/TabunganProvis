package id.ac.provis.unikom.controller;

import id.ac.provis.unikom.model.TransaksiModel;
import id.ac.provis.unikom.view.RiwayatView;
import java.util.ArrayList;

/**
 * @author satadii11
 */
public class RiwayatController {
    
    private TransaksiModel transaksi = new TransaksiModel(); 
    
    public ArrayList<TransaksiModel> findAll() {
        return transaksi.findAll();
    }
    
    public ArrayList<TransaksiModel> cari(RiwayatView view) {
        return transaksi.cari(view.getCari().getText());
    }
}
