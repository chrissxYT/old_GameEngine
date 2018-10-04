package de.chrissx.GameEngine.assets;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadImage(File path) {
		try {
			return ImageIO.read(path);
		} catch (Exception e) {
			e.printStackTrace();
			return new BufferedImage(56, 56, 56);
		}
	}
}
