package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Door;
import org.academiadecodigo.murlogs.castleinvaders.Globals;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Weapon;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BigSkeleton extends Enemy{


    private final int enemySize = 20;
    private int enemyY = enemySize + 490;
    private final int scoreGiven = 20;
    private boolean atDoor;

    // -----------------------------------------------------------------------------------------------------------------
    public BigSkeleton(int hearts, int randomSpawn, int randomX) {
        super(hearts);

        this.setPic(new Picture());
        this.getPic().grow(25, 25);
        this.getPic().draw();

        //spawn enemy right of the field
        if (randomSpawn == 1) {

            this.getPic().load("skeleton_reverse.png");
            this.getPic().translate(randomX + 850, enemyY);
            return;
        }

        //spawn enemy left of the field
        this.getPic().load("skeleton.png");
        this.getPic().translate(-randomX -50, enemyY);
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
        if (getPic().getX() < randomDoorRight) {
            getPic().translate(1, 0);

            if (getPic().getX() == randomDoorRight) {
                atDoor = true;
            }
            return;
        }

        //move left
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

        door.hit(Globals.PUNCH_WEAPON_DAMAGE+5);
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

    public int getEnemySize() {
        return enemySize;
    }

    public int getEnemyX() {
        return getPic().getX();
    }

    public int getEnemyY() {
        return enemyY;
    }

    public int getEnemyWidth() {
        return getPic().getWidth();
    }
}
