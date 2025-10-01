package PRAK101;
import java.util.Scanner;

public class PRAK102_2410817210016_MUHAMMADRIZKYAKBAR {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan angka awal deret: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
            scanner.close();
            return;
        }
        int angkaAwal = scanner.nextInt();
        
        scanner.close(); 

        int bilanganSaatIni = angkaAwal; 
        int jumlahBaris = 0;             

        StringBuilder outputDeret = new StringBuilder(); 

        while (jumlahBaris < 10) {
            int nilaiTampil;

            if (bilanganSaatIni % 5 == 0) {
                nilaiTampil = (bilanganSaatIni / 5) - 1;
            } else {
                nilaiTampil = bilanganSaatIni;
            }

            outputDeret.append(nilaiTampil);

            if (jumlahBaris < 9) {
                outputDeret.append(", ");
            }

            bilanganSaatIni++;

            jumlahBaris++;
        }

        System.out.println("Input: " + angkaAwal);
        System.out.println("Output: " + outputDeret.toString());
    }
}
