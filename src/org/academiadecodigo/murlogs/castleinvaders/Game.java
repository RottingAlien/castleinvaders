package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.murlogs.castleinvaders.Characters.Enemy;
import org.academiadecodigo.murlogs.castleinvaders.Characters.EnemyFactory;
import org.academiadecodigo.murlogs.castleinvaders.Characters.Player;
import org.academiadecodigo.murlogs.castleinvaders.Sound.Sound;

import java.util.LinkedList;

public class Game {


    public void startGame() throws InterruptedException {

        Field field = new Field();
        field.createField();

        Player player = new Player();
        player.prepare();

        Door door = new Door();
        door.drawDoor();


        // Start of music implementation //

        String filePath = "/assets/Mega Rust.wav";
        Sound sound = new Sound(filePath);
        sound.play(true);
        sound.loopIndef();

        // End of music implementation //


        //number of wave -> to increase enemy creation

        int wave = 2;


        LinkedList<Enemy> enemies = EnemyFactory.createEnemys(4 + wave);

        while (true) {


// End of background music implementation


            Thread.sleep(10);

            for (Enemy enemy : enemies) {
                enemy.move(1, 0);
                field.drawVignette();
                if (enemy.isAtDoor() && !door.isDestroyed()) {
                    enemy.punchDoor(door);
                }
            }
        }

    }

}





/*

    // Start of music implementation //
    String filePath = "/assets/Mega Rust.wav";
    Sound sound = new Sound(filePath); // open stream

            try {

                    Thread.sleep(0); // wait 0 seconds between each loop
                    sound.play(true); // play sound from start
                    sound.loopIndef(); // play forever
                    Thread.sleep(20000000);




                    } catch (InterruptedException e) {
                    System.err.println(e.getMessage());

                    } finally {
                    sound.close(); // close stream
                    }

// End of background music implementation

*/