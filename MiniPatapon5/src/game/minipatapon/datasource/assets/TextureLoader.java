package game.minipatapon.datasource.assets;

//import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.sun.opengl.impl.StaticGLInfo;
//import com.maple.eggsnake.logger.DefaultLogger;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.logger.Loggable;
//import game.minipatapon.util.PathHelper;
import game.minipatapon.util.PathHelper;

class TextureLoader {
	private String dirPath;

	Loggable logger;
	String defaultTexture;

	public TextureLoader(String dirPath, String defaultTexture) {
		int ch = dirPath.lastIndexOf(0);
		if (ch != '/' && ch != '\\') {
			this.dirPath = dirPath + '/';
		} else {
			this.dirPath = dirPath;
		}
		this.defaultTexture = defaultTexture;
		// this.map = new HashMap<String, Texture>();
		logger = DefaultLogger.getDefaultLogger();
		// this.defaultTexture = new Texture(this.dirPath + defaultTexture);
	}

	public void loadTexture(String texturePath) {

		String absPath = PathHelper.combine(this.dirPath, texturePath);
		Assets.inst().load(absPath, Texture.class);

//		DefaultLogger.getDefaultLogger().logWithSignature(this,
//				"load texture:  %s", texturePath);
	}

	public void loadTextureAtlas(String atlasPath) {
		String absPath = PathHelper.combine(this.dirPath, atlasPath);
		Assets.inst().load(absPath, TextureAtlas.class);
	}

	public Texture getTexture(String texturePath) {

		try {
			String absPath = PathHelper.combine(this.dirPath, texturePath);

			return Assets.inst().get(absPath, Texture.class);

		} catch (Exception e) {
			logger.logWithSignature(this, "加载资源%1$s失败:%2$s,使用默认图像",
					texturePath, e.getMessage());
			return new Texture(PathHelper.combine(this.dirPath,
					this.defaultTexture));
		}
	}

	public TextureAtlas getTextureAtlas(String atlasPath) {
		try {
			String absPath = PathHelper.combine(this.dirPath, atlasPath);

			return Assets.inst().get(absPath, TextureAtlas.class);
		} catch (Exception e) {
			logger.logWithSignature(this, "加载资源%1$s失败:%2$s", atlasPath,
					e.getMessage());
			return null;
		}

	}
}
