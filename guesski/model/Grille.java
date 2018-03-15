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

            lineVert = new Line();
            lineVert.setStartX(500);
            lineVert.setStartY(0);
            lineVert.setEndX(500);
            lineVert.setEndY(650);
            lineVert.setStrokeWidth(5);
            getChildren().add(lineVert);


            lineHor = new Line();
            lineHor.setStartX(500);
            lineHor.setStartY(650);
            lineHor.setEndX(1024);
            lineHor.setEndY(650);
            lineHor.setStrokeWidth(5);
            getChildren().add(lineHor);

    }
}
