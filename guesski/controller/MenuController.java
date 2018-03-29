package guesski.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

/**
 * Created by gabro on 2018-02-08.
 */
public class MenuController {

    @FXML
    private HBox hbox;

    public void openGame(){
        GameMaster.openGame();
        LevelController.slideBind();
    }
    public void openHelp(){
        GameMaster.openHelp();
    }

    @FXML
    public void initialize(){
        AnchorPane.setBottomAnchor(hbox,0D);
        AnchorPane.setLeftAnchor(hbox,0D);
        AnchorPane.setRightAnchor(hbox, 0D);
        AnchorPane.setTopAnchor(hbox,0D);
    }
}
