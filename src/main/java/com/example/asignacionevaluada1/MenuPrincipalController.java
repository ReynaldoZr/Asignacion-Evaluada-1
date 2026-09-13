package com.example.asignacionevaluada1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {

    @FXML
    private BorderPane panelPrincipal;

    @FXML
    private ContextMenu menuContextual;

    @FXML
    protected void abrirRegistroEstudiantes() {
        abrirVentana("RegistroEstudiantes.fxml", "Registro de Estudiantes");
    }

    @FXML
    protected void abrirRegistroPeliculas() {
        abrirVentana("RegistroPeliculas.fxml", "Registro de Películas");
    }

    private void abrirVentana(String archivo, String titulo) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(archivo));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("No se pudo abrir la ventana.");
            alerta.showAndWait();
        }
    }

    @FXML
    protected void mostrarDesarrollador() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Desarrollador");
        alerta.setHeaderText("Información del desarrollador");
        alerta.setContentText("Desarrollador: Reynaldo Eliud Molina Torrez\nAsignación Evaluada #1\nAplicación desarrollada con JavaFX.");
        alerta.showAndWait();
    }

    @FXML
    protected void mostrarMenuContextual(ContextMenuEvent event) {
        menuContextual.show(panelPrincipal, event.getScreenX(), event.getScreenY());
    }

    @FXML
    protected void cerrarAplicacion() {
        Platform.exit();
    }
}
