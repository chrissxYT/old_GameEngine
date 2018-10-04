package de.chrissx.GameEngine.world;

public class RawTile {
	public int x = 0, y = 0, width = 64, height = 64, id = 1;
	
	public RawTile(int x, int y, int width, int height, int id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
	}
}