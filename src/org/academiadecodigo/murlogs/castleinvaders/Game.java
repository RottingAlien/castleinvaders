package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.murlogs.castleinvaders.Characters.Bullet;
import org.academiadecodigo.murlogs.castleinvaders.Characters.Enemy;
import org.academiadecodigo.murlogs.castleinvaders.Characters.EnemyFactory;
import org.academiadecodigo.murlogs.castleinvaders.Characters.EnemyShooter;
import org.academiadecodigo.murlogs.castleinvaders.Characters.Player;
import org.academiadecodigo.murlogs.castleinvaders.Sound.Sound;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Arrow;

import java.util.LinkedList;

public class Game {


    public void startGame() throws InterruptedException {

        Field field = new Field();
        field.createField();

        Player player = new Player();

        Door door = new Door();
        door.drawDoor();


        // Start of music implementation //

        String filePath = "/assets/Mega Rust.wav";
        Sound sound = new Sound(filePath);
        sound.play(true);
        sound.loopIndef();

        // End of music implementation //


        //number of wave -> to increase enemy creation

        int wave = 0;
        int numberPerWave = 10 + wave;

        LinkedList<Enemy> enemies = new LinkedList<>();


        for (int i = 0; i < numberPerWave; i++) {

            enemies.add(EnemyFactory.createEnemy());
        }


        Arrow[] arrows = new Arrow[10];
        Bullet[] bullets = new Bullet[10];

        while (true) {


            Thread.sleep(10);
            player.move();
            if (player.getPlayerShot()) {
                bullets = player.bulletShoot(bullets);
            }

            for (int i = 0; i < bullets.length; i++) {

                if (bullets[i] != null) {
                    bullets[i].move(0, 1);
                    if (bullets[i].getPic().getY() < 600) {
                        bullets[i].getPic().delete();
                        bullets[i] = null;

                    }
                }
            }


            //player shoot - still in test
            /*
            if (player.getBulletShoot()) {

                Bullet bullet = new Bullet(player.getPictureX(), player.getPlayerPositionY());


                if (bullet.getY() <= 810) {
                    bullet.bulletMove();
                }
            }
            */

            //enemy move & shoot
            for (Enemy enemy : enemies) {
                enemy.move();

                if (enemy instanceof EnemyShooter) {

                    EnemyShooter enemyShooter = (EnemyShooter) enemy;

                    arrows = enemyShooter.canShoot(arrows);
                }

                for (int i = 0; i < arrows.length; i++) {

                    if (arrows[i] != null) {
                        arrows[i].move(0, -1);

                        if (arrows[i].getPic().getY() < -10) {
                            arrows[i].getPic().delete();
                            arrows[i] = null;
                        }
                    }
                }

                field.drawVignette();
                if (enemy.isAtDoor() && !door.isDestroyed()) {
                    enemy.punchDoor(door);

                }
            }
        }
    }
}

