package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Destroyable;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Arrow;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EnemyShooter extends Enemy implements Destroyable {

    private Picture goingRightPicture;
    private boolean goingRight;

    private Picture goingLeftPicture;
    private boolean goingLeft;

    private Picture currentPicture;

    // -----------------------------------------------------------------------------------------------------------------
    public EnemyShooter(int hearts, int randomSpawn, int randomX) {
        super(hearts, randomSpawn, randomX);

        goingRightPicture = new Picture();
        goingRightPicture.load("Skeleton Walk.gif");
        goingRightPicture.grow(7, 7);

        goingLeftPicture = new Picture();
        goingLeftPicture.load("skeleton_walk_reverse.png");
        goingLeftPicture.grow(7, 7);


        if (randomSpawn == 1) {

            goingLeftPicture.translate(randomX + 750, 526);
            goingRightPicture.translate(randomX + 750, 526);

            currentPicture = goingLeftPicture;
            currentPicture.draw();

            goingLeft = true;
            return;
        }

        goingLeftPicture.translate(-randomX, 526);
        goingRightPicture.translate(-randomX, 526);

        currentPicture = goingRightPicture;
        currentPicture.draw();

        goingRight = true;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public void move() {

        if (goingRight) {

            movePicturesRight();

            if (currentPicture.getX() == 755) {

                goingRight = false;
                goingLeft = true;

                changeCurrentPicture();
            }
            return;
        }

        movePicturesLeft();

        if (currentPicture.getX() == 20) {

            goingRight = true;
            goingLeft = false;

            changeCurrentPicture();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void changeCurrentPicture() {

        //turn left
        if (goingLeft) {
            goingRightPicture.delete();
            goingLeftPicture.draw();

            currentPicture = goingLeftPicture;
            return;
        }

        //turn right
        goingLeftPicture.delete();
        goingRightPicture.draw();

        currentPicture = goingRightPicture;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void movePicturesRight() {

        goingLeftPicture.translate(1, 0);
        goingRightPicture.translate(1, 0);
    }

    public void movePicturesLeft() {

        goingRightPicture.translate(-1, 0);
        goingLeftPicture.translate(-1, 0);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public void shoot() {

    }

    public Arrow[] canShoot(Arrow[] arrows) {

        for (int i = 0; i < arrows.length; i++) {
            if (arrows[i] == null) {

                int randomShoot = (int) (Math.random() * 500000);

                if (randomShoot < 100) {
                    arrows[i] = new Arrow(currentPicture.getX(), currentPicture.getY());
                    return arrows;
                }
            }

        }

        return arrows;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void setDestroyed() {

        goingRightPicture.delete();
        goingLeftPicture.delete();
        currentPicture.delete();
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public void chooseWeapon(int index) {

    }

    @Override
    public void hit(int hearts) {
        super.hit(hearts);
    }

    public Picture getCurrentPicture() {
        return currentPicture;
    }
}
