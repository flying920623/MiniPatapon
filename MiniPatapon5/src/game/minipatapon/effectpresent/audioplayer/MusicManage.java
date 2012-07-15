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
			ResourceLoader.getMusic(musicStr).play();
		} else
		{
			ResourceLoader.getMusic(MusicAssets.errorMusicStr).play();
		}
	}

	public static void playMusic(Music music)
	{
		if (music != null || !isPlayMusic(music))
		{
			music.play();
		} else
		{
			ResourceLoader.getMusic(MusicAssets.errorMusicStr).play();
		}
	}

	public static void pauseMusic(String musicStr)
	{
		if (musicStr != null && isPlayMusic(musicStr))
			ResourceLoader.getMusic(musicStr).pause();
	}

	public static void pauseMusic(Music music)
	{
		if (music != null && isPlayMusic(music))
			music.pause();
	}

	public static void stopMusic(String musicStr)
	{
		if (musicStr != null && isPlayMusic(musicStr))
			ResourceLoader.getMusic(musicStr).stop();
	}

	public static void stopMusic(Music music)
	{
		if (music != null && isPlayMusic(music))
			music.stop();
	}

	public static boolean isLoopingMusic(String musicStr)
	{
		return ResourceLoader.getMusic(musicStr).isLooping();
	}
	
	public static boolean isLoopingMusic(Music music)
	{
		return music.isLooping();
	}

	public static void setLoopingMusic(String musicStr, boolean isLooping)
	{
		ResourceLoader.getMusic(musicStr).setLooping(isLooping);
	}
	
	public static void setLoopingMusic(Music music, boolean isLooping)
	{
		music.setLooping(isLooping);
	}

	public static void setVolume(String musicStr, float volume)
	{
		ResourceLoader.getMusic(musicStr).setVolume(volume);
	}
	
	public static void setVolume(Music music, float volume)
	{
		music.setVolume(volume);
	}

	public static boolean isPlayMusic(String musicStr)
	{
		return ResourceLoader.getMusic(musicStr).isPlaying();
	}

	public static boolean isPlayMusic(Music music)
	{
		return music.isPlaying();
	}

	public static float getPositionMusic(String musicStr)
	{
		return ResourceLoader.getMusic(musicStr).getPosition();
	}
	
	public static float getPositionMusic(Music music)
	{
		return music.getPosition();
	}

	public static void disposeMusic(String musicStr)
	{
		ResourceLoader.getMusic(musicStr).dispose();
	}
	
	public static void disposeMusic(Music music)
	{
		music.dispose();
	}

}
