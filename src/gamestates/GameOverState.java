package gamestates;

import static utliz.Constants.GameWindow.TILE_SIZE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import game.ContextSingleton;

public class GameOverState implements State {

	private int points;

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			ContextSingleton.getContext().restart();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Game Over", TILE_SIZE, TILE_SIZE);
		g.drawString("Your Score was: " + points, TILE_SIZE, TILE_SIZE * 3);
		g.drawString("Press Spacebar to Restart", TILE_SIZE, TILE_SIZE * 5);
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
