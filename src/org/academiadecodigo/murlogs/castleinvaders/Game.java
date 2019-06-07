package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.murlogs.castleinvaders.Characters.Bullet;
import org.academiadecodigo.murlogs.castleinvaders.Characters.Enemy;
import org.academiadecodigo.murlogs.castleinvaders.Characters.EnemyFactory;
import org.academiadecodigo.murlogs.castleinvaders.Characters.Player;
import org.academiadecodigo.murlogs.castleinvaders.Sound.Sound;

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

        while (true) {


            Thread.sleep(10);
            player.move();

            if (player.getBulletShoot()) {

                Bullet bullet = new Bullet(player.getPictureX(), player.getPlayerPositionY());


                if(bullet.getY() <= 810) {
                    bullet.bulletMove();
                }
            }

        for (Enemy enemy : enemies) {
            enemy.move();
            field.drawVignette();
            if (enemy.isAtDoor() && !door.isDestroyed()) {
                enemy.punchDoor(door);
            }
        }
    }
}
}
