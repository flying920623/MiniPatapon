package game.minipatapon.datasource.assets;

//import java.util.HashMap;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import game.minipatapon.logger.DefaultLogger;

class MusicLoader {

	private String dirPath;
	Music defaultMusic;

	public MusicLoader(String dirPath, String defaultMusic) {
		int ch = dirPath.lastIndexOf(0);
		if (ch != '/' && ch != '\\') {
			this.dirPath = dirPath + '/';
		} else {
			this.dirPath = dirPath;
		}

		this.defaultMusic = Gdx.audio.newMusic(Gdx.files.internal(this.dirPath
				+ defaultMusic));
	}

	public void loadMusic(String musicPath) {
		
		String absPath = this.dirPath + musicPath;
		Assets.inst().load(absPath, Music.class);
	}
	
	public Music getMusic(String musicPath) {

		try {
			String absPath = this.dirPath + musicPath;
			return Assets.inst().get(absPath, Music.class);

		} catch (Exception e) {
			DefaultLogger.getDefaultLogger().logWithSignature(this, "加载资源%1$s失败:%2$s,使用默认图像",
					musicPath, e.getMessage());
			return defaultMusic;
		}

	}

}
