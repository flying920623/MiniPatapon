package game.minipatapon.datasource.assets;

//import java.util.HashMap;


import com.badlogic.gdx.graphics.Texture;
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

	public Texture loadTexture(String texturePath) {
		// Texture texture = null;
		// try {
		// if (map.containsKey(texturePath)) {
		// logger.logWithSignature(this, "命中资源%1$s", texturePath);
		// texture = map.get(texturePath);
		// } else {
		// String absPath = this.dirPath + texturePath;
		// texture = new Texture(absPath);
		// logger.logWithSignature(this, "加载资源%1$s", texturePath);
		// map.put(texturePath, texture);
		// }
		// } catch (Exception ex) {
		// logger.log("TextureManager loadTexture:加载:%1$s失败", texturePath);
		// texture = this.defaultTexture;
		// }
		//
		// return texture;
		try {
			String absPath = PathHelper.combine(this.dirPath, texturePath);
			return new Texture(absPath);
		} catch (Exception e) {
			logger.logWithSignature(this, "加载资源%1$s失败:%2$s,使用默认图像", texturePath,
					e.getMessage());
			return new Texture(PathHelper.combine(this.dirPath,
					this.defaultTexture));
		}
	}

}
