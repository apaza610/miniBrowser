package com.apaza.miapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Visualizador extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Visualizador.class.getResource("Visualizador.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 200);
        primaryStage.setTitle("svg viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
