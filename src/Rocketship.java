import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
int speed;
boolean isAlive = true;
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}
public void draw(Graphics g) {
g.setColor(Color.BLUE);	
g.fillRect(x, y, width, height);
}
public void update(String move) {
super.update();
	super.update();
	if(move.equals("right")) {
		x+=speed;
	}if(move.equals("left")) {
		x-=speed;
	}if(move.equals("up")) {
		y-=speed;
	}if(move.equals("down")) {
		y+=speed;
	}
	
	}
	
}

