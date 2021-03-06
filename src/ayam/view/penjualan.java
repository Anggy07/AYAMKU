/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anggy
 */
public class penjualan extends javax.swing.JFrame {

    /**
     * Creates new form penjualan
     */
    public penjualan() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

  
     public void setModal(String modal) {
        this.modal.setText(modal);
    }

    public String getModal() {
        return modal.getText();
    }

    public void setjumlah(String jumlah) {
        this.jumlah.setText(jumlah);
    }

    public String getjumlah() {
        return jumlah.getText();
    }

    public void setHarga(String harga) {
        this.harga.setText(harga);
    }

    public void setBerat(String harga) {
        this.berat.setText(harga);
    }

    public String getHarga() {
        return harga.getText();
    }

    public String getBerat() {
        return berat.getText();
    }
    public JTable getTabel(){
        return tabel;
    }

    public void addPenjualan(ActionListener listener) {
        jual.addActionListener(listener);
    }

    public void addRincianJual(ActionListener listener) {
        rincian.addActionListener(listener);
    }

    public void addkembali(ActionListener listener) {
        kembali.addActionListener(listener);
    }

    public void setTableModel(DefaultTableModel tj) {
        tabel.setModel(tj);
    }

    public int getSelectedRow() {
        int baris = tabel.getSelectedRow();
        return baris;
    }
    public void tabeljual (MouseListener a){
        tabel.addMouseListener(a);
    }

    public void disableEditAndDelete() {
        berat.setEnabled(false);
        jumlah.setEnabled(false);
    }

    public void clearInput() {
        berat.setText("");
        harga.setText("");
        jumlah.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        kembali = new javax.swing.JButton();
        harga = new javax.swing.JTextField();
        berat = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rincian = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        modal = new javax.swing.JLabel();
        jual = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 450, 200));

        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button-kembali-1.png"))); // NOI18N
        kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 90, 30));

        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });
        getContentPane().add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 140, 30));

        berat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beratActionPerformed(evt);
            }
        });
        getContentPane().add(berat, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 90, 30));
        getContentPane().add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 90, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("/gram");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 60, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Pilih Ayam yang akan dijual!");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 200, 20));

        rincian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button rincian 1.png"))); // NOI18N
        rincian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(rincian, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, 90, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setText("Jumlah");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 60, 30));

        jLabel4.setText("Contoh : 24000");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setText("Masukkan Harga Ayam Terkini per KiloGram !");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 320, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setText("Berat");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 50, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/coinkecil.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 50, 40));

        modal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(modal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 100, 30));

        jual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/jual.png"))); // NOI18N
        jual.setBorderPainted(false);
        jual.setContentAreaFilled(false);
        getContentPane().add(jual, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 110, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bg-penjualan.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        ayam.view.utama v = new ayam.view.utama();
        ayam.Controller.utama c = new ayam.Controller.utama(v);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_kembaliActionPerformed

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaActionPerformed

    private void beratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_beratActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField berat;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jual;
    private javax.swing.JTextField jumlah;
    private javax.swing.JButton kembali;
    private javax.swing.JLabel modal;
    private javax.swing.JButton rincian;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
