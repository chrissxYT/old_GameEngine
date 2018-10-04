package de.chrissx.GameEngine.assets;

import java.awt.image.BufferedImage;
import java.io.File;

public class SpriteSheet {

	private BufferedImage img;
	
	public SpriteSheet() {
		
	}
	
	public SpriteSheet(File path) {
		img = ImageLoader.loadImage(path);
	}

	public BufferedImage split(int x, int y, int width, int height) {
		return img.getSubimage(x, y, width, height);
	}
	
}
