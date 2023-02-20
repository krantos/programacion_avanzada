package checkingKnowledge;

import java.awt.Graphics;

public interface State  extends KeyboardInterface{

	public void update();
	
	public void render(Graphics g);
	
}
