module Praktikum7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j; // Sesuaikan jika kamu pakai connector versi lama

    opens controller to javafx.fxml;

    opens view to javafx.fxml;

    opens model to javafx.base;

    exports application;
}