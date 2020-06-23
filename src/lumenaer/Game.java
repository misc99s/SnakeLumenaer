package lumenaer;

import graphics.Color;
import graphics.GraphicElement;
import snakeGame.GameOver;
import snakeGame.Snake;
import snakeGame.MiniSnakeGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static graphics.Color.BLACK;

/**
 * Base class for all games. Own games must extend this class.
 *
 */
public abstract class Game {

    /* A pixel matrix, where to displayPixelMatrix the game.*/
    protected PixelMatrix pixelMatrix; // just for convenience
    protected int counter = 0;
    protected static boolean gameOver = false;
    //protected boolean youwon = false;
    protected static boolean once = true;
    protected static int indexGameOver;


    /* Array for storing all individual graphic objects to be drawn */
    protected static List<GraphicElement> graphicElements;

    protected static List<Snake> snakeParts = new ArrayList<>();
    protected static List<GraphicElement> balken = new ArrayList<>();

    /**
     * Constructor
     *
     * @ param the pixel matrix where the game should be drawn upon
     */
    public Game(PixelMatrix matrix) {
        pixelMatrix = matrix;
        pixelMatrix.setBackgroundColor(Color.WHITE);
        graphicElements = new CopyOnWriteArrayList<>();
    }

    /**
     * The next game step. By default, just draws everything.
     * Logic can be extended in the derived classes.
     */
    public void nextGameStep() {
        if(gameOver && once) {
            PixelMatrix.setBackgroundColor(BLACK);
            GameOver gameOverScreen = new GameOver(2, 4);
            graphicElements.add(gameOverScreen);
            indexGameOver = graphicElements.size()-1;
            //GameOver.setBodyColor(BLACK);
            once = false;
        } else {
            if(counter % Snake.getSnakeSpeed() == 0) {
                // set the background
                pixelMatrix.drawBackground();
                snakeParts.get(snakeParts.size()-1).setRichtung(snakeParts.get(snakeParts.size()-1).getRichtung());

                //displayPixelMatrix everything
                for (GraphicElement element : graphicElements) {
                    element.update();
                    element.render(pixelMatrix);
                }

                for (Snake element : snakeParts) {
                    element.update(snakeParts);
                    // element.move();
                    element.render(pixelMatrix);
                }

                for (GraphicElement element : balken) {
                    element.update();
                    element.render(pixelMatrix);
                }

                // Schlange verlängern wenn Frucht gegessen
                if(Snake.getHead()) {
                    int kopf = snakeParts.size()-1;
                    int [][] a = MiniSnakeGame.getColorMatrix();
                    int kopfNewX = snakeParts.get(kopf).getPosX() + snakeParts.get(kopf).getSpeedX();
                    int kopfNewY = snakeParts.get(kopf).getPosY() + snakeParts.get(kopf).getSpeedY();
                    int richtung = snakeParts.get(kopf).getRichtung();
                    MiniSnakeGame.addNewSnakeHead(kopfNewX, kopfNewY);
                    snakeParts.get(kopf).setRichtung(richtung);
                    MiniSnakeGame.setColorMatrix(kopfNewX, kopfNewY, -1);
                    Snake.setHead(false);
                }

                // add new Fruit after time
                int random = (int)(Math.random()*5 + 2);
                if(java.lang.System.currentTimeMillis() > Snake.getTime()+random*1000 && Snake.getTime()>0) {
                    MiniSnakeGame.createRandomFruit();
                    Snake.setTime(0);
                }

                // normalize snakeSpeed after time
                if(java.lang.System.currentTimeMillis() > MiniSnakeGame.getTimerSnakeSpeed() + 6000 && MiniSnakeGame.getTimerSnakeSpeed()>0) {
                    Snake.setSnakeSpeed(4);
                    MiniSnakeGame.setTimerSnakeSpeed();
                }

                if(graphicElements.size() < 6) {
                    for(int i=0; i<4; i++) {
                        MiniSnakeGame.createRandomFruit();
                    }
                }
            }
        }
        counter++;
    }

    /**
     * Abstract methods that handle the input from
     * the user interface (wheel and buzzer)
     */
    public abstract void buzzered();

    public abstract void buzzerReleased();

    public abstract void wheelRotation(int rotationValue);

    public static boolean getGameOver(){
        return gameOver;
    }

    public static void setGameOver(boolean gO){
        gameOver = gO;
    }
}
