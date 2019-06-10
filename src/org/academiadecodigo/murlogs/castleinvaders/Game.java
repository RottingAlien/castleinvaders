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

    private boolean gameOn = true;

    public void startGame() throws InterruptedException {


        boolean gameIsRunning=true;



        Field field = new Field();
        field.createField();

        Player player = new Player(5);

        Door door = new Door();
        door.drawDoor();


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

        Arrow[] arrows = new Arrow[10];



        while (gameOn) {

            Thread.sleep(10);
            player.move();

            if (player.getBullet() != null && !player.isDestroyed()) {

                player.getBullet().move(0, 10);

                if (player.getBullet().bulletGetY() > 549) {

                    player.destroyBullet();
                }
            }

            //enemy move & shoot
            for (Enemy enemy : enemies) {
                enemy.move();
                //field.drawVignette();
                //check for hits on enemies
                if (player.getBullet() != null && !player.getBullet().isBulletDestroyed()) {
                    if (player.getBullet().bulletGetX() > enemy.getPic().getX() &&
                            player.getBullet().bulletGetX() < enemy.getPic().getX() + enemy.getPic().getWidth() &&
                            player.getBullet().bulletGetY() > enemy.getPic().getY() &&
                            player.getBullet().getY() < enemy.getPic().getY() + enemy.getPic().getHeight()) {
                        field.setCurrentScore(enemy.hit(1));

                        player.getBullet().destroyBullet();
                        System.out.println("outchs");
                    }

                    if (enemy.isDestroyed()) {
                        enemy.setDestroyed();
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

                        if ((arrows[i].getArrowY() == player.getPlayerPositionY() + 50) &&
                                ((arrows[i].getArrowX() > player.getPlayerPositionX()) &&
                                        (arrows[i].getArrowX() < player.getPlayerPositionX() + player.getPic().getWidth()))) {
                            arrows[i].setHit(true);
                            arrows[i].getPic().delete();
                            arrows[i] = null;
                            player.hit(1);
                            field.deleteHearts(player.getHearts());
                            continue;
                        }

                        if (arrows[i].getArrowY() < -10) {
                            arrows[i].getPic().delete();
                            arrows[i] = null;
                        }
                    }
                }

                if (enemy.isAtDoor() && !door.isDestroyed() && !enemy.isDestroyed()) {
                    enemy.punchDoor(door);
                }

                if(player.isDestroyed()){
                    gameIsRunning=false;
                }

            }
            int fixedEnemyArrayLength = enemies.length;
            int enemiesLeft = numberPerWave;
            for (int i = 0; i < fixedEnemyArrayLength; i++) {

                if (!enemies[i].isDestroyed()) {
                    continue;
                }

                if (enemies[i].isDestroyed()) {
                    enemiesLeft--;
                    if (enemiesLeft <= 0) {
                        wave++;
                        numberPerWave++;
                        enemies = createNextWave(enemies, numberPerWave);
                    }

                }
            }

            if (player.getHearts() <= 0 || door.isDestroyed()) {

                gameOn = false;
                sound.close();
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
}

