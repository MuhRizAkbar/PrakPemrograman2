package Praktikum2.soal1;

public class TokoBuah {
    public static void main(String[] args) {

        Buah apel = new Buah("Apel", 0.4, 7000.0);
        Buah mangga = new Buah("mangga", 0.2, 3500.0);
        Buah alpukat = new Buah("alpukat", 0.25, 10000.0);

        apel.hitungDanCetak(40.0);
        mangga.hitungDanCetak(15.0);
        alpukat.hitungDanCetak(12.0);
    }
}