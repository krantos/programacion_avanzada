package checkingKnowledge;

import static checkingKnowledge.Constants.GameWindow.*;

import java.awt.Graphics;

public class Points implements Drawable{

	private float points = 0;
	
	@Override
	public void update() {
		points += 0.035;
	}

	@Override
	public void draw(Graphics g) {
		g.drawString(String.format("%04d", (int)points), GAME_WIDTH - TILE_SIZE * 4, TILE_SIZE);
	}

	public void increaseBy(int obstaclePoints) {
		points += obstaclePoints;
	}
	
	public int getScore() {
		return (int)points;
	}

}
