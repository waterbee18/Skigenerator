package guesski.model;

import java.util.Random;

public class LevelInfo
{
    private Skieur skieur;
    private TerrainGeneration tg;

    public LevelInfo()
    {
        Random random = new Random();

        int hauteur = random.nextInt(15);
        double angle = 0.5 + (1 - 0.5) * random.nextDouble();

        skieur = new Skieur();

        tg = new TerrainGeneration();
        tg.generate(hauteur, angle);
    }

    public TerrainGeneration getTg() {
        return tg;
    }
}
