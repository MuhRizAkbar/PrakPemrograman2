package DAO;

import javafx.collections.ObservableList;
import model.Buku;

public interface BukuDAO {
    ObservableList<Buku> findAll();
    void save(Buku b);
    void update(Buku b);
    void delete(int id);
    
    Buku findById(int id);
}