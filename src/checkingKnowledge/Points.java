package checkingKnowledge;

import static checkingKnowledge.Constants.GameWindow.GAME_WIDTH;
import static checkingKnowledge.Constants.GameWindow.TILE_SIZE;

import java.awt.Color;
import java.awt.Graphics;

public class Points implements Drawable {

	private float points = 0;

	@Override
	public void update() {
		points += 0.02;
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(GAME_WIDTH - TILE_SIZE * 10, (int) (TILE_SIZE / 4), TILE_SIZE * 2, TILE_SIZE);
		g.setColor(Color.DARK_GRAY);
		g.drawString(String.format("%04d", (int) points), GAME_WIDTH - TILE_SIZE * 10, TILE_SIZE);
	}

	public void increaseBy(int obstaclePoints) {
		points += obstaclePoints;
	}

	public int getScore() {
		return (int) points;
	}

}
