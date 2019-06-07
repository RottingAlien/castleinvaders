package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Globals;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Punch;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.TypeWeapon;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Weapon;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy extends Character {

    private Rectangle shape;

    private Weapon punchWeapon = new Punch(TypeWeapon.PUNCH);

    private final int enemySize = 20;
    private int enemyY = enemySize + 506;



    // -----------------------------------------------------------------------------------------------------------------
    public Enemy() {
        super();

        this.setPic(new Picture());
        this.getPic().load("Skeleton Walk.gif");

        int randomSpawn = (int) (Math.random() * 2);

        int randomX = (int) (Math.random() * 250);

        //spawn a player left or right of the field

        this.getPic().grow(7, 7);

        if (randomSpawn == 1) {

            this.getPic().translate(randomX + 760, enemyY);
            return;
        }

        this.getPic().translate(-randomX, enemyY);


    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public void move(int x, int y) {

        //int randomStop = (int) (Math.random() * 10);

        //keep them moving to the center
        if (getPic().getX() == -10) {
            getPic().draw();
        }
        if (getPic().getX() < 330) {
            getPic().translate(1, 0);
            return;
        }


        if (getPic().getX() == 760) {
            getPic().draw();
        }
        if (getPic().getX() > 380) {
            getPic().translate(-1, 0);
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
