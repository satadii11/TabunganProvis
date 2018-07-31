package id.ac.provis.unikom.view;

import id.ac.provis.unikom.controller.PenyetoranController;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author dzaki
 */
public class PenyetoranView extends BaseView {

    private PenyetoranController controller;

    public PenyetoranView() {
        initComponents();
        controller = new PenyetoranController();
        tfNamaNasabah.setEnabled(false);
        tfNamaNasabah.setEditable(false);
    }

    public JTextField getNomerRekening() {
        return tfNomerRekening;
    }

    public JTextField getNamaNasabah() {
        return tfNamaNasabah;
    }

    public JPasswordField getPin() {
        return pfPin;
    }

    public JTextField getJumlah() {
        return tfJumlah;
    }

    public void clearForm() {
        tfNomerRekening.setText("");
        tfNamaNasabah.setText("");
        pfPin.setText("");
        tfJumlah.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfJumlah = new javax.swing.JTextField();
        tfNomerRekening = new javax.swing.JTextField();
        btnSetor = new javax.swing.JButton();
        tgl1 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfNamaNasabah = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pfPin = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(244, 67, 54));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Penyetoran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Jumlah");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nomer Rekening");

        tfJumlah.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tfJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfJumlahKeyTyped(evt);
            }
        });

        tfNomerRekening.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tfNomerRekening.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNomerRekeningKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNomerRekeningKeyReleased(evt);
            }
        });

        btnSetor.setBackground(new java.awt.Color(68, 138, 255));
        btnSetor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSetor.setForeground(new java.awt.Color(255, 255, 255));
        btnSetor.setText("Setor");
        btnSetor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetorActionPerformed(evt);
            }
        });

        tgl1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tgl1.setForeground(new java.awt.Color(255, 255, 255));

        btnKembali.setBackground(new java.awt.Color(68, 138, 255));
        btnKembali.setForeground(new java.awt.Color(255, 255, 255));
        btnKembali.setText("<< Kembali");
        btnKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Nasabah");

        tfNamaNasabah.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pin");

        pfPin.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        pfPin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pfPinKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfJumlah)
                            .addComponent(tgl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfNamaNasabah)
                            .addComponent(tfNomerRekening)
                            .addComponent(btnSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pfPin, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
                    .addComponent(btnKembali))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(tgl1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomerRekening, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNamaNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(pfPin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSetor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnKembali)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfJumlahKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_tfJumlahKeyTyped

    private void tfNomerRekeningKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomerRekeningKeyTyped
        if (tfNomerRekening.getText().length() >= 12) {
            evt.consume();
            return;
        }

        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
            return;
        }
    }//GEN-LAST:event_tfNomerRekeningKeyTyped

    private void tfNomerRekeningKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomerRekeningKeyReleased
        controller.findByNomerRekening(this);
    }//GEN-LAST:event_tfNomerRekeningKeyReleased

    private void btnSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetorActionPerformed
        controller.insertPenyetoran(this);
    }//GEN-LAST:event_btnSetorActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new MainMenuView().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void pfPinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfPinKeyTyped
        if (String.valueOf(pfPin.getPassword()).length() >= 6) {
            evt.consume();
            return;
        }

        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
            return;
        }
    }//GEN-LAST:event_pfPinKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSetor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pfPin;
    private javax.swing.JTextField tfJumlah;
    private javax.swing.JTextField tfNamaNasabah;
    private javax.swing.JTextField tfNomerRekening;
    private javax.swing.JLabel tgl1;
    // End of variables declaration//GEN-END:variables
}
