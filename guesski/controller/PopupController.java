package guesski.controller;

import guesski.model.LevelInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by gabro on 2018-02-22.
 */
public class PopupController {

    @FXML
    private Label label;

    private static StringProperty textProp;

    @FXML
    public void initialize(){
        textProp = new SimpleStringProperty();
        label.textProperty().bind(textProp);
    }

    public static void setLabel(String text){
        textProp.set(text);
    }

    public void closePopup(){GameMaster.closePopup();GameMaster.closeGame();}

    public void openGame(){GameMaster.closePopup();
    LevelController.slideBind();}

}
