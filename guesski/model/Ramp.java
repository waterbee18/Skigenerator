package guesski.model;


import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

public class Ramp extends Polygon {

    private List<Node> nodes;
    private List<Double> distance;
    private List<Double> rate;
    private double heigth;
    private double jumpHeigth;

    public Ramp(double[] edge, List<Node> nodes){
        super(edge);
        List<Double> points = new ArrayList<>();
        for (double d:edge){
            points.add(d);
        }
        this.getPoints().setAll(points);
        this.setFill(Color.SKYBLUE);
        this.nodes = nodes;
        heigth = nodes.get(0).getY()*2;
        distance = new ArrayList<>();
        rate = new ArrayList<>();
        for (int i = 0; i< this.nodes.size()-1; i++){
            double dx = this.nodes.get(i).getX()- this.nodes.get(i+1).getX();
            double dy = this.nodes.get(i).getY()- this.nodes.get(i+1).getY();
            distance.add(distance(dx,dy));
            rate.add(Math.atan(dx/dy)*360/(2/Math.PI));
        }
        jumpHeigth = nodes.get(nodes.size()-1).getY();
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

    public double getJumpHeigth(){
        return jumpHeigth;
    }

    private Double distance(double dx, double dy){
        return Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
    }
}
