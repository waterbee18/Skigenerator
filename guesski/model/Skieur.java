package guesski.model;

import java.util.Random;

public class Skieur
{
    Random random = new Random();
    public int energieK = 0;
    public int energieP = 0;
    public int vitesse = 0;
    public int masse = random.nextInt(60) + 60;

    public int getEnergieK() {
        return energieK;
    }

    public int getEnergieP() {
        return energieP;
    }

    public int getMasse() {
        return masse;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setEnergieK(int energieK) {
        this.energieK = energieK;
    }

    public void setEnergieP(int energieP) {
        this.energieP = energieP;
    }

    public void setMasse(int masse) {
        this.masse = masse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
}
