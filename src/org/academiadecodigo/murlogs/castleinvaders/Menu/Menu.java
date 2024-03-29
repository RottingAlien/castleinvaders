package org.academiadecodigo.murlogs.castleinvaders.Menu;

import org.academiadecodigo.murlogs.castleinvaders.Game;
import org.academiadecodigo.murlogs.castleinvaders.Sound.Sound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Menu implements KeyboardHandler {

    private Rectangle screen;
    private Picture castle;
    private Picture invaders;
    private Text start;
    private Text help;
    private Text exit;
    private Picture background;
    private Rectangle rectangle1;
    private Rectangle rectangle2;
    private Rectangle rectangle3;
    private Rectangle selecter;

    private Help helpSection;
    private Keyboard keyboard;
    private Sound menuSound;
    private boolean menuExists;


    private Game game;


    public Menu() {


        helpSection = new Help();

        keyboard = new Keyboard(this);

        game = new Game();

        prepare();

    }


    public void createMenu() {

        String filePath = "/assets/Captain Scurvy.wav";
        menuSound = new Sound(filePath);
        menuSound.play(true);
        menuSound.loopIndef();


        screen = new Rectangle(0, 0, 800, 600);
        start = new Text(410, 395, "Start");
        help = new Text(410, 475, "Help");
        exit = new Text(410, 555, "Exit");
        rectangle1 = new Rectangle(360, 370, 130, 55);
        rectangle2 = new Rectangle(360, 450, 130, 55);
        rectangle3 = new Rectangle(360, 530,130,55 );
        selecter = new Rectangle(350, 360, 150, 75);
        background = new Picture(70, 100, "/assets/menu.png");
        castle = new Picture(20, 40, "/assets/title1.png");
        invaders = new Picture(170, 150, "/assets/title2.png");


        background.grow(85, 180);
        background.draw();

        castle.grow(-20, -20);
        castle.draw();
        invaders.grow(-20, -20);
        invaders.draw();

        rectangle1.setColor(Color.GRAY);
        rectangle1.fill();

        rectangle2.setColor(Color.GRAY);
        rectangle2.fill();

        rectangle3.setColor(Color.GRAY);
        rectangle3.fill();

        selecter.draw();
        selecter.setColor(Color.YELLOW);

        start.draw();
        start.grow(15, 15);
        start.setColor(Color.WHITE);

        help.draw();
        help.grow(15, 15);
        help.setColor(Color.WHITE);

        exit.draw();
        exit.grow(15,15);
        exit.setColor(Color.WHITE);

        menuExists = true;

    }

    public void deleteMenu() {

        menuSound.close();
        screen.delete();
        start.delete();
        help.delete();
        rectangle1.delete();
        rectangle2.delete();
        selecter.delete();
        background.delete();
        castle.delete();
        invaders.delete();

        menuExists = false;

    }

    public boolean menuExists() {

        return menuExists;
    }

    public void prepare() {

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey((KeyboardEvent.KEY_DOWN));
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent enter = new KeyboardEvent();
        enter.setKey(KeyboardEvent.KEY_ENTER);
        enter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent escape = new KeyboardEvent();
        escape.setKey(KeyboardEvent.KEY_ESC);
        escape.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(enter);
        keyboard.addEventListener(escape);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                if (selecter.getY() == 360) {
                    return;
                }
                selecter.translate(0, -80);
                return;

            case KeyboardEvent.KEY_DOWN:
                if (selecter.getY() == 520) {
                    return;
                }
                selecter.translate(0, 80);
                return;

            case KeyboardEvent.KEY_ENTER:
                if (menuExists && !helpSection.helpIsCreated()) {
                    if (selecter.getY() == 360) {
                        deleteMenu();
                        return;
                    }
                    if (selecter.getY() == 440) {
                        helpSection.createHelpSection();

                        return;
                    }

                    if (selecter.getY() == 520 && !helpSection.helpIsCreated()) {
                        System.exit(0);
                    }
                }

                return;

            case KeyboardEvent.KEY_ESC:
                if (menuExists) {
                    if (!helpSection.helpIsCreated()) {
                        return;
                    }
                    helpSection.deleteHelpSection();
                }
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }



    public class Help {


        private Rectangle screen;
        private Picture keywords;

        private Picture instructionsBackground;



        private boolean helpIsCreated;

        public void createHelpSection() {





            screen = new Rectangle(0, 0, 800, 600);

            screen.draw();
            screen.setColor(Color.LIGHT_GRAY);
            screen.fill();

            keywords = new Picture(25, 60, "/assets/game keys.png");
            instructionsBackground = new Picture(70, 100, "/assets/menu instructions.png");

            keywords.grow(0,-40);


            screen.draw();

            instructionsBackground.draw();
            instructionsBackground.grow(85, 180);


            keywords.draw();

            helpIsCreated = true;


        }

        public void deleteHelpSection() {
            screen.delete();
            keywords.delete();
            instructionsBackground.delete();
            helpIsCreated = false;
        }

        public boolean helpIsCreated() {
            return helpIsCreated;
        }



    }

}
