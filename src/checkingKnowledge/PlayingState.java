package checkingKnowledge;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PlayingState implements State {
	
	private ArrayList<Drawable> entities;
	private ObstacleManager obstacles;
	private Player player;
	private Road road;
	
	public PlayingState() {
		createEntities();
	}
	
	private void createEntities() {
		entities = new ArrayList<>();
		road = new Road();
		player = new Player(road);
		obstacles = new ObstacleManager(2);
		entities.add(player);
		entities.add(road);
		entities.add(obstacles);
	}

	@Override
	public void update() {
		for(Drawable e : entities) {
			e.update();
		}
		if(playerHit()) {
			ContextSingleton.getContext().gameOver();
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
		switch(e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			ContextSingleton.getContext().pause();
		}
		player.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);
	}

}
