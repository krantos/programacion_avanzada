package entities;

import static utliz.Constants.GameWindow.GAME_WIDTH;
import static utliz.Constants.GameWindow.TILE_SIZE;
import static utliz.Constants.KRoad.RIGHT_LIMIT;

import java.awt.Color;
import java.awt.Graphics;

public class PointsManager implements Drawable {

	private final Points points;
	private Points prevPoints;

	public PointsManager(Points prevPoints) {
		points = new Points();
		this.prevPoints = prevPoints;
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(GAME_WIDTH - TILE_SIZE * 10, TILE_SIZE / 4, TILE_SIZE * 2, TILE_SIZE);
		g.setColor(Color.DARK_GRAY);
		g.drawString(String.format("%04d", points.getPoints()), GAME_WIDTH - TILE_SIZE * 10, TILE_SIZE);

		g.drawString(prevPoints.toString(), RIGHT_LIMIT + TILE_SIZE, TILE_SIZE * 2);
	}

	public void increaseBy(int obstaclePoints) {
		points.add(obstaclePoints);
	}

	public Points getScore() {
		return points;
	}

}
