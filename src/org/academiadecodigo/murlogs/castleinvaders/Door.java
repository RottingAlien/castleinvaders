package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

// criei esta classe para dar o metodo getHit


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Door extends GameObjects implements Destroyable {

    private int energy;
    private int life;

    public Door() {

        this.life = 100;


    }

    public void hit(int damage) {


        if (life > 0) {
            energy -= damage;
            if (energy < 0) {
                life--;
                energy = Globals.MAX_ENERGY * 2;
            }
        }


    }

    public boolean isDestroyed() {
        if (life == 0) {
            return true;
        }
        return false;
    }

    public void drawDoor() throws InterruptedException {

        Picture picture = new Picture(335, 486, "castledoor.png");

        picture.draw();


    }

    public int getLife(){
        return life;
    }


}

