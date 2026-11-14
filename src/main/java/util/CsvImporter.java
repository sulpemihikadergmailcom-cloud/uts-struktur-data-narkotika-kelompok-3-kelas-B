package util;

import model.Putusan;
import com.kelompok.narkotika.structure.DynamicArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

public class CsvImporter {

    private static final String[] HEADERS = {
            "caseId",
            "nomorPerkara",
            "pengadilan",
            "tanggalPutusan",
            "terdakwaKode",
            "jenisNarkotika",
            "beratBarangBuktiGram",
            "pasalDakwaan",
            "pasalTerbukti",
            "tuntutanBulan",
            "vonisBulan",
            "dendaRupiah",
            "barangBukti",
            "keadaanMemberatkan",
            "keadaanMeringankan",
            "sourcePages"
    };

    public static class ImportResult {

        private final DynamicArray<Putusan> records =
                new DynamicArray<>();

        private final List<String> errors =
                new ArrayList<>();

        public DynamicArray<Putusan> getRecords() {
            return records;
        }

        public List<String> getErrors() {
            return errors;
        }

        public int getimportCount() {
            return records.size();
        }

        public int getRjectedCount(){
            return errors.size();
        }
    }

    public ImportResult importFile(Path path) throws IOException {

        ImportResult result = new ImportResult();

        try (BufferedReader reader = Files.newBufferedReader(
                path, StandardCharsets.UTF_8)) {

            String headerLine = reader.readLine();

            if (headerLine == null) {
                throw new IOException("File CSV kosong.");
            }

            if (headerLine.startsWith("\uFEFF")) {
                headerLine = headerLine.substring(1);
            }

            List<String> header = parseLine(headerLine);

            validateHeader(header);

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {

                lineNumber++;

                if (line.isBlank()) {
                    continue;
                }

                try {
                    List<String> columns = parseLine(line);

                    if (columns.size() != HEADERS.length) {
                        throw new IllegalArgumentException(
                                "Jumlah kolom " + columns.size()
                                        + ", seharusnya 16."
                        );
                    }

                    Putusan putusan = convertToPutusan(columns);

                    result.records.add(putusan);

                } catch (RuntimeException e) {

                    result.errors.add(
                            "Baris " + lineNumber + ": " + e.getMessage()
                    );
                }
            }
        }

        return result;
    }

    private void validateHeader(List<String> header)
            throws IOException {

        if (header.size() != HEADERS.length) {
            throw new IOException(
                    "Header CSV harus memiliki 16 kolom."
            );
        }

        for (int i = 0; i < HEADERS.length; i++) {

            if (!HEADERS[i].equalsIgnoreCase(
                    header.get(i).trim())) {

                throw new IOException(
                        "Header kolom ke-" + (i + 1)
                                + " seharusnya " + HEADERS[i]
                );
            }
        }
    }

    private Putusan convertToPutusan(List<String> c) {

        String caseId = c.get(0).trim();
        String nomorPerkara = c.get(1).trim();
        String pengadilan = c.get(2).trim();

        LocalDate tanggalPutusan =
                parseDate(c.get(3));

        String terdakwaKode = c.get(4).trim();
        String jenisNarkotika = c.get(5).trim();

        double berat =
                parseWeight(c.get(6));

        String pasalDakwaan = c.get(7).trim();
        String pasalTerbukti = c.get(8).trim();

        int tuntutan =
                parseInteger(c.get(9), "tuntutanBulan");

        int vonis =
                parseInteger(c.get(10), "vonisBulan");

        long denda =
                parseLong(c.get(11), "dendaRupiah");

        String barangBukti = c.get(12).trim();
        String keadaanMemberatkan = c.get(13).trim();
        String keadaanMeringankan = c.get(14).trim();
        String sourcePages = c.get(15).trim();

        return new Putusan(
                caseId,
                nomorPerkara,
                pengadilan,
                tanggalPutusan,
                terdakwaKode,
                jenisNarkotika,
                berat,
                pasalDakwaan,
                pasalTerbukti,
                tuntutan,
                vonis,
                denda,
                barangBukti,
                keadaanMemberatkan,
                keadaanMeringankan,
                sourcePages
        );
    }

    private LocalDate parseDate(String value) {

        String text = value.trim();

        if (isMissing(text)) {
            throw new IllegalArgumentException(
                    "tanggalPutusan tidak boleh kosong."
            );
        }

        try {
            return LocalDate.parse(text);
        } catch (DateTimeParseException ignored) {
            // Coba format tanggal berikutnya.
        }

        try {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern(
                            "d/M/uuuu", Locale.ROOT
                    );

            return LocalDate.parse(text, formatter);

        } catch (DateTimeParseException e) {

            throw new IllegalArgumentException(
                    "Format tanggal tidak valid: " + text
            );
        }
    }

    private double parseWeight(String value) {

        String text = value.trim();

        if (isMissing(text)) {
            return Double.NaN;
        }

        if (text.matches("\\d{1,2}:\\d{2}")) {
            throw new IllegalArgumentException(
                    "Berat '" + text
                            + "' menyerupai format waktu. "
                            + "Periksa kembali PDF sumber."
            );
        }

        String normalized = text.replace(",", ".");

        try {
            double result = Double.parseDouble(normalized);

            if (!Double.isFinite(result) || result < 0) {
                throw new IllegalArgumentException(
                        "Berat harus berupa angka positif."
                );
            }

            return result;

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException(
                    "Format berat tidak valid: " + text
            );
        }
    }

    private int parseInteger(String value, String field) {

        String text = value.trim();

        if (isMissing(text)) {
            return 0;
        }

        try {
            int result = Integer.parseInt(text);

            if (result < 0) {
                throw new IllegalArgumentException(
                        field + " tidak boleh negatif."
                );
            }

            return result;

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException(
                    field + " bukan angka yang valid: " + text
            );
        }
    }

    private long parseLong(String value, String field) {

        String text = value.trim();

        if (isMissing(text)) {
            return 0L;
        }

        text = text.replace("Rp.", "")
                .replace("Rp", "")
                .replace(".", "")
                .replace(",", "")
                .replace(" ", "");

        try {
            long result = Long.parseLong(text);

            if (result < 0) {
                throw new IllegalArgumentException(
                        field + " tidak boleh negatif."
                );
            }

            return result;

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException(
                    field + " bukan angka yang valid: " + text
            );
        }
    }

    private boolean isMissing(String value) {

        return value == null
                || value.isBlank()
                || value.trim().equalsIgnoreCase("null");
    }

    /*
     * Memisahkan kolom CSV dengan delimiter titik koma.
     * Mendukung field bertanda kutip dan tanda kutip ganda.
     */
    static List<String> parseLine(String line) {

        List<String> fields = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        boolean quoted = false;

        for (int i = 0; i < line.length(); i++) {

            char ch = line.charAt(i);

            if (ch == '"') {

                if (quoted
                        && i + 1 < line.length()
                        && line.charAt(i + 1) == '"') {

                    current.append('"');
                    i++;

                } else {

                    quoted = !quoted;
                }

            } else if (ch == ';' && !quoted) {

                fields.add(current.toString());
                current.setLength(0);

            } else {

                current.append(ch);
            }
        }

        if (quoted) {
            throw new IllegalArgumentException(
                    "Tanda kutip CSV tidak berpasangan."
            );
        }

        fields.add(current.toString());

        return fields;
    }
}
