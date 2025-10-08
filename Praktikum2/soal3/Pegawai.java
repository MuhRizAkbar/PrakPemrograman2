package Praktikum2.soal3;

//Pada baris ini terjadi error karena nama class 'Employee' tidak sesuai dengan nama file 'Pegawai.java'.
//public class Employee { <- syntaks salah
public class Pegawai { //<- Syntaks yang dibenarkan
    public String nama;

    //Pada baris ini terjadi error karena tipe data 'char' hanya bisa menampung satu karakter, bukan sebuah kalimat (String).
    //Kesalahan ini juga menyebabkan error pada method getAsal() yang mencoba mengembalikan 'char' sebagai 'String'.
    //public char asal; <- syntaks salah
    public String asal; //<- Syntaks yang dibenarkan
    public String jabatan;
    public int umur;

    public String getNama() {
        return nama;
    }
    
    public String getAsal() {
        return asal;
    }
    
    //Pada baris ini terjadi error karena method 'setJabatan' tidak memiliki parameter untuk menerima input, 
    //dan menggunakan variabel 'j' yang tidak terdefinisi.
    //public void setJabatan() { this.jabatan = j; } <- syntaks salah
    public void setJabatan(String j) { this.jabatan = j; } //<- Syntaks yang dibenarkan
}