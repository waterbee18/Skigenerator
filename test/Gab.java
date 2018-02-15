package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by gabro on 2018-02-08.
 */
public class Gab extends Application{

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/guesski/view/Menu.fxml"));
        primaryStage.setTitle("SAlut ca va");
        primaryStage.setScene(new Scene(root, 1200, 900));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}

