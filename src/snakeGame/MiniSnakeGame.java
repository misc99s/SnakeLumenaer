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
    protected int [][] colorMatrix = new int[24][24];
    private int numberOfFruits = 10;
    private boolean stop = true;
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
            balken.add(new GraphicElement(i, 23) {
                @Override
                public void render(PixelMatrix matrix) {
                    matrix.setPixel(y, x, new Color(0,0,0));
                }
            });
        }
    }

    public void createRandomFruit() {
        int random = (int)Math.round(Math.random()*100);
        int randomX = (int)Math.round(Math.random() * 23);
        int randomY = (int)Math.round(Math.random() * 22);
        if(random <= 60){
            graphicElements.add(new AppleFruit(randomX, randomY));
        } else if(random > 60 && random <= 80) {
            graphicElements.add(new BananaFruit(randomX, randomY));
        } else {
            graphicElements.add(new BlueBerryFruit(randomX, randomY));
        }
        colorMatrix[randomX][randomY] = graphicElements.size()-1;
    }

    public int[][] getColorMatrix() {
        return colorMatrix;
    }

    @Override
    public void buzzered() {
        /*
    }
        if(stop) {
            snakeParts.get(snakeParts.size()-1).setSpeedX(0);
            snakeParts.get(snakeParts.size()-1).setSpeedY(0);
        } else {
            snakeParts.get(snakeParts.size()-1).setRichtung(snakeParts.get(snakeParts.size()-1).getRichtung());
        }
        stop = !stop;
     */
    }

    @Override
    public void buzzerReleased() {

    }

    @Override
    public void wheelRotation(int rotationValue) {
        int counter = 0;
        int richtung = snakeParts.get(snakeParts.size() - 1).getRichtung();
        if (counter % 4 == 0) {
            if (rotationValue > 0) { // Rechts abbiegen
                richtung = (richtung - 1) % 4;
            } else { // Links abbiegen
                richtung = (richtung + 1) % 4;
            }
            counter++;
            snakeParts.get(snakeParts.size() - 1).setRichtung(richtung);
        }
    }
}
