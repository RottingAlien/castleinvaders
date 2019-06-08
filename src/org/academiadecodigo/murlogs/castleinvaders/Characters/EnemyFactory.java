package org.academiadecodigo.murlogs.castleinvaders.Characters;


public abstract class EnemyFactory {


    public static Enemy createEnemy() {

        int randomSpawn = (int) (Math.random() * 2);
        int randomX = (int) (Math.random() * 250);
        int randomEnemy = (int) (Math.random() * 2);

        switch (randomEnemy) {
            case 0:
                return new Enemy(randomSpawn, randomX);
            case 1:
                return new EnemyShooter(randomSpawn, randomX);
        }

        return null;
    }
}
