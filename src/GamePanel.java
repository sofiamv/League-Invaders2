import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer aa;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font textFont;
	Graphics graphic;
	Rocketship aaaa = new Rocketship(250, 700, 50, 50);
	ObjectManager objectm = new ObjectManager(aaaa);
	int 	projectileposition = aaaa.x + 20;
	// GameObject aaa;
	GamePanel(){
		aa = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		textFont = new Font("Arial", Font.PLAIN, 30);
		// aaa = new GameObject(1, 1, 1, 1);
	}

	public void updateMenuState() {

	}

	public void updateGameState() {
objectm.update();
objectm.ManageEnemies();
	}

	public void updateEndState() {

	}

	public void drawMenustate(Graphics a) {
		a.setColor(Color.BLUE);
		a.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		a.setFont(titleFont);
		a.setColor(Color.YELLOW);
		a.drawString("League Invaders!", 75, 100);
		a.setFont(textFont);
		a.drawString("Press ENTER to start", 100, 400);
		a.drawString("Press SPACE for instructions", 50, 600);
	}

	public void drawGamestate(Graphics b) {
		b.setColor(Color.BLACK);
		b.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		objectm.draw(b);
	}

	public void drawEndstate(Graphics c) {
		c.setColor(Color.RED);
		c.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		c.setColor(Color.BLACK);
		c.setFont(titleFont);
		c.drawString("Game Over!", 75, 100);
		c.setFont(textFont);
		c.drawString("You killed _ enemies", 75, 400);
		c.drawString("Press ENTER to restart", 50, 600);
	}

	public void startGame() {
		aa.start();
	}

	@Override

	public void paintComponent(Graphics g) {
		// aaa.draw(g);
		if (currentState == MENU_STATE) {
			drawMenustate(g);
		} else if (currentState == GAME_STATE) {
			drawGamestate(g);
		} else if (currentState == END_STATE) {
			drawEndstate(g);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
			
		} else if (currentState == GAME_STATE) {
			updateGameState();
			objectm.checkCollision();
			objectm.purgeObjects();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
		// aaa.update();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	///	System.out.println("Hello");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("What's up?");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			aaaa.update("left");
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			aaaa.update("right");
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
		aaaa.update("down");
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
		aaaa.update("up");
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			objectm.addProjectile(new Projectile(aaaa.x, aaaa.y, 10, 10));
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	//	System.out.println("Have a good day!");

	}
}

