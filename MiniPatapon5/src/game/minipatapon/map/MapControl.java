package game.minipatapon.map;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.tiled.TileAtlas;
import com.badlogic.gdx.graphics.g2d.tiled.TileMapRenderer;
import com.badlogic.gdx.graphics.g2d.tiled.TiledLoader;
import com.badlogic.gdx.graphics.g2d.tiled.TiledMap;

public class MapControl {
	
	public static TileMapRenderer importMap(String mapPath, String mapName)
	{
		TiledMap map;
		TileAtlas atlas;
		TileMapRenderer tileMapRenderer;
		
		FileHandle fileHandle = new FileHandle(mapPath + mapName);
	
		map = TiledLoader.createMap(fileHandle);
		atlas = new TileAtlas(map, new FileHandle(mapPath));
		tileMapRenderer = new TileMapRenderer(map, atlas, 16, 16);
		
		return tileMapRenderer;
	}
}
