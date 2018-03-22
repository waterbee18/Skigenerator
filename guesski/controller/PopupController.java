package guesski.controller;

/**
 * Created by gabro on 2018-02-22.
 */
public class PopupController {

    public void closePopup(){GameMaster.closePopup();GameMaster.closeGame();}

    public void openGame(){GameMaster.closePopup();
    LevelController.slideBind();}
}
