package soal2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataPemerintahan dataPemerintahan = new DataPemerintahan();

        int jumlahNegara = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < jumlahNegara; i++) {
            String nama = scanner.nextLine();
            String jenisKepemimpinan = scanner.nextLine();
            String namaPemimpin = scanner.nextLine();

            if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
                Negara negaraBaru = new Negara(nama, jenisKepemimpinan, namaPemimpin);
                dataPemerintahan.tambahNegara(negaraBaru);
            } else {
                int tanggal = scanner.nextInt();
                int bulan = scanner.nextInt();
                int tahun = scanner.nextInt();
                scanner.nextLine(); 
                
                Negara negaraBaru = new Negara(nama, jenisKepemimpinan, namaPemimpin, tanggal, bulan, tahun);
                dataPemerintahan.tambahNegara(negaraBaru);
            }
        }

        dataPemerintahan.tampilkanDetailNegara();

        scanner.close();
    }
}