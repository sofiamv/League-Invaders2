import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<Projectile> ProjectileObjects = new ArrayList<Projectile>();
	ArrayList<Alien> AlienObjects = new ArrayList<Alien>();
	Rocketship rocket;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score = 0;



	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}
	public int getScore(){
		return score;
	}

	public void update() {
		rocket.update();
		for (int i = 0; i < ProjectileObjects.size(); i++) {
			ProjectileObjects.get(i).update();
		}
		for (int i = 0; i < AlienObjects.size(); i++) {
			AlienObjects.get(i).update();
		}

	}

	public void draw(Graphics graphic) {
		rocket.draw(graphic);
		for (int i = 0; i < ProjectileObjects.size(); i++) {
			ProjectileObjects.get(i).draw(graphic);
		}
		for (int i = 0; i < AlienObjects.size(); i++) {
			AlienObjects.get(i).draw(graphic);
		}

	}

	public void addProjectile(Projectile a) {
		ProjectileObjects.add(a);
	}

	public void addAlien(Alien b) {
		AlienObjects.add(b);
	}

	public void ManageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}

	}

	public void purgeObjects() {
		for (int i = 0; i < AlienObjects.size(); i++) {
			if (AlienObjects.get(i).y < 0) {
				AlienObjects.remove(AlienObjects.get(i));
			}
		}
		for (int i = 0; i < AlienObjects.size(); i++) {
			if (AlienObjects.get(i).isAlive == false) {
				AlienObjects.remove(i);
			}
		}

		for (int i = 0; i < ProjectileObjects.size(); i++) {
			if (ProjectileObjects.get(i).y < 0) {
				ProjectileObjects.remove(ProjectileObjects.get(i));
			}
		}
		for (int i = 0; i < ProjectileObjects.size(); i++) {
			if (ProjectileObjects.get(i).isAlive == false) {
				ProjectileObjects.remove(ProjectileObjects.get(i));
			}
		}
	}

	public void checkCollision() {
		for (Alien a : AlienObjects) {
			if (rocket.collisionbox.intersects(a.collisionbox)) {
				rocket.isAlive = false;

			}
			for (int i = 0; i < AlienObjects.size(); i++) {
				for (int i1 = 0; i1 < ProjectileObjects.size(); i1++) {
					if (AlienObjects.get(i).collisionbox.intersects(ProjectileObjects.get(i1).collisionbox)) {
						AlienObjects.get(i).isAlive = false;
						ProjectileObjects.get(i1).isAlive = false;
						score++;
						

					}
				}
			}

		}
	}

}
