package model;

public class Pelanggan {
    private int pelangganId;
    private String nama;
    private String email;
    private String telepon;

    public Pelanggan(int pelangganId, String nama, String email, String telepon) {
        this.pelangganId = pelangganId;
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
    }
    
    // Getters
    public int getPelangganId() { return pelangganId; }
    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getTelepon() { return telepon; }

    // === TAMBAHAN PENTING ===
    // Method ini memberi tahu ComboBox untuk menampilkan "nama", bukan kode aneh
    @Override
    public String toString() {
        return nama;
    }
}