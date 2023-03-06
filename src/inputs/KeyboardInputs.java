package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.GameContext;

public class KeyboardInputs implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		GameContext.getContext().getState().keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		GameContext.getContext().getState().keyReleased(e);
	}

}
