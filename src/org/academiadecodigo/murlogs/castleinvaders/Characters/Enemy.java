package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Enemy extends Character {

    private Rectangle rectangle;

    public Enemy() {
        super();
        this.rectangle = new Rectangle(0, 800, 20, 20);
    }

    @Override
    public void chooseWeapon(int index) {

    }

    @Override
    public void shoot() {

    }


    public void show() {
        rectangle.draw();
    }

    @Override
    public void move() {

    }

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void translate(double v, double v1) {

    }
}
