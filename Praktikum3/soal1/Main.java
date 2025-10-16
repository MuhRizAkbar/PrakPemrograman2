package soal1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jumlahDadu = scanner.nextInt();
        PermainanDadu permainan = new PermainanDadu();
        permainan.lemparSemuaDadu(jumlahDadu);
        permainan.tampilkanHasil();

        scanner.close();
    }
}
