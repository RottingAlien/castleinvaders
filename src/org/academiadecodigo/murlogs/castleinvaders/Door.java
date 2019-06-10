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

    Picture door = new Picture(335, 486, "castledoor.png");
    Picture door1 = new Picture(335, 486, "castledoorcrack1.png");
    Picture door2 = new Picture(335, 486, "castledoorcrack2.png");
    Picture door3 = new Picture(335, 486, "castledoorcrack3.png");
    Picture door4 = new Picture(335, 486, "castledoordestroyed.png");


    public Door() {

        this.life = 100;


    }

    public int hit(int damage) {


        if (life > 0) {
            energy -= damage;
            if (energy < 0) {
                life--;
                energy = Globals.MAX_ENERGY * 2;
            }
            if (life < 75) {
                door.delete();
            }
            if (life < 50) {
                door1.delete();
            }
            if (life < 25) {
                door2.delete();

            }
        }
        if (life == 0) {
            door3.delete();
        }
        return 0;
    }

    public boolean isDestroyed() {
        if (life == 0) {
            return true;
        }
        return false;
    }

    public void drawDoor() throws InterruptedException {


        door4.draw();
        door3.draw();
        door2.draw();
        door1.draw();
        door.draw();


    }

    public int getLife() {
        return life;
    }


}

