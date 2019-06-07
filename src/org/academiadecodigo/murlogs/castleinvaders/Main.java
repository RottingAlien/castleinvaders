package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.murlogs.castleinvaders.Characters.Enemy;
import org.academiadecodigo.murlogs.castleinvaders.Characters.EnemyFactory;
import java.util.LinkedList;
import org.academiadecodigo.murlogs.castleinvaders.Characters.Player;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        new Field(); // Linha para teste
        Player player = new Player();
        player.prepare();


        //number of wave -> to increase enemy creation

        int wave = 2;


        LinkedList<Enemy> enemies = EnemyFactory.createEnemys(4 + wave);

        while (true) {

            Thread.sleep(20);

            for (Enemy enemy : enemies) {
                enemy.move(1, 0);
            }
        }


    }
}
