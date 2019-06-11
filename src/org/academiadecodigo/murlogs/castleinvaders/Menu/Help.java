package org.academiadecodigo.murlogs.castleinvaders.Menu;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Help {

    private Rectangle screen;
    private Picture keywords;

    private Picture instructionsBackground;



    private boolean helpIsCreated;

    public void createHelpSection() {





        screen = new Rectangle(0, 0, 800, 600);

        screen.draw();
        screen.setColor(Color.LIGHT_GRAY);
        screen.fill();

        keywords = new Picture(25, 60, "game keys.png");
        instructionsBackground = new Picture(70, 100, "menu instructions.png");

        keywords.grow(-80,-80);


        screen.draw();

        instructionsBackground.draw();
        instructionsBackground.grow(85, 180);


        keywords.draw();

        helpIsCreated = true;


    }

    public void deleteHelpSection() {
        screen.delete();
        keywords.delete();
        instructionsBackground.delete();
        helpIsCreated = false;
    }

    public boolean helpIsCreated() {
        return helpIsCreated;
    }



}
