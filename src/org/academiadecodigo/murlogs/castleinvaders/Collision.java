package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.murlogs.castleinvaders.Characters.Bullet;
import org.academiadecodigo.murlogs.castleinvaders.Characters.DoorEnemy;
import org.academiadecodigo.murlogs.castleinvaders.Characters.Enemy;
import org.academiadecodigo.murlogs.castleinvaders.Characters.Player;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Arrow;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Crate;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Fire;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Weapon;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Collision {


    //check for playerHit

    public static boolean playerHit(Player player, Arrow arrow) {

        if (arrow.getArrowY() != (player.getPlayerPositionY() + player.getPlayerHeight())) {
            return false;
        }

        if (arrow.getArrowX() > player.getPlayerPositionX() &&
                arrow.getArrowX() < player.getPlayerPositionX() + player.getPlayerWidth() - 10) {

            arrow.setHit(true);
            arrow.getPic().delete();
            player.hit(1);
            return true;
        }


        return false;
    }

    public static boolean enemyHit(Enemy enemy, Weapon weapon) {

        if (weapon instanceof Bullet) {

            Bullet bullet = (Bullet) weapon;

            if (bullet.bulletGetX() > enemy.getPic().getX() &&
                    bullet.bulletGetX() < enemy.getPic().getX() + enemy.getPic().getWidth() &&
                    bullet.bulletGetY() > enemy.getPic().getY() &&
                    bullet.getY() < enemy.getPic().getY() + enemy.getPic().getHeight()) {

                return true;
            }
        }

        if (weapon instanceof Fire) {

            Fire fire = (Fire) weapon;

            if (fire.getRightFire() != null) {

                if (fire.getRightFireX() > enemy.getPic().getX() &&
                        fire.getRightFireX() < enemy.getPic().getX() + enemy.getPic().getWidth()) {
                    return true;
                }
            }
            if (fire.getLeftFire() != null) {

                if (fire.getLeftFireX() > enemy.getPic().getX() &&
                        fire.getLeftFireX() < enemy.getPic().getX() + enemy.getPic().getWidth()) {
                    return true;
                }
            }

        }

        return false;
    }

    public static boolean cratePick(Player player, Crate crate) {

        if (crate.getCrateY() > 150 &&
                crate.getCrateY() <= 200 &&
                player.getPlayerPositionX() >= crate.getCrateX() &&
                player.getPlayerPositionX() < (crate.getCrateX() + crate.getCrateWidth())) {

            crate.setReadyToDeploy();
            return true;
        }

        return false;
    }


    public class Point {

        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Rect {

        public int x;
        public int x1;
        public int y;
        public int y1;

        public Rect(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.x1 = x + w;
            this.y1 = y + h;
        }

        public Rect(Point p, Point p1) {

            this(p.x, p.y, p1.x - p.x, p1.y - p.y);

        }

        public int width() {
            return x1 - x;
        }

        public int height() {
            return y1 - y;
        }

        public Point topRight() {
            return new Point(this.x1, this.y);
        }

        public Point bottomLeft() {
            return new Point(this.x, this.y1);
        }


    }

    public static boolean isCollided(Rect r, Rect r1) {


        if (r.topRight().y < r1.bottomLeft().y
                || r.bottomLeft().y > r1.topRight().y) {
            return false;
        }
        if (r.topRight().x < r1.bottomLeft().x
                || r.bottomLeft().x > r1.topRight().x) {
            return false;
        }
        return true;

    }

    public boolean isCollided(Picture pic1, Picture pic2) {

        Rect r = new Rect(pic1.getX(), pic1.getY(), pic1.getWidth(), pic1.getHeight());
        Rect r1 = new Rect(pic2.getX(), pic2.getY(), pic2.getWidth(), pic2.getHeight());

        return isCollided(r, r1);

    }

    public boolean isCollided(int x, int y, int w, int h, int x1, int y1, int w1, int h1) {

        Point p = new Point(x, y);
        Point p1 = new Point(x + w, y + h);
        Rect r = new Rect(p, p1);

        p = new Point(x1, y1);
        p1 = new Point(x1 + w1, y1 + h1);
        Rect r1 = new Rect(p, p1);

        return isCollided(r, r1);

    }
}
