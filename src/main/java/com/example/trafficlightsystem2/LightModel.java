package com.example.trafficlightsystem2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class LightModel {

    private String state;
    int timer;
    private String name = "unnamed";
    private PropertyChangeSupport pcs;
    String oldState;
    ArrayList<String> possibleStates = new ArrayList<>();

    public LightModel(){
        pcs = new PropertyChangeSupport(this);
    }


    public void setName(String newName) {
        String oldName = name;
        name = newName;
        pcs.firePropertyChange("NAME", oldName, newName);
    }


    public void setState(String state,String oldState) {
        this.state = state;
        pcs.firePropertyChange("STATE", oldState, state);
    }

    public String getState() {
        return state;
    }

   public void addListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    public int setTimer(String state) {
        switch(state) {
            case "Red":
                timer = 5;
                break;
            case "Green":
                timer = 5;
                break;
            case "Amber":
                timer = 1;
                break;
            case "RedAmber":
                timer = 1;
                break;
            default:
                timer = 0;
                break;
        }
        return timer;
    }


    public String previousState(String theState) {
       String oldState;
        switch (theState) {
            case "Red":
                oldState = "Amber";
                break;
            case "RedAmber":
                oldState = "Red";
                break;
            case "Green":
                oldState = "RedAmber";
                break;
            case "Amber":
                oldState = "Green";
                break;
            default:
                oldState = "Red";
                break;
        }
        return oldState;
    }

    public void runTimer(String state) {
        int timer = setTimer(state);
        while (timer > 0) {
            try {
                Thread.sleep(1000);
                timer--;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public void calculateState() {
        possibleStates.add("Red");
        possibleStates.add("RedAmber");
        possibleStates.add("Green");
        possibleStates.add("Amber");

        new Thread(() -> {
            while (true) {
                for(String theState:possibleStates) {
                    runTimer(theState);
                    String oldState = previousState(theState);
                    setState(theState,oldState);
                }
            }
        }).start();

    }

}
