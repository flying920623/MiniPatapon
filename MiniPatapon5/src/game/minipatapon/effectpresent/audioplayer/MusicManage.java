package game.minipatapon.effectpresent.audioplayer;

import com.badlogic.gdx.audio.Music;

import game.minipatapon.datasource.assets.MusicAssets;
import game.minipatapon.datasource.assets.ResourceLoader;

/**
 * 
 * @author ZhangY
 * 
 */
public class MusicManage
{

	public static void playMusic(String musicStr)
	{
		if (musicStr != null || !isPlayMusic(musicStr))
		{
			ResourceLoader.loadMusic(musicStr).play();
		} else
		{
			ResourceLoader.loadMusic(MusicAssets.errorMusicStr).play();
		}
	}

	public static void playMusic(Music music)
	{
		if (music != null || !isPlayMusic(music))
		{
			music.play();
		} else
		{
			ResourceLoader.loadMusic(MusicAssets.errorMusicStr).play();
		}
	}

	public static void pauseMusic(String musicStr)
	{
		if (musicStr != null && isPlayMusic(musicStr))
			ResourceLoader.loadMusic(musicStr).pause();
	}

	public static void pauseMusic(Music music)
	{
		if (music != null && isPlayMusic(music))
			music.pause();
	}

	public static void stopMusic(String musicStr)
	{
		if (musicStr != null && isPlayMusic(musicStr))
			ResourceLoader.loadMusic(musicStr).stop();
	}

	public static void stopMusic(Music music)
	{
		if (music != null && isPlayMusic(music))
			music.stop();
	}

	public static boolean isLoopingMusic(String musicStr)
	{
		return ResourceLoader.loadMusic(musicStr).isLooping();
	}
	
	public static boolean isLoopingMusic(Music music)
	{
		return music.isLooping();
	}

	public static void setLoopingMusic(String musicStr, boolean isLooping)
	{
		ResourceLoader.loadMusic(musicStr).setLooping(isLooping);
	}
	
	public static void setLoopingMusic(Music music, boolean isLooping)
	{
		music.setLooping(isLooping);
	}

	public static void setVolume(String musicStr, float volume)
	{
		ResourceLoader.loadMusic(musicStr).setVolume(volume);
	}
	
	public static void setVolume(Music music, float volume)
	{
		music.setVolume(volume);
	}

	public static boolean isPlayMusic(String musicStr)
	{
		return ResourceLoader.loadMusic(musicStr).isPlaying();
	}

	public static boolean isPlayMusic(Music music)
	{
		return music.isPlaying();
	}

	public static float getPositionMusic(String musicStr)
	{
		return ResourceLoader.loadMusic(musicStr).getPosition();
	}
	
	public static float getPositionMusic(Music music)
	{
		return music.getPosition();
	}

	public static void disposeMusic(String musicStr)
	{
		ResourceLoader.loadMusic(musicStr).dispose();
	}
	
	public static void disposeMusic(Music music)
	{
		music.dispose();
	}

}
