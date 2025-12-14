package model;

import java.sql.Date;

public class Penjualan {
    private int penjualanId;
    private int jumlah;
    private double totalHarga;
    private Date tanggal;
    private int pelangganId;
    private int bukuId;
    private String namaPelanggan;
    private String judulBuku;

    public Penjualan(int penjualanId, int jumlah, double totalHarga, Date tanggal, int pelangganId, int bukuId) {
        this.penjualanId = penjualanId;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;
        this.pelangganId = pelangganId;
        this.bukuId = bukuId;
    }

    public Penjualan(int penjualanId, int jumlah, double totalHarga, Date tanggal, int pelangganId, int bukuId, String namaPelanggan, String judulBuku) {
        this(penjualanId, jumlah, totalHarga, tanggal, pelangganId, bukuId); // Panggil constructor 1
        this.namaPelanggan = namaPelanggan;
        this.judulBuku = judulBuku;
    }
	public int getPenjualanId() {
		return penjualanId;
	}
	public void setPenjualanId(int penjualanId) {
		this.penjualanId = penjualanId;
	}
	public int getJumlah() {
		return jumlah;
	}
	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
	public double getTotalHarga() {
		return totalHarga;
	}
	public void setTotalHarga(double totalHarga) {
		this.totalHarga = totalHarga;
	}
	public Date getTanggal() {
		return tanggal;
	}
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
	public int getPelangganId() {
		return pelangganId;
	}
	public void setPelangganId(int pelangganId) {
		this.pelangganId = pelangganId;
	}
	public int getBukuId() {
		return bukuId;
	}
	public void setBukuId(int bukuId) {
		this.bukuId = bukuId;
	}
	public String getNamaPelanggan() {
		return namaPelanggan;
	}
	public void setNamaPelanggan(String namaPelanggan) {
		this.namaPelanggan = namaPelanggan;
	}
	public String getJudulBuku() {
		return judulBuku;
	}
	public void setJudulBuku(String judulBuku) {
		this.judulBuku = judulBuku;
	}


}
