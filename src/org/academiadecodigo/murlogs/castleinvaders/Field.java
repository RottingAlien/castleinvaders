package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    Rectangle screen;
    Picture castle;
    Picture sky;
    Picture playerDoor;
    Picture castleDoor;
    Picture vignette;


    public Field(){


        screen = new Rectangle(0,0,800,600);
        screen.draw();

        sky = new Picture(0,0,"sky.png");
        sky.draw();


        castle = new Picture(0,0,"castle.png");
        castle.draw();

        playerDoor = new Picture(68,122,"playerdoor.png");
        playerDoor.draw();

        castleDoor = new Picture(335,486,"castledoor.png");
        castleDoor.draw();

        vignette = new Picture(0,0,"vignette.png");
        vignette.draw();





    }

}
