package de.chrissx.GameEngine.world;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import de.chrissx.GameEngine.threading.GameThreader;
import de.chrissx.GameEngine.util.Util;

public class WorldLoader {

	public static World loadWorld(String name, GameThreader threader) throws IOException, NumberFormatException {
				Tile[][] tiles;
				Path path = Paths.get(Util.WORLDS_FOLDER, name);
				Path world_main_info = Paths.get(path.toString(), "world" + Util.WORLDS_EXTENTION);
				String f = Util.loadFile(world_main_info).get(0);
				WorldInfo info = loadWorldInfo(f);
				tiles = new Tile[info.width][info.height];
				List<File> tile_files = Util.listExtention(path.toFile(), Util.TILES_EXTENTION);
				for(File file : tile_files) {
					String s = Util.loadFile(file.toPath()).get(0);
					Tile t = loadTile(s);
					tiles[t.x][t.y] = t;
				}
				World world_out = new World(info, tiles);
				return world_out;
	}
	
	public static Tile loadTile(String file) {
		Gson g = new Gson();
		RawTile rt = g.fromJson(file, RawTile.class);
		Tile t = new Tile(rt);
		return t;
	}
	
	public static WorldInfo loadWorldInfo(String file) {
		List<String> s = Files.readAllLines(Paths.get(file));
		return info;
	}
}