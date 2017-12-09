/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam.Model;

/**
 *
 * @author anggy
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class AYAM {

    private koneksi conn;
    private String umur = null;
    private String berat = null;
    private String harga = null;
    private String jumlah = null;
    private String total = null;
    private String sakit = null;
    private DefaultTableModel tm;
    private DefaultTableModel tk;
    private DefaultTableModel ts;
    private DefaultTableModel tj;
    private String idAyam;
    private String kondisi = "sehat";
    private String saldo;
    private String minggu;
    private int id;
    private String modal;
    private String totalPenjualan;
    private String jumlahAyam;
    private String beratAyam;
    private String hargajual;
    private final DefaultTableModel trj;

    public AYAM() throws SQLException {
        this.conn = new koneksi();
        String header[] = {"id Ayam", "Umur", "Berat", "Harga", "Jumlah"};
        tm = new DefaultTableModel(null, header);
        //kondisi
        String header1[] = {"Jumlah Ayam", "Kondisi", "Berat"};
        tk = new DefaultTableModel(null, header1);
        //sakit
        String header2[] = {"Jumlah ayam", "keterangan", "Berat"};
        ts = new DefaultTableModel(null, header2);
        //jual
        String header3[] = {"Jumlah ayam", "Berat"};
        tj = new DefaultTableModel(null, header3);
        //rincian_jual
        String header4[] = {"ID_penjualan", "Jumlah Ayam", "Berat Ayam", "Harga Ayam", "Total Penjualan"};
        trj = new DefaultTableModel(null, header4);
    }

    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tm.getRowCount() - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
        String sql = "select * from ayam";
        ResultSet rs = conn.getResult(sql);
        int n = 1;
        while (rs.next()) {
            String kolom[] = new String[5];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tm.addRow(kolom);
            n++;
        }
        return tm;
    }

    //tabel kondisi
    public DefaultTableModel getTableModel1() throws SQLException {
        for (int i = tk.getRowCount() - 1; i >= 0; i--) {
            tk.removeRow(i);
        }
        String sql = "select count(idAyam) as jumlah, kondisi, beratAyam from rincian_ayam  group by kondisi, beratAyam";
        ResultSet rs = conn.getResult(sql);
        int n = 1;
        while (rs.next()) {
            String kolom[] = new String[3];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tk.addRow(kolom);
            n++;
        }
        return tk;
    }

    //jual
    public DefaultTableModel getTableModel3() throws SQLException {
        for (int i = tj.getRowCount() - 1; i >= 0; i--) {
            tj.removeRow(i);
        }
        String sql = "select count(idAyam) as jumlahAyam, beratAyam from rincian_ayam where kondisi <> 'mati' and status='Belum' group by beratAyam";
        //String sql = "select * from jual";
        ResultSet rs = conn.getResult(sql);
        int n = 1;
        while (rs.next()) {
            String kolom[] = new String[2];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tj.addRow(kolom);
            n++;
        }
        return tj;
    }

    public DefaultTableModel getTableModel4() throws SQLException {
        for (int i = trj.getRowCount() - 1; i >= 0; i--) {
            trj.removeRow(i);
        }
        String sql = "select * from rincian_penjualan";
        ResultSet rs = conn.getResult(sql);
        int n = 1;
        while (rs.next()) {
            String kolom[] = new String[5];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            trj.addRow(kolom);
            n++;
        }
        return trj;
    }

//    public void setSelectedRow1(int baris) {
//        this.jumlah= tj.getValueAt(baris, 0).toString();
//        this.berat = tj.getValueAt(baris, 1).toString();
//    }
    public void setSelectedRow(int baris) {
        this.idAyam = tm.getValueAt(baris, 0).toString();
        this.umur = tm.getValueAt(baris, 1).toString();
        this.berat = tm.getValueAt(baris, 2).toString();
        this.harga = tm.getValueAt(baris, 3).toString();
        this.jumlah = tm.getValueAt(baris, 4).toString();

    }

    public String getJumlahAyam() {
        return jumlah;
    }

    public String getSakit() {
        return sakit;
    }

    public DefaultTableModel getTableModel2() throws SQLException {
        for (int i = ts.getRowCount() - 1; i >= 0; i--) {
            ts.removeRow(i);
        }
        String sql = "select count(idAyam) as jumlah,keterangan,beratAyam from rincian_ayam where kondisi = 'sakit' group by keterangan, beratAyam";
        ResultSet rs = conn.getResult(sql);
        int n = 1;
        while (rs.next()) {
            String kolom[] = new String[3];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            ts.addRow(kolom);
            n++;
        }
        return ts;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public void setumur(String umur) {
        this.umur = umur;
    }

    public void setMinggu(String mg) {
        this.minggu = mg;
    }

    public void setberat(String berat) {
        this.berat = berat;
    }

    public void setharga(String harga) {
        this.harga = harga;
    }

    public void setjumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public void setIDayam(String id_ayam) {
        this.idAyam = id_ayam;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public void settotalPenjualan(String jual) {
        this.totalPenjualan = jual;
    }

    public void setjumlahAyam(String jumlah) {
        this.jumlahAyam = jumlah;
    }

    public void setberatAyam(String berat) {
        this.beratAyam = berat;
    }

    public void sethargaJual(String harga) {
        this.hargajual = harga;
    }

    public String getModal() {
        return modal;
    }

    public String getTotalPenjualan() {
        return totalPenjualan;
    }

    public String getumur() {
        return umur;
    }

    public String getberat() {
        return berat;
    }

    public String getharga() {
        return harga;
    }

    public String getjumlah() {
        return jumlah;
    }

    public String gettotal() {
        return total;
    }

    public String getidAyam() {
        return idAyam;
    }

    public String ambilBeratAyam() throws SQLException {
        String sql = "select beratAyam from rincian_ayam limit 1";
        ResultSet rs = conn.getResult(sql);
        rs.next();
        String beratAyam = rs.getString("beratAyam");
        return beratAyam;

    }
//     public String ambilProfit() throws SQLException {
//       String sql = "select sum(totalPenjualan) as a from rincian_penjualan ";
//        ResultSet rs = conn.getResult(sql);
//        String modal;
//        rs.next();
//        modal = rs.getString("a");
//        return modal;
//    }

    public String ambilEfekPakan() throws SQLException {
        String sql = "SELECT p.efek from pembelian_pakan p join rincian_pakan rp on p.id_beli_pakan=rp.idPakan "
                + "where rp.minggu= '" + minggu + "'";
        ResultSet rs = conn.getResult(sql);
        rs.next();
        String efekPakan = rs.getString("efek");
        return efekPakan;

    }

    public String kondisi() throws SQLException {
        String sql = "select kondisi from rincian_ayam";
        ResultSet rs = conn.getResult(sql);
        rs.next();
        String kondisi = rs.getString("kondisi");
        return kondisi;

    }

    public int ambilJumlahAyam() throws SQLException {
        String sql = "select count(idAyam) as jumlahAyam from rincian_ayam";
        ResultSet rs = conn.getResult(sql);
        String jumlahAYam;
        rs.next();
        jumlahAYam = rs.getString("jumlahAYam");
        return Integer.parseInt(jumlahAYam);
    }

    public int ambilJumlahAyamSehat() throws SQLException {
        String sql = "select count(idAyam) as jumlahAyam from rincian_ayam where kondisi = 'sehat'";
        ResultSet rs = conn.getResult(sql);
        String jumlahAYam;
        rs.next();
        jumlahAYam = rs.getString("jumlahAYam");
        return Integer.parseInt(jumlahAYam);
    }

    public int ambilJumlahAyamSakit() throws SQLException {
        String sql = "select count(idAyam) as jumlahAyam from rincian_ayam where kondisi = 'sakit'";
        ResultSet rs = conn.getResult(sql);
        String jumlahAYam;
        rs.next();
        jumlahAYam = rs.getString("jumlahAYam");
        return Integer.parseInt(jumlahAYam);
    }

    public int ambilJumlahPakan() throws SQLException {
        String sql = "SELECT SUM(rp.jumlah) as jumlahPakan from pembelian_pakan p join rincian_pakan rp on p.id_beli_pakan=rp.idPakan "
                + "where rp.minggu= '" + minggu + "'";
        ResultSet rs = conn.getResult(sql);
        String jumlahPakan;
        rs.next();
        jumlahPakan = rs.getString("jumlahPakan");
        System.out.println("ajancpokaocjihfu" + jumlahPakan);
        System.out.println("minggu ke " + minggu);

        return Integer.parseInt(jumlahPakan);
    }

    public int ambilTipeKandang() throws SQLException {
        String sql = "SELECT k.jumlah_ayam as tipeKandang from kandang k join rincian_kandang rk on k.id_kandang=rk.id_kandang";
        ResultSet rs = conn.getResult(sql);
        String tipeKandang;
        rs.next();
        tipeKandang = rs.getString("tipeKandang");
        return Integer.parseInt(tipeKandang);
    }

    public int ambilUpdateBerat() throws SQLException {
        String sql = "select count(idAyam)as jumlah from rincian_ayam ";
        ResultSet rs = conn.getResult(sql);
        String jumlah;
        rs.next();
        jumlah = rs.getString("jumlah");
        return Integer.parseInt(jumlah);
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
        System.out.println(saldo + "," + umur + ", " + berat + ", " + harga + ", " + jumlah);
        String sql = "insert into ayam values (" + null + ",'" + umur + "','" + berat + "','" + harga + "','" + jumlah + "')";
        conn.execute(sql);
    }

    public void Jual() throws SQLException {
        String sql = "insert into rincian_penjualan values (" + null + ",'" + jumlahAyam + "','" + beratAyam + "','" + hargajual + "','" + totalPenjualan + "')";
//        System.out.println(sql);
        conn.execute(sql);
    }

    public void beliAyam() throws SQLException {
        String sql = "insert into rincian_ayam values(" + null + ",'" + kondisi + "'," + null + ",'" + berat + "'," + "'Belum'" + ")";
        conn.execute(sql);
    }

    public void ubah() throws SQLException {
        String sql = "update ayam set id_ayam = '" + null + "', umur= '" + umur + "',berat = '" + berat + "', harga = '" + harga + "', jumlah = '" + jumlah + "' where id_ayam =" + idAyam;
        conn.execute(sql);
    }

    public void updateKondisi(int n, String kondisi) throws SQLException {
        ResultSet rs = conn.getResult("select idAyam from rincian_ayam where kondisi = 'sehat' limit 1 ");
        rs.next();
        this.id = 0;
        this.id += Integer.parseInt(rs.getString("idAyam"));
        for (int i = 0; i < n; i++) {
            updateData(i + this.id, kondisi, "");
        }
        System.out.println("kopooooooook");
        this.id += n;
    }

    public void updateKondisi(int n, String kondisi, String keterangan) throws SQLException {
        ResultSet rs = conn.getResult("select idAyam from rincian_ayam where kondisi= 'sehat' limit 1  ");
        rs.next();
        this.id = 0;
        this.id += Integer.parseInt(rs.getString("idAyam"));
        for (int i = 0; i < n; i++) {
            updateData(i + this.id, kondisi, keterangan);
        }
        this.id += n;

    }

    public void updateKondisi(int n, String kondisi, String keterangan, int beratbadan) throws SQLException {
        ResultSet rs = conn.getResult("select idAyam from rincian_ayam limit 1 ");
        rs.next();
        this.id = 0;
        this.id += Integer.parseInt(rs.getString("idAyam"));
        for (int i = 0; i < n; i++) {
            updateData(i + this.id, kondisi, keterangan, beratbadan);
        }
        this.id += n;

    }

    public void updateBerat(int n, int beratBadan) throws SQLException {
        ResultSet rs = conn.getResult("select idAyam from rincian_ayam ");
        rs.next();
        this.id = 0;
        this.id += Integer.parseInt(rs.getString("idAyam"));
        for (int i = 0; i < n; i++) {
            System.out.println("ini adalah id " + (this.id + i));
//            updateBeratBadan(this.id + i, beratBadan);
            this.id += 1;
        }
    }

    private void updateData(int id, String kondisi, String keterangan) throws SQLException {
        String sql = "update rincian_ayam set kondisi = '" + kondisi + "', keterangan = '" + keterangan + "' where idAyam = " + id;
        conn.execute(sql);
    }

    private void updateData(int id, String kondisi, String keterangan, int beratBadan) throws SQLException {
        String sql = "update rincian_ayam set kondisi = '" + kondisi + "', keterangan = '" + keterangan + "', beratAyam = beratAyam + " + beratBadan + " where idAyam = " + id;
        conn.execute(sql);
        System.out.println(sql);
    }

    public void delete() throws SQLException {
        String sql = "delete from ayam where id_ayam = " + this.idAyam;
        conn.execute(sql);

    }

    public void Reset() throws SQLException {
        String sql = "delete from ayam";
        String sql1 = "delete from rincian_ayam";
        String sql2= "delete from rincian_kandang";
        String sql3 = "delete from rincian_obat";
        String sql4 = "delete from rincian_pakan";
        String sql5 = "delete from rincian_penjualan";
        conn.execute(sql);
        conn.execute(sql1);
        conn.execute(sql2);
        conn.execute(sql3);
        conn.execute(sql4);
        conn.execute(sql5);
       

    }

    public void ResetModal() throws SQLException {
        String sql1 = "update modal set modal = '10000000' where id = '1'";
        conn.execute(sql1);

    }

    public void deleteae() throws SQLException {
        String sql = "delete from jual where beratAyam=" + this.beratAyam;
        conn.execute(sql);

    }

    public void updateBeratSehat(int beratBadan) throws SQLException {
        String sql = "update rincian_ayam set beratAyam = beratAyam + " + beratBadan + " where kondisi = 'Sehat' ";
        conn.execute(sql);
    }

    public void updateBeratStres(int beratBadan) throws SQLException {
        String sql = "update rincian_ayam set beratAyam = beratAyam + " + beratBadan + " where keterangan = 'Stress' ";
        conn.execute(sql);
    }

    public void updateBeratDiare(int beratBadan) throws SQLException {
        String sql = "update rincian_ayam set beratAyam = beratAyam + " + beratBadan + " where keterangan = 'Diare' ";
        conn.execute(sql);
    }

    public void updateBeratKapur(int beratBadan) throws SQLException {
        String sql = "update rincian_ayam set beratAyam = beratAyam + " + beratBadan + " where keterangan = 'Berak Kapur' ";
        conn.execute(sql);
    }

    public void updateBeratDarah(int beratBadan) throws SQLException {
        String sql = "update rincian_ayam set beratAyam = beratAyam + " + beratBadan + " where keterangan = 'Berak Darah' ";
        conn.execute(sql);
    }

    public void updateKolera(int beratBadan) throws SQLException {
        String sql = "update rincian_ayam set beratAyam = beratAyam + " + beratBadan + " where keterangan = 'kolera' ";
        conn.execute(sql);
    }

    public void updatePullorum(int beratBadan) throws SQLException {
        String sql = "update rincian_ayam set beratAyam = beratAyam + " + beratBadan + " where keterangan = 'Pullorum' ";
        conn.execute(sql);
    }

    public void updateNgorok(int beratBadan) throws SQLException {
        String sql = "update rincian_ayam set beratAyam = beratAyam + " + beratBadan + " where keterangan = 'Ngorok' ";
        conn.execute(sql);
    }

    public void updateKorisa(int beratBadan) throws SQLException {
        String sql = "update rincian_ayam set beratAyam = beratAyam + " + beratBadan + " where keterangan = 'Korisa' ";
        conn.execute(sql);
    }

//    public void updateJual() throws SQLException {
//        String sql = "update penjualan set jumlahAyam ='"+jumlah+"', beratAyam='"+berat+"', status";
//        conn.execute(sql);
//    }
    public void updateModal(int modal) throws SQLException {
        String sql = "update modal set modal= " + modal;
        conn.execute(sql);
    }

    public void updateStatus(int jumlahh) throws SQLException {
        String sql = "update rincian_ayam set status='Sudah' where kondisi <> 'mati' and beratAyam= " + jumlahh;
        conn.execute(sql);
    }

}
