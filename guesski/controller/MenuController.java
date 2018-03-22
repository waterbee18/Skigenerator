package guesski.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.shape.Rectangle;

/**
 * Created by gabro on 2018-02-08.
 */
public class MenuController {


    public void openGame(){
        GameMaster.openGame();
        LevelController.slideBind();
    }
    public void openHelp(){
        GameMaster.openHelp();
    }
}
