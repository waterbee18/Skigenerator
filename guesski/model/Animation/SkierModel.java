package guesski.model.Animation;

import guesski.model.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SkierModel {
    private Rectangle skier;

    public SkierModel(){
        skier = new Rectangle(10,10);
    }

    void place(Node node){
        skier.setX(node.getX());
        skier.setY(node.getY());
    }

    void orient(double angle){
        double deg = angle*360/(Math.PI*2);
        if (deg>180) {
            deg -= 180;
        } else if (deg < 0){
            deg+=180;
        }
        skier.setRotate(deg);
    }

    public void translateX(double x){
        skier.setTranslateX(getModel().getX()+x);
    }

    public void translateY(double y){
        skier.setTranslateY(getModel().getY()+y);
    }

    public Rectangle getModel(){
        return skier;
    }

}
