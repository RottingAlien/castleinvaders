package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.murlogs.castleinvaders.Menu.GameOverMenu;
import org.academiadecodigo.murlogs.castleinvaders.Menu.Menu;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        boolean playerContinue;

        while (true) {

            playerContinue = true;

            Menu menu = new Menu();
            menu.createMenu();

            while (menu.menuExists()) {
                Thread.sleep(0);
            }

            while (playerContinue) {
                Game game = new Game();
                game.startGame();

                GameOverMenu gameOverMenu = new GameOverMenu();
                gameOverMenu.createGameOverMenu();

                while (gameOverMenu.GameOverMenuExists()) {
                    Thread.sleep(0);

                    if (!gameOverMenu.isPlayerContinue()) {
                        playerContinue = false;
                    }
                }
            }
        }
    }
}
