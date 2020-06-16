package snakeGame;

import astroidsGame.Projectile;
import graphics.Color;
import graphics.GraphicElement;
import lumenaer.Game;
import lumenaer.PixelMatrix;

import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.black;

public class MiniSnakeGame extends Game {
    //private ArrayList<Fruit> fruits = new ArrayList();
    private int numberOfFruits = 10;
    //private Snake[] snake;
    public MiniSnakeGame(PixelMatrix matrix) {
        super(matrix);
        pixelMatrix.setBackgroundColor(new Color(119,217,126));
        for(int i=0; i<numberOfFruits; i++) {
            createRandomFruit();
        }
        System.out.println(graphicElements);

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
        if(random <= 60){
            Fruit a = new AppleFruit();
            graphicElements.add(a);
        } else if(random > 60 && random <= 80) {
            Fruit b = new BananaFruit();
            graphicElements.add(b);
        } else {
            Fruit c = new BlueBerryFruit();
            graphicElements.add(c);
        }
    }

    @Override
    public void buzzered() {

    }

    @Override
    public void buzzerReleased() {

    }

    @Override
    public void wheelRotation(int rotationValue) {

    }
}
