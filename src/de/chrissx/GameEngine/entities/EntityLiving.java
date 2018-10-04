package de.chrissx.GameEngine.entities;

public class EntityLiving extends Entity{

	protected final int MAX_HEALTH;
	
	protected int health;
	
	public EntityLiving(int x, int y, int width, int height, int MAX_HEALTH) {
		super(x, y, width, height);
		this.MAX_HEALTH = MAX_HEALTH;
		this.health = MAX_HEALTH;
	}
	
	public void move(int moveX, int moveY) {
		x += moveX;
		y += moveY;
	}
	
	public void attack(EntityLiving target, int damage) {
		target.damage(damage);
	}
	
	public void damage(int damage) {
		this.health -= damage;
	}
}