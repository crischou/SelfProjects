package app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("table.fxml"));
        primaryStage.setTitle("Basketball System");


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        //primaryStage.setScene(new Scene(ui, 1280, 720));
        primaryStage.show();


    }
    //this button just for testing doesn't do anything


    public static void main(String[] args) {
        launch(args);
    }

}
