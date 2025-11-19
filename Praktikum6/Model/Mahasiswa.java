package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mahasiswa {

    private int id;
    private final StringProperty nama;
    private final StringProperty nim;

    public Mahasiswa(int id, String nama, String nim) {
        this.id = id;
        this.nama = new SimpleStringProperty(nama);
        this.nim = new SimpleStringProperty(nim);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getNim() {
        return nim.get();
    }

    public void setNim(String nim) {
        this.nim.set(nim);
    }

    public StringProperty namaProperty() {
        return nama;
    }

    public StringProperty nimProperty() {
        return nim;
    }
}