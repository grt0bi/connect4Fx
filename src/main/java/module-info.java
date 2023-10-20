module com.example.connect4fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.connect4fx to javafx.fxml;
    exports com.example.connect4fx;
}