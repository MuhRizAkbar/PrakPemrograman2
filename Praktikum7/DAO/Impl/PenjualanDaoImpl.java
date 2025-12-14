package DAO.Impl;

import DAO.PenjualanDAO;
import model.Penjualan;
import util.DatabaseHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import DAO.PenjualanDAO;
import util.DatabaseHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Penjualan;

import java.sql.*;

public class PenjualanDaoImpl implements PenjualanDAO {
    @Override
    public ObservableList<Penjualan> findAll() {
        ObservableList<Penjualan> list = FXCollections.observableArrayList();
        
        String sql = "SELECT p.*, pel.nama AS nama_pelanggan, b.judul AS judul_buku " +
                     "FROM penjualan p " +
                     "JOIN pelanggan pel ON p.pelanggan_id = pel.pelanggan_id " +
                     "JOIN buku b ON p.buku_id = b.buku_id";
                     
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Menggunakan Constructor ke-2 (yang ada nama dan judul)
                list.add(new Penjualan(
                    rs.getInt("penjualan_id"),
                    rs.getInt("jumlah"),
                    rs.getDouble("total_harga"),
                    rs.getDate("tanggal"),
                    rs.getInt("pelanggan_id"),
                    rs.getInt("buku_id"),
                    rs.getString("nama_pelanggan"), // Ambil nama hasil join
                    rs.getString("judul_buku")      // Ambil judul hasil join
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Penjualan p) {
        String sql = "INSERT INTO penjualan (pelanggan_id, buku_id, jumlah, total_harga, tanggal) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getPelangganId());
            ps.setInt(2, p.getBukuId());
            ps.setInt(3, p.getJumlah());
            ps.setDouble(4, p.getTotalHarga());
            ps.setDate(5, p.getTanggal());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM penjualan WHERE penjualan_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
