package Soal2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("=============================================");
            System.out.println("Pilih jenis hewan yang ingin diinputkan:");
            System.out.println("1 = Kucing");
            System.out.println("2 = Anjing");
            System.out.println("0 = Keluar");
            System.out.print("Masukkan pilihan: ");

            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Pilihan tidak valid. Harap masukkan angka.");
                scanner.nextLine(); 
                pilihan = -1; 
                continue;
            }

            if (pilihan == 1) {
                System.out.print("Nama hewan peliharaan: ");
                String namaKucing = scanner.nextLine();
                
                System.out.print("Ras: ");
                String rasKucing = scanner.nextLine();
                
                System.out.print("Warna Bulu: ");
                String warnaBuluKucing = scanner.nextLine();

                Kucing kucingBaru = new Kucing(rasKucing, namaKucing, warnaBuluKucing);
                kucingBaru.displayDetailKucing();

            } else if (pilihan == 2) {
                System.out.print("Nama hewan peliharaan: ");
                String namaAnjing = scanner.nextLine();
                
                System.out.print("Ras: ");
                String rasAnjing = scanner.nextLine();
                
                System.out.print("Warna Bulu: ");
                String warnaBuluAnjing = scanner.nextLine();
                
                System.out.print("Kemampuan: ");
                String kemampuanStr = scanner.nextLine();

                String[] kemampuanAnjing = kemampuanStr.split(",\\s*"); 

                Anjing anjingBaru = new Anjing(namaAnjing, rasAnjing, warnaBuluAnjing, kemampuanAnjing);
                anjingBaru.displayDetailAnjing();

            } else if (pilihan != 0) {
                System.out.println("Pilihan tidak tersedia. Silakan coba lagi.");
            }

        } while (pilihan != 0);

        System.out.println("\nProgram selesai. Terima kasih!");
        scanner.close();
    }
}
