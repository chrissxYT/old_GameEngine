package de.chrissx.GameEngine.world;

import java.util.ArrayList;
import java.util.List;

public class Tiles {

	private static List<Tile> tiles = new ArrayList<Tile>();
	
	public void registerTile(Tile t, int id) {
		tiles.add(id, t);
	}
	
	public Tile getTile(int id) {
		return tiles.get(id);
	}
	
	public void unregisterTile(int id) {
		tiles.remove(id);
	}
	
	public void unregisterTile(Tile t) {
		tiles.remove(t);
	}
}