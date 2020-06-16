package snakeGame;

import graphics.Color;
import graphics.GraphicElement;
import graphics.SpriteGraphicElement;
import graphics.SquareGraphicElement;
import lumenaer.PixelMatrix;

public class Snake extends GraphicElement {
    private int maxX;
    private Color color;
    private int posX;
    private int posY;
    private int speedX;
    private int speedY;


    public Snake(int posX, int posY) {
        speedX = 0;  //move right
        speedY = -1;  //move up, -speedY move down
        maxX = 21; //outermost right position
        color = new Color (74,43,27);
        this.posX = posX;
        this.posY = posY;
    }

    public int getSpeedX(){
        return this.speedX;
    }

    public int getSpeedY(){
        return this.speedY;
    }

    public void setSpeedX(int speedX){
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY){
        this.speedY = speedY;
    }

    @Override
    public void render(PixelMatrix matrix) {
        matrix.setPixel(posY, posX, color);
    }

    public void update(){
        move();
    }

    public void move(){
    }
}
