package guesski.model.Animation;

import guesski.model.Mathutils;
import guesski.model.Node;
import guesski.model.Ramp;
import guesski.model.Skieur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.List;

public class Animation {
    private List<Node> nodes;
    private List<Double> distance;
    private int nodeIndex;
    private Skieur skieur;
    private Ramp ramp;
    private Timeline tl;
    private SkierModel model;

    public Animation(Skieur skieur, Ramp ramp){
        this.skieur = skieur;
        this.ramp = ramp;
        this.nodes = ramp.getNodes();
        this.distance = ramp.getDistance();
        tl = new Timeline(new KeyFrame(Duration.millis(20), (e)->loop()));
        tl.setCycleCount(Timeline.INDEFINITE);
        model = new SkierModel();
    }

    public void start(){
        System.out.println("Started");
        skieur.setEnergieP(Mathutils.enegiepotentiel(skieur.getMasse(), ramp.getHeigth()));
        nodeIndex = 10;
        model.place(nodes.get(nodeIndex));

        double lostP = Mathutils.enegiepotentiel(skieur.getMasse(), nodes.get(nodeIndex).getY()-ramp.getHeigth());
        skieur.gainEk(lostP);
        skieur.looseEp(lostP);
        tl.play();
    }

    public void loop(){

        Node before = nodes.get(nodeIndex);
        double d = skieur.getVitesse()*0.02;
        System.out.println(d);
        while (d > 0){
            nodeIndex++;
            d-=distance.get(nodeIndex);
        }
        Node after = nodes.get(nodeIndex);
        model.place(after);
        double lostp = Mathutils.enegiepotentiel(skieur.getMasse(),after.getY()-before.getY());
        skieur.looseEp(lostp);
        skieur.gainEk(lostp);
    }

    public SkierModel getSkierModel(){
        return model;
    }

}
