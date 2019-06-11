package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.murlogs.castleinvaders.Characters.*;
import org.academiadecodigo.murlogs.castleinvaders.Sound.Sound;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Arrow;
import org.academiadecodigo.murlogs.castleinvaders.Weapons.Crate;

import java.util.ConcurrentModificationException;

public class Game {

    private boolean gameOn = true;

    public void startGame() throws InterruptedException {


        Field field = new Field();
        field.createField();

        Player player = new Player(5);

        Door door = new Door();
        door.drawDoor();

        field.restartPlayerScore();
        field.restartWaves();


        // Start of music implementation //

        String filePath = "/assets/MegaRust.wav";
        Sound sound = new Sound(filePath);
        sound.play(true);
        sound.loopIndef();

        // End of music implementation //


        //number of wave -> to increase enemy creation

        int wave = 0;
        int numberPerWave = 1 + wave;

        Enemy[] enemies = new Enemy[numberPerWave];

        enemies = createNextWave(enemies, numberPerWave);

        //possible arrows on field
        Arrow[] arrows = new Arrow[10];

        Crate crate = new Crate();

        while (gameOn) {
            try {

                Thread.sleep(10);

                player.move();

                if (crate.isDeployed()) {
                    crate.move(0, 2);
                }

                if (player.getBullet() != null && !player.isDestroyed()) {

                    player.getBullet().move(0, 10);

                    if (player.getBullet().bulletGetY() > 549) {

                        player.destroyBullet();
                    }
                }

                if (player.getFire() != null && !player.isDestroyed()) {
                    player.getFire().move(0,5);
                }


                //enemy move & shoot
                for (Enemy enemy : enemies) {
                    enemy.move();

                    if (Collision.enemyHit(enemy, player.getFire())) {
                        System.out.println("works");
                        field.setCurrentScore(enemy.hit(5));
                        if (enemy.isDestroyed()) {
                            enemy.setDestroyed();
                        }
                    }

                    //field.drawVignette();

                    //check for hits on enemies
                    if (player.getBullet() != null && !player.getBullet().isBulletDestroyed()) {

                        if (Collision.enemyHit(enemy, player.getBullet())) {

                            field.setCurrentScore(enemy.hit(1));
                            player.getBullet().destroyBullet();

                            if (enemy.isDestroyed()) {
                                enemy.setDestroyed();
                            }
                        }
                    }

                    //enemy shoot
                    if (enemy instanceof EnemyShooter) {

                        EnemyShooter enemyShooter = (EnemyShooter) enemy;

                        arrows = enemyShooter.canShoot(arrows);
                    }

                    //check for player hit
                    for (int i = 0; i < arrows.length; i++) {

                        if (arrows[i] != null) {
                            arrows[i].move(0, -1);

                            if (Collision.playerHit(player, arrows[i])) {

                                field.deleteHearts(player.getHearts());
                                arrows[i] = null;
                                continue;
                            }

                            if (arrows[i].getArrowY() < -10) {
                                arrows[i].getPic().delete();
                                arrows[i] = null;
                            }
                        }
                    }

                    if (enemy instanceof DoorEnemy) {

                        DoorEnemy doorEnemy = (DoorEnemy) enemy;

                        if (doorEnemy.isAtDoor() && !door.isDestroyed() && !enemy.isDestroyed()) {
                            doorEnemy.punchDoor(door);
                        }
                    }
                }
                int fixedEnemyArrayLength = enemies.length;
                int enemiesLeft = numberPerWave;


                if (field.getCurrentWave() != 0 && field.getCurrentWave() % 5 == 0 && !crate.isDeployed()) {

                    crate.deploy();
                }

                if (Collision.cratePick(player, crate)) {

                    player.setCratePicked();
                }

                for (int i = 0; i < fixedEnemyArrayLength; i++) {

                    if (!enemies[i].isDestroyed()) {
                        continue;
                    }

                    if (enemies[i].isDestroyed()) {
                        enemiesLeft--;
                        if (enemiesLeft <= 0) {
                            wave++;
                            numberPerWave++;
                            field.setCurrentWave(1);
                            enemies = createNextWave(enemies, numberPerWave);
                        }

                    }
                }

                if (player.getHearts() <= 0 || door.isDestroyed()) {

                    gameOn = false;
                    sound.close();
                }
            } catch (ConcurrentModificationException e) {
                e.printStackTrace();
            }
        }
    }

    private Enemy[] createNextWave(Enemy[] enemies, int numberPerWave) {

        enemies = new Enemy[numberPerWave];

        for (int i = 0; i < numberPerWave; i++) {

            enemies[i] = (EnemyFactory.createEnemy());

        }

        return enemies;
    }

    public boolean isGameOn() {
        return gameOn;
    }
}

