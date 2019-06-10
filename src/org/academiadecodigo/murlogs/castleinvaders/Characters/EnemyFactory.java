package org.academiadecodigo.murlogs.castleinvaders.Characters;


public abstract class EnemyFactory {


    public static Enemy createEnemy() {

        int randomSpawn = (int) (Math.random() * 2);
        int randomX = (int) (Math.random() * 250);

        int randomEnemy = -1;
        boolean doorEnemyProb = (Math.random() < 0.2f);
        boolean enemyShooterProb = (Math.random() < 0.5f);

        if (doorEnemyProb == true) {
            randomEnemy = 0;
        }
        if (enemyShooterProb == true) {
            randomEnemy = 1;
        }


        switch (randomEnemy) {
            case 0:
                return new DoorEnemy(1, randomSpawn, randomX);
            case 1:
                return new EnemyShooter(1, randomSpawn, randomX);
            default:
                return new DoorEnemy(1, randomSpawn, randomX);
        }
    }
}
