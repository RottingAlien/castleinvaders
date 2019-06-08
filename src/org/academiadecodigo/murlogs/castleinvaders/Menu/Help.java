package org.academiadecodigo.murlogs.castleinvaders.Menu;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Help {

    private Rectangle screen;
    private Picture keywords;
    private boolean helpIsCreated;

    public void createHelpSection() {


        screen = new Rectangle(0, 0, 800, 600);
        keywords = new Picture(70, 180, "instructions.png");


        screen.draw();
        screen.setColor(Color.LIGHT_GRAY);
        screen.fill();

        keywords.draw();

        helpIsCreated = true;

    }

    public void deleteHelpSection() {
        screen.delete();
        keywords.delete();
        helpIsCreated = false;
    }

    public boolean helpIsCreated() {
        return helpIsCreated;
    }
}
