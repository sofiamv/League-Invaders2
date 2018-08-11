import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<Projectile> ProjectileObjects = new ArrayList<Projectile>();
	ArrayList<Alien> AlienObjects = new ArrayList<Alien>();
	Rocketship rocket;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	ObjectManager(Rocketship rocket){
		this.rocket = rocket;
	}
public void update(){
	rocket.update();
	for(int i = 0; i < ProjectileObjects.size(); i++){
		ProjectileObjects.get(i).update();
	}
	for(int i = 0; i < AlienObjects.size(); i++){
		AlienObjects.get(i).update();
	}
	
	
	
}
public void draw(Graphics graphic){
	rocket.draw(graphic);
	for(int i = 0; i < ProjectileObjects.size(); i++){
		ProjectileObjects.get(i).draw(graphic);
	}for(int i = 0; i < AlienObjects.size(); i++){
		AlienObjects.get(i).draw(graphic);
	}
	
	
}
public void addProjectile(Projectile a){
	ProjectileObjects.add(a);
}
public void addAlien(Alien b) {
	AlienObjects.add(b);
}
public void ManageEnemies() {
	 if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
         addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
enemyTimer = System.currentTimeMillis();
 }

}
public void purgeObjects() {
	for(int i = 0; i < AlienObjects.size(); i++) {
		if(AlienObjects.get(i).y < 0) {
			AlienObjects.remove(AlienObjects.get(i));
		}	
			if(ProjectileObjects.get(i).y < 0) {
				ProjectileObjects.remove(ProjectileObjects.get(i));
			}
	}
		}
public void checkCollision() {
	for(Alien a : alienList){

        if(rocket.collisionBox.intersects(a.collisionBox){

                rocket.isAlive = false;

        }

}
}


}

