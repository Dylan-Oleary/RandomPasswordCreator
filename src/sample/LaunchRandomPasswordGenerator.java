package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class LaunchRandomPasswordGenerator extends Application {
    @FXML
    private Circle themeSelector;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Random Password Generator");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 300, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}