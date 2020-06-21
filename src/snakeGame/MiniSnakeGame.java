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

public class MiniSnakeGame extends Game {
    protected static int [][] colorMatrix = new int[24][24];
    private int numberOfFruits = 10;
    private boolean stop = true;
    private static double timerSnakeSpeed = 0;
    //private int counter = 0;
    public MiniSnakeGame(PixelMatrix matrix) {
        super(matrix);
        pixelMatrix.setBackgroundColor(new Color(119,217,126));

        for(int i=0; i<colorMatrix.length; i++) {
            for(int j=0; j<colorMatrix[0].length; j++) {
                colorMatrix[i][j] = -1;
            }
        }

        for(int i=0; i<numberOfFruits; i++) {
            createRandomFruit();
        }

        for(int i = 0;  i < 3; i++) {
            snakeParts.add(new Snake(11, 22-i));
        }

        for(int i = 0; i < 24; i++){
            balken.add(new Balken(i, 23) {
            });
            colorMatrix[i][23] = balken.size()-1 + 100;
        }
    }

    public static void createRandomFruit() {
        int random = (int)Math.round(Math.random()*100);
        int randomX = (int)Math.round(Math.random() * 23);
        int randomY = (int)Math.round(Math.random() * 22);
        while(colorMatrix[randomX][randomY] != -1) {
            randomX = (int)Math.round(Math.random() * 23);
            randomY = (int)Math.round(Math.random() * 22);
        }
        if(random <= 60){
            graphicElements.add(new AppleFruit(randomX, randomY));
        } else if(random > 60 && random <= 80) {
            graphicElements.add(new BananaFruit(randomX, randomY));
        } else {
            graphicElements.add(new BlueBerryFruit(randomX, randomY));
        }
        colorMatrix[randomX][randomY] = graphicElements.size()-1;
    }

    public static int[][] getColorMatrix() {
        return colorMatrix;
    }
    public static void setColorMatrix(int x, int y, int cm) { colorMatrix[x][y] = cm; }
    public static void addNewSnakeHead(int x, int y) {
        snakeParts.add(new Snake(x, y));
    }
    public static List getGraphicElements() { return graphicElements; }
    public static List getBalken() { return balken; }
    public static Color getFruitColor(int i) { return graphicElements.get(i).getColor(); }
    public static void setBalkenColor(Color c) {
        for(int i=4*Balken.getFruitsEaten(); i<4+4*Balken.getFruitsEaten(); i++) {
            balken.get(i).setColor(c);
        }
    }
    public static Color getBalkenColor(int i) {
        return balken.get(i).getColor();
    }
    public static void resetBalkenColor() {
        for(int i=0; i<balken.size(); i++) {
            balken.get(i).setColor(Color.BLACK);
            Balken.resetFruitsEaten();
        }
    }

    public static int getFruitX (int i) {
        return graphicElements.get(i).getX();
    }
    public static int getFruitY (int i) { return graphicElements.get(i).getY(); }
    public static double getTimerSnakeSpeed() { return timerSnakeSpeed; }
    public static void setTimerSnakeSpeed() { timerSnakeSpeed = 0; }

    @Override
    public void buzzered() {
        /*
        if(stop) {
            snakeParts.get(snakeParts.size()-1).setSpeedX(0);
            snakeParts.get(snakeParts.size()-1).setSpeedY(0);
        } else {
            snakeParts.get(snakeParts.size()-1).setRichtung(snakeParts.get(snakeParts.size()-1).getRichtung());
        }
        stop = !stop;
     */
        int blueBerry = 0;
        boolean bb = false;
        int banana = 0;
        boolean ba = false;

        // DOESN'T WORK YET
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

            // Schlange verlangsamen
            if(bb) {
                Snake.setSnakeSpeed(6);
            }
            // Schlange verschnellern
            if(ba) {
                Snake.setSnakeSpeed(2);
            }
            // Timer starten für Normalgeschwindigkeit
            timerSnakeSpeed = java.lang.System.currentTimeMillis();
        }
    }

    @Override
    public void buzzerReleased() {

    }

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
