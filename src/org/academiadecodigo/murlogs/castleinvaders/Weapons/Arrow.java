package org.academiadecodigo.murlogs.castleinvaders.Weapons;

import java.util.ConcurrentModificationException;

public class Arrow extends Weapon {

    public double arrowX;
    public double arrowY;
    public boolean hit;

    public Arrow(int x, int y) {
        super("arrow-enemy.png", TypeWeapon.ARROW);
        this.arrowX = x;
        this.arrowY = y;
        getPic().translate(x, y);
        getPic().draw();
        //ConcurrentModificationException
    }

    @Override
    public void move(int x, int y) {
        if (!hit) {
            getPic().translate(0, -1);
            this.arrowY -= 1;
        }
    }

    public double getArrowY(){
        return arrowY;
    }

    public double getArrowX(){
        return arrowX;
    }

    public void setHit(boolean hit){
        this.hit = hit;
    }
}
