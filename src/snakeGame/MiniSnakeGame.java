package snakeGame;

import astroidsGame.Projectile;
import graphics.Color;
import lumenaer.Game;
import lumenaer.PixelMatrix;

import java.util.List;

public class MiniSnakeGame extends Game {
    List<Fruit>fruits;

    private Snake[] snake;
    public MiniSnakeGame(PixelMatrix matrix) {
        super(matrix);
        pixelMatrix.setBackgroundColor(new Color(119,217,126));
    }

    public void createRandomFruit(){
        int random = (int) Math.random()*10;
        if(random <= 6){

        }else if(random > 6 && random <= 8){

        }else if(random > 8 && random <= 10){

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
