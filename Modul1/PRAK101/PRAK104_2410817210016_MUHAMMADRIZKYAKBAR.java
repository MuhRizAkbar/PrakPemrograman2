package PRAK101;

import java.util.Scanner;

public class PRAK104_2410817210016_MUHAMMADRIZKYAKBAR {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Tangan Abu:");
	        String inputAbu = scanner.nextLine().replaceAll("\\s+", ""); 

	        System.out.println("Tangan Bagas:");
	        String inputBagas = scanner.nextLine().replaceAll("\\s+", "");

	        scanner.close();

	        if (inputAbu.length() != 3 || inputBagas.length() != 3) {
	            System.out.println("Input tidak valid. Harap masukkan 3 pilihan (B, G, K) untuk setiap tangan.");
	            return;
	        }

	        int skorAbu = 0;
	        int skorBagas = 0;

	        for (int i = 0; i < 3; i++) {
	            char tanganAbu = inputAbu.charAt(i);
	            char tanganBagas = inputBagas.charAt(i);

	            if (tanganAbu == tanganBagas) {

	            }
	            else if ((tanganAbu == 'B' && tanganBagas == 'G') ||
	                     (tanganAbu == 'G' && tanganBagas == 'K') ||
	                     (tanganAbu == 'K' && tanganBagas == 'B')) {
	                skorAbu++;
	            }

	            else {
	                skorBagas++;
	            }
	        }

	        String pemenangAkhir;
	        if (skorAbu > skorBagas) {
	            pemenangAkhir = "Abu";
	        } else if (skorBagas > skorAbu) {
	            pemenangAkhir = "Bagas";
	        } else {
	            pemenangAkhir = "Seri";
	        }

	        System.out.println(pemenangAkhir);
	    }
	}