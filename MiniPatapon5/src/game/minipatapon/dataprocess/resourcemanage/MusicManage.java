package game.minipatapon.dataprocess.resourcemanage;

import game.minipatapon.datasource.assets.MusicAssets;

import com.badlogic.gdx.audio.Music;

public class MusicManage {
	public void MusicPlay(Music mus, int time) {
		mus.play();
	}
	
	public static void dispose()
	{
		MusicAssets.dispose();
	}

}
