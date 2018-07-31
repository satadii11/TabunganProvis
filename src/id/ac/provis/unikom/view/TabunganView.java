package id.ac.provis.unikom.view;

import id.ac.provis.unikom.controller.TabunganController;
import id.ac.provis.unikom.model.BukuTabunganModel;
import id.ac.provis.unikom.model.NasabahModel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author satadii11
 */
public class TabunganView extends BaseView {

    private ArrayList<BukuTabunganModel> bukuTabunganModels;    
    private ArrayList<NasabahModel> nasabahModels;
    private TabunganController controller;
    private DefaultTableModel tableModel;
    private NumberFormat formatRupiah;
    
    public TabunganView() {
        initComponents();
        controller = new TabunganController();
        tableModel = (DefaultTableModel) tableTabungan.getModel();
        formatRupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));

        initializeTabunganTable();
        initializeCombobox();
    }

    private void initializeTabunganTable() {
        bukuTabunganModels = controller.findAllTabungan();
        inflateTable();
    }

    private void inflateTable() {
        tableModel.setRowCount(0);
        for (BukuTabunganModel tabungan : bukuTabunganModels) {
            tableModel.addRow(new Object[] {
                tabungan.getNamaNasabah(),
                tabungan.getNomerRekening(),
                formatRupiah.format(tabungan.getSaldo()),
                tabungan.getStatus()
            });
        }
        tableModel.fireTableDataChanged();
    }
    
    private void initializeCombobox() {
        nasabahModels = controller.findAllNasabah();
        for (NasabahModel nasabah : nasabahModels) {
            cbNasabah.addItem(nasabah.getId() + " - " + nasabah.getNama());
        }
    }
    
    public NasabahModel findNasabah(int pos) {
        return nasabahModels.get(pos);
    }
    
    public JComboBox getNasabah() {
        return cbNasabah;
    }
    
    public JTextField getSaldo() {
        return tfSaldo;
    }
    
    public JPasswordField getPin() {
        return pfPin;
    }
    
    public JTable getTable() {
        return tableTabungan;
    }
    
    public JTextField getCari() {
        return tfCari;
    }
    
    private void clearForm() {
        cbNasabah.setSelectedIndex(0);
        tfSaldo.setText("");
        pfPin.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfSaldo = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTabungan = new javax.swing.JTable();
        btnUbah = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tfCari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbNasabah = new javax.swing.JComboBox<>();
        pfPin = new javax.swing.JPasswordField();
        btnBuka = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(244, 67, 54));

        jPanel1.setBackground(new java.awt.Color(244, 67, 54));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Nasabah", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PIN");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Saldo");

        tfSaldo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfSaldoKeyTyped(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(68, 138, 255));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.setToolTipText("");
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnTambah.setBackground(new java.awt.Color(68, 138, 255));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnKembali.setBackground(new java.awt.Color(68, 138, 255));
        btnKembali.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnKembali.setForeground(new java.awt.Color(255, 255, 255));
        btnKembali.setText("<< Kembali");
        btnKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        tableTabungan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableTabungan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Nasabah", "Nomer Rekening", "Saldo", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTabungan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableTabungan.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableTabungan);
        if (tableTabungan.getColumnModel().getColumnCount() > 0) {
            tableTabungan.getColumnModel().getColumn(0).setResizable(false);
            tableTabungan.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableTabungan.getColumnModel().getColumn(1).setResizable(false);
            tableTabungan.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableTabungan.getColumnModel().getColumn(2).setResizable(false);
            tableTabungan.getColumnModel().getColumn(2).setPreferredWidth(20);
            tableTabungan.getColumnModel().getColumn(3).setResizable(false);
            tableTabungan.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        btnUbah.setBackground(new java.awt.Color(68, 138, 255));
        btnUbah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setText("Ubah");
        btnUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnTutup.setBackground(new java.awt.Color(68, 138, 255));
        btnTutup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTutup.setForeground(new java.awt.Color(255, 255, 255));
        btnTutup.setText("Tutup");
        btnTutup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cari");

        tfCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCariKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nasabah");

        pfPin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pfPinKeyTyped(evt);
            }
        });

        btnBuka.setBackground(new java.awt.Color(68, 138, 255));
        btnBuka.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuka.setForeground(new java.awt.Color(255, 255, 255));
        btnBuka.setText("Buka");
        btnBuka.setToolTipText("");
        btnBuka.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBukaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbNasabah, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnSimpan)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTambah))
                                .addComponent(tfSaldo))
                            .addComponent(pfPin, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuka, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnKembali))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2)
                    .addComponent(cbNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(pfPin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnTambah))))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah)
                    .addComponent(btnTutup)
                    .addComponent(btnBuka))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new MainMenuView().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void tfSaldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSaldoKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_tfSaldoKeyTyped

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        controller.save(this);
        initializeTabunganTable();
        clearForm();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void pfPinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfPinKeyTyped
        if (pfPin.getPassword().length >= 6) {
            evt.consume();
        }
        
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_pfPinKeyTyped

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        controller.update(this);
        initializeTabunganTable();
        clearForm();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        controller.edit(this);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnBukaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBukaActionPerformed
        controller.bukaTabungan(this);
        initializeTabunganTable();
    }//GEN-LAST:event_btnBukaActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        controller.tutupTabungan(this);
        initializeTabunganTable();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void tfCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCariKeyReleased
        bukuTabunganModels = controller.cari(this);
        inflateTable();
    }//GEN-LAST:event_tfCariKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuka;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbNasabah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPasswordField pfPin;
    private javax.swing.JTable tableTabungan;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfSaldo;
    // End of variables declaration//GEN-END:variables
}
