package de.chrissx.GameEngine.entities;

public abstract class Entity {

	protected int x, y, width, height;
	
	protected boolean alive;
	
	public Entity(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		alive = true;
	}
	
	public void kill() {
		alive = false;
	}
}