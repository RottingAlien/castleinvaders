package org.academiadecodigo.murlogs.castleinvaders.Weapons;

public class Arrow extends Weapon {


    public Arrow(int x, int y) {
        super("arrow-enemy.png", TypeWeapon.ARROW);

        getPic().translate(x, y);
        getPic().draw();
    }

    @Override
    public void move(int x, int y) {

        getPic().translate(0, -1);
    }
}
