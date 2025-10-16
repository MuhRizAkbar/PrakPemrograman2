package soal3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemAkademik sistem = new SistemAkademik();
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                    String nimTambah = scanner.nextLine();
                    sistem.tambahMahasiswa(nama, nimTambah);
                    break;
                case 2:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nimHapus = scanner.nextLine();
                    sistem.hapusMahasiswa(nimHapus);
                    break;
                case 3:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dicari: ");
                    String nimCari = scanner.nextLine();
                    sistem.cariMahasiswa(nimCari);
                    break;
                case 4:
                    sistem.tampilkanSemuaMahasiswa();
                    break;
                case 0:
                    berjalan = false;
                    System.out.println("Terima kasih! Program berhenti.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
        scanner.close();
    }
}
