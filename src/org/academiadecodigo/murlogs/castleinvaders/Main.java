package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.murlogs.castleinvaders.Menu.GameOverMenu;
import org.academiadecodigo.murlogs.castleinvaders.Menu.Menu;

public class Main {


    public static void main(String[] args) throws InterruptedException {


        Menu menu = new Menu();
        menu.createMenu();

        while (menu.menuExists()) {
            Thread.sleep(0);
        }

        while (true) {

            Game game = new Game();
            game.startGame();

            GameOverMenu gameOverMenu = new GameOverMenu();
            gameOverMenu.createGameOverMenu();

        }
    }


    }
