module com.example.asignacionevaluada1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.asignacionevaluada1 to javafx.fxml, javafx.base;
    exports com.example.asignacionevaluada1;
}

