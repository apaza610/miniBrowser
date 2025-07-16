package com.apaza.miapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static com.apaza.miapp.Visualizador.elpath;

public class VisualizadorCtrl implements Initializable {

    @FXML private Button btnGo;
    @FXML private TextField tfInput;
    @FXML private WebView wvNavegador;

    private WebEngine motor;

    @FXML
    void goToSite(ActionEvent event) {
        String elpath = tfInput.getText();
        File svgFile = new File(elpath);
        String url = svgFile.toURI().toString();
        motor.load(url);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        motor = wvNavegador.getEngine();
        tfInput.setText(elpath);
        btnGo.fire();
    }
}
