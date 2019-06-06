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

public class Door implements Destroyable {

    private int energy;
    private int life;

    public Door() {

        this.energy = Globals.MAX_ENERGY * 2;
        this.life = 3;


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

    public void test() throws InterruptedException {

        Rectangle rect = new Rectangle(10, 10, 900, 800);

        rect.setColor(Color.DARK_GRAY);
        rect.fill();

        Picture picture = new Picture(350,100, "http://www.castlesandmanorhouses.com/castles/pics/door.jpg");
        picture.grow(-70, -70);

        picture.draw();





    }


}

