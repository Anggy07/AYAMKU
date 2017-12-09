-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 04 Des 2017 pada 18.03
-- Versi Server: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ayamku`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `ayam`
--

CREATE TABLE `ayam` (
  `id_ayam` int(11) NOT NULL,
  `umur` varchar(11) NOT NULL,
  `berat` varchar(11) NOT NULL,
  `harga` int(15) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `jual`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `jual` (
`jumlahAyam` bigint(21)
,`beratAyam` int(12)
);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kandang`
--

CREATE TABLE `kandang` (
  `id_kandang` int(11) NOT NULL,
  `tipe_kandang` varchar(11) NOT NULL,
  `jenisKandang` varchar(20) NOT NULL,
  `ukuran` varchar(20) NOT NULL,
  `jumlah_ayam` int(11) NOT NULL,
  `fasilitas` text NOT NULL,
  `harga` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kandang`
--

INSERT INTO `kandang` (`id_kandang`, `tipe_kandang`, `jenisKandang`, `ukuran`, `jumlah_ayam`, `fasilitas`, `harga`) VALUES
(1, 'tipe A', 'Bukan panggung', '2,5 x 3 meter', 50, 'Tempat makan : 3 kg (10)\r\n\r\nTempat minum: 1 liter (10)\r\n', 230500),
(2, 'tipe C', 'panggung', '2,5 x 3 meter', 50, 'Tempat makan : 3 kg (10)\r\nTempat minum: 1 liter (10)\r\n', 260000),
(3, 'tipe B', 'Bukan panggung', '5 x 6 meter', 100, 'Tempat makan : 3 kg (20)\r\nTempat minum: 1 liter (20)\r\n', 461000),
(4, 'tipe D', 'Panggung', '5 x 6 meter', 100, 'Tempat makan : 3 kg (20)\r\nTempat minum: 1 liter (20)\r\n', 480000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `modal`
--

CREATE TABLE `modal` (
  `id` int(1) NOT NULL,
  `modal` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `modal`
--

INSERT INTO `modal` (`id`, `modal`) VALUES
(1, 10000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian_obat`
--

CREATE TABLE `pembelian_obat` (
  `id_beli_obat` int(11) NOT NULL,
  `nama_obat` varchar(20) NOT NULL,
  `keterangan` text NOT NULL,
  `rincian` text NOT NULL,
  `aturanPakai` text NOT NULL,
  `harga` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pembelian_obat`
--

INSERT INTO `pembelian_obat` (`id_beli_obat`, `nama_obat`, `keterangan`, `rincian`, `aturanPakai`, `harga`) VALUES
(1, 'Vita Chicks', 'Vitamin anti biotic ini mempunyai\r\nfungsi untuk mempercepat\r\npertumbuhan ayam, mencegah \r\nkekurangan Vitamin pada ayam, dan\r\nmengatasi stress pada ayam, serta\r\nmengurangi kematian pada anak ayam.', 'Isi : 5 gram', '1. Untuk anak ayam umur 0-2 minggu : 5 gram tiap 7 liter air minum per hari\r\n2. Untuk anak ayam umur 3-4 minggu : 5 gram tiap 12 liter air minum per hari\r\n3. Untuk anakan ayam umur 5 minggu- dewasa : 5 gram tiap 7 liter air minum per hari ( ketika mengalami gangguan )\r\n', 1000),
(2, 'Vita Plex', 'Vitamin B kompleks untuk unggas yaitu\r\nmencegah dan mengobati penyakit yang \r\ndisebabkan kekurangan vitamin B \r\nkompleks, menambah daya tahan tubuh\r\nayam terhadap penyakit, mencegah \r\nstress terutama pada waktu perubahan cuaca, vaksin atau pindah kandang,\r\nserta mempercepat pertumbuhan.', 'Isi : 7 kaplet', 'Masukkan kaplet kemulut unggas atau\r\nlarutkan kaplet kedalam air minum \r\nsetiap hari :\r\n1. Ayam umur < 6 minggu : 1/2 kaplet.\r\n2. Ayam umur > 6 minggu : 1 kaplet.\r\n', 1000),
(3, 'Tetra Chlor', 'Merupakan anti biotic, vitamin dan\r\nmineral yang berfungsi sebagai obat \r\npenyakit korisa (pilek, snop, muka \r\nbengkak), penyakit kolera \r\n(berak hijau) dan CRD (ngorok) pada ayam.', 'Isi : 10 kapsul', '\r\nUmur 4 minggu : Sehari 1 kali ½ kapsul\r\nUmur 4-8 minggu : Sehari 2 kali ½ kapsul\r\nUmur 8 minggu lebih : Sehari 2 kali 1 kapsul\r\nObat diminumkan 4-5 hari secara berturut-turut\r\n\r\n', 2500),
(4, 'supertop', 'Kegunaan dari supertop ialah untuk\r\nmemperpanjang nafas dan membuat ayam\r\nbergairah serta menambah tenaga ayam.', 'Isi : 10 kapsul', 'Jika untuk menambah tenaga pada ayam\r\nadu: Berikan 2 kapsul diberikan  \r\nsetengah jam sampai  satu jam \r\nsebelum ayam diadu.\r\nJika untuk menjaga kesehatan ayam,\r\nmempertinggi daya tahan terhadap \r\npenyakit , stres, atau \r\nmeningkatkan daya kerja ayam \r\npemacek:\r\n-ayam umur sampai 1 bulan   : 3 hari sekali ½ kapsul\r\n-ayam umur 1-2 bulan             : 3 hari sekali 1 kapsul\r\n-ayam umur lebih dari2bulan: 2 hari sekali  1 kapsul\r\n\r\n', 3500),
(5, 'sulfamix', 'Berbentuk cairan suntik dan bisa \r\njuga diteteskan ke mulut ayam. \r\nKegunaan dari Sulfamix ialah \r\nmengobati Berak darah, berak kapur,\r\nkorisa, kolera dan Ngorok (CRD) \r\npada ayam.', 'Isi : 5 ml', 'Penyuntikan secara intramuskuler, \r\nsehari 1 0.4 ml tiap kg berat badan \r\nselama 3 -5 hari diberikan berturut-turut.', 4000),
(6, 'neobro', 'Kegunaan dari Neobro ialah mempercepat \r\npertumbuhan ayam, mengurangi angka \r\nkematian ayam, dan juga meningkatkan \r\nefisiensi penggunaan ransum.', 'isi : 10gram', 'Umur 0-6 minggu : 1 gram tiap 2 liter air minum \r\nUmur >6 minggu : 1 gram tiap 3 liter air\r\n', 8000),
(7, 'electrovit', 'Vitamin dan anti biotic berfungsi \r\nmengatasi segala bentuk stress pada \r\nayam, menjaga keseimbangan elektrolit, \r\nmeningkatkan nafsu makan dan memelihara \r\nkesehatan serta produksi yang optimal.', 'isi ; 10 gram', 'Larutkan 1 g ELECTROVIT per 2 liter \r\nair minum. Berikan dosis selama \r\n3-5 hari berturut-turut untuk \r\nsetiap periode.', 1950),
(8, 'Trimezyn', 'Anti biotic, vitamin dan mineral yang berfungsi untuk mengobati korisa, kolera, CRD, pullorum dan mencret kuning pada ayam', '10 kaplet', 'Aturan pakai untuk semua umur ayam yaitu dengan memberikan 1 kaplet setiap hari untuk setiap ekor ayam', 2000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian_pakan`
--

CREATE TABLE `pembelian_pakan` (
  `id_beli_pakan` int(11) NOT NULL,
  `jenis_pakan` varchar(50) NOT NULL,
  `keterangan` text NOT NULL,
  `efek` int(20) NOT NULL,
  `harga` int(12) NOT NULL,
  `komposisi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pembelian_pakan`
--

INSERT INTO `pembelian_pakan` (`id_beli_pakan`, `jenis_pakan`, `keterangan`, `efek`, `harga`, `komposisi`) VALUES
(1, '8202-R ', '1 pak(882 gram) untuk 1 ayam selama 3 minggu', 378, 2000, 'Kada Air => Max => 13%\r\nProtein => 19-21 %\r\nLemak => Max => 7%\r\nSerat => Max => 4%\r\nAbu => Max => 7%\r\nCalcium => 0.9 – 1.1%\r\nPhosphor => 0.6 – 0.9%\r\nAntibiotika => Obat anti berak darah\r\n'),
(2, '8202-Giant ', '1 pak(882 gram) untuk 1 ayam selama 3 minggu', 420, 3000, 'Kada Air => Max => 13%\r\nProtein => 20 - 22%\r\nLemak => Max => 7%\r\nSerat => Max => 4%\r\nAbu => Max => 7%\r\nCalcium => 0.9 – 1.1%\r\nPhosphor => 0.6 – 0.9%\r\nAntibiotika => Obat anti berak darah\r\n'),
(3, '551', '1 pak (4466 gram) untuk 1 ayam selama 8 minggu', 560, 7000, 'Kada Air => Max => 13%\r\nProtein => 18.5 - 20.5%\r\nLemak => Min => 4%\r\nSerat => Max => 6%\r\nAbu => Max => 8%\r\nCalcium => Min => 0.9%\r\nPhosphor => Min => 0.7%\r\nAntibiotika => Zinc Bacitracin\r\nBacteriostatic => Furazolidon\r\n\r\n'),
(4, 'Freebro', '1 pak (4466 gram) untuk 1 ayam selama 8 minggu', 595, 8000, '	Air max. 12,0%\r\n	Protein Kasar 19,0 – 20,0%\r\n	Lemak Kasar 5,0 – 7,0%\r\n	Serat Kasar 4,0 – 6,0%\r\n	Energi Metabolisme 3.100 Kkal/Kg\r\n	Abu max. 13,0%\r\n	Calcium 0,9 – 1,1%\r\n	Phosphor 0,6 – 0,8%');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rincian_ayam`
--

CREATE TABLE `rincian_ayam` (
  `idAyam` int(12) NOT NULL,
  `kondisi` varchar(20) NOT NULL,
  `keterangan` varchar(20) DEFAULT NULL,
  `beratAyam` int(12) NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'Belum'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `rincian_kandang`
--

CREATE TABLE `rincian_kandang` (
  `id` int(11) NOT NULL,
  `id_kandang` int(11) NOT NULL,
  `jumlah` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `rincian_obat`
--

CREATE TABLE `rincian_obat` (
  `id` int(3) NOT NULL,
  `idObat` int(11) NOT NULL,
  `minggu` varchar(12) NOT NULL,
  `jumlah` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `rincian_pakan`
--

CREATE TABLE `rincian_pakan` (
  `id` int(3) NOT NULL,
  `idPakan` int(11) NOT NULL,
  `minggu` varchar(12) NOT NULL DEFAULT '0',
  `jumlah` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `rincian_penjualan`
--

CREATE TABLE `rincian_penjualan` (
  `id_penjualan` int(3) NOT NULL,
  `jumlahAyam` int(12) NOT NULL,
  `beratAyam` int(12) NOT NULL,
  `hargaPer_Kg` int(11) NOT NULL,
  `totalPenjualan` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur untuk view `jual`
--
DROP TABLE IF EXISTS `jual`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `jual`  AS  select count(`rincian_ayam`.`idAyam`) AS `jumlahAyam`,`rincian_ayam`.`beratAyam` AS `beratAyam` from `rincian_ayam` where (`rincian_ayam`.`kondisi` <> 'mati') group by `rincian_ayam`.`beratAyam` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ayam`
--
ALTER TABLE `ayam`
  ADD PRIMARY KEY (`id_ayam`);

--
-- Indexes for table `kandang`
--
ALTER TABLE `kandang`
  ADD PRIMARY KEY (`id_kandang`);

--
-- Indexes for table `modal`
--
ALTER TABLE `modal`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pembelian_obat`
--
ALTER TABLE `pembelian_obat`
  ADD PRIMARY KEY (`id_beli_obat`);

--
-- Indexes for table `pembelian_pakan`
--
ALTER TABLE `pembelian_pakan`
  ADD PRIMARY KEY (`id_beli_pakan`);

--
-- Indexes for table `rincian_ayam`
--
ALTER TABLE `rincian_ayam`
  ADD PRIMARY KEY (`idAyam`);

--
-- Indexes for table `rincian_kandang`
--
ALTER TABLE `rincian_kandang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rincian_obat`
--
ALTER TABLE `rincian_obat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rincian_pakan`
--
ALTER TABLE `rincian_pakan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rincian_penjualan`
--
ALTER TABLE `rincian_penjualan`
  ADD PRIMARY KEY (`id_penjualan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ayam`
--
ALTER TABLE `ayam`
  MODIFY `id_ayam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `kandang`
--
ALTER TABLE `kandang`
  MODIFY `id_kandang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `modal`
--
ALTER TABLE `modal`
  MODIFY `id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pembelian_obat`
--
ALTER TABLE `pembelian_obat`
  MODIFY `id_beli_obat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `pembelian_pakan`
--
ALTER TABLE `pembelian_pakan`
  MODIFY `id_beli_pakan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `rincian_ayam`
--
ALTER TABLE `rincian_ayam`
  MODIFY `idAyam` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2340;

--
-- AUTO_INCREMENT for table `rincian_kandang`
--
ALTER TABLE `rincian_kandang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `rincian_obat`
--
ALTER TABLE `rincian_obat`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT for table `rincian_pakan`
--
ALTER TABLE `rincian_pakan`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT for table `rincian_penjualan`
--
ALTER TABLE `rincian_penjualan`
  MODIFY `id_penjualan` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
