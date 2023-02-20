package checkingKnowledge;

public class ContextSingleton {

	private static final GameContext instance = new GameContext();
	
	private ContextSingleton() {}
	
	public static GameContext getContext() {
		return instance;
	}
}
