package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    Rectangle screen;
    Picture castle;
    Rectangle sky;


    public Field(){


        screen = new Rectangle(0,0,800,600);
        screen.draw();

        sky = new Rectangle(0,0,800,600);
        sky.setColor(new Color(150,150,200));
        sky.fill();


        castle = new Picture(0,0,"castletest.jpg");
        castle.draw();





    }

}
