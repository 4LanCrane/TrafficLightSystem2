package com.example.trafficlightsystem2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application {
    static LightModel model1 = new LightModel();

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) throws Exception {

        //Creating instances of the model and view.
        LightView view1 = new LightView();

        //setting the view as a listener for model
        model1.addListener(view1);
        //start the program
        model1.calculateState();


        //adding the views.
        //Traffic light view
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View.fxml"));
        LightController lightController = new LightController();
        fxmlLoader.setController(lightController);


        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        stage.setTitle("Traffic Lights");
        stage.setScene(scene);
        stage.show();
        view1.addListener(lightController);

        //Pedestrian view
        Stage stage2 = new Stage();
        FXMLLoader fxmlButton = new FXMLLoader(Main.class.getResource("Button.fxml"));

        PedestrianController pedestrianController = new PedestrianController();
        fxmlButton.setController(pedestrianController);
        model1.addListener(pedestrianController);

        Scene scene2 = new Scene(fxmlButton.load(), 520, 440);
        stage2.setTitle("Pedestrian");
        stage2.setScene(scene2);
        stage2.show();

    }

    public static LightModel getModel() {
        return model1;
    }

}