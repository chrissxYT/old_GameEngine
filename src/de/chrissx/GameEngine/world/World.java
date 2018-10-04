package de.chrissx.GameEngine.world;

import java.awt.Graphics;

import de.chrissx.GameEngine.GameObject;

public class World extends GameObject{

	private WorldInfo info;
	private Tile[][] tiles;
	
	public World(WorldInfo info, Tile[][] tiles) {
		this.info = info;
		this.tiles = tiles;
	}
	
	public void render(Graphics g) {
		for(Tile[] ts : tiles) {
			for(Tile t : ts) {
				t.render(g);
			}
		}
	}
	
	public void tick() {
		for(Tile[] ts : tiles) {
			for(Tile t : ts) {
				t.tick();
			}
		}
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	public int getSpawnX() {
		return info.spawnX;
	}
	
	public int getSpawnY() {
		return info.spawnY;
	}
	
	public int getWidth() {
		return info.width;
	}
	
	public int getHeight() {
		return info.height;
	}
}
