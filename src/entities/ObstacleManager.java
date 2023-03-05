package entities;

import static utliz.Constants.GameWindow.GAME_HEIGHT;
import static utliz.Constants.GameWindow.TILE_SIZE;
import static utliz.Constants.KRoad.LEFT_LIMIT;
import static utliz.Constants.KRoad.RIGHT_LIMIT;
import static utliz.Constants.GameEngine.*;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObstacleManager implements Drawable {

	private ArrayList<Obstacle> obstacles;
	private Points points;
	private float timeBetweenObstacle = 0.3f;
	private float timer = 0.0f;

	public ObstacleManager(Points points) {
		this.points = points;
		obstacles = new ArrayList<>();
	}

	public ArrayList<Obstacle> getObstacles() {
		return this.obstacles;
	}

	private void addObstacle() {
		Obstacle o = new Obstacle((int) (LEFT_LIMIT + Math.random() * ((RIGHT_LIMIT - LEFT_LIMIT - TILE_SIZE) + 1)),
		    -TILE_SIZE, TILE_SIZE, TILE_SIZE);
		obstacles.add(o);
	}

	@Override
	public void update() {
		if (timer < timeBetweenObstacle) {
			timer += DELTA_TIME;
		} else {
			System.out.println("Added Obstacle");
			addObstacle();
			timer = 0;
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
			if (obstacles.get(i).getHitbox().y > GAME_HEIGHT) {
				points.increaseBy(obstacles.get(i).getPoints());
				obstacles.remove(i);
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		for (Obstacle o : obstacles) {
			o.draw(g);
		}
	}
}
