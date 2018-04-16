package guesski.controller;

import guesski.model.*;
import guesski.model.Animation.Animation;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.TreeSet;
import java.util.logging.Level;

public class LevelController
{
    private static LevelController lc;
    @FXML
    private Slider slider;
    private Grille grille;
    @FXML
    private Rectangle cible;
    @FXML
    private HBox hb;
    @FXML
    private StackPane stackPane;
    private LevelGenerator levelGenerator;
    private LevelInfo levelInfo;
    @FXML
    private VBox vb;
    @FXML
    private Label echelle;
    @FXML
    private Label ms;
    @FXML
    private Label hp;
    @FXML
    private Label as;
    @FXML
    private Label hs;

    @FXML
    private Label score;
    private IntegerProperty scoreProp;
    private TreeSet<Score> leaderBoard;

    public LevelController(){
        lc = this;
        levelGenerator = new LevelGenerator();
        levelInfo = levelGenerator.generate();
        grille = new Grille();
        leaderBoard = new TreeSet<>();
        scoreProp = new SimpleIntegerProperty(0);
    }

    @FXML
    public void initialize() {

        score.textProperty().bind(scoreProp.asString());
        Ramp ramp = levelInfo.getRamp();
        hb.getChildren().add(0,ramp);
        vb.getChildren().add(0,grille);
        stackPane.getChildren().add(levelInfo.getAnimation().getSkierModel().getModel());
        stackPane.getChildren().add(levelInfo.getAnimation().getSkierModel().getPostionMark());
        slide();
        information();
    }


    public void start(){
        levelInfo.getAnimation().start();
        cible.translateXProperty().unbind();
        Task<Void> sleep = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep((long)(levelInfo.getAnimation().getDuration()*1000));
                return null;
            }
        };
        sleep.setOnSucceeded(event ->  {
            double dX = Math.abs(levelInfo.getAnimation().getSkierModel().getModel().translateXProperty().get()-(cible.translateXProperty().get()+levelInfo.getRamp().getWidth()));
            double width = cible.getWidth();
            if (dX<width){
                PopupController.setLabel("Réussi!");
                GameMaster.openPopup();
                scoreProp.setValue(scoreProp.get()+1);
            } else {
                PopupController.setLabel("Vous avez perdu!");
                GameMaster.openSubmitScore(scoreProp.get());
                scoreProp.setValue(0);
            }
            restart();
        });
        new Thread(sleep).start();
    }

    public void restart(){

        stackPane.getChildren().remove(levelInfo.getAnimation().getSkierModel().getModel());
        hb.getChildren().remove(levelInfo.getRamp());
        vb.getChildren().remove(grille);
        levelInfo = levelGenerator.generate();
        Ramp ramp = levelInfo.getRamp();
        hb.getChildren().add(0,ramp);
        vb.getChildren().add(0,grille);
        stackPane.getChildren().add(levelInfo.getAnimation().getSkierModel().getModel());
        slide();
        information();
    }

    public void information(){

        NumberFormat formatter = new DecimalFormat("#0.00");
        echelle.setText("Échelle: 1 carré = "+50/levelInfo.getScale()+"m");
        ms.setText("Masse skieur= " + formatter.format(levelInfo.getSkieur().getMasse())+ "kg");
        hp.setText("Hauteur pente = " + formatter.format(levelInfo.getRamp().getHeigth()/levelInfo.getScale())+ "m");
        as.setText("Angle saut = " + formatter.format(Math.toDegrees(levelInfo.getRamp().getAngle())) +"°");
        hs.setText("Hauteur rampe = " + formatter.format(levelInfo.getRamp().getJumpHeigth()/levelInfo.getScale())+ "m");

    }

    public void slide(){
        slider.setValue(0);
        slider.setMax(650);
        slider.setMin(0);
        cible.translateXProperty().bind(slider.valueProperty());
    }

    public static  void slideBind(){
        lc.slide();
    }

    public void closeGame(){
        GameMaster.closeGame();
    }

    public void openPopup(){
        PopupController.setLabel("Guesski");
        GameMaster.openPopup();
    }

    public void openHelp(){GameMaster.openHelp();}



}
