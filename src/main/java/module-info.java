module com.example.trafficlightsystem2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.trafficlightsystem2 to javafx.fxml;
    exports com.example.trafficlightsystem2;
}