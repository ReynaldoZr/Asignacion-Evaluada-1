package com.example.asignacionevaluada1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RegistroPeliculasController {

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtDirector;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtAnio;

    @FXML
    private TextField txtDuracion;

    @FXML
    private TableView<Pelicula> tblPeliculas;

    @FXML
    private TableColumn<Pelicula, String> colTitulo;

    @FXML
    private TableColumn<Pelicula, String> colDirector;

    @FXML
    private TableColumn<Pelicula, String> colGenero;

    @FXML
    private TableColumn<Pelicula, String> colAnio;

    @FXML
    private TableColumn<Pelicula, String> colDuracion;

    @FXML
    public void initialize() {
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colDirector.setCellValueFactory(new PropertyValueFactory<>("director"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));

        tblPeliculas.getItems().add(new Pelicula(
                "Titanic", "James Cameron", "Drama", "1997", "195 minutos"
        ));
        tblPeliculas.getItems().add(new Pelicula(
                "Coco", "Lee Unkrich", "Animación", "2017", "105 minutos"
        ));
        tblPeliculas.getItems().add(new Pelicula(
                "Interestelar", "Christopher Nolan", "Ciencia ficción", "2014", "169 minutos"
        ));
    }

    @FXML
    protected void seleccionarPelicula() {
        Pelicula peliculaSeleccionada = tblPeliculas.getSelectionModel().getSelectedItem();

        if (peliculaSeleccionada != null) {
            txtTitulo.setText(peliculaSeleccionada.getTitulo());
            txtDirector.setText(peliculaSeleccionada.getDirector());
            txtGenero.setText(peliculaSeleccionada.getGenero());
            txtAnio.setText(peliculaSeleccionada.getAnio());
            txtDuracion.setText(peliculaSeleccionada.getDuracion());
        }
    }

    @FXML
    protected void guardarPelicula() {
        String titulo = txtTitulo.getText().trim();
        String director = txtDirector.getText().trim();
        String genero = txtGenero.getText().trim();
        String anio = txtAnio.getText().trim();
        String duracion = txtDuracion.getText().trim();

        if (titulo.isEmpty() || director.isEmpty() || genero.isEmpty()
                || anio.isEmpty() || duracion.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos vacíos");
            alerta.setHeaderText(null);
            alerta.setContentText("Debe completar todos los datos de la película.");
            alerta.showAndWait();
            return;
        }

        Pelicula nuevaPelicula = new Pelicula(titulo, director, genero, anio, duracion);
        tblPeliculas.getItems().add(nuevaPelicula);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Registro de película");
        alerta.setHeaderText(null);
        alerta.setContentText("La película fue agregada correctamente.");
        alerta.showAndWait();

        limpiarCampos();
    }

    @FXML
    protected void limpiarCampos() {
        txtTitulo.clear();
        txtDirector.clear();
        txtGenero.clear();
        txtAnio.clear();
        txtDuracion.clear();
        tblPeliculas.getSelectionModel().clearSelection();
    }

    @FXML
    protected void mostrarInformacion() {
        Pelicula peliculaSeleccionada = tblPeliculas.getSelectionModel().getSelectedItem();
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información de películas");
        alerta.setHeaderText(null);

        if (peliculaSeleccionada == null) {
            alerta.setContentText("Seleccione una película de la tabla para ver su información.");
        } else {
            alerta.setContentText(
                    "Título: " + peliculaSeleccionada.getTitulo() + "\n" +
                    "Director: " + peliculaSeleccionada.getDirector() + "\n" +
                    "Género: " + peliculaSeleccionada.getGenero() + "\n" +
                    "Año: " + peliculaSeleccionada.getAnio() + "\n" +
                    "Duración: " + peliculaSeleccionada.getDuracion()
            );
        }

        alerta.showAndWait();
    }
}

