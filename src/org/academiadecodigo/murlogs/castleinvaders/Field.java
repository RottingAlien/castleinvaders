package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    private Rectangle screen;
    private Picture castle;
    private Picture sky;
    private Picture playerDoor;
    private Picture castleDoor;
    private Picture vignette;

    private Picture hearts1;
    private Picture hearts2;
    private Picture hearts3;
    private Picture hearts4;
    private Picture hearts5;
    private Text score;


    public void createField() {

        //Creates "screen area"
        screen = new Rectangle(0, 0, 800, 600);
        screen.draw();

        //Creates Sky
        sky = new Picture(0, 0, "sky.png");
        sky.draw();

        //Creates Castle
        castle = new Picture(0, 0, "castle.png");
        castle.draw();

        //Creates Player Door
        playerDoor = new Picture(68, 122, "playerdoor.png");
        playerDoor.draw();

        vignette = new Picture(0, 0, "vignette.png");
        vignette.draw();

        score = new Text(730, 11, "Score: ");
        score.setColor(Color.YELLOW);
        score.grow(10, 10);
        score.draw();

        hearts1 = new Picture(10, 10, "heart.png");
        hearts2 = new Picture(35, 10, "heart.png");
        hearts3 = new Picture(60, 10, "heart.png");
        hearts4 = new Picture(85, 10, "heart.png");
        hearts5 = new Picture(110, 10, "heart.png");
        hearts1.draw();
        hearts2.draw();
        hearts3.draw();
        hearts4.draw();
        hearts5.draw();


    }

    public void drawVignette() {
        //Creates "vignette" to hide enemy spawn"
        vignette.delete();
        vignette.draw();
    }

    public Picture getHearts1() {
        return hearts1;
    }

    public Picture getHearts2() {
        return hearts2;
    }

    public Picture getHearts3() {
        return hearts3;
    }

    public Picture getHearts4() {
        return hearts4;
    }

    public Picture getHearts5() {
        return hearts5;
    }

}
