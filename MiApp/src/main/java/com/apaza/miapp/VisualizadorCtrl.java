package com.apaza.miapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class VisualizadorCtrl implements Initializable {

    @FXML private TextField tfInput;
    @FXML private WebView wvNavegador;

    private WebEngine motor;
    String elpath;

    @FXML
    void goToSite() {
        elpath = tfInput.getText();
        motor.load(elpath);
    }


    @FXML
    void onFit(ActionEvent event) {
        System.out.println("pepepe");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        motor = wvNavegador.getEngine();
        elpath = Visualizador.elpath;
        tfInput.setText(elpath);
        goToSite();
    }

}
