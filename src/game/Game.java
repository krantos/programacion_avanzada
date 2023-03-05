package game;

import static utliz.Constants.GameEngine.CLOCK_TIME;

import inputs.KeyboardInputs;

public class Game implements Runnable {

	private GamePanel panel;
	private GameContext gameState = ContextSingleton.getContext();

	Game() {
		createGameWindow();
		startGameLoop();
		gameState.restart();
	}

	private void createGameWindow() {
		panel = new GamePanel();
		addControls();
		new GameWindow(panel);
	}

	private void addControls() {
		KeyboardInputs keys = new KeyboardInputs();
		panel.setKeyboard(keys);
	}

	private void startGameLoop() {
		Thread thread = new Thread(this);
		thread.start();
	}

	private void updateGame() {
		gameState.getState().update();
	}

	private void repaint() {
		panel.repaint();
	}

	@Override
	public void run() {
		int iFPS = 0;
		double currentTime = System.nanoTime();
		long lastTimeCheck = System.currentTimeMillis();
		while (true) {
			double now = System.nanoTime();
			if ((now - currentTime) > CLOCK_TIME) {
				updateGame();
				repaint();
				iFPS++;
				currentTime = System.nanoTime();
			}

			if ((System.currentTimeMillis() - lastTimeCheck) > 1000) {
				System.out.println(iFPS);
				iFPS = 0;
				lastTimeCheck = System.currentTimeMillis();
			}
		}
	}

}
