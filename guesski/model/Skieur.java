package guesski.model;

import java.util.Random;

public class Skieur
{
    private Random random = new Random();
    private double energieK = 0;
    private double energieP = 0;
    private double vitesse = 0;
    private double masse = random.nextInt(60) + 60;
    private double vitesseX;
    private double vitesseY;
    private double fallXStart;
    private double fallYstart;
    private double fallingTime;

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

    public double getVitesseX() {
        return vitesseX;
    }

    public double getVitesseY() {
        return vitesseY;
    }

    public void setVitesseX(double vitesseX) {
        this.vitesseX = vitesseX;
    }

    public void setVitesseY(double vitesseY) {
        this.vitesseY = vitesseY;
    }

    public void setVitesseVectorielle(double angle){
        vitesseX = Math.cos(angle) * vitesse;
        vitesseY = Math.sin(angle) * vitesse;
    }

    public double getFallingTime(){
        return fallingTime;
    }

    public void setFallingTime(double t){
        this.fallingTime = t;
    }

    public void addFallingTime(double add){
        fallingTime+=add;
    }

    public double getFallXStart() {
        return fallXStart;
    }

    public void setFallXStart(double fallXStart) {
        this.fallXStart = fallXStart;
    }

    public double getFallYstart() {
        return fallYstart;
    }

    public void setFallYstart(double fallYstart) {
        this.fallYstart = fallYstart;
    }
}
