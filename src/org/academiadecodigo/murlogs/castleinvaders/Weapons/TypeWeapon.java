package org.academiadecodigo.murlogs.castleinvaders.Weapons;

import org.academiadecodigo.murlogs.castleinvaders.Globals;

public enum TypeWeapon {
    FIRE(Globals.FIRE_WEAPON_DAMAGE),
    OIL(Globals.OIL_WEAPON_DAMAGE),
    ROCK(Globals.ROCK_WEAPON_DAMAGE),
    BARREL(Globals.BARREL_WEAPON_DAMAGE);

    private final int damage;

    TypeWeapon(int damage) {
        this.damage = damage;
    }

    /**
     * Method getDamage()
     *
     * @return theweapon's power
     */

    public int getDamage() {
        return damage;
    }
}
