package de.chrissx.GameEngine.assets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Assets {

	private static List<BufferedImage> textures = new ArrayList<BufferedImage>();

	public static List<BufferedImage> getTextures() {
		return textures;
	}
	
	public static void addTexture(BufferedImage b) {
		textures.add(b);
	}
	
	public static BufferedImage getTexture(int i) {
		return textures.get(i);
	}
}