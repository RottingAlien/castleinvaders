package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player extends Character implements KeyboardHandler {

    private Keyboard keyboard;
    private int playerPositionX = 60;
    private final int playerPositionY = 120;
    private boolean turnRight;
    private boolean turnLeft;
    private Picture rightPicture;
    private Picture leftPicture;

    public Player() {
        super();

        rightPicture = new Picture(playerPositionX, playerPositionY, "knight-frame3.png");
        leftPicture = new Picture(playerPositionX, playerPositionY, "knight-frame2.png");
        rightPicture.draw();
/*
        this.setPic(new Picture());
        this.getPic().load("knight-frame2.png");
        this.getPic().load("knight-frame3.png");
        this.getPic().draw();
        this.getPic().translate(playerPositionX , playerPositionY);
*/
        // prepare method;
        keyboard = new Keyboard(this);
        prepare();

    }


    //Prepare the keyboard.

    public void prepare() {
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftReleased = new KeyboardEvent();
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent rightReleased = new KeyboardEvent();
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(rightReleased);
        keyboard.addEventListener(leftReleased);
        keyboard.addEventListener(space);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);

    }

    // Pressing keys to move;

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                break;

            case KeyboardEvent.KEY_RIGHT:
                turnRight = true;
                turnLeft = false;
                leftPicture.delete();
                rightPicture.draw();
                break;
            case KeyboardEvent.KEY_LEFT:
                turnLeft = true;
                turnRight = false;
                rightPicture.delete();
                leftPicture.draw();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            turnLeft = false;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            turnRight = false;

        }
    }


    @Override
    public void move() {

        if (turnRight) {
            leftPicture.translate(2, 0);
            rightPicture.translate(2, 0);
            return;
        }
        if (turnLeft) {
            rightPicture.translate(-2, 0);
            leftPicture.translate(-2, 0);
            return;
        }
        rightPicture.translate(0, 0);
        leftPicture.translate(0, 0);


    }

    @Override
    public void shoot() {

    }

    @Override
    public void chooseWeapon(int index) {

    }
}
