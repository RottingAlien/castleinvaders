package org.academiadecodigo.murlogs.castleinvaders.Weapons;

import org.academiadecodigo.murlogs.castleinvaders.GameObjects;
import org.academiadecodigo.murlogs.castleinvaders.Globals;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;



public abstract class Weapon extends GameObjects {


    private double x;
    private double y;
    private Picture pic;
    private TypeWeapon typeWeapon;


    public Weapon(String path, TypeWeapon type) {
        this.pic = new Picture();
        pic.load(path.trim());
        this.typeWeapon = type;
    }


    //constructor test for enemy
    public Weapon(TypeWeapon type) {
        this.typeWeapon = type;
    }

    public void setPic(String path){pic.load(path.trim());}


    public abstract void move(int x, int y);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public TypeWeapon getTypeWeapon() {
        return typeWeapon;
    }

    public void setTypeWeapon(TypeWeapon typeWeapon) {
        this.typeWeapon = typeWeapon;
    }


// alterações do Miguel a partir daqui.


   /* public void shoot(Enemy enemy){
        enemy.hit();

    } */
}
