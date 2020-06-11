package snakeGame;

import graphics.Color;

/**slows the snake down*/

abstract class BlueBerryFruit extends Fruit{
    Color color;

    public BlueBerryFruit(){
        super();
        color = new Color(0, 213, 255);
    }
}
