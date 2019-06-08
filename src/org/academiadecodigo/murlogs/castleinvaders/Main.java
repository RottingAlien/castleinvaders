package org.academiadecodigo.murlogs.castleinvaders;

import org.academiadecodigo.murlogs.castleinvaders.Menu.Menu;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        Menu menu = new Menu();
        menu.createMenu();

        while (menu.menuExists()) {
            Thread.sleep(0);
        }

        Game game = new Game();
        game.startGame();


    }
}
