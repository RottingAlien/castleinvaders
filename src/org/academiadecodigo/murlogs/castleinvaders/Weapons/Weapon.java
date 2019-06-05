package org.academiadecodigo.murlogs.castleinvaders.Weapons;

import org.academiadecodigo.murlogs.castleinvaders.Globals;
import org.academiadecodigo.simplegraphics.graphics.Movable;

public abstract class Weapon implements Movable {

    private double x;
    private double y;
    private int damage;

    public Weapon(int damage) {

        this.damage = (damage > Globals.MAX_WEAPON_DAMAGE)?Globals.MAX_WEAPON_DAMAGE: damage;
    }

    @Override
    public abstract void translate(double v, double v1);

    public abstract void move(int x, int y);

    public double getX() {return x;}

    public double getY() {return y;}
}
