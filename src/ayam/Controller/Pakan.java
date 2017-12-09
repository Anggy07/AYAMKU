/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam.Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author anggy
 */
public class Pakan {

    private ayam.view.PakanView View;
    private ayam.view.rincian_pakan viewPakan;
    private ayam.Model.PAKAN Model;
    String mg;
    private Component PakanView;

    public Pakan(ayam.view.PakanView V, ayam.Model.PAKAN M, String minggu) throws SQLException {
        mg = minggu;
        // Model.setMinggu(mg);
        System.out.println(mg);
        this.View = V;
        this.Model = M;
        View.setModal(Model.ambilMOdal());
        this.View.addbeliListener(new Pakan.beliListener());
        this.View.addrincianListener(new Pakan.rincianListener());
        this.View.addpilihListener(new Pakan.Pilih());
        this.View.addkembali(new kembaliAwal());
        this.View.setVisible(true);
        //      JOptionPane.showMessageDialog(PakanView, "belilah pakan sesuai umur ayam ");

    }

    public Pakan(ayam.view.PakanView V, ayam.Model.PAKAN M) {
        this.View = V;
        this.Model = M;
        this.View.setVisible(true);
    }

    public Pakan(ayam.view.rincian_pakan vv, ayam.Model.PAKAN M) {
        try {
            this.viewPakan = vv;
            this.Model = M;
            viewPakan.setModal(Model.ambilMOdal());
            this.viewPakan.addkembali(new kembali());
            this.viewPakan.addhapusListener(new Pakan.hapusListener());
            this.viewPakan.setTableModel(this.Model.getTableModel());
            this.viewPakan.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Kandang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class kembali implements ActionListener {

        public kembali() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String minggu = mg;
                ayam.view.PakanView v = new ayam.view.PakanView();
                ayam.Model.PAKAN m = new ayam.Model.PAKAN();
                ayam.Controller.Pakan c = new ayam.Controller.Pakan(v, m, minggu);
                viewPakan.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Pakan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembaliAwal implements ActionListener {

        public kembaliAwal() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String minggu = mg;
                ayam.view.pembelian v = new ayam.view.pembelian();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.pembelian c = new ayam.Controller.pembelian(v, m, minggu);
                View.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Pakan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class rincianListener implements ActionListener {

        public rincianListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                ayam.view.rincian_pakan v = new ayam.view.rincian_pakan();
                ayam.Model.PAKAN m = new ayam.Model.PAKAN();
                ayam.Controller.Pakan c = new ayam.Controller.Pakan(v, m);
                View.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Pakan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class hapusListener implements ActionListener {

        public hapusListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            Model.setSelectedRow(viewPakan.getSelectedRow());
            try {
                Model.delete();
                //    view.disableEditAndDelete();
                int row = viewPakan.getTabel().getSelectedRow();
                String jumlah = viewPakan.getTabel().getValueAt(row, 7).toString();
                String harga = viewPakan.getTabel().getValueAt(row, 4).toString();
                int jumlah1 = Integer.parseInt(jumlah);
                int harga1 = Integer.parseInt(harga);
                int total = jumlah1 * harga1;
                int saldo = Integer.parseInt(viewPakan.getModal());
                int modal = saldo + total;
                Model.updateModal(modal);

                viewPakan.setTableModel(Model.getTableModel());
                JOptionPane.showMessageDialog(viewPakan, "anda telah menjual ayam dengan total penjualan " + total + "\n sisa saldo anda adalah" + modal);

            } catch (SQLException ex) {
                Logger.getLogger(Pakan.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    private class Pilih implements ActionListener {

        public Pilih() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String data[] = new String[4];
            try {
                System.out.println(mg);
                System.out.println(View.getPakan());
                data = Model.getTableModel(View.getPakan());

//                View.setKeterangan(data[0]);
                View.setefek(data[1]);
//                View.setKomposisi(data[2]);
                View.setharga(data[3]);
            } catch (SQLException ex) {
                Logger.getLogger(Pakan.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class beliListener implements ActionListener {

        private Component PakanView;

        public beliListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String minggu = "0";
            if (View.getJumlah().equals("")) {
                JOptionPane.showMessageDialog(View, "Masih ada Masukan kosong!");
            } //            else if (View.getJumlah() != "a-z") {
            //                 JOptionPane.showMessageDialog(View, "Masukan Harus Angka!");
            //            } 
            else {
                try {
                    String data[] = new String[4];
                    data = Model.getTableModel(View.getPakan());
                    //  int jumlah = Integer.parseInt(data[3]);
                    int jumlah = Integer.parseInt(View.getJumlah());
                    int harga = Integer.parseInt(View.getHarga());
                    System.out.println(harga);
                    int total = jumlah * harga;
                    int saldo = Integer.parseInt(View.getModal());
                    int modal = saldo - total;
                    Model.updateModal(modal);

                    Model.setIDPakan(Integer.parseInt(View.getPakan1()));
                    Model.setJumlah(View.getJumlah());
                    Model.setMinggu(mg);
                    System.out.println(mg);
                    Model.beli();
                    View.clearInput();
                    JOptionPane.showMessageDialog(PakanView, "anda telah membeli pakan dengan total pembelian " + total + "\n sisa saldo anda adalah" + modal);

                } catch (SQLException ex) {
                    Logger.getLogger(Pakan.class.getName()).log(Level.SEVERE, null, ex);

                }
            }

        }
    }
}
