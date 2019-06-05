package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Destroyable;
import org.academiadecodigo.murlogs.castleinvaders.Globals;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Weapon;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.LinkedList;


public abstract class Character implements Movable, Destroyable {

    private int x;
    private int y;
    private int energy;
    private int life;
    protected LinkedList<Weapon> weapons;
    private Picture pic;

    public Character() {

        this.life = Globals.MAX_LIVES;
        this.energy = Globals.MAX_ENERGY;

        weapons = new LinkedList<Weapon>();
    }

    public abstract void move();

    /**
     *  hit() Method used to receive the shot of enemy or player.
     * @param intensity int refers to weapon strength
     */

    @Override
    public void hit(int intensity) {

        this.energy -= intensity;

        if (this.energy<=0){
            life--;
        }

    }

    /**
     *  isDestroyed() exceeds isDead() method
     * @return true if no energy and life
     */
    @Override
    public boolean isDestroyed() { return (energy <= 0 && life <= 0); }

    /**
     * translate() method draws the Character.
     * @param v double receives x value
     * @param v1 double receives y value
     */
    @Override
    public abstract void translate(double v, double v1);

    public abstract void shoot();

    public abstract void chooseWeapon(int index);

    /**
     * mode() Method must be mapped to double to use on translate() method
     * @param x int x value
     * @param y int y value
     */
    public abstract void move(int x, int y);


    public Weapon getWeapon(int idx) { return weapons.get(idx);}

    public void addWeapon(Weapon weapon) { weapons.add(weapon);}

    public Picture getPic() {return pic;}

    public void setPic(Picture pic) {this.pic = pic;}
}
