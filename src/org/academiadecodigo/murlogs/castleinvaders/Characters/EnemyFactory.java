package org.academiadecodigo.murlogs.castleinvaders.Characters;


public abstract class EnemyFactory {


    public static Enemy createEnemy() {


        Enemy enemy = new Enemy();


        return enemy;
    }
}
