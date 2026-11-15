package com.kelompok.narkotika;

import com.kelompok.narkotika.model.Putusan;
import com.kelompok.narkotika.service.PutusanService;
import com.kelompok.narkotika.structure.DynamicArray;
import com.kelompok.narkotika.util.CsvImporter;
import com.kelompok.narkotika.util.CsvExporter;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static PutusanService service;

    public static void main(String[] args) {

        DynamicArray<Putusan> data = new DynamicArray<>();
        service = new PutusanService(data);

        int pilihan;

        do {
            System.out.println("\n===== SISTEM DATA PUTUSAN NARKOTIKA =====");
            System.out.println("1. Import data CSV");
            System.out.println("2. Tampilkan seluruh data");
            System.out.println("3. Cari berdasarkan Case ID");
            System.out.println("4. Cari berdasarkan Nomor Perkara");
            System.out.println("5. Filter jenis narkotika");
            System.out.println("6. Filter rentang berat barang bukti");
            System.out.println("7. Filter pasal terbukti");
            System.out.println("8. Filter rentang vonis");
            System.out.println("9. Statistik data");
            System.out.println("10. Urutkan berdasarkan vonis");
            System.out.println("11. Tambah data");
            System.out.println("12. Hapus data");
            System.out.println("13. Export CSV");
            System.out.println("14. Export TXT");
            System.out.println("15. Lihat riwayat aktivitas");
            System.out.println("16. Filter gabungan");
            System.out.println("17. Distribusi jenis narkotika");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = bacaInt();

            switch (pilihan) {
                case 1 -> importData();
                case 2 -> tampilkanData();
                case 3 -> cariCaseId();
                case 4 -> cariNomorPerkara();
                case 5 -> filterJenis();
                case 6 -> filterBerat();
                case 7 -> filterPasal();
                case 8 -> filterVonis();
                case 9 -> statistik();
                case 10 -> urutkan();
                case 11 -> tambahData();
                case 12 -> hapusData();
                case 13 -> exportCsv();
                case 14 -> exportTxt();
                case 15 -> lihatRiwayat();
                case 16 -> filterGabungan();
                case 17 -> service.tampilkanDistribusiJenis();
                case 0 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);
    }

    private static int bacaInt() {
        try {
            return Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    private static void filterGabungan() {
        System.out.println("\n===== FILTER GABUNGAN =====");

        System.out.print("Jenis narkotika (kosong jika dilewati): ");
        String jenis = input.nextLine();
        if (jenis.isBlank()) jenis = null;

        System.out.print("Berat minimum (kosong jika dilewati): ");
        String minBerat = input.nextLine();

        System.out.print("Berat maksimum (kosong jika dilewati): ");
        String maxBerat = input.nextLine();

        Double beratMin = minBerat.isBlank()
                ? null : Double.parseDouble(minBerat.replace(",", "."));

        Double beratMax = maxBerat.isBlank()
                ? null : Double.parseDouble(maxBerat.replace(",", "."));

        System.out.print("Pasal terbukti (kosong jika dilewati): ");
        String pasal = input.nextLine();
        if (pasal.isBlank()) pasal = null;

        System.out.print("Vonis minimum (kosong jika dilewati): ");
        String minVonis = input.nextLine();

        System.out.print("Vonis maksimum (kosong jika dilewati): ");
        String maxVonis = input.nextLine();

        Integer vonisMin = minVonis.isBlank()
                ? null : Integer.parseInt(minVonis);

        Integer vonisMax = maxVonis.isBlank()
                ? null : Integer.parseInt(maxVonis);

        DynamicArray<Putusan> hasil = service.filterGabungan(
                jenis, beratMin, beratMax, pasal, vonisMin, vonisMax
        );

        tampilkanHasil(hasil);
    }



    private static void importData() {
        System.out.println("\n===== IMPORT DATA CSV =====");

        Path fileCSV = Path.of("data", "putusan-50.csv");

        try {
            // Periksa apakah file tersedia
            if (!Files.exists(fileCSV)) {
                System.out.println("File CSV tidak ditemukan!");
                System.out.println("Lokasi yang dicari: "
                        + fileCSV.toAbsolutePath());
                return;
            }

            CsvImporter importer = new CsvImporter();

            CsvImporter.ImportResult hasil =
                    importer.importFile(fileCSV);

            DynamicArray<Putusan> data = hasil.getRecords();

            int berhasil = 0;
            int ditolak = 0;

            for (int i = 0; i < data.size(); i++) {
                Putusan p = data.get(i);

                if (service.tambahPutusan(p)) {
                    berhasil++;
                } else {
                    ditolak++;
                }
            }

            ditolak += hasil.getErrors().size();

            System.out.println("\nImport selesai!");
            System.out.println("Data berhasil ditambahkan: " + berhasil);
            System.out.println("Data ditolak: " + ditolak);

            for (String error : hasil.getErrors()) {
                System.out.println(error);
            }

        } catch (Exception e) {
            System.out.println("Gagal import: " + e.getMessage());
        }
    }


    private static void tampilkanData() {
        DynamicArray<Putusan> data = service.getAll();

        if (data.isEmpty()) {
            System.out.println("Belum ada data.");
            return;
        }

        for (int i = 0; i < data.size(); i++) {
            System.out.println("\nData ke-" + (i + 1));
            System.out.println(data.get(i));
        }
    }

    private static void cariCaseId() {
        System.out.print("Masukkan Case ID: ");
        String id = input.nextLine();

        PutusanService.SearchResult hasil = service.cariCaseId(id);

        tampilkanHasilPencarian(hasil);
    }

    private static void cariNomorPerkara() {
        System.out.print("Masukkan Nomor Perkara: ");
        String nomor = input.nextLine();

        PutusanService.SearchResult hasil =
                service.cariNomorPerkara(nomor);

        tampilkanHasilPencarian(hasil);
    }

    private static void tampilkanHasilPencarian(
            PutusanService.SearchResult hasil) {

        if (hasil.getPutusan() == null) {
            System.out.println("Data tidak ditemukan.");
        } else {
            System.out.println(hasil.getPutusan());
        }

        System.out.println("Jumlah langkah pencarian: " +
                hasil.getSteps());
    }

    private static void filterJenis() {
        System.out.print("Masukkan jenis narkotika: ");
        String jenis = input.nextLine();

        tampilkanHasil(service.filterJenisNarkotika(jenis));
    }

    private static void filterBerat() {
        System.out.print("Berat minimum (gram): ");
        double min = bacaDouble();

        System.out.print("Berat maksimum (gram): ");
        double max = bacaDouble();

        tampilkanHasil(service.filterBerat(min, max));
    }

    private static double bacaDouble() {
        try {
            return Double.parseDouble(
                    input.nextLine().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void filterPasal() {
        System.out.print("Masukkan pasal terbukti: ");
        String pasal = input.nextLine();

        tampilkanHasil(service.filterPasalTerbukti(pasal));
    }

    private static void filterVonis() {
        System.out.print("Vonis minimum (bulan): ");
        int min = bacaInt();

        System.out.print("Vonis maksimum (bulan): ");
        int max = bacaInt();

        tampilkanHasil(service.filterVonis(min, max));
    }

    private static void tampilkanHasil(
            DynamicArray<Putusan> hasil) {

        System.out.println("Jumlah hasil: " + hasil.size());

        for (int i = 0; i < hasil.size(); i++) {
            System.out.println(hasil.get(i));
        }
    }

    private static void statistik() {
        System.out.println("Jumlah data: " + service.jumlahData());
        System.out.println("Rata-rata vonis: " +
                service.rataRataVonis() + " bulan");
        System.out.println("Total denda: Rp" +
                service.totalDenda());
    }

    private static void urutkan() {
        service.urutkanVonis();
        System.out.println("Data berhasil diurutkan berdasarkan vonis.");
    }

    private static void hapusData() {
        tampilkanData();

        System.out.print("Masukkan nomor urut data yang dihapus: ");
        int nomor = bacaInt();

        if (service.hapusPutusan(nomor - 1)) {
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Nomor data tidak valid.");
        }
    }

    private static void exportCsv() {
        System.out.print("Nama file tujuan (contoh: hasil.csv): ");
        String nama = input.nextLine();

        try {
            CsvExporter.exportCsv(
                    Path.of(nama), service.getAll());

            System.out.println("Export CSV berhasil.");
        } catch (Exception e) {
            System.out.println("Gagal export: " + e.getMessage());
        }
    }

    private static void exportTxt() {
        System.out.print("Nama file tujuan (contoh: hasil.txt): ");
        String nama = input.nextLine();

        try {
            CsvExporter.exportTxt(
                    Path.of(nama), service.getAll());

            System.out.println("Export TXT berhasil.");
        } catch (Exception e) {
            System.out.println("Gagal export: " + e.getMessage());
        }
    }

    private static void lihatRiwayat() {
        System.out.println("Aktivitas terakhir: " +
                service.lihatRiwayatTerakhir());
        System.out.println("Jumlah riwayat: " +
                service.jumlahRiwayat());
    }


    private static void tambahData() {
        try {
            System.out.println("\n===== TAMBAH DATA PUTUSAN =====");

            System.out.print("Case ID: ");
            String caseId = input.nextLine();

            System.out.print("Nomor Perkara: ");
            String nomorPerkara = input.nextLine();

            System.out.print("Pengadilan: ");
            String pengadilan = input.nextLine();

            System.out.print("Tanggal Putusan (YYYY-MM-DD): ");
            java.time.LocalDate tanggal =
                    java.time.LocalDate.parse(input.nextLine());

            System.out.print("Kode Terdakwa: ");
            String terdakwaKode = input.nextLine();

            System.out.print("Jenis Narkotika: ");
            String jenis = input.nextLine();

            System.out.print("Berat Barang Bukti (gram): ");
            double berat = bacaDouble();

            System.out.print("Pasal Dakwaan: ");
            String pasalDakwaan = input.nextLine();

            System.out.print("Pasal Terbukti: ");
            String pasalTerbukti = input.nextLine();

            System.out.print("Tuntutan (bulan): ");
            int tuntutan = bacaInt();

            System.out.print("Vonis (bulan): ");
            int vonis = bacaInt();

            System.out.print("Denda (rupiah): ");
            long denda = Long.parseLong(input.nextLine());

            System.out.print("Barang Bukti: ");
            String barangBukti = input.nextLine();

            System.out.print("Keadaan Memberatkan: ");
            String memberatkan = input.nextLine();

            System.out.print("Keadaan Meringankan: ");
            String meringankan = input.nextLine();

            System.out.print("Source Pages: ");
            String sourcePages = input.nextLine();


            Putusan putusan = new Putusan(
                    caseId,
                    nomorPerkara,
                    pengadilan,
                    tanggal,
                    terdakwaKode,
                    jenis,
                    berat,
                    pasalDakwaan,
                    pasalTerbukti,
                    tuntutan,
                    vonis,
                    denda,
                    barangBukti,
                    memberatkan,
                    meringankan,
                    sourcePages
            );

            if (service.tambahPutusan(putusan)) {
                System.out.println("Data berhasil ditambahkan!");
            } else {
                System.out.println("Data gagal ditambahkan. Case ID mungkin duplikat.");
            }

        } catch (Exception e) {
            System.out.println("Gagal menambahkan data: " + e.getMessage());
        }
    }

}

