package PRAK101;
import java.util.Scanner;

public class PRAK105_2410817210016_MUHAMMADRIZKYAKBAR {

    public static final double PHI = 3.14159; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jari-jari: ");
        
        if (!scanner.hasNextDouble()) {
            System.out.println("Input tidak valid. Jari-jari harus berupa angka.");
            scanner.close();
            return;
        }
        double jariJari = scanner.nextDouble();

        System.out.print("Masukkan tinggi: ");
        
        if (!scanner.hasNextDouble()) {
            System.out.println("Input tidak valid. Tinggi harus berupa angka.");
            scanner.close();
            return;
        }
        double tinggi = scanner.nextDouble();
        
        scanner.close();

        double volume = PHI * jariJari * jariJari * tinggi;

        System.out.printf("\nVolume tabung dengan jari-jari %.1f cm dan\n", jariJari);
        System.out.printf("tinggi %.1f cm adalah %.3f m3\n", tinggi, volume);
        
    }
}