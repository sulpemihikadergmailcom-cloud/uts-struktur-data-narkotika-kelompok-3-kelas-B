package com.kelompok.narkotika.service;

import com.kelompok.narkotika.model.Putusan;
import com.kelompok.narkotika.structure.DynamicArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class PutusanServiceTest {

    private PutusanService service;

    @BeforeEach
    void setUp() {
        DynamicArray<Putusan> data = new DynamicArray<>();

        data.add(new Putusan(
                "KDR-001", "12/Pid.Sus/2026/PN Malang",
                "PN Malang", LocalDate.of(2026, 1, 10),
                "T001", "Sabu", 5.0,
                "Pasal 112", "Pasal 112",
                60, 48, 100000000L,
                "5 gram sabu", "Memberatkan",
                "Meringankan", "Halaman 1-10"
        ));

        data.add(new Putusan(
                "KDR-002", "13/Pid.Sus/2026/PN Malang",
                "PN Malang", LocalDate.of(2026, 2, 10),
                "T002", "Ganja", 10.0,
                "Pasal 111", "Pasal 111",
                48, 36, 50000000L,
                "10 gram ganja", "Memberatkan",
                "Meringankan", "Halaman 1-8"
        ));

        service = new PutusanService(data);
    }

    @Test
    void testJumlahData() {
        assertEquals(2, service.jumlahData());
    }

    @Test
    void testCariCaseIdDitemukan() {
        PutusanService.SearchResult hasil =
                service.cariCaseId("KDR-001");

        assertNotNull(hasil.getPutusan());
        assertEquals("KDR-001", hasil.getPutusan().getCaseId());
        assertEquals(0, hasil.getIndex());
        assertEquals(1, hasil.getSteps());
    }

    @Test
    void testCariCaseIdTidakDitemukan() {
        PutusanService.SearchResult hasil =
                service.cariCaseId("KDR-999");

        assertNull(hasil.getPutusan());
        assertEquals(-1, hasil.getIndex());
        assertEquals(2, hasil.getSteps());
    }

    @Test
    void testCariNomorPerkara() {
        PutusanService.SearchResult hasil =
                service.cariNomorPerkara(
                        "13/Pid.Sus/2026/PN Malang"
                );

        assertNotNull(hasil.getPutusan());
        assertEquals("KDR-002", hasil.getPutusan().getCaseId());
    }

    @Test
    void testTambahPutusan() {
        Putusan baru = new Putusan(
                "KDR-003", "14/Pid.Sus/2026/PN Malang",
                "PN Malang", LocalDate.of(2026, 3, 10),
                "T003", "Ekstasi", 2.0,
                "Pasal 112", "Pasal 112",
                36, 24, 25000000L,
                "2 butir ekstasi", "-", "-",
                "Halaman 1-5"
        );

        assertTrue(service.tambahPutusan(baru));
        assertEquals(3, service.jumlahData());
    }

    @Test
    void testTambahCaseIdDuplikat() {
        Putusan duplikat = new Putusan(
                "KDR-001", "99/Pid.Sus/2026/PN Malang",
                "PN Malang", LocalDate.of(2026, 3, 10),
                "T009", "Sabu", 1.0,
                "Pasal 112", "Pasal 112",
                36, 24, 10000000L,
                "Barang bukti", "-", "-", "Halaman 1"
        );

        assertFalse(service.tambahPutusan(duplikat));
        assertEquals(2, service.jumlahData());
    }

    @Test
    void testHapusDataPertama() {
        assertTrue(service.hapusPutusan(0));
        assertEquals(1, service.jumlahData());
        assertEquals("KDR-002",
                service.getAll().get(0).getCaseId());
    }

    @Test
    void testHapusIndexTidakValid() {
        assertFalse(service.hapusPutusan(10));
        assertEquals(2, service.jumlahData());
    }

    @Test
    void testFilterJenisNarkotika() {
        DynamicArray<Putusan> hasil =
                service.filterJenisNarkotika("Sabu");

        assertEquals(1, hasil.size());
        assertEquals("KDR-001", hasil.get(0).getCaseId());
    }

    @Test
    void testFilterBerat() {
        DynamicArray<Putusan> hasil =
                service.filterBerat(5.0, 10.0);

        assertEquals(2, hasil.size());
    }

    @Test
    void testFilterVonis() {
        DynamicArray<Putusan> hasil =
                service.filterVonis(30, 40);

        assertEquals(1, hasil.size());
        assertEquals("KDR-002", hasil.get(0).getCaseId());
    }

    @Test
    void testRataRataVonis() {
        assertEquals(42.0, service.rataRataVonis());
    }

    @Test
    void testTotalDenda() {
        assertEquals(150000000L, service.totalDenda());
    }
}
