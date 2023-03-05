package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import entities.Drawable;
import entities.Obstacle;
import entities.ObstacleManager;
import entities.Player;
import entities.Points;
import entities.Road;
import game.ContextSingleton;

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
		if (playerHit()) {
			ContextSingleton.getContext().gameOver(points.getScore());
		}
		for (Drawable e : entities) {
			e.update();
		}
	}

	private boolean playerHit() {
		for (Obstacle o : obstacles.getObstacles()) {
			if (player.getHitbox().intersects(o.getHitbox()))
				return true;
		}
		return false;
	}

	@Override
	public void render(Graphics g) {
		for (Drawable e : entities) {
			e.draw(g);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
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
