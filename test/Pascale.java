package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Pascale extends Application
{
    public static void main (String[] args)
    {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception{
    Parent root = FXMLLoader.load(getClass().getResource("/guesski/view/SubmitScore.fxml"));
    primaryStage.setScene(new Scene(root, 1000, 1000));
    primaryStage.show();
}
}
