package snakeGame;

import graphics.Color;
import graphics.GraphicElement;
import graphics.SpriteGraphicElement;
import graphics.SquareGraphicElement;
import lumenaer.Game;
import lumenaer.PixelMatrix;

import java.util.ArrayList;
import java.util.List;

/**Snake Class, defines properties and movement of the snake*/
public class Snake extends GraphicElement {
    private static int speedX;
    private static int speedY;
    private static int richtung;
    private static int snakeSpeed = 4;
    private static boolean head = false;
    private static double time;

    public Snake(int posX, int posY) {
        speedX = 0;  //move right
        speedY = -1;  //move up, -speedY move down
        richtung = 0;
        color = new Color (74,43,27);
        this.x = posX;
        this.y = posY;
    }
    /**returns X Position*/
    public int getPosX() { return x; }
    /**returns Y Position*/
    public int getPosY() { return y; }
    /**sets X Position*/
    public void setPosX(int posX) { this.x = posX; }
    /**sets Y Position*/
    public void setPosY(int posY) { this.y = posY; }

    /**returns Speed in X direction*/
    public int getSpeedX() {
        return speedX;
    }
    /**returns Speed in Y direction*/
    public int getSpeedY(){
        return speedY;
    }
    /**sets Speed in X direction*/
    public void setSpeedX(int speedX){
        this.speedX = speedX;
    }
    /**sets Speed in Y direction*/
    public void setSpeedY(int speedY){
        this.speedY = speedY;
    }
    /**returns the Snake's current direction*/
    public int getRichtung() { return richtung; }
    /**sets the Snake's direction*/
    public void setRichtung(int richtung) {
        this.richtung = richtung;
        /**up*/
        if(richtung == 0) { //oben
            speedX = 0;
            speedY = -1;
            /**left*/
        } else if (richtung == 1) { //links
            speedX = -1;
            speedY = 0;
            /**down*/
        } else if (richtung == 2) { //unten
            speedX = 0;
            speedY = 1;
            /**right*/
        } else { //rechts
            speedX = 1;
            speedY = 0;
        }
    }

    /**returns snakeSpeed*/
    public static int getSnakeSpeed(){return snakeSpeed;}
    /**sets snakeSpeed with a  passed value s*/
    public static void setSnakeSpeed(int s){snakeSpeed = s;}
    /**when new head is created*/
    public static boolean getHead(){return head;}
    /**sets the new head*/
    public static void setHead(boolean h){head = h;}
    /**returns the time*/
    public static double getTime() {return time;}
    /**sets the time*/
    public static void setTime(double t) {time = t;}


    /**renders the pixelMatrix*/
    @Override
    public void render(PixelMatrix matrix) {
        matrix.setPixel(y, x, color);
    }
    /**makes the snake move by 1 square*/
    public void update(List<Snake> l) {
        move(l);
    }

    /**makes the snake move*/
    public void move(List<Snake> l) {
        if(!Game.getGameOver()) {
            int kopf = l.size()-1;
            int [][] a = MiniSnakeGame.getColorMatrix();
            int kopfNewX = l.get(kopf).getPosX() + l.get(kopf).getSpeedX();
            int kopfNewY = l.get(kopf).getPosY() + l.get(kopf).getSpeedY();
            /**checks to see if the head is out of bounds, (hits a wall) & sets gameOver to true if this is the case*/
            if(kopfNewX>23 || kopfNewY>22 || kopfNewX<0 || kopfNewY<0) {
                Game.setGameOver(true);
                /**else: moves the snake*/
            } else {
                int index = a[kopfNewX][kopfNewY];
                if(index == -1) { // Schlange bewegen
                    /**last snake part becomes the head, creating the illusion of movement*/
                    if(l.get(kopf).getSpeedX() != 0 || l.get(kopf).getSpeedY() != 0) {
                        for(int i=0; i<l.size()-1; i++) {
                            l.get(i).setPosX(l.get(i+1).getPosX());
                            l.get(i).setPosY(l.get(i+1).getPosY());
                        }
                    }

                    // Kopf wird vorgerückt
                    // xPos = xPos + xSpeed
                    /**moves the head*/
                    l.get(kopf).setPosX(kopfNewX);
                    // yPos = yPos + ySpeed
                    l.get(kopf).setPosY(kopfNewY);
                    l.get(kopf).setSpeedX(0);
                    l.get(kopf).setSpeedY(0);
                } else if(index > -1 && index < 100) {
                    if(!head) {
                        // Merker: Schlange wächst
                        head = true;
                        /**colors the status bar in the color that was eaten*/
                        // Balken einfärben
                        int r = MiniSnakeGame.getFruitColor(index).getRed();
                        int g = MiniSnakeGame.getFruitColor(index).getBlue();
                        int b = MiniSnakeGame.getFruitColor(index).getGreen();
                        if(g!=67) {
                            MiniSnakeGame.setBalkenColor(new Color(r, g, b));
                            Balken.setFruitsEaten();
                        }
                        //MiniSnakeGame.setBalkenColor(MiniSnakeGame.getFruitColor(index))
                        //System.out.println(MiniSnakeGame.getFruitColor(index));

                        // Frucht entfernen und Index in colorMatrix korrigieren
                        /**removes fruit after eaten and colors the Pixel back to green*/
                        MiniSnakeGame.getGraphicElements().remove(index);
                        for(int i=0; i<MiniSnakeGame.getGraphicElements().size(); i++) {
                            int x = MiniSnakeGame.getFruitX(i);
                            int y = MiniSnakeGame.getFruitY(i);
                            MiniSnakeGame.setColorMatrix(x, y, i);
                        }
                        // start time for new fruit
                        time = java.lang.System.currentTimeMillis();
                    }
                }
            }
        }
    }
}
