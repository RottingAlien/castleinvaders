package org.academiadecodigo.murlogs.castleinvaders.Menu;

import org.academiadecodigo.murlogs.castleinvaders.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.murlogs.castleinvaders.Sound.*;


public class GameOverMenu implements KeyboardHandler {

    private Rectangle screen;
    private Picture gameOverBackground;
    private Picture gameOver;
    private Picture retry;
    private Rectangle selecter;
    private Text score;
    private Keyboard keyboard;
    private Sound gameOverSound;
    private boolean gameOverMenuExists;


    private boolean playerContinue = true;

    public GameOverMenu() {

        keyboard = new Keyboard(this);
        prepare();
    }

    public void createGameOverMenu() throws InterruptedException {


        screen = new Rectangle(0, 0, 800, 600);
        gameOverBackground = new Picture(110, 100, "game over background.jpg");
        gameOver = new Picture(90, 115, "game over.png");
        retry = new Picture(325, 255, "retryy.png");
        selecter = new Rectangle(355, 385, 120, 45);
        score = new Text (40, 580, "Score: " + Field.getCurrentScore() );

        screen.draw();

        gameOverBackground.draw();
        gameOverBackground.grow(110, 175);

        gameOver.draw();
        gameOver.grow(70, 70);

        retry.draw();
        retry.grow(0, -30);

        selecter.setColor(Color.YELLOW);
        selecter.draw();

        score.setColor(Color.WHITE);
        score.grow(25,20);
        score.draw();




        Thread.sleep(300);
        String filePath = "/game over song.wav";
        gameOverSound = new Sound(filePath);
        gameOverSound.play(true);

        gameOverMenuExists = true;



// game over menu is drawn
// moving on...


    }


    public void deleteGameOverMenu() throws Exception {
        gameOverSound.stop();
        screen.delete();
        gameOver.delete();
        gameOverBackground.delete();
        retry.delete();
        selecter.delete();

        gameOverMenuExists = false;

    }

    public boolean GameOverMenuExists() {

        return gameOverMenuExists;
    }


    public void prepare() {

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent enter = new KeyboardEvent();
        enter.setKey(KeyboardEvent.KEY_ENTER);
        enter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(enter);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                if (selecter.getY() == 385) {
                    return;
                }
                selecter.translate(0, -50);

                return;

            case KeyboardEvent.KEY_DOWN:
                if (selecter.getY() == 435) {
                    return;
                }
                selecter.translate(0, 50);
                return;


            case KeyboardEvent.KEY_ENTER:
                if (selecter.getY() == 385) {

                    try {
                        deleteGameOverMenu();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    return;

                }

                playerContinue = false;
                try {
                    deleteGameOverMenu();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

        }

    }


    public boolean isPlayerContinue() {
        return playerContinue;
    }


    @Override

    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}