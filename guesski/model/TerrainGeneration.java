package guesski.model;

import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

public class TerrainGeneration {

    private List<Node> dataPoints;
    private double rampRate;
    private double height;
    private Polygon ramp;
    private double rampWidth;

    public TerrainGeneration(double height, double radRampAngle){
        this.height = height;
        rampRate = Math.atan(radRampAngle);
        dataPoints = new ArrayList<>(320);
        int i;
        for ( i = 0; -Math.sin(i*Math.PI/300) <= rampRate; i++){
            dataPoints.add(new Node(i,height/2-(height/2)*Math.cos(i*Math.PI/300)));
        }

        rampWidth = i;

        double[] rampEdge = new double[(dataPoints.size()+2)*2];

        for (i = 0; i < dataPoints.size();i++){
            rampEdge[i*2] = dataPoints.get(i).getX();
            rampEdge[i*2+1] = dataPoints.get(i).getY();
        }
        rampEdge[dataPoints.size()*2-4] = rampEdge[dataPoints.size()*2-6];
        rampEdge[dataPoints.size()*2-3] = height+10;
        rampEdge[dataPoints.size()*2-2] = 0;
        rampEdge[dataPoints.size()*2-1] = height+10;
        this.ramp = new Polygon(rampEdge);
    }

    public Polygon getRamp() {
        return ramp;
    }

    public
}
