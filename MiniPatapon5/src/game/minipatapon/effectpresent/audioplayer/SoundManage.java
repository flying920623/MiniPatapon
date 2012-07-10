package game.minipatapon.effectpresent.audioplayer;

import com.badlogic.gdx.audio.Sound;

import game.minipatapon.datasource.assets.SoundAssets;
import game.minipatapon.datasource.assets.ResourceLoader;

public class SoundManage
{
	public static void playSound(String SoundStr)
	{
		if (SoundStr != null)
		{
			ResourceLoader.loadSound(SoundStr).play();
		} else
		{
			ResourceLoader.loadSound(SoundAssets.errorSoundStr).play();
		}

	}

	public static void playSound(Sound sound)
	{
		if (sound != null)
		{
			sound.play();
		} else
		{
			ResourceLoader.loadSound(SoundAssets.errorSoundStr).play();
		}

	}

	public static void playSound(String SoundStr, float volume)
	{
		if (SoundStr != null)
		{
			ResourceLoader.loadSound(SoundStr).play(volume);
		} else
		{
			ResourceLoader.loadSound(SoundAssets.errorSoundStr).play(volume);
		}
	}

	public static void playSound(Sound sound, float volume)
	{
		if (sound != null)
		{
			sound.play(volume);
		} else
		{
			ResourceLoader.loadSound(SoundAssets.errorSoundStr).play(volume);
		}
	}

	public static void stopSound(String SoundStr)
	{
		ResourceLoader.loadSound(SoundStr).stop();
	}

	public static void stopSound(Sound sound)
	{
		sound.stop();
	}

	public static void disposeSound(String SoundStr)
	{
		ResourceLoader.loadSound(SoundStr).dispose();
	}

	public static void disposeSound(Sound sound)
	{
		sound.dispose();
	}
}
