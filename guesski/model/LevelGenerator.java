package guesski.model;

import guesski.model.Animation.Animation;

import java.util.*;

public class LevelGenerator {

    private double heigth, angle;
    private Random random = new Random();

    public LevelInfo generate(){
        double scale = 5;//px/m
        heigth = random.nextInt(250)+100;
        angle = (0.5 + (1 - 0.5) * random.nextDouble());
        Skieur skieur = new Skieur(heigth/scale);
        List<Vector> rampVectors = new ArrayList<>();
        Ramp ramp = new Ramp(heigth,angle);
        double lastY = 0, rampRate = Math.atan(angle);
        int i;
        for (i = 0; -Math.sin(i*Math.PI/300) < rampRate; i++){
            double newY = Math.cos(i*Math.PI/300+Math.PI)*heigth/2+heigth/2;
            ramp.getPoints().add(new Double(i));
            ramp.getPoints().add(newY);
            rampVectors.add(new Vector(1,lastY - newY));
            lastY = newY;
        }
        ramp.setJumpHeigth(heigth-(ramp.getPoints().get(ramp.getPoints().size()-1)));
        ramp.setWidth(i);
        ramp.getPoints().add(ramp.getPoints().get(ramp.getPoints().size()-2));
        ramp.getPoints().add(heigth+10);
        ramp.getPoints().add(0D);
        ramp.getPoints().add(heigth+10);
        Animation animation = generateAnimation(rampVectors, skieur, scale);
        return new LevelInfo(skieur,ramp,heigth,angle,animation,scale);
    }

    private Animation generateAnimation(List<Vector> ramp, Skieur skieur, double scale){
        Vector height = new Vector(0,-heigth-10);
        Queue<Vector> finalPath = new LinkedList<>();
        Vector startingVector = new Vector(0,0);
        for (int i = 0; i< 10; i++){
            startingVector.add(ramp.get(i));
        }
        finalPath.add(Vector.add(startingVector,height));
        skieur.move(Vector.scalarMultiply(startingVector,1/scale));
        Vector last = startingVector.clone();
        last.invertY();

        for (int i = 10; i < ramp.size();i++){
            Vector cv = ramp.get(i);
            Vector move = new Vector(0,0);
            while (cv.length() > 0){
                double distance = skieur.getVitesse()*0.016*scale;// m/s * s * px/m = px
                double ogDis = distance;

                if (cv.length() < distance){
                    if (ramp.size()== i+1){
                        //skieur.setVitesseX(move.getDx()/0.16);
                        //skieur.setVitesseY(move.getDy()/0.16);
                        break;
                    }
                    distance -= cv.length();
                    move = Vector.add(cv,Vector.toLength(ramp.get(i+1),distance));
                    ramp.get(i+1).minus(distance);
                    cv.setLength(0D);
                } else {
                    move = Vector.toLength(ramp.get(i), distance);
                    cv.minus(distance);
                }
                skieur.move(Vector.scalarMultiply(move,1/scale));//px * m/ps
                move.invertY();
                Vector newPos = Vector.add(last,move);
                finalPath.add(Vector.add(height,newPos));
                last = newPos;
            }
        }
        skieur.setVitesseVectorielle(angle);
        Vector airTime = new Vector(1,1);
        for (int i = 1;airTime.getDy()<heigth;i++){
            double dt = i*0.016;
            double dx = skieur.getVitesseX()*dt;
            double dy = skieur.getVitesseY()*dt-(0.5*9.81*Math.pow(dt,2));
            airTime = Vector.add(last, Vector.scalarMultiply(new Vector(dx,dy).invertY(),scale));
            finalPath.add(Vector.add(height,airTime));
        }

        return new Animation(finalPath);
    }
}
