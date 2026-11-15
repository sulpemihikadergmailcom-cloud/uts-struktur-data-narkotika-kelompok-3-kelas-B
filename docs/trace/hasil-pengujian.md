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

Berdasarkan pengujian unit dan peng