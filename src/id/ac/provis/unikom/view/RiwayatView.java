package id.ac.provis.unikom.view;

import id.ac.provis.unikom.controller.RiwayatController;
import id.ac.provis.unikom.model.TransaksiModel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author satadii11
 */
public class RiwayatView extends javax.swing.JFrame {
    
    private RiwayatController controller;
    private ArrayList<TransaksiModel> transaksiModels;
    private DefaultTableModel model;
    private NumberFormat formatIndonesia;

    public RiwayatView() {
        initComponents();
        
        controller = new RiwayatController();
        model = (DefaultTableModel) tableTransaksi.getModel();
        formatIndonesia = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        
        initializeTable();
 }

    private void initializeTable() {
        transaksiModels = controller.findAll();
        inflateTable();
    }
    
    private void inflateTable() {
        model.setRowCount(0);
        for (TransaksiModel transaksi : transaksiModels) {
            model.addRow(new Object[] {
                transaksi.getNamaNasabah(),
                transaksi.getNomerRekening(),
                formatIndonesia.format(transaksi.getJumlah()),
                transaksi.getTipe(),
                transaksi.getTanggal()
            });
        }
    }
    
    public JTextField getCari() {
        return tfCari;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTransaksi = new javax.swing.JTable();
        tfCari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 67, 54));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Nasabah", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        tableTransaksi.setAutoCreateRowSorter(true);
        tableTransaksi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Nasabah", "Nomer Rekenig", "Jumlah Transaksi", "Tipe Transaksi", "Tanggal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTransaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableTransaksi.setGridColor(new java.awt.Color(0, 0, 0));
        tableTransaksi.setSelectionBackground(new java.awt.Color(68, 138, 255));
        tableTransaksi.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableTransaksi);
        if (tableTransaksi.getColumnModel().getColumnCount() > 0) {
            tableTransaksi.getColumnModel().getColumn(0).setResizable(false);
            tableTransaksi.getColumnModel().getColumn(1).setResizable(false);
            tableTransaksi.getColumnModel().getColumn(2).setResizable(false);
            tableTransaksi.getColumnModel().getColumn(3).setResizable(false);
            tableTransaksi.getColumnModel().getColumn(4).setResizable(false);
        }

        tfCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCariKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CARI");

        btnKembali.setBackground(new java.awt.Color(68, 138, 255));
        btnKembali.setForeground(new java.awt.Color(255, 255, 255));
        btnKembali.setText("<< Kembali");
        btnKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKembali)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCari)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnKembali)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCariKeyReleased
        transaksiModels = controller.cari(this);
        inflateTable();
    }//GEN-LAST:event_tfCariKeyReleased

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new MainMenuView().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableTransaksi;
    private javax.swing.JTextField tfCari;
    // End of variables declaration//GEN-END:variables
}
