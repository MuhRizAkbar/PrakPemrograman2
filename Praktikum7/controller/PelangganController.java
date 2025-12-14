package controller;

import Service.PelangganService;

// Import JavaFX
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Pelanggan;

public class PelangganController {
    
    @FXML private TextField txtNama;
    @FXML private TextField txtEmail;
    @FXML private TextField txtTelepon;
    
    @FXML private TableView<Pelanggan> tblPelanggan;
    @FXML private TableColumn<Pelanggan, String> colNama;
    @FXML private TableColumn<Pelanggan, String> colEmail;
    @FXML private TableColumn<Pelanggan, String> colTelepon;

    private final PelangganService service = new PelangganService();
    private int selectedId = 0;

    @FXML
    public void initialize() {
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelepon.setCellValueFactory(new PropertyValueFactory<>("telepon"));
        
        loadData();

        // Listener untuk mengisi form saat tabel diklik
        tblPelanggan.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                selectedId = newVal.getPelangganId();
                txtNama.setText(newVal.getNama());
                txtEmail.setText(newVal.getEmail());
                txtTelepon.setText(newVal.getTelepon());
            }
        });
    }

    private void loadData() {
        tblPelanggan.setItems(service.getAll());
    }

    @FXML
    private void onAdd() {
        try {
            Pelanggan p = new Pelanggan(0, txtNama.getText(), txtEmail.getText(), txtTelepon.getText());
            service.addData(p);
            clearForm();
            loadData();
            showAlert("Sukses", "Data berhasil disimpan!");
        } catch (Exception e) {
            showAlert("Error", e.getMessage());
        }
    }

    @FXML
    private void onEdit() {
        if (selectedId == 0) {
            showAlert("Peringatan", "Pilih data di tabel dulu!");
            return;
        }
        try {
            Pelanggan p = new Pelanggan(selectedId, txtNama.getText(), txtEmail.getText(), txtTelepon.getText());
            service.updateData(p);
            clearForm();
            loadData();
            showAlert("Sukses", "Data berhasil diupdate!");
        } catch (Exception e) {
            showAlert("Error", e.getMessage());
        }
    }

    @FXML
    private void onDelete() {
        if (selectedId == 0) {
            showAlert("Peringatan", "Pilih data di tabel dulu!");
            return;
        }
        try {
            service.deleteData(selectedId);
            clearForm();
            loadData();
            showAlert("Sukses", "Data berhasil dihapus!");
        } catch (Exception e) {
            showAlert("Error", e.getMessage());
        }
    }

    private void clearForm() {
        txtNama.clear();
        txtEmail.clear();
        txtTelepon.clear();
        selectedId = 0;
        tblPelanggan.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}
