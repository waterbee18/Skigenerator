package guesski.model;

import guesski.controller.LevelController;

import java.util.Random;

public class LevelInfo
{
    private Skieur skieur;
    private LevelController lvc;
    private TerrainGeneration tg;
    private int hauteur = 0;
    private double angle = 0;
    public LevelInfo()
    {
        Random random = new Random();
        setHauteur(random.nextInt(300)+300);
        setAngle(0.5 + (1 - 0.5) * random.nextDouble());
        setSkieur(new Skieur());
        setTg(new TerrainGeneration());
        tg.generate(getHauteur(), getAngle());
    }

    public boolean atteintCible(double x, double width) {
        double masse = skieur.getMasse();
        double energiep = Mathutils.energiePotentiel(masse, hauteur);
        double energiek = energiep;
        double vitesse = 2 * energiek / masse;
        double vitessex = Mathutils.vitesseX(vitesse, getAngle());
        double vitessey = Mathutils.vitesseY(vitesse, getAngle());
        double deltay = Mathutils.deltaY(getTg().getRamp().getJumpHeigth(), 0);
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

    public void setSkieur(Skieur skieur) {
        this.skieur = skieur;
    }

    public LevelController getLvc() {
        return lvc;
    }

    public void setLvc(LevelController lvc) {
        this.lvc = lvc;
    }

    public TerrainGeneration getTg() {
        return tg;
    }

    public void setTg(TerrainGeneration tg) {
        this.tg = tg;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}