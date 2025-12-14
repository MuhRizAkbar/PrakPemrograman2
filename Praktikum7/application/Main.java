package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // PERBAIKAN:
            // 1. Nama file harus 'DashboardLayout.FXML' (bukan Dashboard.fxml)
            // 2. Path harus '/view/' karena package kamu namanya 'view', bukan 'Praktikum7.view'
            Parent root = FXMLLoader.load(getClass().getResource("/view/DashboardLayout.FXML"));
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Aplikasi Toko Buku");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}