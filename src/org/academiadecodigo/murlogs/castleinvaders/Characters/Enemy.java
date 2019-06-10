package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Door;
import org.academiadecodigo.murlogs.castleinvaders.Globals;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Weapon;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy extends Character {


    private final int enemySize = 20;
    private int enemyY = enemySize + 506;
    private final int scoreGiven = 5;
    private boolean atDoor;

    // -----------------------------------------------------------------------------------------------------------------
    public Enemy(int hearts, int randomSpawn, int randomX) {
        super(hearts);

        this.setPic(new Picture());
        this.getPic().grow(7, 7);

        //spawn enemy right of the field
        if (randomSpawn == 1) {

            this.getPic().load("skeleton_walk_reverse.png");
            this.getPic().translate(randomX + 760, enemyY);
            return;
        }

        //spawn enemy left of the field
        this.getPic().load("Skeleton Walk.gif");
        this.getPic().translate(-randomX, enemyY);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private int generateRandom(int min, int max){
        return ((int) (Math.random() * (max - min + 1)) + min);
    }

    int randomDoorRight = generateRandom(340,310);
    int randomDoorLeft = generateRandom(370,340);

    @Override
    public void move() {

        //keep them moving to the center

        //move right
        if (getPic().getX() == -10) {
            getPic().draw();
        }
        if (getPic().getX() < randomDoorRight) {
            getPic().translate(1, 0);

            if (getPic().getX() == randomDoorRight) {
                atDoor = true;
            }
            return;
        }

        //move left
        if (getPic().getX() == 760) {
            getPic().draw();
        }
        if (getPic().getX() > randomDoorLeft) {
            getPic().translate(-1, 0);

            if (getPic().getX() == randomDoorLeft) {
                atDoor = true;
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void setDestroyed() {

        this.getPic().delete();
        this.getPic().translate(1000, 1000);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public void chooseWeapon(int index) {

    }

    @Override
    public void shoot() {

    }

    public void punchDoor(Door door) {

        door.hit(Globals.PUNCH_WEAPON_DAMAGE);
    }

    @Override
    public void addWeapon(Weapon weapon) {
        super.addWeapon(weapon);
    }

    @Override
    public int hit(int hearts) {
        super.hit(hearts);
        return scoreGiven;
    }

    public boolean isAtDoor() {
        return atDoor;
    }
}
