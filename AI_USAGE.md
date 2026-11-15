# AI USAGE DOCUMENTATION

## 1. Informasi Proyek

- Nama Proyek: Aplikasi Pengelolaan Data Putusan Pengadilan Narkotika
- Mata Kuliah: Struktur Data
- Kelas: B
- Jumlah Anggota: 2 mahasiswa
- AI yang digunakan: ChatGPT (GPT-6)
- Periode Penggunaan: 11–15 November 2026

## 2. Tujuan Penggunaan AI

AI generatif digunakan sebagai alat bantu pembelajaran dan pengembangan proyek, khususnya untuk memahami konsep struktur data, membantu proses debugging, menyusun pengujian, memeriksa konsistensi dataset, dan memperbaiki dokumentasi.

AI tidak digunakan sebagai pengganti tanggung jawab anggota kelompok. Setiap saran yang digunakan diperiksa, disesuaikan dengan kebutuhan aplikasi, dan diverifikasi melalui kode program, pengujian, atau pemeriksaan sumber data.

## 3. Catatan Penggunaan AI

### 3.1 Bantuan Implementasi dan Pemahaman Java

- Tanggal:11–15 November 2026
- Anggota: Nurul Deby Heryani
- Alat: ChatGPT (GPT-6)
- Tujuan: Membantu memahami dan mengembangkan aplikasi pengelolaan data putusan menggunakan Java.
- Ringkasan prompt: Meminta penjelasan dan bantuan perbaikan kode Java, termasuk model Putusan, PutusanService, pengelolaan data, pencarian, filtering, agregasi, serta pengurutan.
- Keluaran AI yang digunakan: Penjelasan konsep, contoh perbaikan kode, dan saran implementasi fitur.
- Perubahan yang dilakukan: Kode disesuaikan dengan struktur package, nama class, atribut, dan kebutuhan aplikasi kelompok. Saran yang tidak sesuai dengan implementasi proyek tidak digunakan.
- Cara verifikasi: Menjalankan aplikasi melalui IntelliJ IDEA, memeriksa hasil fitur pada menu aplikasi, dan menjalankan pengujian JUnit.

### 3.2 Bantuan Import dan Export Data

- Tanggal: 11–15 November 2026
- Anggota: Nurul Deby Heryani
- Alat: ChatGPT (GPT-6)
- Tujuan: Membantu memahami proses pembacaan dan penulisan data CSV serta TXT.
- Ringkasan prompt: Meminta bantuan membuat dan memperbaiki CsvImporter dan CsvExporter, termasuk pemrosesan 16 atribut putusan, tanggal, angka, dan penanganan record tidak valid.
- Keluaran AI yang digunakan: Penjelasan parsing CSV, penanganan kesalahan input, dan contoh implementasi impor serta ekspor.
- Perubahan yang dilakukan: Implementasi disesuaikan dengan format dataset proyek, yaitu pemisah titik koma dan skema 16 atribut.
- Cara verifikasi: Menguji proses impor 50 data, memeriksa jumlah record yang diterima dan ditolak, serta memeriksa file hasil ekspor CSV dan TXT.

### 3.3 Bantuan Debugging dan Pengujian

- Tanggal: 12–15 November 2026
- Anggota: Nurul Deby Heryani
- Alat:ChatGPT (GPT-6)
- Tujuan:Membantu menemukan kesalahan kode dan meningkatkan kualitas pengujian aplikasi.
- Ringkasan prompt: Meminta bantuan menganalisis kesalahan pada atribut Putusan, tipe data vonisBulan, hasil filtering, operasi Stack, dan skenario pengujian.
- Keluaran AI yang digunakan: Penjelasan penyebab kesalahan, saran perbaikan kode, serta rancangan test menggunakan JUnit 5.
- Perubahan yang dilakukan:Perbaikan diterapkan setelah disesuaikan dengan kode aktual, termasuk penyesuaian tipe data vonisBulan menjadi int dan penambahan pemeriksaan invariant pada struktur data.
- Cara verifikasi: Menjalankan pengujian menggunakan Maven dengan perintah `mvn clean test` dan memeriksa hasil pengujian pada IntelliJ IDEA.

### 3.4 Bantuan Pemeriksaan Dataset dan Provenance

- Tanggal: 11–15 November 2026
- Anggota: Nurul Deby Heryani
- Alat: ChatGPT (GPT-6)
- Tujuan: Membantu memeriksa kelengkapan atribut dataset putusan dan pencatatan sumber data.
- Ringkasan prompt: Meminta bantuan memeriksa struktur CSV, kelengkapan kode anonim terdakwa, konsistensi berat barang bukti, dan kelengkapan kolom provenance.
- Keluaran AI yang digunakan: Temuan pemeriksaan dataset dan rekomendasi bagian yang perlu diperiksa kembali.
- Perubahan yang dilakukan: Dataset diperiksa dan diperbaiki berdasarkan dokumen putusan sumber yang tersedia. Nilai yang tidak ditemukan tidak dibuat berdasarkan perkiraan.
- Cara verifikasi: Membandingkan nilai pada CSV dengan dokumen putusan dan catatan provenance.

### 3.5 Bantuan Penyusunan Dokumentasi

- Tanggal: 11–15 November 2026
- Anggota: Nurul Deby Heryani
- Alat: ChatGPT (GPT-6)
- Tujuan: Membantu menyusun dan memperbaiki dokumentasi proyek.
- Ringkasan prompt:Meminta bantuan menyusun README, CONTRIBUTIONS, AI_USAGE, ADR, dokumentasi pengujian, dan laporan hasil pengujian.
- Keluaran AI yang digunakan:Rancangan struktur dokumentasi, perbaikan kalimat, tabel, dan daftar pemeriksaan.
- Perubahan yang dilakukan:Isi dokumentasi disesuaikan dengan fitur, struktur folder, pembagian tugas, dan aktivitas yang benar-benar dilakukan kelompok.
- Cara verifikasi: Memeriksa kembali kesesuaian dokumentasi dengan source code, file dataset, hasil pengujian, dan riwayat GitHub.

## 4. Penggunaan AI oleh Anggota 1 – Sulpemi HI Kader

### 4.1 Bantuan Pemahaman dan Implementasi Struktur Data

- **Tanggal:** 14–15 November 2026
- **Anggota:** Sulpemi HI Kader
- **Alat:** ChatGPT (GPT-6)
- **Tujuan:** Membantu memahami konsep dan implementasi struktur data generik dalam Java, khususnya DynamicArray, CustomStack, dan CustomQueue.
- **Ringkasan prompt:** Meminta penjelasan implementasi struktur data generik, penggunaan array, operasi penyimpanan data, serta cara memahami kode Java yang digunakan dalam proyek.
- **Keluaran AI yang digunakan:** Penjelasan konsep struktur data, saran implementasi, serta penjelasan fungsi dan metode dalam kelas struktur data.
- **Perubahan yang dilakukan:** Saran AI dipelajari dan disesuaikan dengan desain serta kebutuhan aplikasi kelompok.
- **Cara verifikasi:** Memeriksa implementasi kode, menjalankan program, dan memastikan operasi struktur data berjalan sesuai kebutuhan.

### 4.2 Bantuan Implementasi CustomStack dan CustomQueue

- **Tanggal:** 14–15 November 2026
- **Anggota:** Sulpemi HI Kader
- **Alat:** ChatGPT (GPT-6)
- **Tujuan:** Membantu memahami operasi Stack dan Queue serta penerapannya dalam aplikasi pengelolaan data putusan.
- **Ringkasan prompt:** Meminta penjelasan dan bantuan implementasi operasi push, pop, peek, enqueue, dequeue, pencarian data, serta pemeliharaan urutan data.
- **Keluaran AI yang digunakan:** Penjelasan operasi Stack dan Queue, saran implementasi metode, serta penjelasan cara menjaga urutan data ketika melakukan pencarian.
- **Perubahan yang dilakukan:** Implementasi CustomStack dan CustomQueue disesuaikan dengan kebutuhan struktur data dan kontrak operasi aplikasi.
- **Cara verifikasi:** Memeriksa urutan data, menjalankan operasi struktur data, serta menjalankan unit test yang tersedia.

### 4.3 Bantuan Pengujian dan Debugging

- **Tanggal:** 14–15 November 2026
- **Anggota:** Sulpemi HI Kader
- **Alat:** ChatGPT (GPT-6)
- **Tujuan:** Membantu memahami kesalahan implementasi, memeriksa invariant struktur data, dan menyusun pengujian.
- **Ringkasan prompt:** Meminta bantuan memahami invariant DynamicArray dan CustomStack, memperbaiki kesalahan kode, serta menambahkan pengujian untuk memeriksa validitas struktur data.
- **Keluaran AI yang digunakan:** Penjelasan invariant, saran pengujian, dan bantuan memahami kesalahan implementasi.
- **Perubahan yang dilakukan:** Menambahkan pemeriksaan invariant serta pengujian yang disesuaikan dengan implementasi aktual.
- **Cara verifikasi:** Menjalankan pengujian JUnit, memeriksa hasil pengujian, dan memastikan operasi struktur data berjalan sesuai harapan.

### 4.4 Pernyataan Penggunaan AI Anggota 1

Anggota 1 menggunakan AI sebagai alat bantu pembelajaran, pemahaman implementasi, debugging, dan pengujian. Seluruh saran AI yang digunakan diperiksa dan disesuaikan dengan kode aktual proyek. Anggota 1 tetap bertanggung jawab terhadap implementasi, pengujian, pemahaman, dan hasil akhir pekerjaan yang dilakukan.

## 5. Batasan Penggunaan AI

AI digunakan untuk:
- Mendiskusikan konsep dan struktur data.
- Meminta contoh implementasi kecil.
- Menjelaskan kesalahan program.
- Meninjau dan menyusun skenario pengujian.
- Membantu memperbaiki kalimat dokumentasi.
- Memberikan saran pemeriksaan konsistensi data.

AI tidak digunakan untuk:
- Mengarang nilai atribut putusan yang tidak ditemukan dalam sumber.
- Mengarang nomor halaman sumber atau hasil verifikasi.
- Membuat bukti commit, Issue, Pull Request, atau review palsu.
- Menggantikan tanggung jawab anggota dalam memahami dan mempertanggungjawabkan program.

## 6. Pernyataan Tanggung Jawab

Seluruh anggota kelompok bertanggung jawab atas kebenaran dataset, implementasi kode, pengujian, dokumentasi, dan hasil akhir proyek.

Setiap keluaran AI yang digunakan telah diperiksa dan disesuaikan dengan kebutuhan proyek. Hasil pengujian dan verifikasi hanya dinyatakan berhasil apabila benar-benar telah dilakukan dan memiliki bukti pendukung.

Dokumen ini dibuat sebagai bentuk transparansi penggunaan AI selama pengerjaan UTS Struktur Data.