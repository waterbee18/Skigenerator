package guesski.controller;

import guesski.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
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
        popup = load(View.POPUP);
        Scene scene = new Scene(root,1024,720);
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

    public void showhelpcenter(){panes.getChildren().add(help);}

    public void hidehelpcenter(){panes.getChildren().remove(help);}


    public void showhpopupcenter(){panes.getChildren().add(popup);}

    public void hidepopupcenter(){panes.getChildren().remove(popup);}

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

    public static void openHelp(){gm.showhelpcenter();}

    public static void closeHelp(){gm.hidehelpcenter();}

    public static void openPopup(){gm.showhpopupcenter();}

    public static void closePopup(){gm.hidepopupcenter();}

}
