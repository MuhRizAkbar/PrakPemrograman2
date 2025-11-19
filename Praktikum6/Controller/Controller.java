package Controller;

import Model.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    private TableView<Mahasiswa> tableView;

    @FXML
    private TableColumn<Mahasiswa, String> nimCol;

    @FXML
    private TableColumn<Mahasiswa, String> namaCol;

    public void initialize() {

        nimCol.setCellValueFactory(new PropertyValueFactory<>("nim"));

        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));

        tableView.setItems(getHardcodedData());

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private ObservableList<Mahasiswa> getHardcodedData() {
        return FXCollections.observableArrayList(
            new Mahasiswa(1, "John", "123"),
            new Mahasiswa(2, "Jane", "123"),
            new Mahasiswa(3, "Jono", "124123"),
            new Mahasiswa(4, "Agus", "1241234"),
            new Mahasiswa(5, "Budi Santoso", "125001"),
            new Mahasiswa(6, "Citra Dewi", "125002"),
            new Mahasiswa(7, "Doni Prasetyo", "125003"),
            new Mahasiswa(8, "Eka Nurmala", "125004"),
            new Mahasiswa(9, "Fajar Rian", "125005"),
            new Mahasiswa(10, "Gita Anggraini", "125006")
        );
    }
}