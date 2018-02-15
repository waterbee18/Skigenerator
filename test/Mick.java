package test;

import guesski.model.TerrainGeneration;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mick extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TerrainGeneration tg = new TerrainGeneration(300, Math.PI/4);
        Group root  = new Group(tg.getRamp());
        Scene s = new Scene(root,720,670);
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
