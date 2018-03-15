package guesski.controller;

import guesski.model.Animation.Animation;
import guesski.model.LevelInfo;
import guesski.model.Grille;
import guesski.model.LevelInfo;
import guesski.model.Ramp;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class LevelController
{
    @FXML
    private Slider slider;
    private Grille grille;
    @FXML
    private Rectangle cible;
    @FXML
    private HBox hb;
    private LevelInfo levelInfo;
    private Animation animation;
    @FXML
    private VBox vb;

    public void slide(){
        slider.setValue(0);
        slider.setMax(475);
        slider.setMin(0);
        cible.translateXProperty().bind(slider.valueProperty());

    }
    public LevelController(){
        levelInfo = new LevelInfo();
        animation =  new Animation(levelInfo.getSkieur(),levelInfo.getTg().getRamp());
        grille = new Grille();

    }

    public void start(){
        animation.start();
        if (levelInfo.atteintCible(cible.getX(),cible.getWidth())){

        }
        cible.translateXProperty().unbind();
    }

    public void closeGame(){
        GameMaster.closeGame();

    }
    public void openPopup(){GameMaster.openPopup();}
    public void openHelp(){GameMaster.openHelp();}


    @FXML
    public void initialize() {
        Ramp ramp = levelInfo.getTg().getRamp();
        hb.getChildren().add(0,ramp);
        vb.getChildren().add(0,grille);
        slide();
    }




}
