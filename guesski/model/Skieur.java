package guesski.model;

import java.util.Random;

public class Skieur
{
    private Random random = new Random();
    private double energieK = 0;
    private double energieP = 0;
    private double vitesse = 0;
    private double masse = random.nextInt(60) + 60;

    public double getEnergieK() {
        return energieK;
    }

    public double getEnergieP() {
        return energieP;
    }

    public double getMasse() {
        return masse;
    }

    public double getVitesse() {
        return vitesse;
    }

    public void setEnergieK(double energieK) {
        this.energieK = energieK;
        vitesse = Math.sqrt(2*energieK/masse);
    }

    public void setEnergieP(double energieP) {
        this.energieP = energieP;
    }

    public void setMasse(double masse) {
        this.masse = masse;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
        this.energieK = 0.5*masse*Math.pow(vitesse,2);
    }

    public void looseEp(double energie){
        energieP-=energie;
    }

    public void looseEk(double energie){
        setEnergieK(energieK-energie);
    }

    public void gainEp(double energie){
        energieP+=energie;
    }

    public void gainEk(double energie){
        setEnergieK(energieK+energie);
    }
}
