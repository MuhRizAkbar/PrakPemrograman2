package soal1;
import java.util.LinkedList;
import java.util.List;

public class PermainanDadu {

    private List<Dadu> semuaDadu;

    public PermainanDadu() {
        this.semuaDadu = new LinkedList<>();
    }

    public void lemparSemuaDadu(int jumlahDadu) {
        for (int i = 0; i < jumlahDadu; i++) {
            semuaDadu.add(new Dadu());
        }
    }

    public void tampilkanHasil() {
        int totalNilai = 0;
        for (int i = 0; i < semuaDadu.size(); i++) {
            int nilaiDadu = semuaDadu.get(i).getNilai();
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + nilaiDadu);
            totalNilai += nilaiDadu;
        }
        System.out.println("Total nilai dadu keseluruhan " + totalNilai);
    }
}