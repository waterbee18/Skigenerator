package test;

import guesski.model.Animation.Animation;
import guesski.model.Skieur;
import guesski.model.TerrainGeneration;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Mick extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TerrainGeneration tg = new TerrainGeneration();
        tg.generate(300, Math.PI/4);
        Skieur skieur = new Skieur();
        Animation animation = new Animation(skieur,tg.getRamp());
        Group root  = new Group(tg.getRamp(),animation.getSkierModel().getModel());
        animation.start();
        Scene s = new Scene(root,720,670);
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
