package test;

import guesski.controller.GameMaster;
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
        GameMaster gm = new GameMaster(primaryStage);
}


    public static void main(String[] args) {launch(args);
    }

}

