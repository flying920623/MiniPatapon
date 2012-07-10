package game.minipatapon.datasource.assets;

//import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
//import com.maple.eggsnake.logger.DefaultLogger;
import game.minipatapon.logger.Loggable;

class SoundLoader {

	private String dirPath;
	//Map<String, Sound> map;
	Loggable logger;
	Sound defaultSound;

	public SoundLoader(String dirPath, String defaultSound) {
		int ch = dirPath.lastIndexOf(0);
		if (ch != '/' && ch != '\\') {
			this.dirPath = dirPath + '/';
		} else {
			this.dirPath = dirPath;
		}
		// this.map = new HashMap<String, Sound>();
		// logger = DefaultLogger.getDefaultLogger();
		//
		// this.defaultSound =
		// Gdx.audio.newSound(Gdx.files.internal(this.dirPath
		//
		// + defaultSound));
	}

	public Sound loadSound(String soundPath) {
		// Sound sound = null;
		// try {
		// if (map.containsKey(soundPath)) {
		// sound = map.get(soundPath);
		// } else {
		// String absPath = this.dirPath + soundPath;
		// FileHandle file = Gdx.files.internal(absPath);
		// sound = Gdx.audio.newSound(file);
		// map.put(soundPath, sound);
		// }
		// } catch (Exception ex) {
		//
		// logger.log("SoundManager loadSound:加载:%1$s失败(%2$s)", soundPath,
		// ex.getMessage());
		//
		// sound = this.defaultSound;
		// }
		// return sound;
		//
		 String absPath = this.dirPath + soundPath;
		 FileHandle file = Gdx.files.internal(absPath);
		 Sound sound = Gdx.audio.newSound(file);
		 return sound;
	}

}
