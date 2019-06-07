package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.murlogs.castleinvaders.Characters.Enemy;
import org.academiadecodigo.murlogs.castleinvaders.Characters.EnemyFactory;
import org.academiadecodigo.murlogs.castleinvaders.Characters.Player;

import java.util.LinkedList;

public class Game {

    public void startGame() throws InterruptedException {

        Field field = new Field();
        field.createField();

        Player player = new Player();
        player.prepare();

        Door door = new Door();
        door.drawDoor();



        //number of wave -> to increase enemy creation

        int wave = 2;


        LinkedList<Enemy> enemies = EnemyFactory.createEnemys(4 + wave);

        while (true) {

            Thread.sleep(10);

            for (Enemy enemy : enemies) {
                enemy.move(1, 0);
                field.drawVignette();
                if (enemy.isAtDoor() && !door.isDestroyed()){
                    enemy.punchDoor(door);
                }
            }









        }

    }

}
