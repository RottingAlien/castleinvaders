package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Weapons.Weapon;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy extends Character{

    public Enemy(int hearts) {
        super(hearts);
    }

    @Override
    public int hit(int hearts) {
        return super.hit(hearts);
    }

    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public void move() {

    }

    @Override
    public void shoot() {

    }

    @Override
    public void chooseWeapon(int index) {

    }

    @Override
    public Weapon getWeapon(int idx) {
        return super.getWeapon(idx);
    }

    @Override
    public void addWeapon(Weapon weapon) {
        super.addWeapon(weapon);
    }

    @Override
    public Picture getPic() {
        return super.getPic();
    }

    @Override
    public void setDestroyed() {
        super.setDestroyed();
    }

    @Override
    public void setPic(Picture pic) {
        super.setPic(pic);
    }

    @Override
    public int getHearts() {
        return super.getHearts();
    }
}
