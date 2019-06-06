package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    Rectangle screen;


    public Field(int width, int height){

        screen = new Rectangle(0,0,width,height);
        screen.draw();
    }

}
