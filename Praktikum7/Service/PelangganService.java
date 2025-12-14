package Service;

import DAO.Impl.PelangganDaoImpl;
import javafx.collections.ObservableList;
import model.Pelanggan;

import java.util.regex.Pattern;

public class PelangganService {
    private final PelangganDaoImpl dao = new PelangganDaoImpl();
    
    // Regex simple untuk cek format email dan angka
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9]+$");

    public ObservableList<Pelanggan> getAll() {
        return dao.findAll();
    }

    public void addData(Pelanggan p) throws Exception {
        validate(p);
        dao.save(p);
    }

    public void updateData(Pelanggan p) throws Exception {
        validate(p);
        dao.update(p);
    }

    public void deleteData(int id) {
        dao.delete(id);
    }

    private void validate(Pelanggan p) throws Exception {
        if (p.getNama() == null || p.getNama().trim().isEmpty()) {
            throw new Exception("Nama tidak boleh kosong!");
        }
        if (p.getEmail() == null || !EMAIL_PATTERN.matcher(p.getEmail()).matches()) {
            throw new Exception("Format Email tidak valid! (Contoh: user@email.com)");
        }
        if (p.getTelepon() == null || !PHONE_PATTERN.matcher(p.getTelepon()).matches()) {
            throw new Exception("Telepon harus berupa angka!");
        }
    }
}