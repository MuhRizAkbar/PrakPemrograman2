package Praktikum2.soal3;

public class Soal3Main {
    public static void main(String[] args) {
        Pegawai p1 = new Pegawai();

        //Pada baris ini terjadi error karena kurangnya titik koma (;) di akhir pernyataan.
        //p1.nama = "Roi" <- syntaks salah
        p1.nama = "Roi"; //<- Syntaks yang dibenarkan
        p1.asal = "Kingdom of Orvel";
        p1.setJabatan("Assasin");
        //Pada bagian ini terdapat kesalahan logika karena atribut 'umur' belum diisi nilainya, sehingga output tidak akan sesuai (akan menghasilkan 0).
        //(Tidak ada baris yang salah, tetapi ada baris yang perlu ditambahkan)
        p1.umur = 17; //<- Baris yang ditambahkan untuk perbaikan
        
        //Pada baris ini terjadi kesalahan karena label output "Nama Pegawai: " tidak sesuai dengan yang diminta ("Nama: ").
        //System.out.println("Nama Pegawai: " + p1.getNama()); <- syntaks salah
        System.out.println("Nama: " + p1.getNama()); //<- Syntaks yang dibenarkan
        
        System.out.println("Asal: " + p1.getAsal());
        System.out.println("Jabatan: " + p1.jabatan);
        
        //Pada baris ini terjadi kesalahan karena output untuk umur tidak menyertakan kata " tahun" sesuai permintaan.
        //System.out.println("Umur: " + p1.umur); <- syntaks salah
        System.out.println("Umur: " + p1.umur + " tahun"); //<- Syntaks yang dibenarkan
    }
}