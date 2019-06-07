package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Globals;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Punch;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.TypeWeapon;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Weapon;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Enemy extends Character {

    private Rectangle shape;

    private Weapon punchWeapon = new Punch(TypeWeapon.PUNCH);

    private final int enemySize = 20;
    private int enemyY = 380;


    // -----------------------------------------------------------------------------------------------------------------
    public Enemy() {
        super();

        int randomSpawn = (int) (Math.random() * 2);

        int randomX = (int) (Math.random() * 250);

        //spawn a player left or right of the field
        if (randomSpawn == 1) {

            this.shape = new Rectangle(-randomX, enemyY, enemySize, enemySize);
            return;
        }

        this.shape = new Rectangle(800 + randomX, enemyY, enemySize, enemySize);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public void move(int x, int y) {

        //int randomStop = (int) (Math.random() * 10);

        //keep them moving to the center
        if (shape.getX() == -10) {
            shape.draw();
        }
        if (shape.getX() < 380) {
            shape.translate(1, 0);
            return;
        }


        if (shape.getX() == 780) {
            shape.draw();
        }
        if (shape.getX() > 420) {
            shape.translate(-1, 0);
        }

    }

    @Override
    public void chooseWeapon(int index) {

    }

    @Override
    public void shoot() {

    }

    /*
    //punch the door
    public void puchDoor(Door door) {

        door.hit(Globals.PUNCH_WEAPON_DAMAGE);
    }*/

    @Override
    public void addWeapon(Weapon weapon) {
        super.addWeapon(weapon);
    }

    @Override
    public void hit(int intensity) {
        super.hit(intensity);
    }


}
