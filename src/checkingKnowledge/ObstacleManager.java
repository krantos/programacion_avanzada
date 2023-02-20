package checkingKnowledge;

import static checkingKnowledge.Constants.KRoad.*;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import static checkingKnowledge.Constants.GameWindow.*;

public class ObstacleManager implements Drawable {
	
	private ArrayList<Obstacle> obstacles;
	private Points points;
	private ObstacleCreator obstacleCreator;
	
	public ObstacleManager(Points points) {
		this.points = points;
		obstacles = new ArrayList<>();
		obstacleCreator = new ObstacleCreator();
		obstacleCreator.start();
	}
	
	public void destroy() {
		obstacleCreator.stop();
	}
	
	public void pause() {
		if(!obstacleCreator.threadSuspended)
			obstacleCreator.mySuspend();
	}
	
	public void resume() {
		if(obstacleCreator.threadSuspended)
			obstacleCreator.myResume();
	}
	
	public ArrayList<Obstacle> getObstacles() {
		return this.obstacles;
	}

	@Override
	public void update() {
		for(int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
			if(obstacles.get(i).hitbox.y > GAME_HEIGHT) {
				points.increaseBy(obstacles.get(i).getPoints());
				obstacles.remove(i);
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		for(Obstacle o : obstacles) {
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
			if(worker == null) {
				worker = new Thread(this);
				worker.start();
			}
		}

		@Override
		public void run() {
			Thread thisThread = Thread.currentThread();
			while(worker == thisThread) {
				try {					
					Thread.sleep(400);
					synchronized (this) {
						while(threadSuspended) {
							wait();
						}
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					Thread.currentThread().interrupt();					
				}
				Obstacle o = new Obstacle((int)(LEFT_LIMIT +  Math.random() * ((RIGHT_LIMIT - LEFT_LIMIT - TILE_SIZE) + 1)), -TILE_SIZE, TILE_SIZE, TILE_SIZE);
				obstacles.add(o);
			}
		}
	}
}