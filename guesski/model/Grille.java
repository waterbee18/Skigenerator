package guesski.model;

import javafx.scene.paint.Color;
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
        for(int i = 500; i < 1250; i+=50){
            lineVert = new Line();
            lineVert.setStartX(i);
            lineVert.setStartY(0);
            lineVert.setEndX(i);
            lineVert.setEndY(650);
            lineVert.setStrokeWidth(1);
            lineVert.setStroke(Color.GRAY);
            getChildren().add(lineVert);
    }
        for (int j = 0; j < 700; j+=50){
            lineHor = new Line();
            lineHor.setStartX(500);
            lineHor.setStartY(j);
            lineHor.setEndX(1200);
            lineHor.setEndY(j);
            lineHor.setStrokeWidth(1);
            lineHor.setStroke(Color.GRAY);
            getChildren().add(lineHor);
        }


    }
}
