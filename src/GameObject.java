import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
int x;
int y;
int width;
int height;
Rectangle collisionbox;
GameObject(int x, int y, int width, int height){
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	collisionbox = new Rectangle(x, y, width, height);
}
public void update() {
//x++;
//y++;
}
public void draw(Graphics c) {
//c.fillRect(x, y, 100, 100);
}
}
