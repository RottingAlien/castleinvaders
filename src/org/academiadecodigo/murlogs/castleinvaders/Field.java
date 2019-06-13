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
    private Text waves;
    private static int currentScore = 0;
    private static int currentWave = 1;

    public void createField() {

        //Creates "screen area"
        screen = new Rectangle(0, 0, 800, 600);
        screen.draw();

        //Creates Sky
        sky = new Picture(0, 0, "/assets/sky.png");
        sky.draw();

        //Creates Castle
        castle = new Picture(0, 0, "/assets/castle.png");
        castle.draw();

        //Creates Player Door
        playerDoor = new Picture(68, 122, "/assets/playerdoor.png");
        playerDoor.draw();

        vignette = new Picture(0, 0, "/assets/vignette.png");
        //vignette.draw();

        score = new Text(730, 11, ("Score: " + currentScore));
        score.setColor(Color.YELLOW);
        score.grow(10, 10);
        score.draw();

        waves = new Text(380, 11, ("Wave " + currentScore));
        waves.setColor(Color.YELLOW);
        waves.grow(10, 10);
        waves.draw();

        hearts1 = new Picture(10, 10, "/assets/heart.png");
        hearts2 = new Picture(35, 10, "/assets/heart.png");
        hearts3 = new Picture(60, 10, "/assets/heart.png");
        hearts4 = new Picture(85, 10, "/assets/heart.png");
        hearts5 = new Picture(110, 10, "/assets/heart.png");
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


    public void deleteHearts(int heartsNumber) {
        switch (heartsNumber) {
            case 4:
                hearts5.delete();
                break;

            case 3:
                hearts4.delete();
                break;

            case 2:
                hearts3.delete();
                break;

            case 1:
                hearts2.delete();
                break;

            case 0:
                hearts1.delete();
                break;
        }
    }

    public void setCurrentScore(int score) {
        currentScore += score;
        this.score.delete();
        this.score = new Text(730, 11, ("Score: " + currentScore));
        this.score.setColor(Color.YELLOW);
        this.score.grow(10, 10);
        this.score.draw();
    }

    public static int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentWave(int wave) {
        currentWave += wave;
        this.waves.delete();
        this.waves = new Text(380, 11, ("Wave " + currentWave));
        this.waves.setColor(Color.YELLOW);
        this.waves.grow(10, 10);
        this.waves.draw();
    }

    public static int getCurrentWave() {
        return currentWave;
    }

    public void restartPlayerScore() {

        if (currentScore > 0) {
            score.delete();
            currentScore = 0;
            this.score = new Text(730, 11, ("Score: " + currentScore));
            this.score.setColor(Color.YELLOW);
            this.score.grow(10, 10);
            this.score.draw();

        }
    }

    public void restartWaves() {

        if (currentWave > 0) {
            waves.delete();
            currentWave = 1;
            this.waves = new Text(380, 11, ("Wave " + currentWave));
            this.waves.setColor(Color.YELLOW);
            this.waves.grow(10, 10);
            this.waves.draw();

        }
    }

}
