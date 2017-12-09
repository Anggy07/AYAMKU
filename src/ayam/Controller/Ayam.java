
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam.Controller;

import ayam.Model.AYAM;
import ayam.view.AyamView;
import ayam.view.kondisi;
import ayam.view.penjualan;
import ayam.view.sakit;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author anggy
 */
public class Ayam {

    private ayam.view.AyamView View;
    private ayam.view.rincian_ayam view;
    private ayam.view.penjualan viewJual;
    private ayam.view.kondisi kondisi;
    private ayam.view.penjualan jual;
    private ayam.view.rincianPenjualan rJual;
    private ayam.view.sakit sakit;
    private ayam.Model.AYAM Model;
    int uang;
    String mg;
    private int modal;

    public Ayam(ayam.view.AyamView v, ayam.Model.AYAM m) throws SQLException {
        this.View = v;
        this.Model = m;
        View.setModal(Model.ambilMOdal());
        System.out.println("pembelian ayam");
        this.View.addrincianListener(new rincianListener());
        this.View.addbeliListener(new beliListener());
        this.View.addkembali(new kembaliAwal());
        this.View.setVisible(true);
    }

    public Ayam(ayam.view.penjualan j, ayam.Model.AYAM m) throws SQLException {
        this.viewJual = j;
        this.Model = m;
        this.viewJual.setModal(Model.ambilMOdal());
        this.viewJual.addkembali(new kembali());
        this.viewJual.addRincianJual(new rincianJual());
        this.viewJual.addPenjualan(new jual());
        this.viewJual.tabeljual(new tabelListenerjual());
        this.viewJual.setTableModel(this.Model.getTableModel3());
        this.viewJual.setVisible(true);
    }

    public Ayam(ayam.view.rincian_ayam vv, ayam.Model.AYAM m) throws SQLException {
        this.view = vv;
        this.Model = m;
        this.view.setModal(Model.ambilMOdal());
        this.view.addhapusListener(new hapusListener());
        this.view.setTableModel(this.Model.getTableModel());
        this.view.setVisible(true);
    }

    public Ayam(ayam.view.rincianPenjualan v, ayam.Model.AYAM m) throws SQLException {
        this.rJual = v;
        this.Model = m;
        int saldo = 10000000;
        int profit = Integer.parseInt(Model.ambilMOdal());
        int modal = profit - saldo;
        System.out.println("iki untunge"+modal);
        this.rJual.RESET(new reset());
        this.rJual.setProfit(Integer.toString(modal));
        this.rJual.addkembali(new addkembali());
        this.rJual.setTableModel(this.Model.getTableModel4());
        this.rJual.setVisible(true);
    }

    public Ayam(ayam.view.kondisi k, ayam.Model.AYAM m, String minggu) throws SQLException {
        this.mg = minggu;
        System.out.println("kondisi");
        System.out.println(mg);
        this.kondisi = k;
        this.Model = m;
        this.Model.setMinggu(mg);
        this.kondisi.setTableModel(this.Model.getTableModel1());
        this.kondisi.klikSakit(new sakitListener());

        this.kondisi.klikBeli(new beliLagiListener());
        this.kondisi.klikKembali(new kembali1Listener());
        this.kondisi.setVisible(true);
    }

    public Ayam(ayam.view.sakit k, ayam.Model.AYAM m, String minggu) throws SQLException {
        this.mg = minggu;
        System.out.println("perawatan sakit");
        System.out.println(mg);
        this.sakit = k;
        this.Model = m;
        this.sakit.setTableModel(this.Model.getTableModel2());
        this.sakit.klikKembali(new kembaliListener());
        this.sakit.tabelSakit(new tabelListener());
        this.sakit.addrincianListener1(new rincian());
        this.sakit.setVisible(true);
    }

    private class reset implements ActionListener {

        public reset() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                JOptionPane.showMessageDialog(rJual, "Apakah anda yakin ingin mereset ulang simulasi anda?");
                Model.Reset();
                Model.ResetModal();
                JOptionPane.showMessageDialog(rJual, "program telah berhasil di reset ulang");
               

            } catch (SQLException ex) {
                Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class addkembali implements ActionListener {

        public addkembali() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                ayam.view.penjualan v = new ayam.view.penjualan();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m);
                rJual.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class rincianJual implements ActionListener {

        public rincianJual() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                ayam.view.rincianPenjualan v = new ayam.view.rincianPenjualan();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m);
                viewJual.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembaliAwal implements ActionListener {

        public kembaliAwal() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String minggu =mg;
                ayam.view.pembelian v = new ayam.view.pembelian();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.pembelian c = new ayam.Controller.pembelian(v, m, minggu);
                View.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class tabelListenerjual implements MouseListener {

        public tabelListenerjual() {
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            int row = viewJual.getTabel().getSelectedRow();
            String jumlah = viewJual.getTabel().getValueAt(row, 0).toString();
            String berat = viewJual.getTabel().getValueAt(row, 1).toString();

            viewJual.setjumlah(jumlah);
            viewJual.setBerat(berat);

            System.out.println("jumlah ayam nya = " + jumlah);
            System.out.println("beratnya = " + berat);
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

    private class jual implements ActionListener {

        public jual() {

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (viewJual.getjumlah().equals("") && viewJual.getHarga().equals("")) {
                JOptionPane.showMessageDialog(viewJual, "Masih ada Masukan kosong!");
//            } else if (viewJual.getjumlah() != "a-z" && viewJual.getHarga() != "a-z") {
//                JOptionPane.showMessageDialog(viewJual, "Masukan Harus Angka!");
            } else {
                try {
               //     System.out.println(+viewJual.getjumlah());

                    // Model.setSelectedRow(viewJual.getSelectedRow());
                    //Model.deleteae();
                    int harga = Integer.parseInt(viewJual.getHarga());
                    int jumlah = Integer.parseInt(viewJual.getjumlah());
                    int berat = Integer.parseInt(viewJual.getBerat());
                    viewJual.clearInput();

                    Model.setjumlahAyam(Integer.toString(jumlah));
                    System.out.println("aaaaaaaaaa " + jumlah);
                    Model.updateStatus(berat);

                    Model.setberatAyam(Integer.toString(berat));
                    Model.sethargaJual(Integer.toString(harga));
                    int totalJual = (berat * jumlah * harga) / 1000;
                    Model.settotalPenjualan(Integer.toString(totalJual));

                    int saldo = Integer.parseInt(viewJual.getModal());
                    modal = saldo + totalJual;
                    try {
                        Model.updateModal(modal);
                        Model.Jual();
                        System.out.println("modal ku saiki : "+modal);

                    } catch (SQLException ex) {
                        Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.println(totalJual);
                    JOptionPane.showMessageDialog(viewJual, "total penjualan anda: " + totalJual + "/n saldo anda : " + modal);
                    viewJual.setTableModel(Model.getTableModel3());

                } catch (SQLException ex) {
                    Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    private class kembali implements ActionListener {

        public kembali() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            ayam.view.utama v = new ayam.view.utama();
            ayam.Controller.utama c = new ayam.Controller.utama(v);
            viewJual.setVisible(false);
        }
    }

    private class rincian implements ActionListener {

        public rincian() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                ayam.view.rincian_obat vv = new ayam.view.rincian_obat();
                ayam.Model.OBAT m = new ayam.Model.OBAT();
                ayam.Controller.Obat c = new ayam.Controller.Obat(vv, m, mg);
                sakit.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class tabelListener implements MouseListener {

        public tabelListener() throws SQLException {
            ayam.view.rincian_obat vv = new ayam.view.rincian_obat();
            ayam.Model.OBAT m = new ayam.Model.OBAT();
            ayam.Controller.Obat c = new ayam.Controller.Obat(vv, m, mg);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = sakit.getTabel().getSelectedRow();
            String jumlah = sakit.getTabel().getValueAt(row, 0).toString();
            String sakitt = sakit.getTabel().getValueAt(row, 1).toString();

            sakit.setJumlahAyam(jumlah);
            sakit.setSakit(sakitt);

            System.out.println("jumlah ayam sakit = " + jumlah);
            System.out.println("sakitnya = " + sakitt);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class kembali1Listener implements ActionListener {

        public kembali1Listener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                ayam.view.perawatan v = new ayam.view.perawatan();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.perawatan c = new ayam.Controller.perawatan(v, m);
                kondisi.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class beliLagiListener implements ActionListener {

        public beliLagiListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            Model.setMinggu(mg);
            try {
                ayam.view.PakanView v;
                if (Integer.parseInt(mg) < 3) {
                    v = new ayam.view.PakanView();
                } else {

                    v = new ayam.view.PakanView();
                }

                ayam.Model.PAKAN m = new ayam.Model.PAKAN();
                ayam.Controller.Pakan c = new ayam.Controller.Pakan(v, m, mg);
            } catch (SQLException ex) {
                Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class sakitListener implements ActionListener {

        public sakitListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String minggu = mg;
                ayam.view.sakit v = new ayam.view.sakit();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m, minggu);
                kondisi.setVisible(false);

                ayam.Model.OBAT mo = new ayam.Model.OBAT();
                ayam.Controller.Obat cc = new ayam.Controller.Obat(v, mo, minggu);
            } catch (SQLException ex) {
                Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembaliListener implements ActionListener {

        public kembaliListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String minggu= mg ;
                ayam.view.kondisi v = new ayam.view.kondisi();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m, mg);
                sakit.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(sakit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class hapusListener implements ActionListener {

        private Component rincianView;

        public hapusListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                Model.setSelectedRow(view.getSelectedRow());

                Model.delete();
                //    view.disableEditAndDelete();
                int row = view.getTabel().getSelectedRow();
                String jumlah = view.getTabel().getValueAt(row, 4).toString();
                int total = Integer.parseInt(jumlah);
                int harga = total * 2500;
                int saldo = Integer.parseInt(view.getModal());
                modal = saldo + harga;
                Model.updateModal(modal);

                view.setTableModel(Model.getTableModel());

                JOptionPane.showMessageDialog(rincianView, "anda telah menjual ayam dengan total penjualan " + harga + "\n sisa saldo anda adalah" + modal);
            } catch (SQLException ex) {
                Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class ubahListener implements ActionListener {

        public ubahListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            Model.setSelectedRow(view.getSelectedRow());
            //   view.setjumlah(Model.getjumlah());

        }
    }

    private class rincianListener implements ActionListener {

        public rincianListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                ayam.view.rincian_ayam vv = new ayam.view.rincian_ayam();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.Ayam v = new ayam.Controller.Ayam(vv, m);
                View.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class beliListener implements ActionListener {

        private Component AyamView;

        public beliListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (View.getjumlah().equals("")) {
                JOptionPane.showMessageDialog(AyamView, "Masih ada Masukan kosong!");
//            } else if (View.getjumlah().matches("[0-9]")) {
//                JOptionPane.showMessageDialog(AyamView, "Masukan Harus Angka!");
            } else {

                try {

                    int jumlah = Integer.parseInt(View.getjumlah());
                    int total = jumlah * 2500;
                    int saldo = Integer.parseInt(View.getModal());
                    modal = saldo - total;
                    Model.updateModal(modal);
                    System.out.println("cek " + Integer.toString(total));
                    System.out.println("cek salado" + (modal));
                    Model.setumur("10");
                    Model.setberat("200");
                    Model.setharga("2500");
                    //Model.setSaldo("20000000");
                    Model.setKondisi("sehat");
                    Model.setjumlah(View.getjumlah());
                    Model.beli();
                    View.clearInput();
                    for (int i = 0; i < jumlah; i++) {
                        System.out.println("lala");
                        Model.beliAyam();
                    }

                    JOptionPane.showMessageDialog(AyamView, "anda telah membeli ayam dengan total pembelian " + total + "\n sisa saldo anda adalah" + modal);

                } catch (SQLException ex) {
                    Logger.getLogger(Ayam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
