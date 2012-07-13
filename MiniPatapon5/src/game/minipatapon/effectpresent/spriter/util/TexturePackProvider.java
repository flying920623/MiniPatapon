package game.minipatapon.effectpresent.spriter.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.spriter.TextureProvider;
import game.minipatapon.logger.DefaultLogger;

public class TexturePackProvider implements TextureProvider {

	private final Map<String, Texture> textures = new HashMap<String, Texture>();
	private final Map<String, TextureRegion> regions = new HashMap<String, TextureRegion>();

	AssetManager manager = new AssetManager();

	@Override
	public Texture getTexture(String filename) {
		// TODO Auto-generated method stub

		if (!textures.containsKey(filename)) {

			textures.put(filename, new Texture(Gdx.files.internal(filename)));
//			System.out.println("Texture " + filename + " loaded");
		}
		return textures.get(filename);
	}

	@Override
	public void disposeTexture(String filename) {
		// TODO Auto-generated method stub

		textures.get(filename).dispose();
		textures.remove(filename);
//		System.out.println("Texture " + filename + " disposed");
	}

	@Override
	public TextureRegion getTextureRegion(String filename) {
		// TODO Auto-generated method stub

		if (!regions.containsKey(filename)) {

			String picName = Gdx.files.internal(filename).name();

			String packPath = filename.replaceAll(picName, "");

			// 去掉 data\images\
			packPath = packPath.substring(12);
			packPath = packPath.replaceAll("\\\\", "/");

			ArrayList<String> strings = new ArrayList<String>();
			strings.add(packPath + "pack");
			strings.add(picName.replaceAll(".png", ""));

			TextureRegion region = TextureAssets
					.GetTextureRegionFromPacker(strings);

			if (region == null) {
				DefaultLogger.getDefaultLogger().logWithSignature(this, strings.toString()
						+ "did not load!!!");
				return region;
			}

			regions.put(filename, region);
//			DefaultLogger.getDefaultLogger().logWithSignature(this, strings.toString()
//					+ "loaded");
		}
		return regions.get(filename);

	}

	@Override
	public void disposeTextureRegion(String filename) {
		// TODO Auto-generated method stub

		regions.remove(filename);

//		DefaultLogger.getDefaultLogger().logWithSignature(this, filename + " disposed");
	}

}
