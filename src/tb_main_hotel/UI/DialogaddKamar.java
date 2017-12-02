/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel.UI;

import tb_main_hotel.ListKamar;
import javax.swing.JOptionPane;


/**
 *
 * @author Andaresta
 */
public class DialogaddKamar extends javax.swing.JDialog {

    private ListKamar listKamar;
    /**
     * Creates new form DialogaddKamar
     */
    public DialogaddKamar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setListKamar(ListKamar listKamar) {
        
        this.listKamar = listKamar;
    }
    
    public void setTitle(String nama) {
    
        this.titleKamar.setText("Kamar Hotel " + nama);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleKamar = new javax.swing.JLabel();
        titleNoKamar = new javax.swing.JLabel();
        btDoReview = new javax.swing.JButton();
        comboJenis = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txNoKamar = new javax.swing.JTextField();
        titleJenis = new javax.swing.JLabel();
        titleJmlKasur = new javax.swing.JLabel();
        comboJmlKasur = new javax.swing.JComboBox<>();
        titleHarga = new javax.swing.JLabel();
        txHarga = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleKamar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleKamar.setText("Kamar");

        titleNoKamar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titleNoKamar.setText("No Kamar");

        btDoReview.setText("Submit");
        btDoReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoReviewActionPerformed(evt);
            }
        });

        comboJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standar", "Deluxe", "Supreme" }));

        jButton1.setText("Batal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        titleJenis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titleJenis.setText("Jenis");

        titleJmlKasur.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titleJmlKasur.setText("Jumlah Kasur");

        comboJmlKasur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        titleHarga.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titleHarga.setText("Harga");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDoReview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleNoKamar)
                            .addComponent(titleJenis))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNoKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(titleJmlKasur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboJmlKasur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(titleHarga)
                        .addGap(72, 72, 72)
                        .addComponent(txHarga))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(titleKamar)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleKamar)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleNoKamar)
                    .addComponent(txNoKamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleJenis)
                    .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleJmlKasur)
                    .addComponent(comboJmlKasur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleHarga)
                    .addComponent(txHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDoReview)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDoReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoReviewActionPerformed
        // TODO add your handling code here:
        int no = 0;
        try {
            no = Integer.parseInt(this.txNoKamar.getText());
        } catch (Exception e) {
            no = 0;
        }
        int jumlah = 0;
        try {
            jumlah = Integer.parseInt(this.comboJmlKasur.getSelectedItem().toString());
        } catch (Exception e) {
            jumlah = 0;
        }
        int harga = 0;
        try {
            harga = Integer.parseInt(this.txHarga.getText());
        } catch (Exception e) {
            harga = 0;
        }
        int hasil = this.listKamar.addKamar(no, this.comboJenis.getSelectedItem().toString(), jumlah, harga);
        if (hasil == 1) {
            JOptionPane.showMessageDialog(this, "Id kamar sudah terdaftar.");
        } else if (hasil == 2) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan kamar.");
        } else {
            this.comboJenis.setSelectedIndex(0);
            this.comboJmlKasur.setSelectedIndex(0);
            this.txHarga.setText("");
            this.txNoKamar.setText("");
            this.setVisible(false);
        }
    }//GEN-LAST:event_btDoReviewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //this.comboRating("");
        this.comboJenis.setSelectedIndex(0);
        this.comboJmlKasur.setSelectedIndex(0);
        this.txHarga.setText("");
        this.txNoKamar.setText("");
        this.setVisible(false);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDoReview;
    private javax.swing.JComboBox<String> comboJenis;
    private javax.swing.JComboBox<String> comboJmlKasur;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titleHarga;
    private javax.swing.JLabel titleJenis;
    private javax.swing.JLabel titleJmlKasur;
    private javax.swing.JLabel titleKamar;
    private javax.swing.JLabel titleNoKamar;
    private javax.swing.JTextField txHarga;
    private javax.swing.JTextField txNoKamar;
    // End of variables declaration//GEN-END:variables
}
