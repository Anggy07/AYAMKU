/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam.Controller;

import ayam.Model.AYAM;
import ayam.view.utama;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anggy
 */
public class pembelian {

    private ayam.view.pembelian view;
    private ayam.view.utama utama;
    private ayam.Model.AYAM model;
    String mg;
//    AYAM ayam;

    public pembelian(ayam.view.pembelian v, ayam.Model.AYAM m, String minggu) throws SQLException {
        this.mg = minggu;
        this.model = m;
        System.out.println("rahasiaaaa" + mg);
        this.view = v;
        view.setModal(model.ambilMOdal());
        this.view.setVisible(true);
        this.view.ayam(new ButtonAyam());
        this.view.kandang(new ButtonKandang());
        this.view.pakan(new ButtonPakan());
//        this.view.obat(new ButtonObat());
        this.view.kembali(new ButtonKembali());

    }

    public pembelian(ayam.view.utama v) {

        System.out.println(mg);
        this.utama = v;
        this.utama.setVisible(true);
//        this.view.ayam(new ButtonAyam());
//        this.view.kandang(new ButtonKandang());
//        this.view.pakan(new ButtonPakan());
//        this.view.obat(new ButtonObat());

    }

    public pembelian(ayam.view.utama vv, String minggu) {
        this.mg = minggu;
        System.out.println(mg);
        this.utama = vv;
        this.utama.setVisible(true);
        this.utama.pembelian(new ButtonPembelian());
        this.utama.perawatan(new ButtonPerawatan());

    }

    public pembelian(ayam.view.pembelian v) {
        this.view = v;
        this.view.setVisible(true);
    }

    private class ButtonKembali implements MouseListener {

        public ButtonKembali() {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            ayam.view.utama v = new ayam.view.utama();
            ayam.Controller.utama c = new ayam.Controller.utama(v);
            view.setVisible(false);
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

    private class ButtonPerawatan implements MouseListener {

        public ButtonPerawatan() {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            try {
                utama.setVisible(false);
                ayam.view.perawatan v = new ayam.view.perawatan();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.perawatan c = new ayam.Controller.perawatan(v, m);
                // TODO add your handling code here:
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

    private class ButtonPembelian implements MouseListener {

        public ButtonPembelian() {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            try {
                String minggu = "0";
                ayam.view.pembelian v = new ayam.view.pembelian();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.pembelian c = new ayam.Controller.pembelian(v, m, minggu);
                utama.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(pembelian.class.getName()).log(Level.SEVERE, null, ex);
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
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class ButtonAyam implements MouseListener {

        public ButtonAyam() {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            view.setVisible(false);
            try {
                ayam.view.AyamView v = new ayam.view.AyamView();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m);
            } catch (SQLException ex) {
                Logger.getLogger(pembelian.class.getName()).log(Level.SEVERE, null, ex);
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

    private class ButtonKandang implements MouseListener {

        public ButtonKandang() {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            try {
                System.out.println("keluar");
                ayam.view.KandangView v = new ayam.view.KandangView();
                System.out.println("keluar model");
                ayam.Model.KANDANG m = new ayam.Model.KANDANG();
                System.out.println("keluar c");
                new ayam.Controller.Kandang(v, m);
                view.setVisible(false);

                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(pembelian.class.getName()).log(Level.SEVERE, null, ex);
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

        private void setVisible(boolean b) {
        }
    }

    private class ButtonPakan implements MouseListener {

        public ButtonPakan() {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            try {

                System.out.println("view muncul");
                ayam.view.PakanView v = new ayam.view.PakanView();
                ayam.Model.PAKAN m = new ayam.Model.PAKAN();
                System.out.println("model keluar");
                new ayam.Controller.Pakan(v, m, mg);
                System.out.println("panggil" + mg);
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(pembelian.class.getName()).log(Level.SEVERE, null, ex);

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

        private void setVisible(boolean b) {
        }
    }

    private class ButtonObat implements MouseListener {

        public ButtonObat() {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            view.setVisible(false);
            try {
                ayam.view.ObatView v = new ayam.view.ObatView();
                System.out.println("view muncul");
                ayam.Model.OBAT m = new ayam.Model.OBAT();
                System.out.println("model keluar");
//                new ayam.Controller.Obat(v, m, mg);
                System.out.println("panggil");
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(pembelian.class.getName()).log(Level.SEVERE, null, ex);
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

        private void setVisible(boolean b) {
        }
    }
}
