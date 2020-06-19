package lumenaer;

import graphics.Color;
import graphics.GraphicElement;
import snakeGame.Snake;
import snakeGame.MiniSnakeGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Base class for all games. Own games must extend this class.
 *
 */
public abstract class Game {

    /* A pixel matrix, where to displayPixelMatrix the game.*/
    protected PixelMatrix pixelMatrix; // just for convenience
    protected int counter = 0;

    /* Array for storing all individual graphic objects to be drawn */
    protected List<GraphicElement> graphicElements;

    protected List<Snake> snakeParts = new ArrayList<>();
    protected List<GraphicElement> balken = new ArrayList<>();

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
        if(counter % snakeParts.get(snakeParts.size()-1).getSnakeSpeed() == 0) {
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
}
