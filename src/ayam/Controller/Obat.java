/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam.Controller;

//import ayam.view.ObatView;
import com.sun.media.sound.ModelAbstractChannelMixer;
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
public class Obat {

    private ayam.view.sakit view;
    private ayam.view.rincian_obat viewObat;
    private ayam.view.infoObat info1;
    private ayam.Model.OBAT model;
    String mg;

    public Obat(ayam.view.infoObat v, ayam.Model.OBAT m, String minggu) {
       this.info1= v;
       this.model = m;
       this.info1.kembali(new kembali());
       this.info1.setVisible(true);
    }

    public Obat(ayam.view.sakit v, ayam.Model.OBAT m, String minggu) {
        mg = minggu;
        System.out.println("pembelian obat");
        System.out.println(mg);
        this.view = v;
        this.model = m;
//         view.setModal(model.ambilMOdal());
//        this.view.addbeliListener(new Obat.beliListener());
        this.view.addbeliListener(new beliListener());
        this.view.addrincianListener1(new Obat.rincianListener1());
        this.view.addpilihListener(new Pilih());
        this.view.kembali(new klikKembali());
        this.view.addInfo(new klikInfo());
        this.view.setVisible(true);
    }

    public Obat(ayam.view.rincian_obat vv, ayam.Model.OBAT m, String minggu) {
        try {
            this.viewObat = vv;
            this.model = m;
             mg = minggu;
            this.viewObat.addkembali(new kembalii());
            this.viewObat.addhapusListener(new Obat.hapusListener());
            this.viewObat.setTableModel(this.model.getTableModel());
            this.viewObat.setVisible(true);
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
                ayam.view.sakit v = new ayam.view.sakit();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
              //  String minggu = null;
                ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m, minggu);
                info1.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Obat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembalii implements ActionListener {

        public kembalii() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String minggu = mg;
                ayam.view.sakit v = new ayam.view.sakit();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m, minggu);
                viewObat.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Obat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class klikInfo implements ActionListener {

        public klikInfo() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                System.out.println("ingooo obaaaatttt");
                String minggu = mg;
                ayam.view.infoObat v = new ayam.view.infoObat();
                ayam.Model.OBAT m = new ayam.Model.OBAT();
                ayam.Controller.Obat c = new ayam.Controller.Obat(v, m, minggu);
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Obat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class klikKembali implements ActionListener {

        public klikKembali() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String minggu = mg;
                ayam.view.kondisi v = new ayam.view.kondisi();
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m, mg);
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Obat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class rincianListener1 implements ActionListener {

        public rincianListener1() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String minggu = mg;
                ayam.view.rincian_obat vv = new ayam.view.rincian_obat();
                ayam.Model.OBAT m = new ayam.Model.OBAT();
                ayam.Controller.Obat c = new ayam.Controller.Obat(vv, m, minggu);
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Obat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class hapusListener implements ActionListener {

        public hapusListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            model.setSelectedRow(viewObat.getSelectedRow());
            try {
                model.delete();
                //    view.disableEditAndDelete();
                viewObat.setTableModel(model.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(Obat.class.getName()).log(Level.SEVERE, null, ex);

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
                data = model.getTableModel(view.getObat());
            } catch (SQLException ex) {
                Logger.getLogger(Obat.class.getName()).log(Level.SEVERE, null, ex);
            }

//            view.setketerangan(data[0]);
//            view.setrincian(data[1]);
//            view.setAturan(data[2]);
//            view.setharga(data[3]);
        }
    }

    private class beliListener implements ActionListener {

        private Component ObatView;

        public beliListener() {

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
//            System.out.println("gdjasgjkhfkekhfjkdhgkrj");
            if (view.getJumlah().equals("")) {
                JOptionPane.showMessageDialog(view, "Masih ada Masukan kosong!");
            }
            try {
                String data[] = new String[4];
                data = model.getTableModel(view.getObat());
                int jumlah = Integer.parseInt(view.getJumlah());
                int harga = Integer.parseInt(data[3]);
                int total = jumlah * harga;

                int j = Integer.parseInt(view.getJumlahAyam());
                String s = view.getSakit();
                String id = view.getObat1();
                int obat = Integer.parseInt(view.getJumlah());
                total = jumlah * harga;
                int saldo = Integer.parseInt(model.ambilMOdal());
                int modal = saldo - total;
                model.updateModal(modal);
                model.setIDObat(Integer.parseInt(view.getObat1()));
                model.setJumlah(view.getJumlah());
                model.setMinggu(mg);
                view.clearInput();
                System.out.println("sakitnya dia adalah " + s);
                System.out.println("dia beli obat dengan id " + id);
                System.out.println("beli obat " + obat);
                System.out.println("jumlah ayam " + j);

                if (s.contains("Diare") && id.contains("8")) {
                    System.out.println("diare1");
                    if (obat >= j) {
                        System.out.println("diare2");
//                            model.beli();
                        model.updateKondisi(j, "Diare");
                        JOptionPane.showMessageDialog(view, "anda telah membeli obat dengan total pembelian " + total + "\n sisa saldo anda adalah" + modal);
                    } else {
                        JOptionPane.showMessageDialog(view, "Jumlah obat yang anda beli kurang");
//                            int a = obat;
//                            model.updateKondisi(a, "Diare");
                    }
                } else if ((s.contains("Stress") && id.contains("1"))
                        || (s.contains("Stress") && id.contains("2"))
                        || (s.contains("Stress") && id.contains("7"))) {
                    System.out.println("stres1");
                    if (obat >= j) {
                        System.out.println("Stres2");
//                            model.beli();
                        model.updateKondisi(j, "Stress");
                        JOptionPane.showMessageDialog(view, "anda telah membeli obat dengan total pembelian " + total + "\n sisa saldo anda adalah" + modal);
                    } else {
                        JOptionPane.showMessageDialog(view, "Jumlah obat yang anda beli kurang");
//                            int a = obat;
//                            model.updateKondisi(a, "Stress");
                    }
                } else if (s.contains("Berak Kapur") && id.contains("5")) {
                    if (obat >= j) {
                        System.out.println("BK2");
//                            model.beli();
                        model.updateKondisi(j, "Berak Kapur");
                        JOptionPane.showMessageDialog(view, "anda telah membeli obat dengan total pembelian " + total + "\n sisa saldo anda adalah" + modal);
                    } else {
                        JOptionPane.showMessageDialog(view, "Jumlah obat yang anda beli kurang");
//                            int a = obat;
//                            model.updateKondisi(a, "Berak Kapur");
                    }
                } else if (s.contains("Berak Darah") && id.contains("5")) {
                    if (obat >= j) {
                        System.out.println("BD2");
//                            model.beli();
                        model.updateKondisi(j, "Berak Darah");
                        JOptionPane.showMessageDialog(view, "anda telah membeli obat dengan total pembelian " + total + "\n sisa saldo anda adalah" + modal);
                    } else {
                        JOptionPane.showMessageDialog(view, "Jumlah obat yang anda beli kurang");
//                            int a = obat;
//                            model.updateKondisi(a, "Berak Darah");
                    }
                } else if (s.contains("Pullorum") && id.contains("8")) {
                    if (obat >= j) {
                        System.out.println("P2");
//                            model.beli();
                        model.updateKondisi(j, "Pullorum");
                        JOptionPane.showMessageDialog(view, "anda telah membeli obat dengan total pembelian " + total + "\n sisa saldo anda adalah" + modal);
                    } else {
                        JOptionPane.showMessageDialog(view, "Jumlah obat yang anda beli kurang");
//                            int a = obat;
//                            model.updateKondisi(a, "Pullroum");
                    }
                } else if ((s.contains("Ngorok") && id.contains("3"))
                        || (s.contains("Ngorok") && id.contains("5"))) {
                    if (obat >= j) {
                        System.out.println("S2");
//                            model.beli();
                        model.updateKondisi(j, "Ngorok");
                        JOptionPane.showMessageDialog(view, "anda telah membeli obat dengan total pembelian " + total + "\n sisa saldo anda adalah" + modal);
                    } else {
                        JOptionPane.showMessageDialog(view, "Jumlah obat yang anda beli kurang");
//                            int a = obat;
//                            model.updateKondisi(a, "Ngorok");
                    }
                } else if ((s.contains("Korisa") && id.contains("3"))
                        || (s.contains("Korisa") && id.contains("5"))) {
                    if (obat >= j) {
                        System.out.println("K2");
//                            model.beli();
                        model.updateKondisi(j, "Korisa");
                        JOptionPane.showMessageDialog(view, "anda telah membeli obat dengan total pembelian " + total + "\n sisa saldo anda adalah" + modal);
                    } else {
                        JOptionPane.showMessageDialog(view, "Jumlah obat yang anda beli kurang");
//                            int a = obat;
//                            model.updateKondisi(a, "Korisa");
                    }
                } else if ((s.contains("Kolera") && id.contains("3"))
                        || (s.contains("Kolera") && id.contains("5"))) {
                    if (obat >= j) {
                        System.out.println("Ko2");
//                            model.beli();
                        model.updateKondisi(j, "Kolera");
                        JOptionPane.showMessageDialog(view, "anda telah membeli obat dengan total pembelian " + total + "\n sisa saldo anda adalah" + modal);
//                ayam.Model.AYAM m = new ayam.Model.AYAM();
//                m.getTableModel2();
                    } else {
                        JOptionPane.showMessageDialog(view, "Jumlah obat yang anda beli kurang");
//                            int a = obat;
//                            model.updateKondisi(a, "Kolera");
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "obat yang anda beli salah");

                }

                ayam.Model.AYAM m = new ayam.Model.AYAM();
                view.setTableModel(m.getTableModel2());
                model.beli();
            } catch (SQLException ex) {
                Logger.getLogger(Obat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
