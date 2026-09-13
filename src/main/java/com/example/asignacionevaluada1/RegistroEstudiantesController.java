package com.example.asignacionevaluada1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RegistroEstudiantesController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCarnet;

    @FXML
    private TextField txtCarrera;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextArea txtRegistros;

    @FXML
    protected void guardarEstudiante() {
        String nombre = txtNombre.getText().trim();
        String carnet = txtCarnet.getText().trim();
        String carrera = txtCarrera.getText().trim();
        String correo = txtCorreo.getText().trim();
        String telefono = txtTelefono.getText().trim();

        if (nombre.isEmpty() || carnet.isEmpty() || carrera.isEmpty()
                || correo.isEmpty() || telefono.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos vacíos");
            alerta.setHeaderText(null);
            alerta.setContentText("Debe completar todos los campos.");
            alerta.showAndWait();
            return;
        }

        txtRegistros.appendText(
                "Nombre: " + nombre + "\n" +
                "Carnet: " + carnet + "\n" +
                "Carrera: " + carrera + "\n" +
                "Correo: " + correo + "\n" +
                "Teléfono: " + telefono + "\n" +
                "------------------------------\n"
        );

        limpiarCampos();
    }

    @FXML
    protected void limpiarCampos() {
        txtNombre.clear();
        txtCarnet.clear();
        txtCarrera.clear();
        txtCorreo.clear();
        txtTelefono.clear();
    }
}

