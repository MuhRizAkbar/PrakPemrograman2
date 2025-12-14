package DAO;
import javafx.collections.ObservableList;
import model.Pelanggan;

public interface PelangganDAO {
    ObservableList<Pelanggan> findAll();
    void save(Pelanggan p);
    void update(Pelanggan p);
    void delete(int id);
}