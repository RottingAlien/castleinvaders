package org.academiadecodigo.murlogs.castleinvaders.Characters;

import org.academiadecodigo.murlogs.castleinvaders.Weapons.TypeWeapon;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Weapon;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet extends Weapon {

    private int x;
    private int y;
    private Picture bulletImage;
    private boolean bulletDestroyed;

    public Bullet(int x, int y) {
        super("arrow.png", TypeWeapon.ARROW);
        super.setPic("arrow.png");
        this.x = x;
        this.y = y;
        bulletImage = getPic();
        bulletImage.draw();
        bulletImage.translate(x, y);

    }

    @Override
    public void move(int x, int y) {
        if (this.y < 550) {
            bulletImage.translate(x, y);
            this.x += x;
            this.y += y;
        }
    }

    public void destroyBullet() {
        bulletImage.delete();
        bulletDestroyed = true;
    }

    public boolean isBulletDestroyed() {
        return bulletDestroyed;
    }

    public int bulletGetX() {
        return this.x;
    }

    public int bulletGetY() {
        return this.y;
    }
}
