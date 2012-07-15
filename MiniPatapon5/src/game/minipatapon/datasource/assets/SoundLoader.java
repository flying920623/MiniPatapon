package game.minipatapon.datasource.assets;

//import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
//import com.maple.eggsnake.logger.DefaultLogger;
import game.minipatapon.logger.Loggable;

class SoundLoader {

	private String dirPath;
	// Map<String, Sound> map;
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
		this.defaultSound = Gdx.audio.newSound(Gdx.files.internal(this.dirPath
				+ defaultSound));
	}

	public Sound getSound(String soundPath) {
		String absPath = this.dirPath + soundPath;
		return Assets.inst().get(absPath, Sound.class);
	}
	
	public void loadSound(String soundPath) {
		String absPath = this.dirPath + soundPath;
		Assets.inst().load(absPath, Sound.class);
	}

}
