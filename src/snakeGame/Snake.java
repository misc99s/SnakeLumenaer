package snakeGame;

import graphics.Color;
import graphics.GraphicElement;
import graphics.SpriteGraphicElement;
import graphics.SquareGraphicElement;
import lumenaer.PixelMatrix;

import java.util.ArrayList;
import java.util.List;

public class Snake extends GraphicElement {
    private int maxX;
    private Color color;
    private int posX;
    private int posY;

    private static int speedX;
    private static int speedY;
    private static int richtung;
    private static int snakeSpeed = 5;
    private static boolean head = false;

    public Snake(int posX, int posY) {
        speedX = 0;  //move right
        speedY = -1;  //move up, -speedY move down
        richtung = 0;
        maxX = 21; //outermost right position
        color = new Color (74,43,27);
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() { return posX; }
    public int getPosY() { return posY; }
    public void setPosX(int posX) { this.posX = posX; }
    public void setPosY(int posY) { this.posY = posY; }

    public int getSpeedX() {
        return speedX;
    }
    public int getSpeedY(){
        return speedY;
    }
    public void setSpeedX(int speedX){
        this.speedX = speedX;
    }
    public void setSpeedY(int speedY){
        this.speedY = speedY;
    }

    public int getRichtung() { return richtung; }
    public void setRichtung(int richtung) {
        this.richtung = richtung;
        if(richtung == 0) { //oben
            speedX = 0;
            speedY = -1;
        } else if (richtung == 1) { //links
            speedX = -1;
            speedY = 0;
        } else if (richtung == 2) { //unten
            speedX = 0;
            speedY = 1;
        } else { //rechts
            speedX = 1;
            speedY = 0;
        }
    }

    public int getSnakeSpeed(){return snakeSpeed;}
    public void setSnakeSpeed(int snakeSpeed){this.snakeSpeed = snakeSpeed;}
    public static boolean getHead(){return head;}
    public static void setHead(boolean h){head = h;}

    @Override
    public void render(PixelMatrix matrix) {
        matrix.setPixel(posY, posX, color);
    }

    public void update(List<Snake> l) {
        move(l);
    }

    public void move(List<Snake> l) {
        int kopf = l.size()-1;
        int [][] a = MiniSnakeGame.getColorMatrix();
        int kopfNewX = l.get(kopf).getPosX() + l.get(kopf).getSpeedX();
        int kopfNewY = l.get(kopf).getPosY() + l.get(kopf).getSpeedY();
        int index = a[kopfNewX][kopfNewY];
        if(index == -1) { // Schlange bewegen
            // Körperteile werden zum Kopf hochgerutscht
            if(l.get(kopf).getSpeedX() != 0 || l.get(kopf).getSpeedY() != 0) {
                for(int i=0; i<l.size()-1; i++) {
                    l.get(i).setPosX(l.get(i+1).getPosX());
                    l.get(i).setPosY(l.get(i+1).getPosY());
                }
            }

            // Kopf wird vorgerückt
            // xPos = xPos + xSpeed
            l.get(kopf).setPosX(kopfNewX);
            // yPos = yPos + ySpeed
            l.get(kopf).setPosY(kopfNewY);
            l.get(kopf).setSpeedX(0);
            l.get(kopf).setSpeedY(0);
        } else if(index > -1 && index < 100) {
            if(!head) {
                // Merker: Schlange wächst
                head = true;

                // Balken einfärben
                int r = MiniSnakeGame.getFruitColor(index).getRed();
                int g = MiniSnakeGame.getFruitColor(index).getBlue();
                int b = MiniSnakeGame.getFruitColor(index).getGreen();
                System.out.println("rot " + r + " grün " + g + " blau " + b); // gibt für rgb immer 0 zurück ?
                MiniSnakeGame.setBalkenColor(new Color(r, g, b));
                //MiniSnakeGame.setBalkenColor(MiniSnakeGame.getFruitColor(index));
                //MiniSnakeGame.setBalkenColor(new Color(255, 255, 255)); // funktioniert in weiß
                //System.out.println(MiniSnakeGame.getFruitColor(index));

                // Frucht entfernen und Index in colorMatrix korrigieren

                //GraphicElement frucht = (GraphicElement) MiniSnakeGame.getGraphicElements().get(a[kopfNewX][kopfNewY]);
                //System.out.println(MiniSnakeGame.getGraphicElements().get(a[kopfNewX][kopfNewY]));
                //MiniSnakeGame.getBalken().get(0).setColor(frucht.getColor());
                System.out.println(MiniSnakeGame.getGraphicElements().size() + " Früchte");
                MiniSnakeGame.getGraphicElements().remove(index);
                System.out.println(MiniSnakeGame.getGraphicElements().size() + " Früchte");
                for(int i=0; i<MiniSnakeGame.getGraphicElements().size(); i++) {
                    int x = MiniSnakeGame.getFruitX(i);
                    int y = MiniSnakeGame.getFruitY(i);
                    MiniSnakeGame.setColorMatrix(x, y, i);
                }


                //System.out.println(index);
                Balken.setFruitsEaten();
                System.out.println(Balken.getFruitsEaten() + " Früchte gegessen");
            }
        }
    }
}
