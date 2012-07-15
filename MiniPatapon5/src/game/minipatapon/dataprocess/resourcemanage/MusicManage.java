package game.minipatapon.dataprocess.resourcemanage;

import game.minipatapon.datasource.assets.Assets;
import game.minipatapon.datasource.assets.MusicAssets;
import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.SoundAssets;

import com.badlogic.gdx.assets.loaders.MusicLoader;
import com.badlogic.gdx.audio.Music;

public class MusicManage {
	public void MusicPlay(Music mus, int time) {
		mus.play();
	}
	
	public static void loadBackgroundStage(){
	}
	
	public static void loadForegroundStage()
	{
		
	}

	public static void loadStartAnimationStage() {
		
	}

	public static void loadMainMenuStage() {
		ResourceLoader.loadMusic(MusicAssets.mainStageMusicStr);
	}

	public static void loadChooseHeroStage() {
		ResourceLoader.loadMusic(MusicAssets.chooseHeroMusicStr);
	}
	
	public static void loadChooseLevelStage()
	{
		
	}

	public static void loadLevel3Stage() {
		ResourceLoader.loadMusic(SoundAssets.missionCompleteSoundStr);
		ResourceLoader.loadMusic(SoundAssets.missionFailedSoundStr);
		ResourceLoader.loadMusic(SoundAssets.forwordSoundStr);
		ResourceLoader.loadMusic(SoundAssets.atkSoundStr);
		ResourceLoader.loadMusic(SoundAssets.defSoundStr);
		ResourceLoader.loadMusic(SoundAssets.failSoundStr);
		ResourceLoader.loadMusic(MusicAssets.drumTwoRhythmStr);
		
	}


}
