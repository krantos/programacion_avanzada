package gamestates;

import static utliz.Constants.GameWindow.TILE_SIZE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import game.GameContext;

public class PauseState implements State {

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Pause", TILE_SIZE, TILE_SIZE);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			GameContext.getContext().play();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
