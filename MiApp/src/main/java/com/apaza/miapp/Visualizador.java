package com.apaza.miapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Visualizador extends Application {
    public static String elpath = "";
    private static double ancho;
    private static double alto;
    static Stage stagetmp;
    static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Visualizador.class.getResource("Visualizador.fxml"));
        getAnchoAltoDeSVG(elpath);
        scene = new Scene(fxmlLoader.load(), ancho, alto);
        primaryStage.setTitle("svg viewer");
        primaryStage.setScene(scene);
        stagetmp = primaryStage;
        primaryStage.show();
    }

    public static void cambioAnchoAlto(int ancho, int alto){
        stagetmp.setWidth(ancho);
        stagetmp.setHeight(alto);
    }

    public static void main(String[] args) {
        elpath = args[0];
//        elpath = "D:\\apz\\pruebas\\juegos\\並.svg";
//        elpath = "D:\\apz\\maps\\progr\\leng\\java\\0libs\\javafx\\0fotos\\basico_holamundo.svg";
        launch();
    }

    public static void getAnchoAltoDeSVG(String elpath){
        try {
            File svgFile = new File(elpath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(svgFile);
            Element svgElement = doc.getDocumentElement();

            ancho = Double.parseDouble(svgElement.getAttribute("width").replace("px","")) +1;
            alto = Double.parseDouble(svgElement.getAttribute("height").replace("px","")) +1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
