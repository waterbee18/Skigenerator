package guesski.model;

import javafx.scene.shape.Line;

public class Grille extends javafx.scene.Group
{
    private Line lineVert;
    private Line lineHor;

    public Grille(){
        grille();
    }

    private void grille()
    {

        for(int i = 500; i < 1000; i+=50)
        {
            lineVert = new Line();
            lineVert.setStartX(i);
            lineVert.setStartY(0);
            lineVert.setEndX(i);
            lineVert.setEndY(720);
            getChildren().add(lineVert);
        }

        for (int j = 50; j < 700; j+=50)
        {
            lineHor = new Line();
            lineHor.setStartX(500);
            lineHor.setStartY(j);
            lineHor.setEndX(1024);
            lineHor.setEndY(j);
            getChildren().add(lineHor);
        }
    }
}
