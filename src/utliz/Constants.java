package utliz;

public class Constants {
	
	public static class GameEngine {
		public static final int FPS = 60;
		public static final double CLOCK_TIME = 1000000000.0 / FPS;
		public static final float DELTA_TIME = 1.0f / FPS;
	}

	public static class GameWindow {
		public static final int TILES_REAL_SIZE = 16;
		public static int SCALE = 2;
		public static float FONT_SIZE = TILES_REAL_SIZE * 1.5f;
		public static int TILE_SIZE = TILES_REAL_SIZE * SCALE;
		public static int TILES_IN_WIDTH = 15;
		public static int TILES_IN_HEIGHT = 24;
		public static int GAME_WIDTH = TILE_SIZE * TILES_IN_WIDTH;
		public static int GAME_HEIGHT = TILE_SIZE * TILES_IN_HEIGHT;
	}

	public static class KGameLogic {
		public static int GRAVITY = (int) 1.5f * Constants.GameWindow.SCALE;
	}

	public static class Kplayer {
		public static int SPEED = (int) 2.5f * Constants.GameWindow.SCALE;
	}

	public static class KRoad {
		public static int LEFT_LIMIT = (int) Constants.GameWindow.TILE_SIZE * 2;
		public static int RIGHT_LIMIT = (int) Constants.GameWindow.TILE_SIZE * 10;
	}

}
