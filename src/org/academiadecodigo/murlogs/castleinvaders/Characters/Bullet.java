package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Weapons.TypeWeapon;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Weapon;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet extends Weapon {

    private int x;
    private int y;
    private Picture bulletImage;

    public Bullet(int x, int y){
        super("arrow.png", TypeWeapon.ARROW);
        super.setPic("arrow.png");
        bulletImage = getPic();
        getPic().draw();
        getPic().translate(x, y);

    }
    @Override
    public void move(int x, int y) {
        getPic().translate(x, y);
    }
}
