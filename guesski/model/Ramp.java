package guesski.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Ramp extends Polygon {

    private double heigth;
    private double angle;
    private double width;
    private double jumpHeigth;

    public Ramp(double heigth, double angle){
        this.angle = angle;
        this.heigth = heigth;
        this.setFill(Color.SKYBLUE);
    }

    public void setWidth(double width){
        this.width = width;
    }

    public double getWidth(){
        return width;
    }

    public double getHeigth(){
        return heigth;
    }

    public double getAngle(){
        return angle;
    }

    public double getJumpHeigth() {
        return jumpHeigth;
    }

    public void setJumpHeigth(double heigth){
        this.jumpHeigth = heigth;
    }
}
