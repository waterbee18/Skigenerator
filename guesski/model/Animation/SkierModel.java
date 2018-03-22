package guesski.model.Animation;

import guesski.model.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;


public class SkierModel {
    private ImageView skier;

    public SkierModel(){
        skier = new ImageView();
        File file = new File("src/guesski/view/materials/skieur.png");
        if (!file.exists()){
            System.out.println("existe pas");
        }
        Image image = new Image(file.toURI().toString(),40,40,true,false);
        skier.setImage(image);

    }

    void place(Node node){
        skier.setX(node.getX());
        skier.setY(node.getY()-20);
    }

    void orient(double angle){
        double deg = angle*360/(Math.PI*2);
        /*if (deg>180) {
            deg -= 180;
        } else if (deg < 0){
            deg+=180;
        }*/
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

}
