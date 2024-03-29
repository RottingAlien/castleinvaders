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
        boolean crateGivenInRound = false;
        boolean cratePickedInRound = false;

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

                    player.getFire().move(0, 5);
                }


                //enemy move & shoot
                for (int i = 0; i < enemies.length; i++) {
                    Enemy enemy = enemies[i];

                    enemy.move();

                    if (Collision.enemyHit(enemy, player.getFire())) {
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
                    for (int ii = 0; ii < arrows.length; ii++) {

                        if (arrows[ii] != null) {
                            arrows[ii].move(0, -1);

                            if (Collision.playerHit(player, arrows[ii])) {

                                field.deleteHearts(player.getHearts());
                                arrows[ii] = null;
                                continue;
                            }

                            if (arrows[ii].getArrowY() < -10) {
                                arrows[ii].getPic().delete();
                                arrows[ii] = null;
                            }
                        }
                    }

                    if (enemy instanceof DoorEnemy) {

                        DoorEnemy doorEnemy = (DoorEnemy) enemy;
                        //EnemyRunner enemyRunner = (EnemyRunner) enemy;

                        if (doorEnemy.isAtDoor() && !door.isDestroyed() && !enemy.isDestroyed()) {
                            doorEnemy.punchDoor(door);
                        }
                    }
                    if (enemy instanceof EnemyRunner){

                        EnemyRunner enemyRunner = (EnemyRunner) enemy;
                        if (enemyRunner.isAtDoor() && !door.isDestroyed() && !enemyRunner.isDestroyed()) {
                            enemyRunner.punchDoor(door);

                        }
                    }
                }

                int fixedEnemyArrayLength = enemies.length;
                int enemiesLeft = numberPerWave;


                if ((field.getCurrentWave() % 5 == 0) &&
                        !crateGivenInRound &&
                        !crate.isDeployed() &&
                        !cratePickedInRound) {

                    crate.deploy();
                    crateGivenInRound = true;
                }

                if (Collision.cratePick(player, crate)) {

                    cratePickedInRound = true;
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
                            crateGivenInRound = false;
                            cratePickedInRound = false;
                            enemies = createNextWave(enemies, numberPerWave);
                        }
                    }
                }

                if (player.getHearts() <= 0 || door.isDestroyed()) {

                    gameOn = false;
                    sound.close();
                }

            } catch (ConcurrentModificationException e) {
                System.err.println("###############NÉ§#####################\n"+
                        "############£      §###################\n" +
                        "##########æ         *N#################\n" +
                        "############o         ###############\n" +
                        "#############=          Ñ##############\n" +
                        "#############I           £#############\n" +
                        "#############             =¶###########\n" +
                        "############§               N##########\n" +
                        "############±      =o/I§%    Ñ#########\n" +
                        "############@I*    ©######@  /@########\n" +
                        "###########¶o*    I#######©? *########\n" +
                        "###########-£        *©###£ ?@&±#######\n" +
                        "##########*-@   ?¶£    %   *###########\n" +
                        "#########& @ o   ####É*&É##############\n" +
                        "########§§#I X  I######################\n" +
                        "##########Ñ  £  o######################\n" +
                        "##########? ±#*  ######################\n" +
                        "#########æI£##% ?######################\n" +
                        "##############æI¶######################");
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

