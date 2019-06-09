package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.murlogs.castleinvaders.Menu.GameOverMenu;
import org.academiadecodigo.murlogs.castleinvaders.Menu.Menu;

public class Main {

    public static void main(String[] args) throws InterruptedException {



        GameOverMenu gameOverMenu = new GameOverMenu();
        gameOverMenu.createGameOverMenu();

        while(gameOverMenu.GameOverMenuExists()){
            Thread.sleep(1000);
        }

       Menu menu = new Menu();
        menu.createMenu();

        while (menu.menuExists()) {
            Thread.sleep(0);
        }

        Game game = new Game();
        game.startGame();




    }
}
