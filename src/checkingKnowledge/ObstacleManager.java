package checkingKnowledge;

import java.awt.Graphics;
import java.util.ArrayList;

import static checkingKnowledge.Constants.GameWindow.*;

public class ObstacleManager implements Drawable {
	
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	private int diffuculty;
	
	public ObstacleManager(int difficulty) {
		this.diffuculty = difficulty;
		createObstacles();
	}
	
	private void createObstacles() {
		for(int i = 0; i <= diffuculty; i++) {
			obstacles.add(new Obstacle(200 + TILE_SIZE * i, -150 + TILE_SIZE * i, TILE_SIZE, TILE_SIZE));
		}
	}
	
	public ArrayList<Obstacle> getObstacles() {
		return this.obstacles;
	}

	@Override
	public void update() {
		for(Obstacle o : obstacles) {
			o.update();
		}
	}

	@Override
	public void draw(Graphics g) {
		for(Obstacle o : obstacles) {
			o.draw(g);
		}
	}

}
