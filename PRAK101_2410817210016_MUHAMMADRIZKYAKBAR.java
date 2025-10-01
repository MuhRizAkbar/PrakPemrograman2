package PRAK101;
import java.util.Scanner;

public class PRAK101_2410817210016_MUHAMMADRIZKYAKBAR {
	public static void main(String[] args) {
		
		   Scanner scanner = new Scanner(System.in);
	        System.out.print("Masukkan Nama Lengkap: ");
	        String namaLengkap = scanner.nextLine();

	        System.out.print("Masukkan Tempat Lahir: ");
	        String tempatLahir = scanner.nextLine();

	        System.out.print("Masukkan Tanggal Lahir: ");
	        int tanggalLahir = scanner.nextInt();
	        scanner.nextLine(); 

	        System.out.print("Masukkan Bulan Lahir: ");
	        int bulanLahir = scanner.nextInt();
	        scanner.nextLine(); 

	        System.out.print("Masukkan Tahun Lahir: ");
	        int tahunLahir = scanner.nextInt();
	        scanner.nextLine(); 

	        System.out.print("Masukkan Tinggi Badan: ");
	        int tinggiBadan = scanner.nextInt();
	        scanner.nextLine(); 

	        System.out.print("Masukkan Berat Badan: ");
	        double beratBadan = scanner.nextDouble();
	        scanner.nextLine(); 

	        scanner.close();
	        
	        String namaBulan;
	           switch (bulanLahir) {
	               case 1: namaBulan = "Januari"; break;
	               case 2: namaBulan = "Februari"; break;
	               case 3: namaBulan = "Maret"; break;
	               case 4: namaBulan = "April"; break;
	               case 5: namaBulan = "Mei"; break;
	               case 6: namaBulan = "Juni"; break;
	               case 7: namaBulan = "Juli"; break;
	               case 8: namaBulan = "Agustus"; break;
	               case 9: namaBulan = "September"; break;
	               case 10: namaBulan = "Oktober"; break;
	               case 11: namaBulan = "November"; break;
	               case 12: namaBulan = "Desember"; break;
	               default: namaBulan = "Bulan tidak valid"; break;
	           }
	        
	           System.out.println("\n===== Output Data Diri =====");
	           System.out.println(
	               "Nama Lengkap " + namaLengkap + 
	               ", Lahir di " + tempatLahir + 
	               " pada Tanggal " + tanggalLahir + " " + namaBulan + " " + tahunLahir
	           );
	           System.out.println(
	               "Tinggi Badan " + tinggiBadan + " cm" + 
	               " dan Berat Badan " + beratBadan + " kilogram"
	           );
	           System.out.println("============================");
	}
     
}