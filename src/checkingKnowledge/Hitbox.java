package checkingKnowledge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Hitbox {

	protected int x, y, width, height;
	protected float xOffset, yOffset;
	protected Rectangle2D.Float hitbox;
	
	public Hitbox(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	protected void initHitbox(float x, float y, float width, float height) {
		this.hitbox = new Rectangle2D.Float(x, y, width, height);
	}
	
	protected void setOffsets(float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public Rectangle2D.Float getHitbox() {
		return this.hitbox;
	}
	
	public void drawHitbox(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
	}
}
