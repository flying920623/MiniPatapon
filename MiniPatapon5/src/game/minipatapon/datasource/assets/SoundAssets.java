package game.minipatapon.datasource.assets;

import java.util.ArrayList;

import com.badlogic.gdx.audio.Sound;

public class SoundAssets
{

	public static String errorSoundStr = "default.ogg";

	public static String missionFailedSoundStr = "mission complete.ogg";
	public static String missionCompleteSoundStr = "mission complete.ogg";
	
	public static String forwordSoundStr = "patapatapatapon.ogg"; 
	public static String forwordSound2Str = "patapatapatapon2.ogg"; 
	public static String atkSoundStr = "ponponpatapon.ogg"; 
	public static String atkSound2Str = "ponponpatapon2.ogg"; 
	public static String defSoundStr = "chakechakepatapon.ogg"; 
	public static String defSound2Str = "chakechakepatapon2.ogg";	
	public static String cheerSoundStr = "cheer_sound.ogg";
	
	public static String howlSoundStr = "howl_sound.ogg";
	public static String rainSoundStr = "rain_sound.ogg";
	public static String windSoundStr = "wind_sound.ogg";
	public static String thunderSoundStr = "thunder.ogg";
	
	public static String clickSoundStr = "click_sound.ogg";
	public static String clickSound2Str = "button_click_sound.ogg";
	
	public static String startLevelSoundStr = "start_level_sound.ogg";
	public static String arriveDestSoundStr = "arrive_dest_sound.ogg";
	
	public static String failSoundStr = "fail_sound.ogg";
	
	
	public static String deathSoundStr = "kill_sound.ogg";
	
	public static Sound getSound(String soundStr)
	{
		// MusicAssets.GetMusic(MusicAssets.exampleMusicStr);
		// while(!m_musicMap.containsKey(musicStr))
		// {
		// LoadMusic(musicStr);
		// }
		return ResourceLoader.getSound(soundStr);
	}

	public static void LoadSound(String soundStr)
	{
		Sound temp = ResourceLoader.getSound(soundStr);
		// m_musicMap.put(musicStr, temp);
	}

	public static void LoadSound(ArrayList<String> soundStrs)
	{

		for (String soundStr : soundStrs)
		{
			Sound temp = ResourceLoader.getSound(soundStr);
			// m_musicMap.put(musicStr, temp);
		}

	}
}
