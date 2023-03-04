package checkingKnowledge;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

	public KeyboardInputs() {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		ContextSingleton.getContext().getState().keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		ContextSingleton.getContext().getState().keyReleased(e);
	}

}
