package DAO.Impl;

import DAO.PelangganDAO;
import util.DatabaseHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Pelanggan;

import java.sql.*;

public class PelangganDaoImpl implements PelangganDAO{
    @Override
    public ObservableList<Pelanggan> findAll() {
        ObservableList<Pelanggan> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM pelanggan";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Pelanggan(
                    rs.getInt("pelanggan_id"),
                    rs.getString("nama"),
                    rs.getString("email"),
                    rs.getString("telepon")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Pelanggan p) {
        String sql = "INSERT INTO pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNama());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelepon());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pelanggan p) {
        String sql = "UPDATE pelanggan SET nama=?, email=?, telepon=? WHERE pelanggan_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNama());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelepon());
            ps.setInt(4, p.getPelangganId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM pelanggan WHERE pelanggan_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}