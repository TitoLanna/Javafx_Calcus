package com.javafx.calculator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
       Parent fxmlLoader =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UI.fxml")));
        Scene scene = new Scene(fxmlLoader);
        stage.setTitle("Calculator");
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}