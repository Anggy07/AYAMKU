/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam.Controller;

import ayam.view.KandangView;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Kandang {

    private ayam.view.KandangView view;
    private ayam.view.rincian_kandang ViewRincian;
    private ayam.Model.KANDANG model;

    public Kandang(ayam.view.KandangView v, ayam.Model.KANDANG m) throws SQLException {
        this.view = v;
        this.model = m;
        view.setModal(model.ambilMOdal());
        this.view.addbeliListener(new Kandang.beliListener());
        this.view.addrincianListener(new Kandang.rincianListener());
        this.view.addpilihListener(new Kandang.pilih());
        this.view.addkembali(new kembaliAwal());
        this.view.setVisible(true);
    }

    public Kandang(ayam.view.rincian_kandang vv, ayam.Model.KANDANG m) {
        try {
            this.ViewRincian = vv;
            this.model = m;
            this.ViewRincian.setModal(model.ambilMOdal());
            this.ViewRincian.addhapusListener(new Kandang.hapusListener());
            this.ViewRincian.setTableModel(this.model.getTableModel());
            this.ViewRincian.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Kandang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class rincianListener implements ActionListener {

        public rincianListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                ayam.view.rincian_kandang vv = new ayam.view.rincian_kandang();
                ayam.Model.KANDANG m = new ayam.Model.KANDANG();
                ayam.Controller.Kandang c = new ayam.Controller.Kandang(vv, m);
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembaliAwal implements ActionListener {

        public kembaliAwal() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String minggu = "0";
                ayam.view.pembelian v = new ayam.view.pembelian();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.pembelian c = new ayam.Controller.pembelian(v, m, minggu);
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class pilih implements ActionListener {

        public pilih() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String data[] = new String[6];
            try {
                data = model.getTableModel(view.getKandang());
            } catch (SQLException ex) {
                Logger.getLogger(Kandang.class.getName()).log(Level.SEVERE, null, ex);
            }

//            view.setJenisKandang(data[0]);
            //  view.setfasilitas(data[3]);
            view.setUkuran(data[1]);
            view.setJumlahAyam(data[2]);
            view.setharga(data[4]);

        }
    }

    private class beliListener implements ActionListener {

        private Component KandangView;

        public beliListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String data[] = new String[5];
                try {
                    data = model.getTableModel(view.getKandang());
                } catch (SQLException ex) {
                    Logger.getLogger(Kandang.class.getName()).log(Level.SEVERE, null, ex);
                }
                view.setharga(data[4]);
                if (view.getJumlah().equals("")) {
                    JOptionPane.showMessageDialog(view, "Masih ada Masukan kosong!");
                } else {
                    int harga = Integer.parseInt(data[4]);
                    System.out.println(harga);
                    int jumlah = Integer.parseInt(view.getJumlah());
                    int total = jumlah * harga;
                    int saldo = Integer.parseInt(view.getModal());
                    int modal = saldo - total;
                    model.updateModal(modal);
                    model.setIDKandang(Integer.parseInt(view.getKandang1()));
                    model.setJumlah(view.getJumlah());
                    model.beli();
                    view.clearInput();
                    JOptionPane.showMessageDialog(KandangView, "anda telah membeli kandang dengan total pembelian " + total + "\n sisa saldo anda adalah" + modal);

                }
            } catch (SQLException ex) {
                Logger.getLogger(Kandang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class hapusListener implements ActionListener {

        public hapusListener() {

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            model.setSelectedRow(ViewRincian.getSelectedRow());
            try {
                model.delete();
                //    view.disableEditAndDelete();
                int row = ViewRincian.getTabel().getSelectedRow();
                String jumlah = ViewRincian.getTabel().getValueAt(row, 7).toString();
                String harga = ViewRincian.getTabel().getValueAt(row, 6).toString();
                int jumlah1 = Integer.parseInt(jumlah);
                int harga1 = Integer.parseInt(harga);
                int total = jumlah1 * harga1;
                int saldo = Integer.parseInt(ViewRincian.getModal());
                int modal = saldo + total;
                model.updateModal(modal);
                ViewRincian.setTableModel(model.getTableModel());
                
                JOptionPane.showMessageDialog(ViewRincian, "anda telah menjual ayam dengan total penjualan " +total + "\n sisa saldo anda adalah" + modal);
           
                
            } catch (SQLException ex) {
                Logger.getLogger(Kandang.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }
}
