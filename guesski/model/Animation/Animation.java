package guesski.model.Animation;

import guesski.model.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.Queue;

public class Animation {

    private SkierModel model;
    private Timeline animation;
    private Queue<Vector> movement;
    private boolean done = false;
    private double duration;

    public Animation(Queue<Vector> movements){
        this.movement = movements;
        animation = new Timeline(new KeyFrame(Duration.millis(16), (e)->loop()));
        animation.setCycleCount(Timeline.INDEFINITE);
        duration = movements.size()*0.016;
        model = new SkierModel();
    }

    public void loop(){
        if (!movement.isEmpty()){
            Vector newMove = movement.poll();
            model.move(newMove);
        } else {
            animation.stop();
            done = true;
        }

    }

    public void start(){
        animation.play();
    }

    public boolean isDone(){
        return done;
    }

    public double getDuration(){
        return duration;
    }

    public SkierModel getSkierModel(){
        return model;
    }
}
