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

         hauteur = random.nextInt(15);
         angle = 0.5 + (1 - 0.5) * random.nextDouble();

        skieur = new Skieur();

        tg = new TerrainGeneration();
        tg.generate(hauteur,angle);
    }

    public void TrouverPoints() {
        double masse = skieur.getMasse();
        double energiep = Mathutils.enegiepotentiel(masse, hauteur);
        double energiek = energiep;
        double vitesse = 2 * energiek / masse;
        double vitessex = Mathutils.vitesseX(vitesse, angle);
        double vitessey = Mathutils.vitesseY(vitesse, angle);
        double deltay = Mathutils.deltaY(tg.getRamp().getJumpHeigth(), 0);
        double deltat[] = Mathutils.quad(-4.9, vitessey, deltay);
        double racine1 = 0;
        if (deltat[0] > 0) {
            racine1 = deltat[0];
        }
        else{
            racine1 = deltat[1];

        }
        double xfinale = Mathutils.xFinal(vitessex,racine1);
      /*
        if (xfinale == cible){
            ouvrir le pop up
        }
        else {
            recommencer la game
        }
        */
    }
}