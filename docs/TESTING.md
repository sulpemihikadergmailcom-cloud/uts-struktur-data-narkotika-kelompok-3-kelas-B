# Dokumentasi Pengujian

## Pengujian PutusanService

Pengujian dilakukan menggunakan JUnit 5
untuk memastikan fungsi PutusanService berjalan
sesuai kebutuhan aplikasi.

## Skenario Pengujian

1. Menghitung jumlah data putusan.
2. Mencari data berdasarkan Case ID.
3. Memastikan pencarian data yang tidak ditemukan.
4. Mencari data berdasarkan nomor perkara.
5. Menambahkan data putusan baru.
6. Menguji penolakan Case ID duplikat.
7. Menghapus data putusan.
8. Menguji penghapusan data yang tidak tersedia.
9. Memfilter data berdasarkan jenis narkotika.
10. Memfilter data berdasarkan berat barang bukti.
11. Memfilter data berdasarkan rentang vonis.
12. Menghitung rata-rata vonis.
13. Menghitung total denda.

## Hasil Pengujian

Pengujian dijalankan menggunakan Maven
dengan perintah:

mvn test

Hasil aktual pengujian dicatat berdasarkan
laporan yang muncul setelah proses pengujian selesai.
