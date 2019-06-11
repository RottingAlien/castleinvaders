package org.academiadecodigo.murlogs.castleinvaders.Weapons;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Crate {

    private int crateX;
    private int crateY;
    private Picture crateImage;
    private boolean isDeployed;

    public Crate() {

        crateImage = new Picture();
        crateImage.load("crate.png");
        crateImage.translate(600, -20);
        crateImage.draw();
    }

    public void move(int x, int y) {

        if (this.crateY < 200) {
            crateImage.translate(x, y);
            crateImage.draw();
            this.crateX += x;
            this.crateY += y;
        }
    }

    public void deploy() {
        isDeployed = true;
    }

    public boolean isDeployed() {
        return isDeployed;
    }

    public int getCrateY() {
        return crateImage.getY();
    }

    public int getCrateX() {
        return crateImage.getX();
    }

    public int getCrateWidth() {
        return crateImage.getWidth();
    }

    public void setReadyToDeploy() {
        isDeployed = false;
        crateImage.delete();
        crateImage.translate(0,-200);
        crateY -= 200;
        crateImage.draw();
    }
}
