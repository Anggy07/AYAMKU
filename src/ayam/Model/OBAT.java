package ayam.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class OBAT {

    private koneksi conn;
    private String keterangan;
    private String rincian;
    private String harga;
    private String jumlah;
    private String aturan;
    private String total;
    private String namaObat;
    private final DefaultTableModel tm;
    private String idObat;
    private String minggu;
    private int idObat1;
    private int id;

    public OBAT() throws SQLException {
        this.conn = new koneksi();
        String header[] = {"id", "Nama Obat", "Keterangan", "Rincian", "Aturan Pakai", "Harga", "Minggu", "Jumlah"};
        tm = new DefaultTableModel(null, header);
    }

    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tm.getRowCount() - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
        String sql = "SELECT ro.id, o.nama_obat, o.keterangan, o.rincian, o.aturanPakai, o.harga, ro.minggu, "
                + "ro.jumlah FROM pembelian_obat o join rincian_obat ro on o.id_beli_obat = ro.idObat";
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
        this.idObat = tm.getValueAt(baris, 0).toString();
        this.namaObat = tm.getValueAt(baris, 1).toString();
        this.keterangan = tm.getValueAt(baris, 2).toString();
        this.rincian = tm.getValueAt(baris, 3).toString();
        this.aturan = tm.getValueAt(baris, 4).toString();
        this.harga = tm.getValueAt(baris, 5).toString();
        this.minggu = tm.getValueAt(baris, 6).toString();
        this.jumlah = tm.getValueAt(baris, 7).toString();

    }

    public int setIDObat(int idObat) {
        int a = this.idObat1 = idObat;
        return a;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setRincian(String rincian) {
        this.rincian = rincian;
    }

    public void setAturanPakai(String aturan) {
        this.aturan = aturan;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public void setMinggu(String jumlah) {
        this.minggu = jumlah;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getMinggu() {
        return minggu;
    }

    public String getRincian() {
        return rincian;
    }

    public String getAturanPakai() {
        return aturan;
    }

    public String getHarga() {
        return harga;
    }

    public String getjumlah() {
        return jumlah;
    }

    public String gettotal() {
        return total;
    }

    public String[] getTableModel(String namaObat) throws SQLException {
        String sql = "select keterangan, rincian, aturanPakai, harga "
                + "from pembelian_obat where nama_obat = '" + namaObat + "';";
        ResultSet rs = conn.getResult(sql);
        String kolom[] = new String[4];
        while (rs.next()) {
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }

        }
        return kolom;
    }

//    public String[] getObat() throws SQLException {
//        String sql = "select nama_obat from pembelian_obat";
//        String obat = "";
//        ResultSet rs = conn.getResult(sql);
//        while (rs.next()) {
//            obat += rs.getString("nama_obat") + "-";
//        }
//        String x[] = obat.split("-");
//        for (String i : x) {
//            System.out.println(i);
//        }
//        return obat.split("-");
//
//    }
    public String[][] getObat() throws SQLException {
        String sql = "select id_beli_obat, nama_obat, rincian, aturanPakai, harga from pembelian_obat";
        String pakann = "";
        ResultSet rs = conn.getResult(sql);
        rs.last();
        String pakan[][] = new String[5][rs.getRow()];
        rs.beforeFirst();
        int i = 0;
        while (rs.next()) {
            pakan[0][i] = rs.getString("id_beli_obat");
            pakan[1][i] = rs.getString("nama_obat");
            pakan[2][i] = rs.getString("rincian");
            pakan[3][i] = rs.getString("aturanPakai");
            pakan[4][i] = rs.getString("harga");
            i++;
        }
        System.out.println("pakanmu  ==== " + pakan);
        return pakan;

    }

    public void beli() throws SQLException {
        System.out.println("print");
        System.out.println(namaObat + ", " + keterangan + "," + rincian + "," + aturan + ", " + harga + ", " + minggu + "," + jumlah);
        String sql = "insert into rincian_obat values (" + null + ",'" + idObat1 + "','" + minggu + "','" + jumlah + "')";
        conn.execute(sql);
    }

    public void delete() throws SQLException {
        String sql = "delete from rincian_obat where id = " + this.idObat;
        conn.execute(sql);
    }

    public void updateKondisiDiare() throws SQLException {
        String sql = "UPDATE `rincian_ayam` SET kondisi='Sehat' , keterangan='' WHERE keterangan='diare'";
        conn.execute(sql);
    }

    public void updateKondisi(int n, String keterangan) throws SQLException {
        ResultSet rs = conn.getResult("select idAyam from rincian_ayam where keterangan = '" + keterangan + "' limit 1 ");
        rs.next();
        this.id = 0;
        this.id += Integer.parseInt(rs.getString("idAyam"));
        System.out.println("wwwwwwwww = " + id);
        for (int i = 0; i < n; i++) {
            updateData(i + this.id, "Sehat", "");
        }
        System.out.println("kopooooooook");
        this.id += n;
    }

    private void updateData(int id, String kondisi, String keterangan) throws SQLException {
        String sql = "update rincian_ayam set kondisi = '" + kondisi + "', keterangan = '" + keterangan + "' where idAyam = " + id;
        conn.execute(sql);
    }

    public void updateModal(int modal) throws SQLException {
        String sql = "update modal set modal= " + modal;
        conn.execute(sql);
    }
}
