/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anggy
 */
public class KANDANG {

    private final koneksi conn;
    private String tipeKandang;
    private String jenisKandang;
    private String jumlahAyam;
    private String Ukuran;
    private String harga;
    private String jumlah;
    private String Fasilitas;
    private final DefaultTableModel tm;
    private String idKandang;
    private int idKandang1;

    public KANDANG() throws SQLException {
        this.conn = new koneksi();
        String header[] = {"id", "Tipe Kandang", "Jenis kandang", "Ukuran", "Jumlah Ayam", "Fasilitas", "Harga", "Jumlah"};
        tm = new DefaultTableModel(null, header);
    }

    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tm.getRowCount() - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
        String sql = "select rk.id, k.tipe_kandang, k.jenisKandang, k.ukuran, k.jumlah_ayam, k.fasilitas, k.harga, "
                + "rk.jumlah from kandang k join rincian_kandang rk on k.id_kandang=rk.id_kandang";
        ResultSet rs = conn.getResult(sql);
        int n = 1;
        while (rs.next()) {
            String kolom[] = new String[8];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tm.addRow(kolom);
            n++;
        }
        return tm;
    }
    public String ambilMOdal() throws SQLException {
        String sql = "select modal from modal ";
        ResultSet rs = conn.getResult(sql);
        String modal;
        rs.next();
        modal = rs.getString("modal");
        return modal;
    }

    public void setSelectedRow(int baris) {
        this.idKandang = tm.getValueAt(baris, 0).toString();
        this.tipeKandang= tm.getValueAt(baris, 1).toString();
        this.jenisKandang = tm.getValueAt(baris, 2).toString();
        this.Ukuran = tm.getValueAt(baris, 3).toString();
        this.jumlahAyam = tm.getValueAt(baris, 4).toString();
        this.Fasilitas = tm.getValueAt(baris, 5).toString();
        this.harga = tm.getValueAt(baris, 6).toString();
        this.jumlah = tm.getValueAt(baris, 7).toString();

    }

    public void settipeKandang(String tipeKandang) {
        this.tipeKandang = tipeKandang;
    }
    
    public int setIDKandang(int idKandang) {
        int a=  this.idKandang1 = idKandang;
        return a;
    }

    public void setjenisKandang(String jenisKandang) {
        this.jenisKandang = jenisKandang;
    }

    public void setUkuran(String Ukuran) {
        this.Ukuran = Ukuran;
    }

    public void setjumlahAyam(String jumlahAyam) {
        this.jumlahAyam = jumlahAyam;
    }

    public void setFasilitas(String Fasilitas) {
        this.Fasilitas = Fasilitas;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
    
    public String getidKandang() {
        return idKandang;
    }

    public String gettipeKandang() {
        return tipeKandang;
    }

    public String getjenisKandang() {
        return jenisKandang;
    }

    public String getUkuran() {
        return Ukuran;
    }

    public String getJumlahAyam() {
        return jumlahAyam;
    }

    public String getFasilitas() {
        return Fasilitas;
    }

    public String getHarga() {
        return harga;
    }

    public String getjumlah() {
        return jumlah;
    }

    public String gettotal() {
        String total = null;
        return total;
    }

    public String[] getTableModel(String tipeKandang) throws SQLException {
        String sql = "select jenisKandang, ukuran, jumlah_ayam, fasilitas, harga from kandang where tipe_kandang = '" + tipeKandang + "';";
        ResultSet rs = conn.getResult(sql);
        String kolom[] = new String[5];
        while (rs.next()) {
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }

        }
        return kolom;
    }

    public String[][] getKandang() throws SQLException {
        String sql = "select id_kandang, tipe_kandang, jenisKandang, ukuran, jumlah_ayam, fasilitas, harga from kandang";
        String kandang = "";
        ResultSet rs = conn.getResult(sql);
        rs.last();
        String kandangg [][]= new String[7][rs.getRow()];
        rs.beforeFirst();
        int i =0;
        while (rs.next()) {
            kandangg [0][i]= rs.getString("id_kandang");
            kandangg [1][i]= rs.getString("tipe_kandang");
            kandangg [2][i]= rs.getString("jenisKandang");
            kandangg [3][i]= rs.getString("ukuran");
            kandangg [4][i]= rs.getString("jumlah_ayam");
            kandangg [5][i]= rs.getString("fasilitas");
            kandangg [6][i]= rs.getString("harga");
            i++;
//            kandang += rs.getString("tipe_kandang") + "-";
        }
//        String x[] = kandang.split("-");
//        for (String i : x) {
//            System.out.println(i);
//        }
//        return kandang.split("-");
        System.out.println("kandangmu  ==== " + kandangg);
        return kandangg;

    }

    public void beli() throws SQLException {
        System.out.println("print");
        System.out.println(tipeKandang + ", " + jenisKandang + "," + Ukuran + "," + jumlahAyam + "," 
                + Fasilitas + ", " + harga + ", " + jumlah);
//        String sql = "insert into rincian_kandang values (" + null + ",'" + tipeKandang + "','" + jenisKandang + "','" 
//                + Ukuran + "','" + jumlahAyam + "','" + Fasilitas + "','" + harga + "','" + jumlah + "')";
        String sql = "INSERT INTO `rincian_kandang`(`id`, `id_kandang`, `jumlah`) VALUES (" + null + ",'" + idKandang1 + "','" + jumlah + "')";
        conn.execute(sql);
    }
     public void delete() throws SQLException {
        String sql = "delete from rincian_kandang where id = " + this.idKandang;
        conn.execute(sql);

    }
        public void updateModal(int modal) throws SQLException {
        String sql = "update modal set modal= " + modal;
        conn.execute(sql);
    }
}
