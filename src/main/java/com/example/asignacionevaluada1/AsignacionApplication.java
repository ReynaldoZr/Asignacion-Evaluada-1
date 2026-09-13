package com.example.asignacionevaluada1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AsignacionApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                AsignacionApplication.class.getResource("MenuPrincipal.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Asignación Evaluada #1");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

