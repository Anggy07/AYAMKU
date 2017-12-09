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
public class PAKAN {

    private final koneksi conn;
    private String jenispakan;
    private String keterangan;
    private String efek;
    private String Komposisi;
    private String harga;
    private String jumlah;
    private String total;
    private final DefaultTableModel tm;
    private String idPakan;
    private String Minggu;
    private int idPakan1;

    public PAKAN() throws SQLException {
        this.conn = new koneksi();
        String header[] = {"id", "Jenis Pakan", "Keterangan", "Efek", "Harga", "Komposisi", "Minggu ke","Jumlah"};
        tm = new DefaultTableModel(null, header);
    }

    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tm.getRowCount() - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
        String sql = "SELECT rp.id, p.jenis_pakan, p.keterangan, p.efek, p.harga, p.komposisi, rp.minggu, "
                + "rp.jumlah from pembelian_pakan p join rincian_pakan rp on p.id_beli_pakan=rp.idPakan";
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

    public void setSelectedRow(int baris) {
        this.idPakan = tm.getValueAt(baris, 0).toString();
        this.jenispakan = tm.getValueAt(baris, 1).toString();
        this.keterangan= tm.getValueAt(baris, 2).toString();
        this.efek = tm.getValueAt(baris, 3).toString();
        this.Komposisi = tm.getValueAt(baris, 4).toString();
        this.harga = tm.getValueAt(baris, 5).toString();
         this.Minggu = tm.getValueAt(baris, 6).toString();
        this.jumlah = tm.getValueAt(baris, 7).toString();  
    }
    
    public int setIDPakan(int idPakan) {
        int a=  this.idPakan1 = idPakan;
        return a;
    }
    
    public void setJenisPakan(String jenispakan) {
        this.jenispakan = jenispakan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setefek(String efek) {
        this.efek = efek;
    }

    public void setKomposisi(String Komposisi) {
        this.Komposisi = Komposisi;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
    
    public void setMinggu(String jumlah) {
        this.Minggu = jumlah;
    }

    public String getJenisPakan() {
        return jenispakan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getefek() {
        return efek;
    }

    public String getKomposisi() {
        return Komposisi;
    }

    public String getHarga() {
        return harga;
    }
    public String getMinggu() {
        return Minggu;
    }

    public String getjumlah() {
        return jumlah;
    }

    public String gettotal() {
        return total;
    }

    public String[] getTableModel(String jenisPakan) throws SQLException {
        String sql = "select keterangan, efek, komposisi, harga from pembelian_pakan where jenis_pakan = '" + jenisPakan + "';";
        ResultSet rs = conn.getResult(sql);
        String kolom[] = new String[4];
        while (rs.next()) {
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }

        }
        return kolom;
    }

    public String[] getPakan() throws SQLException {
        String sql = "select jenis_pakan from pembelian_pakan limit 0,2";
        String pakan = "";
        ResultSet rs = conn.getResult(sql);
        while (rs.next()) {
            pakan += rs.getString("jenis_pakan") + "_";
        }
        String x[] = pakan.split("_");
        for (String i : x) {
            System.out.println(i);
        }
        return pakan.split("_");

    }
    
    public String[] getPakan1() throws SQLException {
        String sql = "select jenis_pakan from pembelian_pakan limit 2,2";
        String pakan = "";
        ResultSet rs = conn.getResult(sql);
        while (rs.next()) {
            pakan += rs.getString("jenis_pakan") + "_";
        }
        String x[] = pakan.split("_");
        for (String i : x) {
            System.out.println(i);
        }
        return pakan.split("_");

    }
    
    public String[][] getPakan3() throws SQLException {
        String sql = "select id_beli_pakan, jenis_pakan, keterangan, efek, harga, komposisi from pembelian_pakan";
        String pakann = "";
        ResultSet rs = conn.getResult(sql);
        rs.last();
        String pakan[][]= new String[6][rs.getRow()];
        rs.beforeFirst();
        int i =0;
        while (rs.next()) {
            pakan [0][i]= rs.getString("id_beli_pakan");
            pakan [1][i]= rs.getString("jenis_pakan");
            pakan [2][i]= rs.getString("keterangan");
            pakan [3][i]= rs.getString("efek");
            pakan [4][i]= rs.getString("harga");
            pakan [5][i]= rs.getString("komposisi");
            i++;
//            kandang += rs.getString("tipe_kandang") + "-";
        }
//        String x[] = kandang.split("-");
//        for (String i : x) {
//            System.out.println(i);
//        }
//        return kandang.split("-");
        System.out.println("pakanmu  ==== " + pakan);
        return pakan;

    }
     public String ambilMOdal() throws SQLException {
        String sql = "select modal from modal ";
        ResultSet rs = conn.getResult(sql);
        String modal;
        rs.next();
        modal = rs.getString("modal");
        return modal;
    }

    
 
 
    public void beli() throws SQLException {
        System.out.println("print");
        System.out.println(jenispakan + ", " + keterangan + "," + efek + "," + Komposisi + ", " + harga + ", "+ Minggu+", " + jumlah);
        
        String sql = "insert into rincian_pakan values (" + null + ",'" + idPakan1 + "','" +Minggu+"','" + jumlah + "')";
        conn.execute(sql);
    }
      public void delete() throws SQLException {
        String sql = "delete from rincian_pakan where id = " + this.idPakan;
        conn.execute(sql);

    }
         public void updateModal(int modal) throws SQLException {
        String sql = "update modal set modal= " + modal;
        conn.execute(sql);
    }

}
