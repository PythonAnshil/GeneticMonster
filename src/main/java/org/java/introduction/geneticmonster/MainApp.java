package org.java.introduction.geneticmonster;





import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("Main.fxml"));
        GridPane rootLayout = loader.load();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Genetic Monsters");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
