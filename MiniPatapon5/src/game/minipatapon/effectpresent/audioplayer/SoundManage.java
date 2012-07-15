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
			ResourceLoader.getSound(SoundStr).play(1);
		} else
		{
			ResourceLoader.getSound(SoundAssets.errorSoundStr).play(1);
		}

	}

	public static void playSound(Sound sound)
	{
		if (sound != null)
		{
			sound.play(1);
		} else
		{
			ResourceLoader.getSound(SoundAssets.errorSoundStr).play(1);
		}

	}

	public static void playSound(String SoundStr, float volume)
	{
		if (SoundStr != null)
		{
			ResourceLoader.getSound(SoundStr).play(volume);
		} else
		{
			ResourceLoader.getSound(SoundAssets.errorSoundStr).play(volume);
		}
	}

	public static void playSound(Sound sound, float volume)
	{
		if (sound != null)
		{
			sound.play(volume);
		} else
		{
			ResourceLoader.getSound(SoundAssets.errorSoundStr).play(volume);
		}
	}

	public static void stopSound(String SoundStr)
	{
		ResourceLoader.getSound(SoundStr).stop();
	}

	public static void stopSound(Sound sound)
	{
		sound.stop();
	}

	public static void disposeSound(String SoundStr)
	{
		ResourceLoader.getSound(SoundStr).dispose();
	}

	public static void disposeSound(Sound sound)
	{
		sound.dispose();
	}
}
