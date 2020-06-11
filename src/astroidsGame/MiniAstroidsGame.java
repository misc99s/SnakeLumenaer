package astroidsGame;

import graphics.Color;
import lumenaer.Game;
import lumenaer.PixelMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class MiniAstroidsGame extends Game {

	SpaceShip spaceShip;
	Bar bar;
	List<Projectile> projectiles;
	int counter;

	public MiniAstroidsGame(PixelMatrix matrix) {

		super(matrix);
		spaceShip = new SpaceShip(0, 3);
		bar = new Bar(15,20,3,1, Color.BLUE);

		graphicElements.add(spaceShip);
		graphicElements.add(bar);

		projectiles = new CopyOnWriteArrayList<>();

		pixelMatrix.setBackgroundColor(new Color(220,230,47));
		counter = 0;
	}

	@Override
	public void nextGameStep() {

		//check collision
		for (Projectile p : projectiles) {
			if (spaceShip.intersects(p)) {
				p.explode();
				counter ++;
			}
		}

		//select references that can be destroyed
		for (Projectile p : projectiles) {
			if (p.isDestroyed() || p.getY() < 0) {
				graphicElements.remove(p);
				projectiles.remove(p);
			}
		}
		super.nextGameStep();
	}

	@Override
	public void buzzered() {

		// generate a new Projectile
		Projectile p = new Projectile(bar.getX()+1, bar.getY(),1,Color.BLACK);

		//"doppelte Buchhaltung": projectiles are in graphicElements to be rendered,
		// and in the projectiles-List to be managed better.
		graphicElements.add(p);
		projectiles.add(p);

	}

	@Override
	public void buzzerReleased() {
	}

	@Override
	public void wheelRotation(int rotationValue) {


		int newXValue = bar.getX() - rotationValue;

		if (newXValue < 0 ) {
			newXValue = 0;
		}

		if (newXValue + bar.getWidth() > 23) {
			newXValue = 24 - bar.getWidth();
		}
		bar.move(newXValue,bar.getY()); // y-value stays the same
	}
}
