package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Destroyable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EnemyShooter extends Enemy implements Destroyable {

    private boolean goingLeft;

    private Picture goingRightPicture;
    private Picture goingLeftPicture;

    private Picture currentPicture;

    // -----------------------------------------------------------------------------------------------------------------
    public EnemyShooter() {
        super();

        goingRightPicture = new Picture();
        goingRightPicture.load("Skeleton Walk.gif");
        goingRightPicture.grow(7, 7);

        goingLeftPicture = new Picture();
        goingLeftPicture.load("skeleton_walk_reverse.png");
        goingLeftPicture.grow(7, 7);

        int randomSpawn = (int) (Math.random() * 2);

        int randomX = (int) (Math.random() * 250);

        goingLeftPicture.translate(randomX + 750, 526);
        goingRightPicture.translate(-randomX, 526);

        if (randomSpawn == 1) {
            currentPicture = goingLeftPicture;
            currentPicture.draw();

            goingLeft = true;
            return;
        }

        currentPicture = goingRightPicture;
        currentPicture.draw();
    }

    // -----------------------------------------------------------------------------------------------------------------

    //TODO: change pictures left to right
    @Override
    public void move() {

        if (!goingLeft) {

            currentPicture.translate(1, 0);

            if (currentPicture.getX() == 755) {

                currentPicture = cleanCurrentPicture(currentPicture);
                goingLeft = true;
            }
            return;
        }

        currentPicture.translate(-1, 0);

        if (currentPicture.getX() == 20) {

            currentPicture = cleanCurrentPicture(currentPicture);
            goingLeft = false;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    public Picture cleanCurrentPicture(Picture picture) {

        if (goingLeft) {

            picture.delete();
            picture.translate(735, 0);

            currentPicture = goingRightPicture;
            currentPicture.draw();

            return currentPicture;
        }

        picture.delete();
        picture.translate(-735, 0);

        currentPicture = goingLeftPicture;
        currentPicture.draw();

        return currentPicture;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public void shoot() {

    }

    @Override
    public void chooseWeapon(int index) {

    }

    public Picture getCurrentPicture() {
        return currentPicture;
    }
}
