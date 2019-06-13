package org.academiadecodigo.murlogs.castleinvaders.Weapons;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Crate {

    private int crateX;
    private int crateY;
    private Picture crateImage;
    private boolean isDeployed;

    public int randomDrop(int min,int max){
        return (int) (Math.random() * ((max - min) +1 ) - min);
    }

    public Crate() {

        crateImage = new Picture();
        crateImage.load("/assets/spellbook.png");
        crateImage.translate(randomDrop(100,700), -20);
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
        int cratX = crateImage.getX();
        crateImage.translate(-cratX,-200);
        crateY -= 200;
        crateImage.translate(randomDrop(100,700),0);
        crateImage.draw();
    }
}
