package com.example.trafficlightsystem2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        //create an instance of the model and set the initial state to red
        LightModel model1 = new LightModel();
        //create an instance of the view
        LightView view1 = new LightView();
        //add the view as a listener to the model
        model1.addListener(view1);
        model1.calculateState();
        //cycle through the standard states of a UK traffic signal
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View.fxml"));
        LightController lightController = new LightController();
        fxmlLoader.setController(lightController);
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        view1.addListener(lightController);
    }

}