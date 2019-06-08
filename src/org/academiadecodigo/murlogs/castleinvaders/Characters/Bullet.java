package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.GameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet extends GameObjects {

    private int x;
    private int y;
    private Picture bulletImage;

    public Bullet(int x, int y){
        this.x = x;
        this.y = y;
        bulletImage = new Picture(x, y, "arrow.png");
        draw();
    }

    public void draw(){
        bulletImage.draw();
    }

    public void bulletMove () {
        bulletImage.translate(0, 10);
    }

    public int getY (){
        return this.bulletImage.getY();
    }
}
