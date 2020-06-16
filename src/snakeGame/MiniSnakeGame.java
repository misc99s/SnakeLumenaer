package snakeGame;

import astroidsGame.Projectile;
import graphics.Color;
import lumenaer.Game;
import lumenaer.PixelMatrix;

import java.util.ArrayList;
import java.util.List;

public class MiniSnakeGame extends Game {
    private static ArrayList<Fruit> fruits;
    private int numberOfFruits = 7;

    private Snake[] snake;
    public MiniSnakeGame(PixelMatrix matrix) {
        super(matrix);
        pixelMatrix.setBackgroundColor(new Color(119,217,126));
        for(int i=0; i<numberOfFruits; i++) {
            createRandomFruit();
        }
    }

    public void createRandomFruit() {
        int random = (int)Math.round(Math.random()*100);
        if(random <= 60){
            Fruit a = new AppleFruit();
            fruits.add(a);
        } else if(random > 60 && random <= 80) {
            Fruit b = new BananaFruit();
            fruits.add(b);
        } else {
            Fruit c = new BlueBerryFruit();
            fruits.add(c);
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
