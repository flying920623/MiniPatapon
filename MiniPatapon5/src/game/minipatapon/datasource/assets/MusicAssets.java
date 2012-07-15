package game.minipatapon.datasource.assets;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import com.badlogic.gdx.audio.Music;

public class MusicAssets {
	public static String errorMusicStr = "default.ogg";
	private static Map<String, Music> m_musicMap = new HashMap<String, Music>();
	public static String mainStageMusicStr = "title.mp3";

	public static String level1MusicStr = "level_1_music.mp3";
	public static String level2MusicStr = "level_2_music.mp3";
	public static String level3MusicStr = "level_3_music.mp3";

	public static String chooseLevelMusicStr = "choose_level_music.mp3";
	public static String chooseHeroMusicStr = "choose_hero_music.mp3";

	public static String helpMusicStr = "help_music.mp3";
	public static String settingMusicStr = "setting_music.mp3";
	public static String drumTwoRhythmStr = "drum_two_rhythm.mp3";

	public static String startMusicStr = "start_music.mp3";

//	public static Music GetMusic(String musicStr) {
//		// MusicAssets.GetMusic(MusicAssets.exampleMusicStr);
//		while (!m_musicMap.containsKey(musicStr)) {
//			LoadMusic(musicStr);
//		}
////		return ResourceLoader.loadMusic(musicStr);
//		return m_musicMap.get(musicStr);
//	}
//
//	public static void LoadMusic(String musicStr) {
//		Music temp = ResourceLoader.getMusic(musicStr);
//		m_musicMap.put(musicStr, temp);
//	}
//
//	public static void LoadMusic(ArrayList<String> musicStrs) {
//
//		for (String musicStr : musicStrs) {
//			Music temp = ResourceLoader.getMusic(musicStr);
//			m_musicMap.put(musicStr, temp);
//		}
//
//	}
//
//	public static void dispose() {
//		m_musicMap.clear();
//	}
}
