package checkingKnowledge;

public class GameContext {

	private State gameState = null;
	private PlayingState playing = new PlayingState();
	private PauseState pause = new PauseState();
	private GameOverState gameOver = new GameOverState();

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
		playing = new PlayingState();
		play();
	}

	public void gameOver(int points) {
		gameOver.setPoints(points);
		gameState = gameOver;
	}

	public State getState() {
		return gameState;
	}

}
