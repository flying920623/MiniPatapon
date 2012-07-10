package game.minipatapon.datasource.assets;

//import java.util.HashMap;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.logger.Loggable;

class FontLoader {

	String baseDir;
	BitmapFont defaultFont;
	//Map<String, Map<String, BitmapFont>> map;
	Loggable logger;

	public FontLoader(String baseDir, String defaultFont, String defaultBitmap) {
		this.baseDir = baseDir;
		logger = DefaultLogger.getDefaultLogger();
//		map = new HashMap<String, Map<String, BitmapFont>>();
//		this.defaultFont = this.directLoadFont(defaultFont, defaultBitmap);
	}

	private String combinePath(String base, String relativePath) {
		if ((!base.endsWith("/") && (!base.endsWith("\\")))) {
			base = base + "/";
		}
		return base + relativePath;
	}

	public BitmapFont loadFont(String fileName, String bitmapName) {
//		BitmapFont font = null;
//		try {
//			if (map.containsKey(fileName)) {
//				Map<String, BitmapFont> m = map.get(fileName);
//				if (m.containsKey(bitmapName)) {
//					font = m.get(bitmapName);
//				} else {
//					font = directLoadFont(fileName, bitmapName);
//					m.put(bitmapName, font);
//				}
//			} else {
//				font = directLoadFont(fileName, bitmapName);
//				Map<String, BitmapFont> mNew = new HashMap<String, BitmapFont>();
//				mNew.put(bitmapName, font);
//				map.put(fileName, mNew);
//			}
//		} catch (Exception ex) {
//			logger.log("FontLoader loadFont 加载字体失败:$1%s", ex.getMessage());
//			font = this.defaultFont;
//		}
//		return font;
		return directLoadFont(fileName, bitmapName);
	}

	public BitmapFont directLoadFont(String fileName, String bitmapName) {
		FileHandle fontFile = Gdx.files.internal(this.combinePath(this.baseDir,
				fileName));
		FileHandle bitmapFile = Gdx.files.internal(this.combinePath(
				this.baseDir, bitmapName));
		return new BitmapFont(fontFile, bitmapFile, false);

	}
}
