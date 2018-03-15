package guesski.model;


import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

public class Ramp extends Polygon {

    private List<Node> nodes;
    private List<Double> distance;
    private List<Double> rate;
    private double heigth;
    private double jumpHeigth;
    private double angle;

    public Ramp(double[] edge, List<Node> nodes, double heigth, double angle){
        this.angle = angle;
        this.heigth = heigth;
        List<Double> points = new ArrayList<>();
        for (double d:edge){
            points.add(d);
        }
        this.getPoints().setAll(points);
        this.setFill(Color.SKYBLUE);
        this.nodes = nodes;
        distance = new ArrayList<>();
        rate = new ArrayList<>();
        for (int i = 0; i< this.nodes.size()-1; i++){
            double dx = this.nodes.get(i).getX()- this.nodes.get(i+1).getX();
            double dy = this.nodes.get(i).getY()- this.nodes.get(i+1).getY();
            distance.add(distance(dx,dy));
            rate.add(Math.atan(dy/dx));
        }
        jumpHeigth = heigth-nodes.get(nodes.size()-1).getY();
    }

    public List<Node> getNodes(){
        return this.nodes;
    }

    public List<Double> getDistance(){
        return distance;
    }

    public double getHeigth(){
        return heigth;
    }

    public double getRate(int i){
        return rate.get(i);
    }

    public double getJumpHeigth(){
        return jumpHeigth;
    }

    private Double distance(double dx, double dy){
        return Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
    }

    public double getAngle(){
        return angle;
    }
}
