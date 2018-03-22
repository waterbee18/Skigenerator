package guesski.model.Animation;

import guesski.model.Mathutils;
import guesski.model.Node;
import guesski.model.Ramp;
import guesski.model.Skieur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.List;

public class Animation {
    private List<Node> nodes;
    private List<Double> distance;
    private int nodeIndex;
    private Skieur skieur;
    private Ramp ramp;
    private Timeline downHill;
    private Timeline freefall;
    private SkierModel model;
    private int scale = 25;
    private double deltaT = 0.016;

    public Animation(Skieur skieur, Ramp ramp){
        this.skieur = skieur;
        this.ramp = ramp;
        this.nodes = ramp.getNodes();
        this.distance = ramp.getDistance();
        downHill = new Timeline(new KeyFrame(Duration.millis(16), (e)-> downHillLoop()));
        downHill.setCycleCount(Timeline.INDEFINITE);
        freefall = new Timeline(new KeyFrame(Duration.millis(16), (e)->freeFallLoop()));
        freefall.setCycleCount(Timeline.INDEFINITE);
        model = new SkierModel();
    }

    public void start(){
        skieur.setEnergieP(Mathutils.energiePotentiel(skieur.getMasse(), ramp.getHeigth()/scale));
        nodeIndex = 10;
        model.place(nodes.get(nodeIndex));
        double lostP = Mathutils.energiePotentiel(skieur.getMasse(), (nodes.get(nodeIndex).getY()-nodes.get(0).getY())/scale);
        skieur.gainEk(lostP);
        skieur.looseEp(lostP);
        downHill.play();
    }

    private void downHillLoop(){
        if (nodeIndex<distance.size()) {
            Node before = nodes.get(nodeIndex);
            double d = ((skieur.getVitesse() * deltaT) / scale);
            while (d > 0 && nodeIndex < distance.size()) {
                d -= (distance.get(nodeIndex) / (scale*20));
                nodeIndex++;
            }
            Node after = nodes.get(nodeIndex);
            model.place(after);
            model.orient(ramp.getRate(nodeIndex-1));
            double deltaP = Mathutils.energiePotentiel(skieur.getMasse(), (after.getY() - before.getY())/scale);
            skieur.looseEp(deltaP);
            skieur.gainEk(deltaP);
        } else {
            downHill.stop();
            skieur.setVitesseVectorielle(ramp.getAngle());
            Node last = nodes.get(nodeIndex);
            skieur.setFallingTime(0);
            skieur.setFallXStart(last.getX());
            skieur.setFallYstart(last.getY());
            freefall.play();
        }
    }

    private void freeFallLoop(){
        double dX = (skieur.getVitesseX()*skieur.getFallingTime());
        double dY = -(skieur.getVitesseY()*skieur.getFallingTime()-(0.5*Mathutils.Constant.GRAVITY.getValue()*Math.pow(skieur.getFallingTime(),2)));
        model.place(new Node(dX+skieur.getFallXStart(),dY+skieur.getFallYstart()));
        model.orient(Math.atan(dY/dX));
        skieur.addFallingTime(deltaT);
    }

    public SkierModel getSkierModel(){
        return model;
    }

    public int getScale(){
        return scale;
    }

}
