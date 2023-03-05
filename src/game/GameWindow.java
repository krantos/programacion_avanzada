package game;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow {

	private JFrame jFrame;

	GameWindow(JPanel jPanel) {
		jFrame = new JFrame("My Game");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setResizable(false);
		jFrame.add(jPanel);
		jFrame.pack();
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
	}
}
