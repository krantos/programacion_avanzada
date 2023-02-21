package checkingKnowledge;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PlayingState implements State {
	
	private ArrayList<Drawable> entities;
	private ObstacleManager obstacles;
	private Player player;
	private Points points;
	private Road road;
	
	public PlayingState() {
		createEntities();
	}
	
	private void createEntities() {
		entities = new ArrayList<>();
		road = new Road();
		player = new Player();
		points = new Points();
		obstacles = new ObstacleManager(points);
		entities.add(player);
		entities.add(road);
		entities.add(obstacles);
		entities.add(points);
	}

	@Override
	public void update() {
		if(playerHit()) {
			obstacles.destroy();
			ContextSingleton.getContext().gameOver(points.getScore());
		} 
		obstacles.resume();
		for(Drawable e : entities) {
			e.update();
		}
	}
	
	private boolean playerHit() {
		for(Obstacle o : obstacles.getObstacles()) {
			if(player.hitbox.intersects(o.hitbox))
				return true;
		}
		return false;
	}

	@Override
	public void render(Graphics g) {
		for(Drawable e: entities) {
			e.draw(g);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			obstacles.pause();
			ContextSingleton.getContext().pause();
			return;
		}
		player.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);
	}

}
