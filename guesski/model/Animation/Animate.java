package guesski.model.Animation;

import guesski.model.Ramp;
import guesski.model.Skieur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

import java.util.List;

public class Animate {
    private List<Node> nodes;
    private List<Double> distance;
    private Skieur skieur;
    private Ramp ramp;
    private Timeline tl;

    public Animate(Skieur skieur, Ramp ramp){
        this.skieur = skieur;
        this.ramp = ramp;
        tl = new Timeline(new KeyFrame(Duration.millis(20), (e)->loop()));
    }

    public void start(){
        tl.play();
    }

    public void loop(){
        double d = skieur.getVitesse()*0.02;

    }
}
