# Sistem Pengelolaan Data Putusan Narkotika

## Deskripsi
Program ini merupakan aplikasi berbasis Java untuk mengelola data putusan pengadilan terkait perkara narkotika.

Aplikasi menggunakan struktur data yang diimplementasikan secara manual untuk menyimpan dan mengolah data putusan.

## Teknologi
- Java 17
- Maven
- IntelliJ IDEA
- JUnit 5

## Struktur Data
1. Dynamic Array sebagai struktur data utama untuk menyimpan data putusan.
2. Custom Stack untuk menyimpan riwayat aktivitas.

## Fitur Program
- Import data putusan dari CSV.
- Menampilkan seluruh data.
- Menambahkan data putusan.
- Menghapus data putusan.
- Pencarian berdasarkan Case ID.
- Pencarian berdasarkan nomor perkara.
- Menghitung langkah pencarian.
- Filter jenis narkotika.
- Filter berat barang bukti.
- Filter pasal terbukti.
- Filter rentang vonis.
- Filter gabungan.
- Statistik jumlah data.
- Menghitung rata-rata vonis.
- Menghitung total denda.
- Distribusi jenis narkotika.
- Pengurutan berdasarkan vonis.
- Riwayat aktivitas.
- Export data ke CSV dan TXT.

## Format Case ID
Setiap data putusan menggunakan kode unik dengan format:

- KDR-001
- KDR-002
- KDR-003
- Dan seterusnya.

## Struktur Data Putusan
Setiap record memiliki 16 atribut:
1. caseId
2. nomorPerkara
3. pengadilan
4. tanggalPutusan
5. terdakwaKode
6. jenisNarkotika
7. beratBarangBuktiGram
8. pasalDakwaan
9. pasalTerbukti
10. tuntutanBulan
11. vonisBulan
12. dendaRupiah
13. barangBukti
14. keadaanMemberatkan
15. keadaanMeringankan
16. sourcePages

## Cara Menjalankan
1. Buka proyek menggunakan IntelliJ IDEA.
2. Pastikan Java 17 sudah terpasang.
3. Buka file `Main.java`.
4. Jalankan method `main()`.
5. Pilih menu yang tersedia pada console.

## Pengujian
Pengujian dilakukan menggunakan JUnit 5 untuk memeriksa:
- Jumlah data.
- Pencarian Case ID.
- Pencarian nomor perkara.
- Penambahan data.
- Pencegahan Case ID duplikat.
- Penghapusan data.
- Filter data.
- Perhitungan statistik.


## Anggota Kelompok

### Sulpemi HI Kader
Tugas dan Tanggung Jawab:
- Mengimplementasikan struktur data Dynamic Array secara manual.
- Mengimplementasikan Custom Stack.
- Mengembangkan algoritma pengolahan dan pencarian data putusan.
- Mengimplementasikan struktur pendukung program.
- Membuat pengujian untuk struktur data dan algoritma.
- Melakukan integrasi struktur data dengan bagian program lainnya.
- Melakukan review Pull Request dari Anggota 2.

### Nurul Deby Heryani
Tugas dan Tanggung Jawab:
- Mengekstraksi 25 data putusan pengadilan narkotika.
- Melakukan pengolahan dan validasi data putusan.
- Membuat model data Putusan.java dengan 16 atribut.
- Mengembangkan CsvImporter.java untuk membaca data CSV.
- Mengembangkan CsvExporter.java untuk ekspor data CSV dan TXT.
- Mengembangkan PutusanService.java untuk pengelolaan data, pencarian, filter, dan statistik.
- Mengintegrasikan fitur melalui Main.java.
- Membuat pengujian menggunakan JUnit.
- Menyusun dokumentasi README.md dan ADR strategi pencarian.
- Melakukan review Pull Request dari Anggota 1.

## Build Project

Proyek ini menggunakan Maven dan Java 17.

Pastikan Java 17 dan Maven sudah terpasang sebelum menjalankan perintah berikut.

Untuk membersihkan hasil build sebelumnya dan membangun proyek, jalankan:

```bash
mvn clean package
```

Jika proses berhasil, file hasil kompilasi akan tersedia di folder `target/`.

## Menjalankan Pengujian

Pengujian otomatis menggunakan JUnit 5.

Jalankan seluruh unit test dengan perintah:

```bash
mvn clean test
```

Untuk menjalankan proses pengujian tanpa membersihkan hasil build sebelumnya:

```bash
mvn test
```

Laporan pengujian dapat diperiksa pada:

```text
target/surefire-reports/
```

## Menjalankan Aplikasi

### Melalui IntelliJ IDEA

1. Buka proyek menggunakan IntelliJ IDEA.
2. Pastikan Project SDK menggunakan Java 17.
3. Buka file `Main.java` pada package `com.kelompok.narkotika`.
4. Jalankan method `main()`.
5. Aplikasi akan menampilkan menu pada console.
6. Pilih nomor menu sesuai fitur yang ingin digunakan.

### Melalui Terminal

Kompilasi seluruh source code:

```bash
mvn compile
```

Setelah kompilasi berhasil, aplikasi dapat dijalankan melalui konfigurasi Run IntelliJ IDEA dengan memilih class `com.kelompok.narkotika.Main`.

## Contoh Perintah Maven

| Perintah | Fungsi |
|---|---|
| `mvn clean` | Membersihkan hasil build sebelumnya |
| `mvn compile` | Mengompilasi source code |
| `mvn test` | Menjalankan unit test |
| `mvn clean test` | Membersihkan dan menjalankan pengujian |
| `mvn package` | Membuat hasil build proyek |
| `mvn clean package` | Membersihkan dan membangun proyek |

## Lokasi Dataset dan Hasil Ekspor

Dataset utama berada pada:

```text
data/putusan-50.csv
```

Dokumentasi provenance berada pada:

```text
docs/data-provenance.csv
```

File hasil ekspor CSV dan TXT disimpan sesuai lokasi yang ditentukan melalui fitur ekspor aplikasi.
