package checkingKnowledge;

import static checkingKnowledge.Constants.GameWindow.GAME_HEIGHT;
import static checkingKnowledge.Constants.GameWindow.TILE_SIZE;
import static checkingKnowledge.Constants.KRoad.LEFT_LIMIT;
import static checkingKnowledge.Constants.KRoad.RIGHT_LIMIT;
import static checkingKnowledge.Constants.Kplayer.SPEED;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Player extends Hitbox implements Drawable {
	
	private int speedX  = 0;
	private int speedY = 0;
	
	public Player() {
		super((int)((RIGHT_LIMIT - LEFT_LIMIT) / 2), GAME_HEIGHT - TILE_SIZE - 2, TILE_SIZE, TILE_SIZE);
		initHitbox(x, y, TILE_SIZE, TILE_SIZE);
		setOffsets(0, 0);
	}

	@Override
	public void update() {
		if(hitbox.y + hitbox.height + speedY < GAME_HEIGHT && hitbox.y + speedY > 0) {			
			hitbox.y += speedY;
		}
		
		if(hitbox.x + hitbox.width + speedX < RIGHT_LIMIT && hitbox.x + speedX > LEFT_LIMIT) {			
			hitbox.x += speedX;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect((int)(hitbox.x - xOffset), (int)(hitbox.y - yOffset), width, height);
		drawHitbox(g);
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
			speedX = -SPEED;
			break;
		case KeyEvent.VK_D:
			speedX = SPEED;
			break;
		case KeyEvent.VK_S:
			speedY = SPEED;
			break;
		case KeyEvent.VK_W:
			speedY = -SPEED;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
		case KeyEvent.VK_D:
			speedX = 0;
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_W:
			speedY = 0;
			break;
		}
	}
	
	
}
