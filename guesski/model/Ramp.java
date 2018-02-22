package guesski.model;


import javafx.scene.shape.Polygon;

import java.util.List;

public class Ramp extends Polygon {

    private List<Node> points;
    private List<Double> distance;
    private List<Double> rate;

    public Ramp(double[] edge, List<Node> nodes){
        super(edge);
        this.points = nodes;
        for (int i = 0; i<points.size()-1; i++){
            double dx = points.get(i).getX()-points.get(i+1).getX();
            double dy = points.get(i).getY()-points.get(i+1).getY();
            distance.add(distance(dx,dy));
            rate.add(Math.atan(dx/dy)*360/(2/Math.PI));
        }
    }

    public void setPoints(){

    }

    private Double distance(double dx, double dy){
        return Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
    }
}
