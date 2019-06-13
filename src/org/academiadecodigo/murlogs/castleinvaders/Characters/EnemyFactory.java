package org.academiadecodigo.murlogs.castleinvaders.Characters;


public abstract class EnemyFactory {


    public static Enemy createEnemy() {

        int randomSpawn = (int) (Math.random() * 2);
        int randomX = (int) (Math.random() * 250);

        int randomEnemy = -1;
        boolean enemyShooterProb = (Math.random() < 0.5f);
        boolean bigSkeletonProb = (Math.random() < 0.1f);
        boolean runnerSkeleton = (Math.random() < 0.1f);

        if (enemyShooterProb) {
            randomEnemy = 0;
        }
        if (runnerSkeleton) {
            randomEnemy = 2;
        }
        if (bigSkeletonProb) {
            randomEnemy = 1;
        }



        switch (randomEnemy) {
            case 0:
                return new EnemyShooter(1, randomSpawn, randomX);
            case 1:
                return new BigSkeleton(3, randomSpawn, randomX);
            case 2:
                return new EnemyRunner(1,randomSpawn,randomX);
            default:
                return new DoorEnemy(1, randomSpawn, randomX);
        }
    }
}
