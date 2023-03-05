package entities;

import static utliz.Constants.GameWindow.GAME_HEIGHT;
import static utliz.Constants.KRoad.LEFT_LIMIT;
import static utliz.Constants.KRoad.RIGHT_LIMIT;

import java.awt.Color;
import java.awt.Graphics;

public class Road implements Drawable {

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.drawLine(LEFT_LIMIT, 0, LEFT_LIMIT, GAME_HEIGHT);
		g.drawLine(RIGHT_LIMIT, 0, RIGHT_LIMIT, GAME_HEIGHT);
	}

}
