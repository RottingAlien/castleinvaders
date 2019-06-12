package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Destroyable;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Arrow;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EnemyRunner extends DoorEnemy implements Destroyable {

    private Picture goingRightPicture;
    private boolean goingRight;

    private Picture goingLeftPicture;
    private boolean goingLeft;

    private Picture currentPicture;
    private boolean destroyed;


    private final int scoreGiven = 15;

    // -----------------------------------------------------------------------------------------------------------------
    public EnemyRunner(int hearts, int randomSpawn, int randomX) {
        super(hearts, randomSpawn, randomX);

        this.setPic(new Picture());
        this.getPic().grow(7, 7);

        goingRightPicture = new Picture();
        goingRightPicture.load("skeletonRunnerRight.png");
        goingRightPicture.grow(7, 7);

        goingLeftPicture = new Picture();
        goingLeftPicture.load("skeletonRunnerLeft.png");
        goingLeftPicture.grow(7, 7);


        if (randomSpawn == 1) {

            goingLeftPicture.translate(randomX + 850, 526);
            goingRightPicture.translate(randomX + 850, 526);

            currentPicture = goingLeftPicture;
            currentPicture.draw();
            setPic(currentPicture);
            goingLeft = true;
            return;
        }

        goingLeftPicture.translate(-randomX - 50, 526);
        goingRightPicture.translate(-randomX - 50, 526);

        currentPicture = goingRightPicture;
        currentPicture.draw();
        setPic(currentPicture);
        goingRight = true;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public void move() {
        if (!destroyed) {
            if (goingRight) {

                movePicturesRight();
                super.setAtDoor(false);

                if (currentPicture.getX() >= 320 && currentPicture.getX() <= 380) {
                    super.setAtDoor(true);
                }

                if (currentPicture.getX() >= 755) {

                    goingRight = false;
                    goingLeft = true;

                    changeCurrentPicture();
                }
                return;
            }

            movePicturesLeft();
            super.setAtDoor(false);
            if (currentPicture.getX() >= 320 && currentPicture.getX() <= 380) {
                super.setAtDoor(true);
            }
            if (currentPicture.getX() <= 20) {

                goingRight = true;
                goingLeft = false;

                changeCurrentPicture();
            }
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

        goingLeftPicture.translate(3, 0);
        goingRightPicture.translate(3, 0);
    }

    public void movePicturesLeft() {

        goingRightPicture.translate(-3, 0);
        goingLeftPicture.translate(-3, 0);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public void shoot() {
    }
    // -----------------------------------------------------------------------------------------------------------------

    public void setDestroyed() {
        destroyed = true;
        goingRightPicture.delete();
        goingLeftPicture.delete();
        currentPicture.delete();
        goingRightPicture.translate(1000, 1000);
        goingLeftPicture.translate(1000, 1000);
        currentPicture.translate(1000, 1000);
    }

    // -----------------------------------------------------------------------------------------------------------------


    @Override
    public void chooseWeapon(int index) {

    }

    @Override
    public int hit(int hearts) {
        super.hit(hearts);
        return scoreGiven;
    }

    public Picture getCurrentPicture() {
        return currentPicture;
    }

}
