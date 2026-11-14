package util;

import model.Putusan;
import com.kelompok.narkotika.structure.DynamicArray;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvExporter {

    private static final String HEADER =
            "caseId;nomorPerkara;pengadilan;tanggalPutusan;" +
                    "terdakwaKode;jenisNarkotika;beratBarangBuktiGram;" +
                    "pasalDakwaan;pasalTerbukti;tuntutanBulan;vonisBulan;" +
                    "dendaRupiah;barangBukti;keadaanMemberatkan;" +
                    "keadaanMeringankan;sourcePages";

    public static void exportCsv(
            Path filePath,
            DynamicArray<Putusan> records
    ) throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(
                filePath, StandardCharsets.UTF_8)) {

            writer.write(HEADER);
            writer.newLine();

            for (int i = 0; i < records.size(); i++) {
                Putusan p = records.get(i);

                String[] values = {
                        p.getCaseId(),
                        p.getNomorPerkara(),
                        p.getPengadilan(),
                        String.valueOf(p.getTanggalPutusan()),
                        p.getTerdakwaKode(),
                        p.getJenisNarkotika(),
                        String.valueOf(p.getBeratBarangBuktiGram()),
                        p.getPasalDakwaan(),
                        p.getPasalTerbukti(),
                        String.valueOf(p.getTuntutanBulan()),
                        String.valueOf(p.getVonisBulan()),
                        String.valueOf(p.getDendaRupiah()),
                        p.getBarangBukti(),
                        p.getKeadaanMemberatkan(),
                        p.getKeadaanMeringankan(),
                        p.getSourcePages()
                };

                for (int j = 0; j < values.length; j++) {
                    if (j > 0) {
                        writer.write(";");
                    }
                    writer.write(escapeCsv(values[j]));
                }

                writer.newLine();
            }
        }
    }

    public static void exportTxt(
            Path filePath,
            DynamicArray<Putusan> records
    ) throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(
                filePath, StandardCharsets.UTF_8)) {

            for (int i = 0; i < records.size(); i++) {
                Putusan p = records.get(i);

                writer.write("==================================");
                writer.newLine();
                writer.write("CASE ID: " + p.getCaseId());
                writer.newLine();
                writer.write("Nomor Perkara: " + p.getNomorPerkara());
                writer.newLine();
                writer.write("Pengadilan: " + p.getPengadilan());
                writer.newLine();
                writer.write("Tanggal Putusan: " + p.getTanggalPutusan());
                writer.newLine();
                writer.write("Terdakwa: " + p.getTerdakwaKode());
                writer.newLine();
                writer.write("Jenis Narkotika: " + p.getJenisNarkotika());
                writer.newLine();
                writer.write("Berat Barang Bukti: " +
                        p.getBeratBarangBuktiGram() + " gram");
                writer.newLine();
                writer.write("Pasal Dakwaan: " + p.getPasalDakwaan());
                writer.newLine();
                writer.write("Pasal Terbukti: " + p.getPasalTerbukti());
                writer.newLine();
                writer.write("Tuntutan: " + p.getTuntutanBulan() + " bulan");
                writer.newLine();
                writer.write("Vonis: " + p.getVonisBulan() + " bulan");
                writer.newLine();
                writer.write("Denda: Rp" + p.getDendaRupiah());
                writer.newLine();
                writer.write("Barang Bukti: " + p.getBarangBukti());
                writer.newLine();
                writer.write("Keadaan Memberatkan: " +
                        p.getKeadaanMemberatkan());
                writer.newLine();
                writer.write("Keadaan Meringankan: " +
                        p.getKeadaanMeringankan());
                writer.newLine();
                writer.write("Source Pages: " + p.getSourcePages());
                writer.newLine();
            }
        }
    }

    private static String escapeCsv(String value) {
        if (value == null) {
            return "";
        }

        if (value.contains(";") ||
                value.contains("\"") ||
                value.contains("\n") ||
                value.contains("\r")) {

            return "\"" + value.replace("\"", "\"\"") + "\"";
        }

        return value;
    }
}

