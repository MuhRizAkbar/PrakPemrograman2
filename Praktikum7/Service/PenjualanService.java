package Service;

import DAO.Impl.BukuDaoImpl;
import DAO.Impl.PenjualanDaoImpl;
import javafx.collections.ObservableList;
import model.Buku;
import model.Penjualan;

public class PenjualanService {
    private final PenjualanDaoImpl dao = new PenjualanDaoImpl();
    private final BukuDaoImpl bukuDao = new BukuDaoImpl();

    public ObservableList<Penjualan> getAll() {
        return dao.findAll();
    }

    public void addData(Penjualan p) throws Exception {
        // 1. Ambil data buku berdasarkan ID
        Buku buku = bukuDao.findById(p.getBukuId());
        
        // 2. Cek apakah buku ada
        if (buku == null) {
            throw new Exception("Buku tidak ditemukan!");
        }

        // 3. Cek stok cukup atau tidak
        if (buku.getStok() < p.getJumlah()) {
            throw new Exception("Stok buku tidak mencukupi! Sisa: " + buku.getStok());
        }

        // 4. Kurangi stok buku
        buku.setStok(buku.getStok() - p.getJumlah());
        bukuDao.update(buku); // Update stok di database

        // 5. Simpan transaksi penjualan
        dao.save(p);
    }

    public void deleteData(int id) {
        dao.delete(id);
    }
}