package checkingKnowledge;

import static checkingKnowledge.Constants.GameWindow.TILE_SIZE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameOverState implements State {

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
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
		g.drawString("Press Spacebar to Restart", TILE_SIZE, TILE_SIZE * 2);
	}

}
