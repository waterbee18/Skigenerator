package guesski.controller;

import guesski.view.View;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;


public class GameMaster {

    private static GameMaster gm;
    private Stage stage;
    private AnchorPane root;
    private StackPane panes;
    private Parent menu;
    private Parent gameBoard;
    private Parent help;
    private Parent popup;
    private Parent submitScore;
    private Scene scene;

    public GameMaster(Stage stage){
        gm = this;
        this.stage = stage;
        panes = new StackPane();
        stretch(panes);
        root = new AnchorPane(panes);
        menu = load(View.MENU);
        help = load(View.HELP);
        gameBoard = load(View.GAME);
        submitScore = load(View.SUBMIT_SCORE);
        popup = load(View.POPUP);

        Rectangle2D screenDimensions = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(root,screenDimensions.getMaxX(),screenDimensions.getMaxY());
        stage.setScene(scene);
        showMenu();
        stage.show();
    }

    public void showMenu(){ panes.getChildren().add(menu);}

    public void hideMenu(){
        panes.getChildren().remove(menu);
    }

    public void showGameBoard(){
         panes.getChildren().add(gameBoard);
    }

    public void hideBoardGame(){
        panes.getChildren().remove(gameBoard);
    }

    public void showHelpCenter(){panes.getChildren().add(help);}

    public void hideHelpCenter(){panes.getChildren().remove(help);}

    public void showPopUp(){panes.getChildren().add(popup);}

    public void hidePopUp(){panes.getChildren().remove(popup);}

    public void showSubmitScore(){panes.getChildren().add(submitScore);}

    public void hideSubmitScore(){panes.getChildren().remove(submitScore);}

    private void stretch(Node node){
        AnchorPane.setBottomAnchor(node,0d);
        AnchorPane.setTopAnchor(node,0d);
        AnchorPane.setLeftAnchor(node,0d);
        AnchorPane.setRightAnchor(node,0d);
    }

    private Parent load(View view){
        try {
            return FXMLLoader.load(getClass().getResource(view.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void openMenu(){
        gm.showMenu();
    }

    public static void closeMenu(){
        gm.hideMenu();
    }

    public static void openGame(){
        gm.showGameBoard();
    }

    public static void closeGame(){gm.hideBoardGame();}

    public static void openHelp(){gm.showHelpCenter();}

    public static void closeHelp(){gm.hideHelpCenter();}

    public static void openPopup(){
        gm.showPopUp();
    }

    public static void closePopup(){gm.hidePopUp();}

    public static void openSubmitScore(int score){
        gm.showSubmitScore();
        ScoreController.newScore(score);
    }

    public static void closeSubmitScore(){gm.hideSubmitScore();}

}
