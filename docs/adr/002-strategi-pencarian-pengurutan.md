
# ADR-002 - Pemilihan Strategi Pencarian

## Status
Diterima

## Konteks
Aplikasi pengolahan data putusan narkotika membutuhkan
fitur pencarian untuk menemukan data berdasarkan
Case ID dan nomor perkara.

Jumlah data yang dikelola dalam aplikasi adalah
50 data putusan pengadilan.

Data disimpan menggunakan struktur data Dynamic Array.

## Keputusan
Kelompok memilih menggunakan algoritma
Linear Search (Sequential Search) untuk
melakukan pencarian data putusan.

Pencarian dilakukan dengan memeriksa setiap elemen
Dynamic Array secara berurutan sampai data ditemukan
atau seluruh elemen selesai diperiksa.

Pencarian diterapkan pada:
- Case ID
- Nomor perkara

## Alasan Pemilihan
- Implementasi sederhana dan mudah dipahami.
- Tidak memerlukan data dalam keadaan terurut.
- Sesuai dengan struktur Dynamic Array.
- Cocok untuk jumlah data sebanyak 50 record.
- Jumlah langkah pencarian dapat dihitung.

## Kompleksitas

| Kondisi | Kompleksitas |
|---|---|
| Best Case | O(1) |
| Average Case | O(n) |
| Worst Case | O(n) |
| Space Complexity | O(1) |

## Konsekuensi
- Pencarian dapat dilakukan tanpa mengurutkan data.
- Setiap pemeriksaan elemen dihitung sebagai satu langkah.
- Pencarian membutuhkan lebih banyak pemeriksaan
  ketika data berada di posisi akhir atau tidak ditemukan.
- Jika jumlah data bertambah besar, strategi pencarian
  dapat dievaluasi kembali.

## Implementasi
Strategi pencarian diterapkan pada class
PutusanService.java melalui method:
- cariCaseId(String caseId)
- cariNomorPerkara(String nomorPerkara)

Kedua method menghasilkan objek SearchResult
yang menyimpan data hasil pencarian, indeks,
dan jumlah langkah pemeriksaan.

## Evaluasi dan Pengembangan

Linear Search dipilih karena data putusan
tidak diwajibkan berada dalam kondisi terurut.

Binary Search dapat dipertimbangkan apabila
jumlah data meningkat dan data telah diurutkan
berdasarkan atribut pencarian yang digunakan.

Untuk kebutuhan aplikasi saat ini,
Linear Search dinilai lebih sederhana
dan sesuai dengan jumlah 50 data putusan.
