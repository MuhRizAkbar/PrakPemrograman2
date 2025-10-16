package soal3;

import java.util.ArrayList;
import java.util.Iterator;

public class SistemAkademik {
    private ArrayList<Mahasiswa> daftarMahasiswa;

    public SistemAkademik() {
        this.daftarMahasiswa = new ArrayList<>();
    }

    public void tambahMahasiswa(String nama, String nim) {
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getNim().equals(nim)) {
                System.out.println("Error: NIM " + nim + " sudah terdaftar.");
                return;
            }
        }
        Mahasiswa mahasiswaBaru = new Mahasiswa(nama, nim);
        daftarMahasiswa.add(mahasiswaBaru);
        System.out.println("Mahasiswa " + nama + " ditambahkan.");
    }

    public void hapusMahasiswa(String nim) {

        Iterator<Mahasiswa> iterator = daftarMahasiswa.iterator();
        boolean ditemukan = false;
        while (iterator.hasNext()) {
            Mahasiswa mhs = iterator.next();
            if (mhs.getNim().equals(nim)) {
                iterator.remove();
                ditemukan = true;
                System.out.println("Mahasiswa dengan NIM " + nim + " dihapus.");
                break; 
            }
        }
        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    public void cariMahasiswa(String nim) {
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getNim().equals(nim)) {
                System.out.println("Data ditemukan:");
                System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
                return;
            }
        }
        System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
    }

    public void tampilkanSemuaMahasiswa() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa yang ditambahkan.");
            return;
        }
        System.out.println("Daftar Mahasiswa:");
        for (Mahasiswa mhs : daftarMahasiswa) {
            System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
        }
    }
}