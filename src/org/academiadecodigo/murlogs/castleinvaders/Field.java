package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    private Rectangle screen;
    private Picture castle;
    private Picture sky;
    private Picture playerDoor;
    private Picture castleDoor;
    private Picture vignette;


    public Field(){

        //Creates "screen area"
        screen = new Rectangle(0,0,800,600);
        screen.draw();

        //Creates Sky
        sky = new Picture(0,0,"sky.png");
        sky.draw();

        //Creates Castle
        castle = new Picture(0,0,"castle.png");
        castle.draw();

        //Creates Player Door
        playerDoor = new Picture(68,122,"playerdoor.png");
        playerDoor.draw();

        //Creates Castle Door
        castleDoor = new Picture(335,486,"castledoor.png");
        castleDoor.draw();

        //Creates "vignette" to hide enemy spawn"
        vignette = new Picture(0,0,"vignette.png");
        vignette.draw();





    }

}
