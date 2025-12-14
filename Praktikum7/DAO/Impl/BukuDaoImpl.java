package DAO.Impl;

import DAO.BukuDAO;
import util.DatabaseHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Buku;

import java.sql.*;

public class BukuDaoImpl implements BukuDAO {
	@Override
    public ObservableList<Buku> findAll() {
        ObservableList<Buku> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM buku";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Buku(
                    rs.getInt("buku_id"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getDouble("harga"),
                    rs.getInt("stok")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Buku b) {
        String sql = "INSERT INTO buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPenulis());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getStok());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Buku b) {
        String sql = "UPDATE buku SET judul=?, penulis=?, harga=?, stok=? WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPenulis());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getStok());
            ps.setInt(5, b.getBukuId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM buku WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Buku findById(int id) {
        String sql = "SELECT * FROM buku WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Buku(
                    rs.getInt("buku_id"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getDouble("harga"),
                    rs.getInt("stok")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
