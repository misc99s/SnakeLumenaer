package snakeGame;

import astroidsGame.Projectile;
import graphics.Color;
import graphics.GraphicElement;
import lumenaer.Game;
import lumenaer.PixelMatrix;

import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.black;
import static java.lang.Thread.sleep;
import lumenaer.Lumenaer;
/**The Main Game Class*/
public class MiniSnakeGame extends Game {
    protected static int [][] colorMatrix = new int[24][24];
    private int numberOfFruits = 10;
    private boolean stop = true;
    private static double timerSnakeSpeed = 0;

    public MiniSnakeGame(PixelMatrix matrix) {
        super(matrix);
        pixelMatrix.setBackgroundColor(new Color(119,217,126));
        for(int i=0; i<colorMatrix.length; i++) {
            for(int j=0; j<colorMatrix[0].length; j++) {
                colorMatrix[i][j] = -1;
            }
        }

        /*GameOver gameOverScreen = new GameOver(2, 4);
        graphicElements.add(gameOverScreen);
        GameOver.setBodyColor(new Color(119,217,126));*/
        /**spawns random fruit depending on numberOfFruits*/
        for(int i=0; i<numberOfFruits; i++) {
            createRandomFruit();
        }
        /**creates the snake at the beginning, has the length of 3*/
        for(int i = 0;  i < 3; i++) {
            snakeParts.add(new Snake(11, 22-i));
        }
        /**sets the black status bar (Balken)*/
        for(int i = 0; i < 24; i++){
            balken.add(new Balken(i, 23) {
            });
            colorMatrix[i][23] = balken.size()-1 + 100;
        }
    }

    /**creates a Fruit Object at random*/
    public static void createRandomFruit() {
        /**random value for type of fruit*/
        int random = (int)Math.round(Math.random()*100);
        /**random X Coordinate*/
        int randomX = (int)Math.round(Math.random() * 23);
        /**random Y Coordinate*/
        int randomY = (int)Math.round(Math.random() * 22);
        /**checks if there is already a fruit at the coordinate*/
        while(colorMatrix[randomX][randomY] != -1) {
            randomX = (int)Math.round(Math.random() * 23);
            randomY = (int)Math.round(Math.random() * 22);
        }
        /**AppleFruit(red) is the most common, 60% spawn rate*/
        if(random <= 60){
            graphicElements.add(new AppleFruit(randomX, randomY));
            /**BananaFruit(yellow), 20% spawn rate*/
        } else if(random > 60 && random <= 80) {
            graphicElements.add(new BananaFruit(randomX, randomY));
        } else { /**BlueBerryFruit(blue), 20% spawn rate*/
            graphicElements.add(new BlueBerryFruit(randomX, randomY));
        }
        /**enters the Fruit into the colorMatrix (grid)*/
        colorMatrix[randomX][randomY] = graphicElements.size()-1;
    }
    /**returns colorMatrix*/
    public static int[][] getColorMatrix() {
        return colorMatrix;
    }
    /**sets ColorMatrix*/
    public static void setColorMatrix(int x, int y, int cm) { colorMatrix[x][y] = cm; }
    /**adds a part to the snake*/
    public static void addNewSnakeHead(int x, int y) {
        snakeParts.add(new Snake(x, y));
    }
    /**returns graphicElements, List*/
    public static List getGraphicElements() { return graphicElements; }
    /**returns the black status bar*/
    public static List getBalken() { return balken; }
    /**returns (eaten) FruitColor*/
    public static Color getFruitColor(int i) { return graphicElements.get(i).getColor(); }
    public static void setBalkenColor(Color c) {
        /**sets status bar(balken) color depending on the fruit eaten*/
        for(int i=4*Balken.getFruitsEaten(); i<4+4*Balken.getFruitsEaten(); i++) {
            balken.get(i).setColor(c);
        }
    }
    /**gets the status bar color(balken)*/
    public static Color getBalkenColor(int i) {
        return balken.get(i).getColor();
    }
    /**resets the status bar(balken) to default(color: black)*/
    public static void resetBalkenColor() {
        for(int i=0; i<balken.size(); i++) {
            balken.get(i).setColor(Color.BLACK);
            Balken.resetFruitsEaten();
        }
    }

    /**gets all X Coordinates from Fruits*/
    public static int getFruitX (int i) {
        return graphicElements.get(i).getX();
    }
    /**gets all Y Coordinates from Fruits*/
    public static int getFruitY (int i) { return graphicElements.get(i).getY(); }
    /**returns Snake's speed after eating a special Fruit*/
    public static double getTimerSnakeSpeed() { return timerSnakeSpeed; }
    /**sets the Snake's speed back to 0*/
    public static void setTimerSnakeSpeed() { timerSnakeSpeed = 0; }

    @Override
    public void buzzered() {
        /**if gameOver, then Game Over Screen appears*/
        if(gameOver) {
            //currentGame = new MiniSnakeGame(pixelMatrix);
            pixelMatrix.setBackgroundColor(new Color(119,217,126));
            //graphicElements.remove(graphicElements.size()-1);
            graphicElements.remove(indexGameOver);
            for(int i=0; i<MiniSnakeGame.getGraphicElements().size(); i++) {
                int x = MiniSnakeGame.getFruitX(i);
                int y = MiniSnakeGame.getFruitY(i);
                MiniSnakeGame.setColorMatrix(x, y, i);
            }
            //GameOver.setBodyColor(new Color(119,217,126));
            // delete snake
            /**deletes snake*/
            int end = snakeParts.size();
            for(int i=0; i<end; i++) {
                snakeParts.remove(0);
            }
            /** create new snake with the length of 3*/
            for(int i = 0;  i < 3; i++) {
                snakeParts.add(new Snake(11, 22-i));
            }
            snakeParts.get(snakeParts.size()-1).setRichtung(0);
            /**resets the status bar(Balken)'s color*/
            resetBalkenColor();

            once = true;
            setGameOver(false);
        } else {
            int blueBerry = 0;
            boolean bb = false;
            int banana = 0;
            boolean ba = false;
            /**counts how many BlueBerries and Bananas there are, the bigger one triggers "their" function*/
            if(getBalkenColor(23).getBlue() != 0) {
                for(int i=3; i<balken.size(); i+=4) {
                    // Bananen und Blaubeeren zählen
                    if (getBalkenColor(i).getRed() == 246) {
                        banana++;
                    } else blueBerry++;
                }
                // Balken leeren
                resetBalkenColor();

                // Abfrage mehr Bananen oder mehr Blaubeeren
                if(blueBerry>4) {
                    bb = true;
                } else if(banana>4) {
                    ba = true;
                } else {
                    int random = (int) (Math.random()*10);
                    if(random>4) {
                        bb = true;
                    } else ba = true;
                }
                /**the bigger the number in setSnakeSpeed() to slower the snake is, because modulo (%)*/
                /**if more BlueBerries: slows snake down*/
                // Schlange verlangsamen
                if(bb) {
                    Snake.setSnakeSpeed(6);
                }
                // Schlange verschnellern
                /**if more Bananas: speeds snake up*/
                if(ba) {
                    Snake.setSnakeSpeed(2);
                }
                // Timer starten für Normalgeschwindigkeit
                /**starts timer for normal/default speed*/
                timerSnakeSpeed = java.lang.System.currentTimeMillis();
            }
        }
    }

    @Override
    public void buzzerReleased() {

    }


    /**sets the snake's direction/rotation via the mouse wheel*/
    @Override
    public void wheelRotation(int rotationValue) {

        int richtung = snakeParts.get(snakeParts.size() - 1).getRichtung();
        //if (counter % 2 == 0) {
            if (rotationValue > 0) { // Rechts abbiegen
                if (richtung == 0) {
                    richtung = 3;
                } else richtung--;
            } else { // Links abbiegen
                richtung = (richtung + 1) % 4;
            }
            snakeParts.get(snakeParts.size() - 1).setRichtung(richtung);
        //}
        //counter++;
    }
}
