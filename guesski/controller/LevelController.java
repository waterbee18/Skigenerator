package guesski.controller;

import guesski.model.Animation.Animation;
import guesski.model.LevelInfo;
import guesski.model.Grille;
import guesski.model.LevelInfo;
import guesski.model.Ramp;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.text.DecimalFormat;
import java.text.NumberFormat;
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
    private LevelInfo levelInfo;
    private Animation animation;
    @FXML
    private VBox vb;
    @FXML
    private Label label;
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

    public LevelController(){
        lc = this;
        levelInfo = new LevelInfo();
        animation =  new Animation(levelInfo.getSkieur(),levelInfo.getTg().getRamp());
        grille = new Grille();

    }
    public void information(){

        NumberFormat formatter = new DecimalFormat("#0.00");

        echelle.setText("Échelle: 1 carré = " );
        ms.setText("Masse skieur= " + formatter.format(levelInfo.getSkieur().getMasse())+ "kg");
        hp.setText("Hauteur pente = " + formatter.format(levelInfo.getHauteur())+ "m");
        as.setText("Angle saut = " + formatter.format(Math.toDegrees(levelInfo.getTg().getRamp().getAngle())) +"°");
        hs.setText("Hauteur rampe = " + formatter.format(levelInfo.getTg().getRamp().getJumpHeigth())+ "m");

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

    public void start(){
        animation.start();

        if (levelInfo.atteintCible(cible.getX(),cible.getWidth())){
            PopupController.setLabel("Vous avez gagné!");
            GameMaster.openPopup();
            scoreProp.setValue(scoreProp.get()+1);
        }
        else
        {
            PopupController.setLabel("Vous avez perdu!");
            GameMaster.openPopup();
            scoreProp.setValue(0);
        }

        cible.translateXProperty().unbind();
    }

    public void closeGame(){
        GameMaster.closeGame();

    }
    public void openPopup(){
        PopupController.setLabel(" ");
        GameMaster.openPopup();
    }
    public void openHelp(){GameMaster.openHelp();}


    @FXML
    public void initialize() {
        scoreProp = new SimpleIntegerProperty(0);
        score.textProperty().bind(scoreProp.asString());
        Ramp ramp = levelInfo.getTg().getRamp();
        hb.getChildren().add(0,ramp);
        vb.getChildren().add(0,grille);
        slide();
        information();
    }

}
