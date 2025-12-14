package DAO;

import javafx.collections.ObservableList;
import model.Penjualan;

public interface PenjualanDAO {
    ObservableList<Penjualan> findAll();
    void save(Penjualan p);
    void delete(int id);
}