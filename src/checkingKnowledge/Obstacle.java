package checkingKnowledge;

import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends Hitbox implements Drawable {


	public Obstacle(int x, int y, int width, int height) {
		super(x, y, width, height);
		initHitbox(x, y, width, height);
	}

	@Override
	public void update() {
		hitbox.y += 3;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect((int)hitbox.x, (int)hitbox.y, width, height);
	}

}
