package guesski.model.Animation;

import guesski.model.Node;
import guesski.model.Vector;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;


public class SkierModel {
    private ImageView skier;
    private double width;
    private double heigth;
    private double lastX = 0;
    private double lastY = 0;

    public SkierModel(){
        skier = new ImageView();
        File file = new File("src/guesski/view/materials/skieur.png");
        if (!file.exists()){
            System.out.println("Existe pas");
        }
        this.width = 40;
        this.heigth = 40;
        Image image = new Image(file.toURI().toString(),width,heigth,true,false);
        skier.setImage(image);
    }

    void place(Node node){
        skier.setX(node.getX());
        skier.setY(node.getY()-20);
    }

    void orient(double angle){
        double deg = angle*360/(Math.PI*2);
        skier.setRotate(deg);
    }

    public void translateX(double x){
        skier.setTranslateX(getModel().getX()+x);
    }

    public void translateY(double y){
        skier.setTranslateY(getModel().getY()+y);
    }

    public ImageView getModel(){
        return skier;
    }

    public void move(Vector vector){
        double newdx = vector.getDx()-width/2;
        double newdy = vector.getDy();
        skier.setTranslateX(newdx);
        skier.setTranslateY(newdy);
        skier.setRotate(Math.atan((newdx-lastX)/(lastY-newdy))*360/(2*Math.PI)+90);
        lastX = newdx;
        lastY = newdy;
    }

}
