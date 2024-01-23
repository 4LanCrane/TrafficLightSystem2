package com.example.trafficlightsystem2;

import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;


public class LightController implements Initializable, PropertyChangeListener {

    public LightController() {
    }

    @FXML
    Circle redLight;
    @FXML
    Circle amberLight;
    @FXML
    Circle greenLight;



    @FXML
    Rectangle GreenMan;

    public void turnRedLightOn() {
        redLight.setFill(javafx.scene.paint.Color.RED);
    }

    public void turnRedLightOff() {
        redLight.setFill(javafx.scene.paint.Color.BLACK);
    }

    public void turnAmberLightOn() {
        amberLight.setFill(javafx.scene.paint.Color.ORANGE);

    }

    public void turnAmberLightOff() {
        amberLight.setFill(javafx.scene.paint.Color.BLACK);
    }


    public void turnGreenLightOn() {
        greenLight.setFill(javafx.scene.paint.Color.GREEN);
    }

    public void turnGreenLightOff() {
        greenLight.setFill(javafx.scene.paint.Color.BLACK);
    }

    public void propertyChange(PropertyChangeEvent event) {
        ArrayList<Boolean> value = (ArrayList<Boolean>) event.getOldValue();
        if (value.get(0)) {
            turnRedLightOn();
        } else {
            turnRedLightOff();
        }
        if (value.get(1)) {
            turnAmberLightOn();
        } else {
            turnAmberLightOff();
        }
        if (value.get(2)) {
            turnGreenLightOn();
        } else {
            turnGreenLightOff();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        turnAmberLightOn();
    }
}
