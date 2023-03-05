package game;

import entities.Points;
import gamestates.GameOverState;
import gamestates.PauseState;
import gamestates.PlayingState;
import gamestates.State;
import storage.FileStorage;
import storage.PointStorage;

public class GameContext {

	private State gameState = null;
	private PlayingState playing;
	private PauseState pause;
	private GameOverState gameOver;
	private PointStorage pointStorage;

	public GameContext() {
		pause = new PauseState();
		gameOver = new GameOverState();
		pointStorage = new FileStorage();
		playing = new PlayingState(pointStorage.readPoints());
	}

	public void setState(State state) {
		gameState = state;
	}

	public void play() {
		gameState = playing;
	}

	public void pause() {
		gameState = pause;
	}

	public void restart() {
		playing = new PlayingState(pointStorage.readPoints());
		play();
	}

	public void setGameOver(Points points) {
		pointStorage.savePoints(points);
		gameOver.setPoints(points.getPoints());
		gameState = gameOver;
	}

	public State getState() {
		return gameState;
	}

}
