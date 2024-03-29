package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Weapons.Fire;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player extends Character implements KeyboardHandler {

    private Keyboard keyboard;
    private int playerPositionX = 78;
    private final int playerPositionY = 154;
    private boolean turnRight;
    private boolean turnLeft;
    private Picture rightPicture;
    private Picture leftPicture;
    private Picture rightFirePicture;
    private Picture leftFirePicture;
    private Picture currentPicture;
    private Bullet bullet;
    private boolean bulletExists;
    private boolean cratePicked;
    private Fire fire;


    private boolean shoot = false;
    private boolean special = false;

    public Player(int hearts) {
        super(hearts);

        rightFirePicture = new Picture(playerPositionX, playerPositionY, "/assets/wizardRightRed.png");
        leftFirePicture = new Picture(playerPositionX, playerPositionY, "/assets/wizardLeftRed.png");

        rightPicture = new Picture(playerPositionX, playerPositionY, "/assets/wizardRight.png");
        leftPicture = new Picture(playerPositionX, playerPositionY, "/assets/wizardLeft.png");
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

        KeyboardEvent b = new KeyboardEvent();
        b.setKey(KeyboardEvent.KEY_B);
        b.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftReleased = new KeyboardEvent();
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent rightReleased = new KeyboardEvent();
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent spaceReleased = new KeyboardEvent();
        spaceReleased.setKey(KeyboardEvent.KEY_SPACE);
        spaceReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent bReleased = new KeyboardEvent();
        bReleased.setKey(KeyboardEvent.KEY_B);
        bReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(spaceReleased);
        keyboard.addEventListener(rightReleased);
        keyboard.addEventListener(leftReleased);
        keyboard.addEventListener(bReleased);
        keyboard.addEventListener(space);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(b);

    }

    // Pressing keys to move;

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                //playerShooting();
                shoot = true;
                break;

            case KeyboardEvent.KEY_RIGHT:
                turnRight = true;
                turnLeft = false;
                break;
            case KeyboardEvent.KEY_LEFT:
                turnLeft = true;
                turnRight = false;
                break;
            case KeyboardEvent.KEY_B:
                //specialShoot();
                special = true;
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

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_B:
                special = false;
                break;
            case KeyboardEvent.KEY_SPACE:
                shoot = false;
                break;
        }
    }


    @Override
    public void move() {

        if (shoot) {
            playerShooting();
        }

        if (special) {
            specialShoot();
        }

        if (!isDestroyed()) {


            if (turnRight && rightPicture.getX() < 760) {
                goingRight();
                refreshPlayerPosition(2, 0);
                return;
            }
            if (turnLeft && leftPicture.getX() > 0) {
                goingLeft();

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
        leftFirePicture.translate(x,y);
        rightFirePicture.translate(x,y);
        playerPositionX += x;
    }

    @Override
    public void shoot() {
    }

    public void playerShooting() {
        if (bulletExists) {
            return;
        }
        if (!isDestroyed()) {
            bullet = new Bullet(playerPositionX + (rightPicture.getWidth() / 2), playerPositionY + (rightPicture.getHeight() / 2));
            bulletExists = true;
        }
    }

    public void specialShoot() {
        if (cratePicked) {
            fire = new Fire(playerPositionX + (rightPicture.getWidth() / 2), playerPositionY + (rightPicture.getHeight() / 2));
            cratePicked = false;

            if(currentPicture == leftFirePicture){
                leftFirePicture.delete();
                leftPicture.draw();
                return;
            }

            rightFirePicture.delete();
            rightPicture.draw();
        }

    }

    @Override
    public void chooseWeapon(int index) {

    }

    public void destroyBullet() {
        bulletExists = false;
        bullet = null;
    }

    public int getPlayerPositionY() {
        return playerPositionY;
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public int getPlayerHeight() {
        return rightPicture.getHeight();
    }

    public int getPlayerWidth() {
        return rightPicture.getWidth();
    }


    public Bullet getBullet() {
        return bullet;
    }

    public void setCratePicked() {
        cratePicked = true;
    }

    public boolean isCratePicked() {
        return cratePicked;
    }

    public Fire getFire() {
        return fire;
    }

    public boolean isShoot() {
        return shoot;
    }

    public boolean isSpecial() {
        return special;
    }
    public void goingLeft(){
        if(!cratePicked) {
            rightPicture.delete();
            leftPicture.draw();
            currentPicture = leftPicture;
            rightFirePicture.delete();
            leftFirePicture.delete();
            return;
        }
        leftFirePicture.draw();
        currentPicture = leftFirePicture;
        rightFirePicture.delete();
        rightPicture.delete();
        leftPicture.delete();
    }
    public void goingRight(){
        if(!cratePicked) {
            rightPicture.draw();
            currentPicture = rightPicture;
            leftPicture.delete();
            rightFirePicture.delete();
            leftFirePicture.delete();
            return;
        }
        rightFirePicture.draw();
        currentPicture = rightFirePicture;
        leftFirePicture.delete();
        rightPicture.delete();
        leftPicture.delete();
    }
}

