package org.academiadecodigo.murlogs.castleinvaders.Characters;

import java.util.LinkedList;

public abstract class EnemyFactory {


    public static LinkedList<Enemy> createEnemys(int numberOfEnemys) {

        LinkedList<Enemy> enemyWave = new LinkedList<>();

        for (int i = 0; i < numberOfEnemys; i++) {

            enemyWave.add(new Enemy());
        }

        return enemyWave;
    }
}
