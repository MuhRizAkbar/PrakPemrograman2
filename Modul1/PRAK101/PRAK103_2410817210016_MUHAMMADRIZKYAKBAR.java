package PRAK101;
import java.util.Scanner;
public class PRAK103_2410817210016_MUHAMMADRIZKYAKBAR {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("N dan Bilangan Awal : ");

        if (!scanner.hasNextInt()) {
            System.out.println("Input N tidak valid. Harap masukkan bilangan bulat.");
            scanner.close();
            return;
        }
        int N = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("Input Bilangan Awal tidak valid. Harap masukkan bilangan bulat.");
            scanner.close();
            return;
        }
        int bilanganSaatIni = scanner.nextInt();
        
        scanner.close();

        int jumlahDitampilkan = 0;
        StringBuilder outputDeret = new StringBuilder();
        
        System.out.println("Input: " + N + " " + bilanganSaatIni);
        System.out.print("Output: ");

        do {
            if (bilanganSaatIni % 2 != 0) {
                outputDeret.append(bilanganSaatIni);
                
                jumlahDitampilkan++;
                if (jumlahDitampilkan < N) {
                    outputDeret.append(", ");
                }
            }
            bilanganSaatIni++;

        } while (jumlahDitampilkan < N);

        System.out.println(outputDeret.toString());
    }
}
