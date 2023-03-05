package entities;

import static utliz.Constants.GameWindow.GAME_HEIGHT;
import static utliz.Constants.GameWindow.TILE_SIZE;
import static utliz.Constants.KRoad.LEFT_LIMIT;
import static utliz.Constants.KRoad.RIGHT_LIMIT;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObstacleManager implements Drawable {

	private ArrayList<Obstacle> obstacles;
	private PointsManager points;
	private ObstacleCreator obstacleCreator;

	public ObstacleManager(PointsManager points) {
		this.points = points;
		obstacles = new ArrayList<>();
		obstacleCreator = new ObstacleCreator();
		obstacleCreator.start();
	}

	public void destroy() {
		obstacleCreator.stop();
	}

	public void pause() {
		if (!obstacleCreator.threadSuspended)
			obstacleCreator.mySuspend();
	}

	public void resume() {
		if (obstacleCreator.threadSuspended)
			obstacleCreator.myResume();
	}

	public ArrayList<Obstacle> getObstacles() {
		return this.obstacles;
	}

	@Override
	public void update() {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
			if (obstacles.get(i).getHitbox().y > GAME_HEIGHT) {
				points.increaseBy(obstacles.get(i).getPoints());
				obstacles.remove(i);
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		for (Obstacle o : obstacles) {
			o.draw(g);
		}
	}

	class ObstacleCreator implements Runnable {

		private Thread worker;
		protected boolean threadSuspended = false;

		public void stop() {
			worker = null;
		}

		synchronized void mySuspend() {
			threadSuspended = true;
		}

		synchronized void myResume() {
			threadSuspended = false;
			notify();
		}

		public void start() {
			if (worker == null) {
				worker = new Thread(this);
				worker.start();
			}
		}

		@Override
		public void run() {
			Thread thisThread = Thread.currentThread();
			while (worker == thisThread) {
				try {
					Thread.sleep(250);
					synchronized (this) {
						while (threadSuspended) {
							wait();
						}
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					Thread.currentThread().interrupt();
				}
				Obstacle o = new Obstacle((int) (LEFT_LIMIT + Math.random() * ((RIGHT_LIMIT - LEFT_LIMIT - TILE_SIZE) + 1)),
				    -TILE_SIZE, TILE_SIZE, TILE_SIZE);
				obstacles.add(o);
			}
		}
	}
}
