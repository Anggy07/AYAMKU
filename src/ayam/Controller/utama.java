/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam.Controller;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anggy
 */
public class utama {

    private ayam.view.pembelian beli;
    private ayam.view.perawatan rawat;
    private ayam.view.utama utama;
    String mg;

    public utama(ayam.view.utama v){
        this.utama = v;
        this.utama.setVisible(true);
        this.utama.pembelian(new ButtonBeli());
        this.utama.perawatan(new ButtonRawat());
        this.utama.penjualan(new ButtonJual());
    }

    private class ButtonJual implements MouseListener {

        public ButtonJual() {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            try {
                ayam.view.penjualan v = new ayam.view.penjualan();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m);
                utama.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(utama.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
         }

        @Override
        public void mouseReleased(MouseEvent me) {
         }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }

   
    

    private class ButtonRawat implements MouseListener {

        public ButtonRawat() {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            try {
                ayam.view.perawatan v = new ayam.view.perawatan();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.perawatan c = new ayam.Controller.perawatan(v, m);
                utama.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(utama.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }

    private class ButtonBeli implements MouseListener {

        public ButtonBeli() {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            try {
                String minggu = "0";
                ayam.view.pembelian v = new ayam.view.pembelian();
                 ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.pembelian c = new ayam.Controller.pembelian(v,m, minggu);
                utama.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(utama.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }
    
  
}
