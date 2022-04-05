module com.example.lab6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.desktop;
    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    requires transitive javafx.base;
    requires transitive javafx.graphics;
    requires javafx.swing;

    opens com.example.lab6 to javafx.fxml;
    exports com.example.lab6;
}