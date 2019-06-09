package org.academiadecodigo.murlogs.castleinvaders.Menu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.murlogs.castleinvaders.Sound.*;
import org.academiadecodigo.murlogs.castleinvaders.Game;

public class GameOverMenu implements KeyboardHandler {

    private Rectangle screen;
    private Picture gameOverBackground;
    private Picture gameOver;
    private Picture retry;
    private Rectangle selecter;
    private Keyboard keyboard;
    private Sound gameOverSound;
    private boolean gameOverMenuExists;
    private Menu menu;
    private Game game2;

    public GameOverMenu() {

        keyboard = new Keyboard(this);
        prepare();

    }

    public void createGameOverMenu() throws InterruptedException {


        screen = new Rectangle(0, 0, 800, 600);
        gameOverBackground = new Picture(110, 100, "game over background.jpg");
        gameOver = new Picture(90, 115, "game over.png");
        retry = new Picture(240, 280, "continue.png");
        selecter = new Rectangle(355, 385, 90, 40);


        screen.draw();

        gameOverBackground.draw();
        gameOverBackground.grow(110, 175);

        gameOver.draw();
        gameOver.grow(30, 30);

        retry.draw();
        retry.grow(-50, -50);

        selecter.setColor(Color.YELLOW);
        selecter.draw();


        Thread.sleep(1500);
        String filePath = "/game over song.wav";
        gameOverSound = new Sound(filePath);
        gameOverSound.play(true);

        gameOverMenuExists = true;

// game over menu is drawn
// moving on...


    }


    public void deleteGameOverMenu() {
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
                    if(selecter.getY()==385){

                        System.out.println("meter diretamente no jogo - game.start()");
                        return;

                    }
                    deleteGameOverMenu();
                }

        }




    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}