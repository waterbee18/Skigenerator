package guesski.controller;

import guesski.model.Animation.Animation;
import guesski.model.LevelInfo;
import javafx.beans.property.DoubleProperty;
import guesski.model.Grille;
import guesski.model.LevelInfo;
import guesski.model.Ramp;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class LevelController
{
    @FXML
    private Rectangle cible;
    private LevelInfo levelInfo;
    private DoubleProperty x;
    private Animation animation;

    public LevelController(){
        levelInfo = new LevelInfo();
        animation =  new Animation(levelInfo.getSkieur(),levelInfo.getTg().getRamp());
    }

    public void start(){
        animation.start();
        if (levelInfo.atteintCible(cible.getX(),cible.getWidth())){

        }
    }



    public void closeGame(){
        GameMaster.closeGame();
    }
    public void openPopup(){GameMaster.openPopup();}

    @FXML
    Rectangle cible;
    @FXML
    AnchorPane anchor;
    LevelInfo levelinfo;
    Grille grille;

    public LevelController(){
        levelinfo = new LevelInfo();
        grille = new Grille();
    }

    @FXML
    public void initialize() {
        Ramp ramp = levelinfo.getTg().getRamp();
        ramp.setTranslateY(100);
        anchor.getChildren().add(ramp);
        anchor.getChildren().add(grille);
    }

    public void dragDetected()
    {
        Dragboard dragboard = cible.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent contenu = new ClipboardContent();
        contenu.putString("Dropped");
        dragboard.setContent(contenu);
        return;
    }

    public void dragOver(DragEvent event)
    {
        event.acceptTransferModes(TransferMode.MOVE);
        event.consume();
    }

    public void dragDropped (DragEvent event)
    {
        String content = event.getDragboard().getString();
        System.out.println(content);

        event.setDropCompleted(true);
    }
}
