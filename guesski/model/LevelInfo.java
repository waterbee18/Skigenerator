package guesski.model;

import java.util.Random;

public class LevelInfo
{

    private Skieur skieur;

    public LevelInfo()
    {
        Random random = new Random();

        int hauteur = random.nextInt(15);
        double angle = 0.5 + (1 - 0.5) * random.nextDouble();

        skieur = new Skieur();
    }
}
