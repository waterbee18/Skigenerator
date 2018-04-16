package guesski.controller;

import guesski.model.Score;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;


public class ScoreController {

    @FXML
    private TextField name;
    @FXML
    private VBox leaderboard;
    @FXML
    private Label label;
    private static StringProperty scoreResult;
    private TreeSet<Score> scores;
    private static int latestScore;
    private static boolean submitted;
    private File saveFile;

    public ScoreController(){
        scores = new TreeSet<>();
        scoreResult = new SimpleStringProperty();
        latestScore = 0;
        saveFile = new File("leaderboard.save");
        try {
            if (!saveFile.exists()){
                saveFile.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(saveFile));
            String line;
            while ((line = reader.readLine()) != null){
                String[] input = line.split(",");
                scores.add(new Score(input[0],Integer.valueOf(input[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void initialize(){
        buildScoreboard();
        label.textProperty().bind(scoreResult);
    }

    public void submitScore(){
        if (!submitted) {
            scores.add(new Score(name.getText(), latestScore));
            buildScoreboard();
            submitted = true;
            saveLeaderBoard();
        }
    }

    private void saveLeaderBoard(){
        Iterator<Score> scoreIterator = scores.descendingIterator();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
            while (scoreIterator.hasNext()){
                Score score = scoreIterator.next();
                writer.write(score.getUsername()+","+score.getScore()+"\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildScoreboard(){
        leaderboard.getChildren().clear();
        Iterator<Score> scoreIterator = scores.descendingIterator();
        int i = 0;
        while (scoreIterator.hasNext() && i < 11){
            i++;
            Score score = scoreIterator.next();
            System.out.println(i+". "+score.getUsername()+" "+score.getScore());
            leaderboard.getChildren().add(new Label(i+". "+score.getUsername()+" "+score.getScore()));

        }
    }

    public void closePopup(){
        GameMaster.closeSubmitScore();
        GameMaster.closeGame();
    }

    public void openGame(){
        GameMaster.closeSubmitScore();
        LevelController.slideBind();
    }

    public static void newScore(int newScore){
        latestScore = newScore;
        submitted = false;
        scoreResult.set("Votre score: "+newScore);
    }

}
