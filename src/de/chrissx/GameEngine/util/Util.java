package de.chrissx.GameEngine.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Util {

	public static final String JAR_PATH = new File("").getAbsoluteFile().getAbsolutePath();
	
	public static final String ASSETS_FOLDER = Paths.get(JAR_PATH, "assets").toString();
	
	public static final String WORLDS_FOLDER = Paths.get(JAR_PATH, "worlds").toString();
	
	public static final String WORLDS_EXTENTION = ".world";
	
	public static final String TEXTURES_FOLDER = Paths.get(ASSETS_FOLDER, "textures").toString();
	
	public static final String TEXTURES_EXTENTION = ".png";
	
	public static final String SOUNDS_FOLDER = Paths.get(ASSETS_FOLDER, "sounds").toString();
	
	public static final String SOUNDS_EXTENTION = ".wav";
	
	public static final String TILES_EXTENTION = ".tile";
	
	public static List<String> loadFile(Path path) throws IOException {
		return Files.readAllLines(path);
	}
	
	public static List<File> listExtention(File dir, String ext) {
		List<File> files = new ArrayList<File>();
		for(File f : dir.listFiles()) {
			if(f.getName().endsWith(ext)) {
				files.add(f);
			}
		}
		return files;
	}
}
