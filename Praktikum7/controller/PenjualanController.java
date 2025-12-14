package controller;

// Import 3 Service
import Service.BukuService;
import Service.PelangganService;
import Service.PenjualanService;

// Import JavaFX dan util
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Buku;
import model.Pelanggan;
import model.Penjualan;

import java.sql.Date;
import java.time.LocalDate;

public class PenjualanController {

    @FXML private ComboBox<Pelanggan> cbPelanggan;
    @FXML private ComboBox<Buku> cbBuku;
    @FXML private TextField txtJumlah;
    @FXML private TextField txtTotal;
    @FXML private DatePicker dpTanggal;

    @FXML private TableView<Penjualan> tblPenjualan;
    @FXML private TableColumn<Penjualan, String> colPelanggan;
    @FXML private TableColumn<Penjualan, String> colBuku;
    @FXML private TableColumn<Penjualan, Integer> colJumlah;
    @FXML private TableColumn<Penjualan, Double> colTotal;
    @FXML private TableColumn<Penjualan, String> colTanggal;
    
    // Memanggil 3 service sekaligus
    private final PenjualanService service = new PenjualanService();
    private final PelangganService pelangganService = new PelangganService();
    private final BukuService bukuService = new BukuService();

    @FXML
    public void initialize() {
        colPelanggan.setCellValueFactory(new PropertyValueFactory<>("namaPelanggan"));
        colBuku.setCellValueFactory(new PropertyValueFactory<>("judulBuku"));
        colJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        
        loadData();
        refreshCombo();
        
        // Logika otomatis menghitung total harga saat jumlah diketik
        txtJumlah.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.isEmpty() && cbBuku.getValue() != null) {
                try {
                    int qty = Integer.parseInt(newVal);
                    double total = qty * cbBuku.getValue().getHarga();
                    txtTotal.setText(String.valueOf(total));
                } catch (NumberFormatException e) {
                    // Abaikan jika bukan angka
                }
            }
        });
    }

    private void loadData() {
        tblPenjualan.setItems(service.getAll());
    }

    private void refreshCombo() {
        cbPelanggan.setItems(pelangganService.getAll());
        cbBuku.setItems(bukuService.getAll());
    }

    @FXML
    private void onAdd() {
        try {
            if (cbPelanggan.getValue() == null || cbBuku.getValue() == null) {
                throw new Exception("Harap pilih Pelanggan dan Buku!");
            }
            
            LocalDate localDate = dpTanggal.getValue();
            if (localDate == null) {
                throw new Exception("Harap pilih tanggal!");
            }

            int jumlah = Integer.parseInt(txtJumlah.getText());
            double total = Double.parseDouble(txtTotal.getText());

            Penjualan p = new Penjualan(
                0, 
                jumlah, 
                total,
                Date.valueOf(localDate), 
                cbPelanggan.getValue().getPelangganId(), 
                cbBuku.getValue().getBukuId()
            );

            // Service akan mengecek stok dan menguranginya
            service.addData(p); 
            
            loadData();
            refreshCombo(); // Refresh agar stok buku di combo terupdate (opsional)
            clearForm();
            showAlert("Sukses", "Transaksi berhasil disimpan!");
            
        } catch (NumberFormatException e) {
            showAlert("Error", "Jumlah harus angka!");
        } catch (Exception e) {
            showAlert("Error", e.getMessage());
        }
    }

    @FXML
    private void onDelete() {
        Penjualan selected = tblPenjualan.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Peringatan", "Pilih data transaksi yang mau dihapus!");
            return;
        }
        try {
            service.deleteData(selected.getPenjualanId());
            loadData();
            showAlert("Sukses", "Data penjualan dihapus!");
        } catch (Exception e) {
            showAlert("Gagal", e.getMessage());
        }
    }

    private void clearForm() {
        cbPelanggan.setValue(null);
        cbBuku.setValue(null);
        txtJumlah.clear();
        txtTotal.clear();
        dpTanggal.setValue(null);
    }
    
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}