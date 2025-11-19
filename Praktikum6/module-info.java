module Praktikum6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    exports application;
    exports Controller;
    exports Model;

    opens application to javafx.graphics, javafx.fxml;
    opens Controller to javafx.fxml;
    opens Model to javafx.base;
}