package test;

import guesski.model.LevelInfo;
import guesski.model.LevelGenerator;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Mick extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LevelGenerator tg = new LevelGenerator();
        LevelInfo info = tg.generate();
        StackPane root  = new StackPane(info.getRamp(),info.getAnimation().getSkierModel().getModel());
        root.setAlignment(Pos.BOTTOM_LEFT);
        info.getAnimation().start();
        Scene s = new Scene(root,1200,670);
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
