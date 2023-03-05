package game;

import static utliz.Constants.GameWindow.FONT_SIZE;
import static utliz.Constants.GameWindow.GAME_HEIGHT;
import static utliz.Constants.GameWindow.GAME_WIDTH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInputs;

public class GamePanel extends JPanel {

	GamePanel() {
		setBackground(Color.LIGHT_GRAY);
		setFocusable(true);
		requestFocusInWindow();
		setSize();
	}

	private void setSize() {
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setPreferredSize(size);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, (int) FONT_SIZE));
		GameContext gameContext = ContextSingleton.getContext();
		gameContext.getState().render(g);
	}

	public void setKeyboard(KeyboardInputs keyboardInputs) {
		addKeyListener(keyboardInputs);
	}

}
