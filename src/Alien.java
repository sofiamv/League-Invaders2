import java.awt.Graphics;
import java.awt.Color;

public class Alien extends GameObject {
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	public void update() {
		y+=4
		super.update();;
	}
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
