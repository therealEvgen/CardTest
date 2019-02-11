package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root2 = FXMLLoader.load(getClass().getResource("Username.fxml"));
        primaryStage.setTitle("Username");
        primaryStage.setScene(new Scene(root2, 294, 413));
        primaryStage.show();



/*
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 842, 462));
        primaryStage.show();
*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
