package checkingKnowledge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import static checkingKnowledge.Constants.GameWindow.TILE_SIZE;

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
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {			
			ContextSingleton.getContext().play();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
