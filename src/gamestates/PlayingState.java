package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import entities.Drawable;
import entities.Obstacle;
import entities.ObstacleManager;
import entities.Player;
import entities.Points;
import entities.PointsManager;
import entities.Road;
import game.GameContext;

public class PlayingState implements State {

	private ArrayList<Drawable> entities;
	private final ObstacleManager obstacles;
	private final Player player;
	private final PointsManager points;
	private final Road road;

	public PlayingState(Points prevPoints) {
		entities = new ArrayList<>();
		road = new Road();
		player = new Player();
		points = new PointsManager(prevPoints);
		obstacles = new ObstacleManager(points);
		entities.add(player);
		entities.add(road);
		entities.add(obstacles);
		entities.add(points);
	}

	@Override
	public void update() {
		if (playerHit()) {
			GameContext.getContext().setGameOver(points.getScore());
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
			GameContext.getContext().pause();
			return;
		}
		player.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);
	}

}
