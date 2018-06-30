import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	GamePanel b = new GamePanel();
	JFrame frame;
	final static int HEIGHT = 800;
	final static int WIDTH = 500;
	LeagueInvaders(){
		frame = new JFrame();
	}
	public static void main(String[] args) {
	LeagueInvaders a = new LeagueInvaders();
	a.setup();
}
	public void setup() {
		frame.addKeyListener(b);
		frame.add(b);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		b.startGame();
	
	}
}
