package org.academiadecodigo.murlogs.castleinvaders.Characters;


public abstract class EnemyFactory {


    public static Enemy createEnemy() {

        //TODO: make enemy with position here

        int randomEnemy = (int) (Math.random() * 2);
        switch (randomEnemy) {
            case 0:
                return new Enemy();
            case 1:
                return new EnemyShooter();
        }

        return null;
    }
}
