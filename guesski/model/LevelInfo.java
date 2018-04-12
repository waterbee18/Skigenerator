package guesski.model;

import guesski.controller.LevelController;
import guesski.model.Animation.Animation;

public class LevelInfo
{
    private Skieur skieur;
    private Ramp ramp;
    private double hauteur = 0;
    private double angle = 0;
    private Animation animation;
    private double scale;

    public LevelInfo(Skieur skieur, Ramp ramp, double hauteur, double angle, Animation animation, double scale) {
        this.skieur = skieur;
        this.ramp = ramp;
        this.hauteur = hauteur;
        this.angle = angle;
        this.animation = animation;
        this.scale = scale;
    }

    public boolean atteintCible(double x, double width) {
        double masse = skieur.getMasse();
        double energiep = Mathutils.energiePotentiel(masse, hauteur);
        double energiek = energiep;
        double vitesse = 2 * energiek / masse;
        double vitessex = Mathutils.vitesseX(vitesse, ramp.getAngle());
        double vitessey = Mathutils.vitesseY(vitesse, ramp.getAngle());
        double deltay = Mathutils.deltaY(ramp.getJumpHeigth(), 0);
        double deltat[] = Mathutils.quad(-4.9, vitessey, deltay);
        double racine1 = 0;
        if (deltat[0] > 0) {
            racine1 = deltat[0];
        } else {
            racine1 = deltat[1];
        }
        double xfinale = Mathutils.xFinal(vitessex,racine1);

        return x <= xfinale && xfinale <=(x+width);

    }

    public Skieur getSkieur() {
        return skieur;
    }

    public Ramp getRamp(){
        return ramp;
    }

    public Animation getAnimation(){
        return animation;
    }

    public double getScale(){
        return scale;
    }
}