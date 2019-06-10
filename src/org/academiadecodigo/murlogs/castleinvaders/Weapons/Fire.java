package org.academiadecodigo.murlogs.castleinvaders.Weapons;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Fire extends Weapon {

    private int fireX;
    private int fireY;

    private Picture rightFire;
    private Picture leftFire;

    private Picture fireImage;
    private boolean fireDestroyed;

    public Fire(int x, int y) {

        super("fireBall.png", TypeWeapon.FIRE);
        super.setPic("fireBall.png");

        this.fireX = x;
        this.fireY = y;

        fireImage = getPic();
        fireImage.draw();
        fireImage.translate(x, y);
    }

    public Fire(int x, int y, String path) {

        fireX = x;
        fireY = y;

        fireImage = new Picture();
        fireImage.load(path);
        fireImage.draw();
        fireImage.translate(x, y);

    }

    @Override
    public void move(int x, int y) {

        if (rightFire != null && rightFire.getX() < 820) {
            rightFire.translate(5, 0);
        }
        if (leftFire != null && leftFire.getX() > -20) {
            leftFire.translate(-5, 0);
            return;
        }

        if (fireY > 540 && !fireDestroyed) {

            fireDestroyed = true;
            fireImage.delete();
            fireImage.translate(1000, 1000);

            rightFire = new Picture();
            rightFire.load("fireBallRight.png");
            rightFire.translate(fireX, fireY);
            rightFire.draw();

            leftFire = new Picture();
            leftFire.load("fireBallLeft.png");
            leftFire.translate(fireX, fireY);
            leftFire.draw();

            return;
        }

        fireImage.translate(x, y);
        fireX += x;
        fireY += y;
    }

    public void destroyedFire() {
        fireImage.delete();
        fireDestroyed = true;
    }

    public int getFireX() {
        return fireX;
    }
}
