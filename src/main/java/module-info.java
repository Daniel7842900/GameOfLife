module com.example.gol {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.almasb.fxgl.all;

    opens com.example.gol to javafx.fxml;
    exports com.example.gol;
}