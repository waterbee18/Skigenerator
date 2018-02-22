package guesski.model.Animation;

import guesski.model.Node;
import javafx.scene.shape.Circle;

public class SkierModel {
    private Circle skier;

    public SkierModel(){
        skier = new Circle(5);
    }

    void place(Node node){
        skier.setCenterX(node.getX());
        skier.setCenterY(node.getY());
    }

    void orient(double angle){

    }

    public Circle getModel(){
        return skier;
    }
}
