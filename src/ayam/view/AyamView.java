/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam.view;

/**
 *
 * @author anggy
 */
import ayam.Controller.Ayam;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class AyamView extends javax.swing.JFrame {

    public AyamView() {

        initComponents();
        setumur();
        setberat();
        setharga();
  
        this.setLocationRelativeTo(null);
    }

    public void setumur() {
        this.umur.setText("10 hari");
    }

    public void setberat() {
        this.berat.setText("200 gram");
    }

    public void setharga() {
        this.harga.setText("2500");
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


    public void addbeliListener(ActionListener listener) {
        beli.addActionListener(listener);
    }
    public void addkembali(ActionListener listener) {
        kembali.addActionListener(listener);
    }

    public void clearInput() {
        jumlah.setText("");
        harga.setText("");
        umur.setText("");
        berat.setText("");

    }

    public void addrincianListener(ActionListener listener) {
        rincian.addActionListener(listener);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jumlah = new javax.swing.JTextField();
        kembali = new javax.swing.JButton();
        modal = new javax.swing.JLabel();
        beli = new javax.swing.JButton();
        berat = new javax.swing.JLabel();
        umur = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();
        rincian = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jumlah.setBorder(null);
        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });
        jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jumlahKeyTyped(evt);
            }
        });
        getContentPane().add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, 120, 40));

        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button-kembali-1.png"))); // NOI18N
        kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 90, 30));

        modal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(modal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 160, 40));

        beli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button beli 1.png"))); // NOI18N
        beli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliActionPerformed(evt);
            }
        });
        getContentPane().add(beli, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, 90, 30));
        getContentPane().add(berat, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 90, 40));
        getContentPane().add(umur, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 90, 40));
        getContentPane().add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 90, 40));

        rincian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button rincian 1.png"))); // NOI18N
        rincian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(rincian, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 440, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pembelian-ayam.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
//        try {
//            String minggu = "0";
//            ayam.view.pembelian v = new ayam.view.pembelian();
//             ayam.Model.AYAM m = new ayam.Model.AYAM();
//            ayam.Controller.pembelian c = new ayam.Controller.pembelian(v,m, minggu);
//            this.setVisible(false);// TODO add your handling code here:
//        } catch (SQLException ex) {
//            Logger.getLogger(AyamView.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_kembaliActionPerformed

    private void beliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_beliActionPerformed

    private void jumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahKeyTyped
char karakter = evt.getKeyChar();
if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE)))){
    getToolkit().beep();
    evt.consume();
}// TODO add your handling code here:
    }//GEN-LAST:event_jumlahKeyTyped

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
            java.util.logging.Logger.getLogger(AyamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AyamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AyamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AyamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AyamView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beli;
    private javax.swing.JLabel berat;
    private javax.swing.JLabel harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JButton kembali;
    private javax.swing.JLabel modal;
    private javax.swing.JButton rincian;
    private javax.swing.JLabel umur;
    // End of variables declaration//GEN-END:variables

}
