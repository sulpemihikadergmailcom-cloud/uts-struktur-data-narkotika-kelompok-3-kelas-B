# HASIL PENGUJIAN SISTEM

## 1. Pengujian Unit (JUnit 5)

Pengujian unit dilakukan menggunakan JUnit 5 terhadap class `PutusanServiceTest`.

Hasil pengujian:

| Keterangan | Hasil |
|---|---:|
| Total test | 13 |
| Test berhasil | 13 |
| Test gagal | 0 |
| Status | PASS |

Seluruh 13 test berhasil dijalankan tanpa kegagalan.

## 2. Pengujian Fungsional Program

Pengujian dilakukan secara langsung melalui menu aplikasi Sistem Data Putusan Narkotika.

| No. | Fitur yang Diuji | Hasil |
|---:|---|---|
| 1 | Import data CSV | Berhasil mengimpor 50 data, ditolak 0 |
| 2 | Menampilkan seluruh data | Berhasil |
| 3 | Pencarian berdasarkan Case ID | Berhasil |
| 4 | Pencarian berdasarkan nomor perkara | Berhasil |
| 5 | Filter jenis narkotika | Berhasil |
| 6 | Filter rentang berat barang bukti | Berhasil |
| 7 | Filter pasal terbukti | Berhasil |
| 8 | Filter rentang vonis | Berhasil |
| 9 | Statistik data | Berhasil |
| 10 | Pengurutan berdasarkan vonis | Berhasil |
| 11 | Menambahkan data putusan | Berhasil |
| 12 | Menghapus data putusan | Berhasil |
| 13 | Export CSV | Berhasil |
| 14 | Export TXT | Berhasil |
| 15 | Melihat riwayat aktivitas | Berhasil |
| 16 | Filter gabungan | Berhasil |
| 17 | Distribusi jenis narkotika | Berhasil |

## 3. Pengujian Tambah dan Hapus Data

Pengujian penambahan dilakukan menggunakan data dummy dengan Case ID `KDR-051`.

Data berhasil ditambahkan ke dalam sistem. Selanjutnya, data dummy tersebut berhasil dihapus melalui menu hapus data.

Data dummy tidak digunakan sebagai bagian dari dataset final.

## 4. Kesimpulan

Berdasarkan pengujian unit menggunakan JUnit 5 dan pengujian fungsional secara manual, aplikasi Sistem Pengelolaan Data Putusan Narkotika telah berhasil menjalankan fitur-fitur utama yang tersedia.

Hasil pengujian unit menunjukkan bahwa seluruh 13 test pada `PutusanServiceTest` berhasil dijalankan dengan 13 test berhasil dan 0 test gagal.

Pengujian fungsional secara manual juga menunjukkan bahwa fitur impor data, penampilan data, pencarian, penyaringan, statistik, pengurutan, penambahan, penghapusan, ekspor, dan riwayat aktivitas dapat dijalankan sesuai hasil yang dicatat pada tabel pengujian.

Pengujian penambahan dan penghapusan menggunakan data dummy `KDR-051` juga berhasil dilakukan. Data dummy tersebut telah dihapus kembali sehingga tidak menjadi bagian dari dataset final.

### Catatan Pengujian Lanjutan

Pengujian fungsional di atas belum secara otomatis membuktikan bahwa seluruh tujuh skenario wajib pada Panduan UTS telah terpenuhi. Oleh karena itu, beberapa skenario masih perlu diperiksa dan dilengkapi bukti pengujiannya, yaitu:

1. Membuktikan jumlah data tepat 50 menggunakan pemeriksaan `size()`.
2. Menguji pencarian data yang ditemukan, tidak ditemukan, dan data pada posisi batas.
3. Menguji penghapusan elemen pertama, tengah, dan terakhir.
4. Menguji penambahan tiga record sekaligus serta memeriksa invariant dan urutan data.
5. Menguji filter gabungan dan mencocokkan hasilnya dengan provenance secara manual.
6. Membuktikan pencarian pada Stack atau Queue tidak mengubah urutan akhir.
7. Menguji impor record tidak valid dan memastikan struktur data tetap konsisten.

Hasil ketujuh skenario tersebut harus dilengkapi berdasarkan pengujian yang benar-benar dilakukan. Tidak ada skenario yang dinyatakan berhasil sebelum pengujian dan bukti pendukungnya tersedia.