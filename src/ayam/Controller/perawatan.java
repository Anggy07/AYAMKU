/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam.Controller;

/**
 *
 * @author anggy
 */
import ayam.view.utama;
import com.sun.xml.internal.ws.api.policy.ModelUnmarshaller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class perawatan {

    private ayam.view.perawatan view;
    private ayam.Model.AYAM model;

    public perawatan(ayam.view.perawatan v, ayam.Model.AYAM m) {
        this.view = v;
        this.model = m;
        System.out.println("metuo");
        this.view.addperawatan(new ButtonMinggu1());
        this.view.addperawatan2(new buttonMinggu2());
        this.view.addperawatan3(new buttonMinggu3());
        this.view.addperawatan4(new buttonMinggu4());
        this.view.kembali(new kembali());
        this.view.setVisible(true);

    }

    private class kembali implements ActionListener {

        public kembali() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            ayam.view.utama v = new ayam.view.utama();
            ayam.Controller.utama c = new ayam.Controller.utama(v);
            view.setVisible(false);
        }
    }

    private class ButtonMinggu1 implements ActionListener {

        public ButtonMinggu1() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String minggu = "1";
                int ayamMati = 0;
                int stres = 0;
                int diare = 0;
                int sisaAyam = 0;
                int KorbanAyam = 0;
                int totalStres = 0;
                int sisa = 0;
                System.out.println("metu");

                try {
                    String a = "0";
                    model.setMinggu(a);
                    int JumlahAyam = model.ambilJumlahAyam();
                    System.out.println(JumlahAyam);
                    int Jumlahpakan = model.ambilJumlahPakan();
                    System.out.println(Jumlahpakan);
                    int tipeKandang = model.ambilTipeKandang();
                    System.out.println(tipeKandang);

                    int beratAyam = Integer.parseInt(model.ambilBeratAyam());
                    System.out.println("iki" + beratAyam);
                    int efekPakan = Integer.parseInt(model.ambilEfekPakan());
                    System.out.println("iki" + efekPakan);

                    int beratAwal = 200;

                    if (JumlahAyam <= tipeKandang && JumlahAyam > Jumlahpakan) {
                        KorbanAyam = JumlahAyam - Jumlahpakan;
                        System.out.println("Jumlah Ayam = " + JumlahAyam + " Jumlah Pakan = " + Jumlahpakan);
                        stres = KorbanAyam * 40 / 100;
                        ayamMati = KorbanAyam - stres;
                        int n = stres + ayamMati;
                        model.updateKondisi(n, "Sakit", "Stress");
                        model.updateKondisi(ayamMati, "Mati");
//                        int sehat = beratAwal + ((efekPakan / 7) * 5);
//                        int stress = beratAwal + ((efekPakan / 7) * 5) - 23;
                        int sehat = ((efekPakan / 7) * 5);
                        int stress = ((efekPakan / 7) * 5) - 23;
                        model.updateBeratSehat(sehat);
                        model.updateBeratStres(stress);
                        System.out.println("if 1 : " + stres + ", " + ayamMati);
                    }

                    if (JumlahAyam > tipeKandang && JumlahAyam <= Jumlahpakan) {
                        ayamMati = JumlahAyam * 10 / 100;
                        stres = JumlahAyam * 15 / 100;
                        sisaAyam = JumlahAyam - stres - ayamMati;
                        diare = sisaAyam * 10 / 100;
                        int stresss = stres + diare + ayamMati;
                        int sehat = ((efekPakan / 7) * 5);
                        int stress = ((efekPakan / 7) * 5) - 23;
                        int mencret = stres + ayamMati;
                        model.updateBeratSehat(sehat);
                        model.updateBeratStres(stress);
                        model.updateKondisi(stresss, "Sakit", "Stress");
                        model.updateKondisi(mencret, "Sakit", "Diare");
                        model.updateKondisi(ayamMati, "Mati");
                        System.out.println("if 2 : " + ayamMati + ", " + stres + ", " + diare);

                    }
                    if (JumlahAyam > tipeKandang && JumlahAyam > Jumlahpakan) {
                        KorbanAyam = JumlahAyam - Jumlahpakan; // ayam yang jadi korban karena pakan
                        stres = KorbanAyam * 40 / 100; // ayam stress
                        ayamMati = KorbanAyam - stres; // ayam mati karena stres kandang
                        sisaAyam = JumlahAyam - KorbanAyam; //ayam sehat
                        totalStres = (sisaAyam * 10 / 100) + stres;
                        sisa = sisaAyam - (sisaAyam * 10 / 100);//sisa ayam dr sebab kandang
                        diare = sisa * 10 / 100;

                        int sehat = ((efekPakan / 7) * 5);
                        int stress = ((efekPakan / 7) * 5) - 23;
                        int bbdiare = ((efekPakan / 7) * 5) - 20;

                        int stre = ayamMati + totalStres + diare;
                        int mencret = ayamMati + diare;
                        int sehattt = JumlahAyam;
                        model.updateKondisi(sehattt, "sehat");
                        model.updateKondisi(stre, "Sakit", "Stress");
                        model.updateKondisi(mencret, "Sakit", "Diare");
                        model.updateKondisi(ayamMati, "Mati");
                        model.updateBeratStres(stress);
                        System.out.println(stress);
                        model.updateBeratSehat(sehat);
                        model.updateBeratDiare(bbdiare);
                        System.out.println("if 3 : " + ayamMati + ", " + totalStres + ", " + diare);
                    }
                    if (JumlahAyam <= tipeKandang && JumlahAyam <= Jumlahpakan) {
                        int berakDarah = JumlahAyam * 10 / 100;
                        int berakKapur = JumlahAyam * 10 / 100;
                        diare = JumlahAyam * (10 / 100);

                        int sehat = ((efekPakan / 7) * 7);
                        int stress =  ((efekPakan / 7) * 7) - 23;
                        int bbdiare =  ((efekPakan / 7) * 7) - 20;

                        int darah = berakDarah + berakKapur + diare;
                        int kapur = diare + berakKapur;
                        model.updateKondisi(darah, "Sakit", "Berak Darah");
                        model.updateKondisi(kapur, "Sakit", "Berak Kapur");
                        model.updateKondisi(diare, "Sakit", "Diare");

                        model.updateBeratSehat(sehat);
                        model.updateBeratKapur(bbdiare);
                        model.updateBeratDarah(bbdiare);
                        model.updateBeratDiare(bbdiare);
                        System.out.println("if 4 : " + berakDarah + ", " + berakKapur + ", " + diare);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(perawatan.class.getName()).log(Level.SEVERE, null, ex);
                }
                ayam.view.kondisi v = new ayam.view.kondisi();
                System.out.println("co");
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m, minggu);
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(perawatan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class buttonMinggu2 implements ActionListener {

        public buttonMinggu2() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {

            System.out.println("metu");
            try {
                String minggu = "2";

                int ayamMati = 0;
                int stres = 0;
                int diare = 0;
                int sisaAyam = 0;
                int KorbanAyam = 0;
                int totalStres = 0;
                int koleraa = 0;
                int kolera = 0;
                int sisa = 0;
                int sisasehat = 0;
                int berakKapurr = 0;

                try {
                    String a = "1";
                    model.setMinggu(a);
                    int JumlahAyam = model.ambilJumlahAyamSehat();
                    System.out.println(JumlahAyam);
//
                    int JumlahAyamsehat = model.ambilJumlahAyamSehat();
                    System.out.println(JumlahAyamsehat);
//
                    int JumlahAyamsakit = model.ambilJumlahAyamSakit();
                    System.out.println(JumlahAyamsakit);
//
                    int efekPakan = Integer.parseInt(model.ambilEfekPakan());
                    System.out.println("iki" + efekPakan);

                    int Jumlahpakan = model.ambilJumlahPakan();
                    System.out.println(Jumlahpakan);
//
                    int tipeKandang = model.ambilTipeKandang();
                    System.out.println(tipeKandang);
//
                    int beratAyam = Integer.parseInt(model.ambilBeratAyam());
                    System.out.println("iki" + beratAyam);
//
//
                    int beratAwal = 200;
//                    model.updateKondisi(JumlahAyamsakit, "mati");
//
                    if (JumlahAyam <= tipeKandang && JumlahAyam > Jumlahpakan) {
                        KorbanAyam = JumlahAyam - Jumlahpakan;
                        System.out.println("Jumlah Ayam = " + JumlahAyam + " Jumlah Pakan = " + Jumlahpakan);
                        stres = KorbanAyam * 40 / 100;
                        ayamMati = KorbanAyam - stres;
                        kolera = (JumlahAyam-KorbanAyam)*10 / 100;
                        int n = kolera+stres + ayamMati;
                        int m = stres + ayamMati;
                        model.updateKondisi(n, "Sakit", "Stress");
                        model.updateKondisi(m, "Sakit", "Kolera");
//                        model.updateKondisi(n, "Sakit", "Stress");
                        model.updateKondisi(ayamMati, "Mati");
                        int sehat =  ((efekPakan / 7) * 5);
                        int stress = ((efekPakan / 7) * 5) - 20;
                        int kol = ((efekPakan / 7) * 5) - 30;
                        
                        model.updateBeratSehat(sehat);
                        model.updateBeratStres(stress);
                        model.updateKolera(kol);
                        System.out.println("if 1 : " + stres + ", " + ayamMati);
                    }

                    if (JumlahAyam > tipeKandang && JumlahAyam <= Jumlahpakan) {
                        ayamMati = JumlahAyam * 10 / 100;
                        stres = JumlahAyam * 15 / 100;
                        sisaAyam = JumlahAyam - stres - ayamMati;
                        diare = sisaAyam * 10 / 100;
                        kolera = (sisaAyam-diare) * 10 / 100;
                        int k = stres + diare + ayamMati + kolera;
                        int stresss = stres + diare + ayamMati;

                        int sehat = ((efekPakan / 7) * 5);
                        int stress = ((efekPakan / 7) * 5) - 23;
                        koleraa = ((efekPakan / 7) * 5) - 30;

                        int mencret = stres + ayamMati;
                        model.updateBeratSehat(sehat);
//                        model.updateBeratStres(stress);
                        model.updateKondisi(k, "Sakit", "Kolera", koleraa);
                        model.updateKondisi(stresss, "Sakit", "Stress", stress);
//                              model.updateKondisi(mencret, "Sakit", "Diare");
                        model.updateKondisi(ayamMati, "Mati");
//                        model.updateKolera(koleraa);
                        System.out.println("if 2 : " + ayamMati + ", " + stres + ", " + diare);

                    }
                    model.updateKondisi(JumlahAyamsakit, "mati");
                    if (JumlahAyam > tipeKandang && JumlahAyam > Jumlahpakan) {
                        KorbanAyam = JumlahAyam - Jumlahpakan; // ayam yang jadi korban karena pakan
                        stres = KorbanAyam * 40 / 100; // ayam stress
                        ayamMati = KorbanAyam - stres; // ayam mati karena stres kandang
                        sisaAyam = JumlahAyam - KorbanAyam; //ayam sehat
                        totalStres = (sisaAyam * 10 / 100) + stres;
                        sisa = sisaAyam - (sisaAyam * 10 / 100);//sisa ayam dr sebab kandang
                        kolera = sisa * 10 / 100;
//                        berakKapurr = (sisa-kolera) * 10 / 100;

//                        kolera = JumlahAyamsehat * 10 / 100;
                        int sehat = ((efekPakan / 7) * 5);
                        int stress = ((efekPakan / 7) * 5) - 23;
                        int bbkolera = ((efekPakan / 7) * 5) - 30;
//                        int berakKapur = ((efekPakan / 7) * 5) - 30;

                        int stre = ayamMati + totalStres;
                        int k = stre + diare + kolera;
                        int kol = stre + diare;
                        model.updateKondisi(kol, "Sakit", "Kolera", bbkolera);
                        model.updateKondisi(stre, "Sakit", "Stress", stress);
                        model.updateKondisi(ayamMati, "Mati");
//                        model.updateKondisi(k, "Sakit", "berak kapur", berakKapur);
                        model.updateBeratSehat(sehat);
//                        model.updateBeratStres(stress);
//                        model.updateBeratDiare(bbdiare);
//                        model.updateBeratKapur(berakKapur);
                        System.out.println("if 3 : " + ayamMati + ", " + totalStres + ", " + diare + ", " + berakKapurr);
                    }
                    if (JumlahAyam <= tipeKandang && JumlahAyam <= Jumlahpakan) {
                        kolera = JumlahAyam * 10 / 100;
                        int berakKapur = JumlahAyam * 10 / 100;
                        diare = JumlahAyam * (10 / 100);

                        int sehat = ((efekPakan / 7) * 7);
                        int stress = ((efekPakan / 7) * 7) - 23;
                        int bbdiare = ((efekPakan / 7) * 7) - 20;
                        int koleraaa = ((efekPakan / 7) * 7) - 30;

                        int kol = kolera + berakKapur + diare;
                        int kapur = diare + berakKapur;
                        model.updateKondisi(kol, "Sakit", "Kolera");
                        model.updateKondisi(kapur, "Sakit", "Berak Kapur");
                        model.updateKondisi(diare, "Sakit", "Diare");

                        model.updateBeratSehat(sehat);
                        model.updateBeratKapur(bbdiare);
                        model.updateKolera(koleraaa);
                        model.updateBeratDiare(bbdiare);
                        System.out.println("if 4 : " + kolera + ", " + berakKapur + ", " + diare);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(perawatan.class.getName()).log(Level.SEVERE, null, ex);
                }
                ayam.view.kondisi v = new ayam.view.kondisi();
                System.out.println("co");
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m, minggu);
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(perawatan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class buttonMinggu4 implements ActionListener {

        public buttonMinggu4() {
        }

        @Override

        public void actionPerformed(ActionEvent ae) {

            try {
                String minggu = "4";
                model.setMinggu(minggu);
                System.out.println("metu");
                int ayamMati = 0;
                int stres = 0;
                int diare = 0;
                int sisaAyam = 0;
                int KorbanAyam = 0;
                int totalStres = 0;
                int koleraa = 0;
                int kolera = 0;
                int sisa = 0;
                int sisasehat = 0;
                int berakKapurr = 0;

                try {
                    String a = "3";
                    model.setMinggu(a);
                    int JumlahAyam = model.ambilJumlahAyamSehat();
                    System.out.println(JumlahAyam);
                    int Jumlahpakan = model.ambilJumlahPakan();
                    System.out.println(Jumlahpakan);
                    int tipeKandang = model.ambilTipeKandang();
                    System.out.println(tipeKandang);

                    int JumlahAyamsehat = model.ambilJumlahAyamSehat();
                    System.out.println(JumlahAyamsehat);
//
                    int JumlahAyamsakit = model.ambilJumlahAyamSakit();
                    System.out.println(JumlahAyamsakit);
//
                    int efekPakan = Integer.parseInt(model.ambilEfekPakan());
                    System.out.println("iki" + efekPakan);

                    int beratAwal = 200;

                    if (JumlahAyam <= tipeKandang && JumlahAyam > Jumlahpakan) {
                            KorbanAyam = JumlahAyam - Jumlahpakan;
                            System.out.println("Jumlah Ayam = " + JumlahAyam + " Jumlah Pakan = " + Jumlahpakan);
                            stres = KorbanAyam * 40 / 100;
                            ayamMati = KorbanAyam - stres;
                            int ngorok = (JumlahAyam-KorbanAyam) * 10 /100;
                            int n = stres + ayamMati + ngorok;
                            int m = stres + ayamMati ;
                            model.updateKondisi(n, "Sakit", "Ngorok");
                            model.updateKondisi(m, "Sakit", "Stress");
                            model.updateKondisi(ayamMati, "Mati");
                            int sehat =  ((efekPakan / 7) * 5);
                            int stress =  ((efekPakan / 7) * 5) - 20;
                            int ngor =  ((efekPakan / 7) * 5) - 30;
                            model.updateBeratSehat(sehat);
                            model.updateBeratStres(stress);
                            model.updateNgorok(ngor);
                            System.out.println("if 1 : " + stres + ", " + ayamMati);
                        }

                        if (JumlahAyam > tipeKandang && JumlahAyam <= Jumlahpakan) {
                            ayamMati = JumlahAyam * 10 / 100;
                            stres = JumlahAyam * 15 / 100;
                            sisaAyam = JumlahAyam - stres;
                            int Ngorok = sisaAyam * 10 / 100;
//                            int k = stres + korisa + ayamMati + pullorum;
                            int ngorr = stres + Ngorok + ayamMati;

                            int sehat = ((efekPakan / 7) * 5);
                            int stress = ((efekPakan / 7) * 5) - 23;
                            int ngor = ((efekPakan / 7) * 5) - 30;

                            int st = stres + ayamMati;
//                            model.updateKondisi(k, "Sakit", "Korisa");
                            model.updateKondisi(ngorr, "Sakit", "Ngorok");
                                  model.updateKondisi(st, "Sakit", "Stress");
                            model.updateKondisi(ayamMati, "Mati");
                            model.updateBeratSehat(sehat);
                            model.updateBeratStres(stress);
                            model.updateNgorok(ngor);
                            System.out.println("if 2 : " + ayamMati + ", " + stres + ", " + Ngorok);

                        }
                    if (JumlahAyam > tipeKandang && JumlahAyam > Jumlahpakan) {
                        KorbanAyam = JumlahAyam - Jumlahpakan; // ayam yang jadi korban karena pakan
                        stres = KorbanAyam * 40 / 100; // ayam stress
                        ayamMati = KorbanAyam - stres; // ayam mati karena stres kandang
                        sisaAyam = JumlahAyam - KorbanAyam; //ayam sehat
                        totalStres = (sisaAyam * 10 / 100) + stres;
                        sisa = sisaAyam - (sisaAyam * 10 / 100);//sisa ayam dr sebab kandang
                        int Ngorok = sisa * 10 / 100;

                        int sehat = ((efekPakan / 7) * 5);
                        int ngor = ((efekPakan / 7) * 5) - 30;
                        int stress = ((efekPakan / 7) * 5) - 23;
//                        int bbdiare = ((efekPakan / 7) * 5) - 20;

                        int st = ayamMati + totalStres + Ngorok;
                        int ngorr = ayamMati + Ngorok;
                        int sehattt = JumlahAyam;
//                        model.updateKondisi(sehattt, "sehat");
                        model.updateKondisi(st, "Sakit", "Stress");
                        model.updateKondisi(ngorr, "Sakit", "Ngorok");
                        model.updateKondisi(ayamMati, "Mati");
                        model.updateNgorok(ngor);
                        model.updateBeratSehat(sehat);
//                        model.updateBeratDiare(bbdiare);
                        model.updateBeratStres(stress);
                        System.out.println("if 3 : " + ayamMati + ", " + totalStres + ", " + diare);
                    }
                    if (JumlahAyam <= tipeKandang && JumlahAyam <= Jumlahpakan) {
                        int Ngorok = JumlahAyam * 10 / 100;
                        diare = JumlahAyam * (10 / 100);

                        int sehat = ((efekPakan / 7) * 7);
                        int ngor =  ((efekPakan / 7) * 7) - 30;
                        int bbdiare =  ((efekPakan / 7) * 7) - 20;

                        int ngorr = Ngorok + diare;
                        model.updateKondisi(ngorr, "Sakit", "Ngorok");
                        model.updateKondisi(diare, "Sakit", "Diare");

                        model.updateBeratSehat(sehat);
                        model.updateNgorok(ngor);
                        model.updateBeratDiare(bbdiare);
                        System.out.println("if 4 : " + Ngorok +  ", " + diare);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(perawatan.class.getName()).log(Level.SEVERE, null, ex);
                }
                ayam.view.kondisi v = new ayam.view.kondisi();
                System.out.println("co");
                ayam.Model.AYAM m = new ayam.Model.AYAM();
                ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m, minggu);
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(perawatan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class buttonMinggu3 implements ActionListener {

        public buttonMinggu3() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {

            try {
                String minggu = "3";
                model.setMinggu(minggu);
                System.out.println("metu");
                int ayamMati = 0;
                int stres = 0;
                int diare = 0;
                int sisaAyam = 0;
                int KorbanAyam = 0;
                int totalStres = 0;
                int koleraa = 0;
                int kolera = 0;
                int sisa = 0;
                int sisasehat = 0;
                int berakKapurr = 0;

                {
                    try {
                        String a = "2";
                        model.setMinggu(a);
                        int JumlahAyam = model.ambilJumlahAyamSehat();
                        System.out.println(JumlahAyam);
                        int Jumlahpakan = model.ambilJumlahPakan();
                        System.out.println(Jumlahpakan);
                        int tipeKandang = model.ambilTipeKandang();
                        System.out.println(tipeKandang);
                        int JumlahAyamsehat = model.ambilJumlahAyamSehat();
                        System.out.println(JumlahAyamsehat);
//
                        int JumlahAyamsakit = model.ambilJumlahAyamSakit();
                        System.out.println(JumlahAyamsakit);
//
                        int efekPakan = Integer.parseInt(model.ambilEfekPakan());
                        System.out.println("iki" + efekPakan);

                        int beratAwal = 200;

                        if (JumlahAyam <= tipeKandang && JumlahAyam > Jumlahpakan) {
                            KorbanAyam = JumlahAyam - Jumlahpakan;
                            System.out.println("Jumlah Ayam = " + JumlahAyam + " Jumlah Pakan = " + Jumlahpakan);
                            stres = KorbanAyam * 40 / 100;
                            ayamMati = KorbanAyam - stres;
                            int pullo = (JumlahAyam-KorbanAyam) * 10 /100;
                            int n = stres + ayamMati + pullo;
                            int m = stres + ayamMati ;
                            model.updateKondisi(n, "Sakit", "Pullorum");
                            model.updateKondisi(m, "Sakit", "Stress");
                            model.updateKondisi(ayamMati, "Mati");
                            int sehat =  ((efekPakan / 7) * 5);
                            int stress =  ((efekPakan / 7) * 5) - 20;
                            int pull =  ((efekPakan / 7) * 5) - 30;
                            model.updateBeratSehat(sehat);
                            model.updateBeratStres(stress);
                            model.updatePullorum(pull);
                            System.out.println("if 1 : " + stres + ", " + ayamMati);
                        }

                        if (JumlahAyam > tipeKandang && JumlahAyam <= Jumlahpakan) {
                            ayamMati = JumlahAyam * 10 / 100;
                            stres = JumlahAyam * 15 / 100;
                            sisaAyam = JumlahAyam - stres;
                            int korisa = sisaAyam * 10 / 100;
                            int pullorum = (sisaAyam-korisa) * 10 / 100;
                            int k = stres + korisa + ayamMati + pullorum;
                            int pullorumm = stres + korisa + ayamMati;

                            int sehat = ((efekPakan / 7) * 5);
                            int stress = ((efekPakan / 7) * 5) - 23;
                            int korisaa = ((efekPakan / 7) * 5) - 30;

                            int st = stres + ayamMati;
                            model.updateKondisi(k, "Sakit", "Korisa");
                            model.updateKondisi(pullorumm, "Sakit", "Pullorum");
                                  model.updateKondisi(st, "Sakit", "Stress");
                            model.updateKondisi(ayamMati, "Mati");
                            model.updateBeratSehat(sehat);
                            model.updateBeratStres(stress);
                            model.updateKorisa(korisaa);
                            model.updatePullorum(korisaa);
                            System.out.println("if 2 : " + ayamMati + ", " + stres + ", " + diare);

                        }
                    if (JumlahAyam > tipeKandang && JumlahAyam > Jumlahpakan) {
                        KorbanAyam = JumlahAyam - Jumlahpakan; // ayam yang jadi korban karena pakan
                        stres = KorbanAyam * 40 / 100; // ayam stress
                        ayamMati = KorbanAyam - stres; // ayam mati karena stres kandang
                        sisaAyam = JumlahAyam - KorbanAyam; //ayam sehat
                        totalStres = (sisaAyam * 10 / 100) + stres;
                        sisa = sisaAyam - (sisaAyam * 10 / 100);//sisa ayam dr sebab kandang
                        int pullorum = sisa * 10 / 100;

                        int sehat = ((efekPakan / 7) * 5);
                        int pulll = ((efekPakan / 7) * 5) - 30;
//                        int bbdiare = ((efekPakan / 7) * 5) - 20;
                        int stress = ((efekPakan / 7) * 5) - 20;

                        int st = ayamMati + totalStres + pullorum;
                        int pul = ayamMati + pullorum;
                        int sehattt = JumlahAyam;
                        model.updateKondisi(sehattt, "sehat");
                        model.updateKondisi(st, "Sakit", "Stress");
                        model.updateKondisi(pul, "Sakit", "Pullorum");
                        model.updateKondisi(ayamMati, "Mati");
                        model.updatePullorum(pulll);
                        model.updateBeratSehat(sehat);
//                        model.updateBeratDiare(bbdiare);
                        model.updateBeratStres(stress);
                        System.out.println("if 3 : " + ayamMati + ", " + totalStres + ", " + diare);
                    }
                    if (JumlahAyam <= tipeKandang && JumlahAyam <= Jumlahpakan) {
                        int Pullo = JumlahAyam * 10 / 100;
                        int korisa = JumlahAyam * 10 / 100;
                        diare = JumlahAyam * (10 / 100);

                        int sehat = ((efekPakan / 7) * 7);
                        int pull =  ((efekPakan / 7) * 7) - 30;
                        int bbdiare =  ((efekPakan / 7) * 7) - 20;

                        int pul = Pullo + korisa + diare;
                        int kor = diare + korisa;
                        model.updateKondisi(pul, "Sakit", "Pullorum");
                        model.updateKondisi(kor, "Sakit", "Korisa");
                        model.updateKondisi(diare, "Sakit", "Diare");

                        model.updateBeratSehat(sehat);
                        model.updateKorisa(pull);
                        model.updatePullorum(pull);
                        model.updateBeratDiare(bbdiare);
                        System.out.println("if 4 : " + Pullo + ", " + korisa + ", " + diare);

                    }
                    } catch (SQLException ex) {
                        Logger.getLogger(perawatan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ayam.view.kondisi v = new ayam.view.kondisi();
                    System.out.println("co");
                    ayam.Model.AYAM m = new ayam.Model.AYAM();
                    ayam.Controller.Ayam c = new ayam.Controller.Ayam(v, m, minggu);
                    view.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(perawatan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
