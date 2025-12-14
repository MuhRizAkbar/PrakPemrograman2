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

        Buku buku = bukuDao.findById(p.getBukuId());
        
        if (buku == null) {
            throw new Exception("Buku tidak ditemukan!");
        }

        if (buku.getStok() < p.getJumlah()) {
            throw new Exception("Stok buku tidak mencukupi! Sisa: " + buku.getStok());
        }
        
        buku.setStok(buku.getStok() - p.getJumlah());
        bukuDao.update(buku); 

        dao.save(p);
    }

    public void deleteData(int id) {
        dao.delete(id);
    }

}
