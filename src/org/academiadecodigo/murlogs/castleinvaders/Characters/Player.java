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
    private boolean playerShot;
    private boolean bulletMove;
    private Picture rightPicture;
    private Picture leftPicture;

    public Player(int hearts) {
        super(hearts);

        rightPicture = new Picture(playerPositionX, playerPositionY, "knight-frame3.png");
        leftPicture = new Picture(playerPositionX, playerPositionY, "knight-frame2.png");
        rightPicture.draw();
        super.setPic(rightPicture);

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

        KeyboardEvent spaceReleased = new KeyboardEvent();
        spaceReleased.setKey(KeyboardEvent.KEY_SPACE);
        spaceReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(spaceReleased);
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
                System.out.println("space key pressed");
                playerShot = true;
                break;

            case KeyboardEvent.KEY_RIGHT:
                turnRight = true;
                turnLeft = false;
                break;
            case KeyboardEvent.KEY_LEFT:
                turnLeft = true;
                turnRight = false;
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

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            System.out.println("space key released");
            playerShot = false;
        }
    }


    @Override
    public void move() {
        if (!isDestroyed()) {
            if (turnRight) {
                leftPicture.delete();
                rightPicture.draw();
                refreshPlayerPosition(2, 0);
                return;
            }
            if (turnLeft) {
                rightPicture.delete();
                leftPicture.draw();
                refreshPlayerPosition(-2, 0);
                return;
            }

            refreshPlayerPosition(0, 0);
        }
        if (isDestroyed()) {

            rightPicture.delete();
            leftPicture.delete();
        }

    }

    public void refreshPlayerPosition(int x, int y) {
        leftPicture.translate(x, y);
        rightPicture.translate(x, y);
        playerPositionX += x;
    }

    @Override
    public void shoot() {

        Bullet bullet = new Bullet(playerPositionX, playerPositionY);
        bullet.move(0, 1);

    }

    public Bullet[] bulletShoot(Bullet[] bullets){
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] == null) {
                bullets[i] = new Bullet(leftPicture.getX(), leftPicture.getY());
                bulletMove = true;
                return bullets;
            }
        }
        return bullets;
    }

    @Override
    public void chooseWeapon(int index) {

    }

 /*   public boolean setCanShoot() {
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] == null) {
                if (getBulletShoot()) {
                    bullets[i] = new Bullet(playerPositionX, getPlayerPositionY());
                    return bullets;
                }
            }

        }
        return bullets;
    }*/

    public boolean getPlayerShot(){
        return this.playerShot;
    }

    public int getPlayerPositionY(){
        return playerPositionY;
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }
}
