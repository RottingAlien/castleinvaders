package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Destroyable;
import org.academiadecodigo.murlogs.castleinvaders.GameObjects;
import org.academiadecodigo.murlogs.castleinvaders.Globals;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Weapon;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.LinkedList;


public abstract class Character extends GameObjects implements Destroyable {

    private int x;
    private int y;
    private int hearts;
    protected LinkedList<Weapon> weapons;
    private Picture pic;

    public Character(int hearts) {
        this.hearts = hearts;
        weapons = new LinkedList<>();
    }



    /**
     *  hit() Method used to receive the shot of enemy or player.
     * @param hearts int refers to weapon strength
     */

    @Override
    public void hit(int hearts) {

        this.hearts -= hearts;


    }

    /**
     *  isDestroyed() exceeds isDead() method
     * @return true if no energy and life
     */
    @Override
    public boolean isDestroyed() { return (hearts <= 0); }

    /**
     * translate() method draws the Character.
     */
    public abstract void move();

    public abstract void shoot();

    public abstract void chooseWeapon(int index);

    public Weapon getWeapon(int idx) { return weapons.get(idx);}

    public void addWeapon(Weapon weapon) { weapons.add(weapon);}

    public Picture getPic() {return pic;}

    public void setPic(Picture pic) {this.pic = pic;}
}


