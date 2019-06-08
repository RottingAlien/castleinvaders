package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.GameObjects;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.TypeWeapon;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Weapon;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet extends Weapon {

    private int x;
    private int y;
    private Picture bulletImage;

    public Bullet(int x, int y){
        super("arrow.png", TypeWeapon.ARROW);

    }



    @Override
    public void move(int x, int y) {
        getPic().translate(0, -1);
    }
}
