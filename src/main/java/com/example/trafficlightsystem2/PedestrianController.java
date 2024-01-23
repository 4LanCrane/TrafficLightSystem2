package com.example.trafficlightsystem2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.net.URL;
import java.util.ResourceBundle;

public class PedestrianController implements Initializable, PropertyChangeListener {

    @FXML
    Rectangle RedMan;

    @FXML
    Rectangle GreenMan;

    @FXML
    Button PushButton;

    String state;


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        state = (String) evt.getOldValue();
        switch (state) {
        case "Red":
            go();
            break;
        case "Green":
            stop();
            break;
        case "Amber":
            stop();
            break;
       case "RedAmber":
           stop();
           break;
        }
    }

    public void stop() {
        RedMan.setVisible(false);
        GreenMan.setVisible(true);
    }

    public void go() {
        RedMan.setVisible(true);
        GreenMan.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RedMan.setVisible(false);
    }


    @FXML
    public void buttonPushed(ActionEvent event) {
        LightModel model = Main.getModel();
        model.pedWaiting();
    }
}
