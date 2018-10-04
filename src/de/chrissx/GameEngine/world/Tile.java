package de.chrissx.GameEngine.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.chrissx.GameEngine.GameObject;
import de.chrissx.GameEngine.assets.Assets;

public class Tile extends GameObject {

	private BufferedImage texture;
	public int x, y, width, height, id;
	
	public Tile(RawTile rt) {
		texture = Assets.getTexture(rt.id);
		x = rt.x;
		y = rt.y;
		width =  rt.width;
		height = rt.height;
		id = rt.id;
	}
	
	public void render(Graphics g) {
		g.drawImage(texture, x, y, width, height, null);
	}
	
	public void tick() {
		
	}
}
