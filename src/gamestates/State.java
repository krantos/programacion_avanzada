package gamestates;

import java.awt.Graphics;

import inputs.KeyboardInterface;

public interface State extends KeyboardInterface {

	public void update();

	public void render(Graphics g);

}
