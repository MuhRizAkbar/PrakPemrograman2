package Service;

import DAO.Impl.BukuDaoImpl;
import javafx.collections.ObservableList;
import model.Buku;

public class BukuService {
    private final BukuDaoImpl dao = new BukuDaoImpl();

    public ObservableList<Buku> getAll() {
        return dao.findAll();
    }

    public void addData(Buku b) throws Exception {
        validate(b);
        dao.save(b);
    }

    public void updateData(Buku b) throws Exception {
        validate(b);
        dao.update(b);
    }

    public void deleteData(int id) {
        dao.delete(id);
    }

    private void validate(Buku b) throws Exception {
        if (b.getJudul() == null || b.getJudul().trim().isEmpty()) {
            throw new Exception("Judul buku tidak boleh kosong!");
        }
        if (b.getHarga() < 0) {
            throw new Exception("Harga tidak boleh negatif!");
        }
        if (b.getStok() < 0) {
            throw new Exception("Stok tidak boleh negatif!");
        }
    }
}