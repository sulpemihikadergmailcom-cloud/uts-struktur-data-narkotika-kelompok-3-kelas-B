
package service;

import model.Putusan;
import com.kelompok.narkotika.structure.DynamicArray;
import com.kelompok.narkotika.structure.CustomStack;

public class PutusanService {

    private final DynamicArray<Putusan> data;
    private final CustomStack<String> riwayat;

    public PutusanService(DynamicArray<Putusan> data) {
        this.data = data;
        this.riwayat = new CustomStack<>();
    }

    public DynamicArray<Putusan> getAll() {
        return data;
    }

    public int jumlahData() {
        return data.size();
    }

    public boolean tambahPutusan(Putusan putusan) {
        if (putusan == null) {
            return false;
        }

        if (cariCaseId(putusan.getCaseId()).getIndex() != -1) {
            return false;
        }

        data.add(putusan);
        riwayat.push("Menambahkan putusan: " + putusan.getCaseId());

        return true;
    }

    public boolean hapusPutusan(int index) {
        if (index < 0 || index >= data.size()) {
            return false;
        }

        Putusan dihapus = data.get(index);
        data.remove(index);

        riwayat.push("Menghapus putusan: " + dihapus.getCaseId());

        return true;
    }

    public static class SearchResult {
        private final Putusan putusan;
        private final int index;
        private final int steps;

        public SearchResult(Putusan putusan, int index, int steps) {
            this.putusan = putusan;
            this.index = index;
            this.steps = steps;
        }

        public Putusan getPutusan() {
            return putusan;
        }

        public int getIndex() {
            return index;
        }

        public int getSteps() {
            return steps;
        }
    }

    public SearchResult cariCaseId(String caseId) {
        int steps = 0;

        for (int i = 0; i < data.size(); i++) {
            steps++;

            if (data.get(i).getCaseId().equalsIgnoreCase(caseId)) {
                riwayat.push("Mencari caseId: " + caseId);

                return new SearchResult(data.get(i), i, steps);
            }
        }

        riwayat.push("CaseId tidak ditemukan: " + caseId);

        return new SearchResult(null, -1, steps);
    }

    public SearchResult cariNomorPerkara(String nomorPerkara) {
        int steps = 0;

        for (int i = 0; i < data.size(); i++) {
            steps++;

            if (data.get(i).getNomorPerkara()
                    .equalsIgnoreCase(nomorPerkara)) {

                riwayat.push("Mencari nomor perkara: " + nomorPerkara);

                return new SearchResult(data.get(i), i, steps);
            }
        }

        riwayat.push("Nomor perkara tidak ditemukan: " + nomorPerkara);

        return new SearchResult(null, -1, steps);
    }

    public DynamicArray<Putusan> filterJenisNarkotika(String jenis) {
        DynamicArray<Putusan> hasil = new DynamicArray<>();

        for (int i = 0; i < data.size(); i++) {
            Putusan p = data.get(i);

            if (p.getJenisNarkotika() != null &&
                    p.getJenisNarkotika().equalsIgnoreCase(jenis)) {
                hasil.add(p);
            }
        }

        return hasil;
    }

    public DynamicArray<Putusan> filterBerat(
            double beratMinimum,
            double beratMaksimum
    ) {
        DynamicArray<Putusan> hasil = new DynamicArray<>();

        if (beratMinimum < 0 || beratMaksimum < beratMinimum) {
            return hasil;
        }

        for (int i = 0; i < data.size(); i++) {
            Putusan p = data.get(i);
            double berat = p.getBeratBarangBuktiGram();

            if (Double.isFinite(berat) &&
                    berat >= beratMinimum &&
                    berat <= beratMaksimum) {
                hasil.add(p);
            }
        }

        return hasil;
    }

    public DynamicArray<Putusan> filterPasalTerbukti(String pasal) {
        DynamicArray<Putusan> hasil = new DynamicArray<>();

        for (int i = 0; i < data.size(); i++) {
            Putusan p = data.get(i);

            if (p.getPasalTerbukti() != null &&
                    p.getPasalTerbukti().equalsIgnoreCase(pasal)) {
                hasil.add(p);
            }
        }

        return hasil;
    }

    public DynamicArray<Putusan> filterVonis(
            int vonisMinimum,
            int vonisMaksimum
    ) {
        DynamicArray<Putusan> hasil = new DynamicArray<>();

        if (vonisMinimum < 0 || vonisMaksimum < vonisMinimum) {
            return hasil;
        }

        for (int i = 0; i < data.size(); i++) {
            Putusan p = data.get(i);

            if (p.getVonisBulan() >= vonisMinimum &&
                    p.getVonisBulan() <= vonisMaksimum) {
                hasil.add(p);
            }
        }

        return hasil;
    }

    public DynamicArray<Putusan> filterGabungan(
            String jenis,
            Double beratMinimum,
            Double beratMaksimum,
            String pasal,
            Integer vonisMinimum,
            Integer vonisMaksimum
    ) {
        DynamicArray<Putusan> hasil = new DynamicArray<>();

        for (int i = 0; i < data.size(); i++) {
            Putusan p = data.get(i);

            boolean cocok = true;

            if (jenis != null &&
                    !p.getJenisNarkotika().equalsIgnoreCase(jenis)) {
                cocok = false;
            }

            if (beratMinimum != null && beratMaksimum != null) {
                double berat = p.getBeratBarangBuktiGram();

                if (!Double.isFinite(berat) ||
                        berat < beratMinimum ||
                        berat > beratMaksimum) {
                    cocok = false;
                }
            }

            if (pasal != null &&
                    !p.getPasalTerbukti().equalsIgnoreCase(pasal)) {
                cocok = false;
            }

            if (vonisMinimum != null && vonisMaksimum != null) {
                if (p.getVonisBulan() < vonisMinimum ||
                        p.getVonisBulan() > vonisMaksimum) {
                    cocok = false;
                }
            }

            if (cocok) {
                hasil.add(p);
            }
        }

        return hasil;
    }

    public double rataRataVonis() {
        if (data.isEmpty()) {
            return 0;
        }

        long total = 0;

        for (int i = 0; i < data.size(); i++) {
            total += data.get(i).getVonisBulan();
        }

        return (double) total / data.size();
    }

    public long totalDenda() {
        long total = 0;

        for (int i = 0; i < data.size(); i++) {
            total += data.get(i).getDendaRupiah();
        }

        return total;
    }

    public void urutkanVonis() {
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = 0; j < data.size() - i - 1; j++) {

                if (data.get(j).getVonisBulan() >
                        data.get(j + 1).getVonisBulan()) {

                    Putusan sementara = data.get(j);

                    data.set(j, data.get(j + 1));
                    data.set(j + 1, sementara);
                }
            }
        }

        riwayat.push("Mengurutkan data berdasarkan vonis");
    }

    public String lihatRiwayatTerakhir() {
        if (riwayat.isEmpty()) {
            return "Belum ada aktivitas";
        }

        return riwayat.peek();
    }

    public String ambilRiwayatTerakhir() {
        if (riwayat.isEmpty()) {
            return "Belum ada aktivitas";
        }

        return riwayat.pop();
    }

    public int jumlahRiwayat() {
        return riwayat.size();
    }
}
