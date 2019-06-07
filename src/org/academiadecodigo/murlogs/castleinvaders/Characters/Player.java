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

    public Player() {
        super();

        this.setPic(new Picture());
        this.getPic().load("knight-frame3.png");
        this.getPic().draw();
        this.getPic().translate(playerPositionX , playerPositionY);

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
                this.getPic().load(("knight-frame3.png"));
                move(10,0);
                break;
            case KeyboardEvent.KEY_LEFT:
                this.getPic().load(("knight-frame2.png"));
                move(-10, 0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    @Override
    public void move(int x, int y) {
        Picture picture = getPic();
        picture.translate(x, y);
        picture.draw();
    }

    @Override
    public void shoot() {

    }

    @Override
    public void chooseWeapon(int index) {

    }
}
