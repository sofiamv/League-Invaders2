import java.awt.Graphics;
import java.awt.Color;

public class Alien extends GameObject {
	 boolean isAlive = true;
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	public void update() {
		super.update();
		y+=4;
		
	}
	public void draw(Graphics g) {
	  g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
}
