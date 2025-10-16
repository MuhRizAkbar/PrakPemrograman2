package soal2;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataPemerintahan {

    private List<Negara> daftarNegara;
    private Map<Integer, String> namaBulan;

    public DataPemerintahan() {
        this.daftarNegara = new LinkedList<>();
        this.namaBulan = new HashMap<>();
        inisialisasiBulan();
    }

    private void inisialisasiBulan() {
        namaBulan.put(1, "Januari");
        namaBulan.put(2, "Februari");
        namaBulan.put(3, "Maret");
        namaBulan.put(4, "April");
        namaBulan.put(5, "Mei");
        namaBulan.put(6, "Juni");
        namaBulan.put(7, "Juli");
        namaBulan.put(8, "Agustus");
        namaBulan.put(9, "September");
        namaBulan.put(10, "Oktober");
        namaBulan.put(11, "November");
        namaBulan.put(12, "Desember");
    }

    public void tambahNegara(Negara negara) {
        daftarNegara.add(negara);
    }

    public void tampilkanDetailNegara() {
        for (Negara negara : daftarNegara) {
            String jenisPemimpinKapital = negara.getJenisKepemimpinan().substring(0, 1).toUpperCase() + negara.getJenisKepemimpinan().substring(1);
            
            System.out.println("Negara " + negara.getNama() + " mempunyai " + jenisPemimpinKapital + " bernama " + negara.getNamaPemimpin());

            if (negara.getTahunKemerdekaan() != 0) {
                String bulan = namaBulan.get(negara.getBulanKemerdekaan());
                System.out.println("Deklarasi Kemerdekaan pada Tanggal " + negara.getTanggalKemerdekaan() + " " + bulan + " " + negara.getTahunKemerdekaan());
            }
             System.out.println();
        }
    }
}