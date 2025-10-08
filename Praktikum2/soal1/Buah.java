package Praktikum2.soal1;
public class Buah {

    String namaBuah;
    double berat;
    double harga;

    public Buah(String nama, double berat, double harga) {
        this.namaBuah = nama;
        this.berat = berat;
        this.harga = harga;
    }

    public void hitungDanCetak(double jumlahBeli) {
        double hargaPerKg = this.harga / this.berat;
        double hargaSebelumDiskon = hargaPerKg * jumlahBeli;
        int kelipatanDiskon = (int) Math.floor(jumlahBeli / 4);
        double diskonPerKelipatan = this.harga * 0.08; 
        double totalDiskon = kelipatanDiskon * diskonPerKelipatan;
        double hargaSetelahDiskon = hargaSebelumDiskon - totalDiskon;

        System.out.println("Nama Buah: " + this.namaBuah);
        System.out.println("Berat: " + this.berat);
        System.out.println("Harga: " + this.harga);
        System.out.println("Jumlah Beli: " + jumlahBeli + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f%n", hargaSebelumDiskon);
        System.out.printf("Total Diskon: Rp%.2f%n", totalDiskon);
        System.out.printf("Harga Setelah Diskon: Rp%.2f%n", hargaSetelahDiskon);

        System.out.println();
    }
}