package org.academiadecodigo.murlogs.castleinvaders.Weapons;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Fire extends Weapon {

    private int fireX;
    private int fireY;

    private Picture fireImage;
    private boolean fireDestroyed;

    public Fire(int x, int y) {

        super("fireBall.png", TypeWeapon.FIRE);
        super.setPic("fireBall.png");

        this.fireX = x;
        this.fireY = y;

        fireImage = getPic();
        fireImage.draw();
        fireImage.translate(x,y);
    }

    @Override
    public void move(int x, int y) {
        if (this.fireY < 550) {
            fireImage.translate(x,y);
            this.fireX += x;
            this.fireY += y;
        }
    }

    public void destroyedFire() {
        fireImage.delete();
        fireDestroyed = true;
    }
}
