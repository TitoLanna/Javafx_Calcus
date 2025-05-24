module com.javafx.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.javafx.calculator to javafx.fxml;
    exports com.javafx.calculator;
}