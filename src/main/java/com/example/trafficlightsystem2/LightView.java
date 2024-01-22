package com.example.trafficlightsystem2;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class LightView implements PropertyChangeListener {
    static boolean redOn = false;
    static boolean greenOn = false;
    static boolean amberOn = false;
    static ArrayList<Boolean> lights;
    static ArrayList<Boolean> notLights;
    private PropertyChangeSupport pcs;

    public LightView(){
        pcs = new PropertyChangeSupport(this);
        lights = new ArrayList<>();
        notLights = new ArrayList<>();
        lights.add(false);
        lights.add(false);
        lights.add(false);
        notLights.add(false);
        notLights.add(false);
        notLights.add(false);
    }

    public void addListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {

        String propertyName = event.getPropertyName();
        String oldValue = (String) event.getOldValue();
        String newValue = (String) event.getNewValue();


        switch (propertyName) {
            case "NAME":
                System.out.println("Name changed from " + oldValue + " to " + newValue);
                break;
            case "STATE":
                switch(oldValue) {
                    case "Red":
                        redOn = true;
                        amberOn = false;
                        greenOn = false;

                        lights.set(0,redOn);
                        lights.set(1,amberOn);
                        lights.set(2,greenOn);
                        notLights.set(0,!redOn);
                        notLights.set(1,!amberOn);
                        notLights.set(2,!greenOn);
                        pcs.firePropertyChange("LIGHTS",lights,notLights);

                        break;
                    case "Green":
                        redOn = false;
                        amberOn = false;
                        greenOn = true;

                        lights.set(0,redOn);
                        lights.set(1,amberOn);
                        lights.set(2,greenOn);
                        notLights.set(0,!redOn);
                        notLights.set(1,!amberOn);
                        notLights.set(2,!greenOn);
                        pcs.firePropertyChange("LIGHTS",lights,notLights);
                        break;
                    case "Amber":
                        redOn = false;
                        amberOn = true;
                        greenOn = false;

                        lights.set(0,redOn);
                        lights.set(1,amberOn);
                        lights.set(2,greenOn);
                        notLights.set(0,!redOn);
                        notLights.set(1,!amberOn);
                        notLights.set(2,!greenOn);
                        pcs.firePropertyChange("LIGHTS", lights, notLights);
                        break;
                    case "RedAmber":
                        redOn = true;
                        amberOn = true;
                        greenOn = false;

                        lights.set(0,redOn);
                        lights.set(1,amberOn);
                        lights.set(2,greenOn);
                        notLights.set(0,!redOn);
                        notLights.set(1,!amberOn);
                        notLights.set(2,!greenOn);
                        pcs.firePropertyChange("LIGHTS", lights, notLights);

                        break;
                    default: redOn = false; greenOn = false; amberOn = false; break;
                }
        }
    }

    public static boolean getRedOn() {
        return redOn;
    }

    public static boolean getAmberOn() {
        return amberOn;
    }

    public static boolean getGreenOn() {
        return greenOn;
    }
}
