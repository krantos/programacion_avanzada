package game;

import inputs.KeyboardInputs;

public class Game implements Runnable {

	private final int FPS = 60;
	private GamePanel panel;
	private GameContext gameState = ContextSingleton.getContext();

	Game() {
		createGameWindow();
		startGameLoop();
		gameState.play();
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
			if ((now - currentTime) > 1000000000.0 / FPS) {
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
