package game.minipatapon.datasource.assets;

import game.minipatapon.logger.DefaultLogger;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureAssets {
	// public static ArrayList<String> ;
//
//	private static Map<String, Texture> m_texMap = new HashMap<String, Texture>();
//	private static Map<ArrayList<String>, ArrayList<TextureRegion>> m_texregionMap = new HashMap<ArrayList<String>, ArrayList<TextureRegion>>();
//	private static Map<String, TextureAtlas> m_textureAtlasMap = new HashMap<String, TextureAtlas>();
//	
	
	//loading
	public final static ArrayList<String> LoadingBarImg = new ArrayList<String>() {
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		{
			add("Loading/loadingPack");
			add("bar");
		}
	};
	
	public final static ArrayList<String> LoadingProcessBarImg = new ArrayList<String>() {
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		{
			add("Loading/loadingPack");
			add("processBar");
		}
	};
	
	//ChooseLevel
	public final static String Level1Img = "Level/level1.png";
	public final static String Level2Img = "Level/level2.png";
	public final static String Level3Img = "Level/level3.png";
	public final static String Level4LockedImg = "Level/level4_locked.png";
	public final static String Level5Img = "Level/level5.png";
	public final static String Level6Img = "Level/level6.png";
	
	// mission
	public final static ArrayList<String> MissionCompleted = new ArrayList<String>() {
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		{
			add("missionPack");
			add("MissionCompleted");
		}
	};

	public final static ArrayList<String> MissionFailed = new ArrayList<String>() {
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		{
			add("MissionPack");
			add("MissionFailed");
		}
	};

	// note
	public final static ArrayList<String> PataNote = new ArrayList<String>() {
		{
			add("notePack");
			add("pata");
		}
	};

	public final static ArrayList<String> PonNote = new ArrayList<String>() {
		{
			add("notePack");
			add("pon");
		}
	};

	public final static ArrayList<String> ChakeNote = new ArrayList<String>() {
		{
			add("notePack");
			add("chake");
		}
	};

	// StatAnimationStage
	public final static ArrayList<String> MiniImg = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("StartAnimation/StartAnimationPack");
			add("mini");
		}
	};

	public final static ArrayList<String> PataImg = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("StartAnimation/StartAnimationPack");
			add("pata");
		}
	};

	public final static ArrayList<String> PonImg = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("StartAnimation/StartAnimationPack");
			add("pon");
		}
	};

	public final static ArrayList<String> Logo2Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("StartAnimation/StartAnimationPack");
			add("logo2");
		}
	};

	public final static ArrayList<String> StripImg = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("StartAnimation/StartAnimationPack");
			add("white");
		}
	};

	public final static ArrayList<String> PoweredImg = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("StartAnimation/StartAnimationPack");
			add("powerdby");
		}
	};

	public final static ArrayList<String> NuclearLogoImg = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("StartAnimation/StartAnimationPack");
			add("nuclear-Logo");
		}
	};

	public final static ArrayList<String> VeilImg = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("StartAnimation/StartAnimationPack");
			add("white");
		}
	};

	public final static ArrayList<String> LogoImg = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("StartAnimation/StartAnimationPack");
			add("logo");
		}
	};

	public final static ArrayList<String> BlackBgImg = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("StartAnimation/StartAnimationPack");
			add("blackBg");
		}
	};

	// private static Map<String , Texture> m_texMap = new HashMap<String,
	// Texture>();
	// private static Map<ArrayList<String>, ArrayList<TextureRegion>>
	// m_texregionMap = new HashMap<ArrayList<String>,
	// ArrayList<TextureRegion>>();

	// MainMenuStage

	public final static String ColorTitleImg = "MainMenu/colorTitle.png";

	public final static String StartMenuImg = "MainMenu/StartMenu.png";

	// TimerDialog
	public final static ArrayList<String> StartMenuBg = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("MainMenu/StartMenuPack");
			add("StartMenuBg");
		}
	};

	public final static String MainMenuPack = "MainMenuPack";
	
	public final static ArrayList<String> StandardBearer_right_Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(MainMenuPack);
			add("flagman1");
			add("flagman2");
		}
	};
	public final static ArrayList<String> ShieldSoldier_right_Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(MainMenuPack);
			add("shieldSoldiers");
			add("shieldSoldiers2");
		}
	};
	public final static ArrayList<String> Swordman_right_Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(MainMenuPack);
			add("swordsman1");
			add("swordsman2");
		}
	};
	public final static ArrayList<String> Swordman2_right_Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(MainMenuPack);
			add("holdKnife2");
			add("holdKnife1");
		}
	};
	public final static ArrayList<String> StandardBearer_left_Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(MainMenuPack);
			add("holdFlag1");
			add("holdFlag2");
			add("holdFlag3");
			add("holdFlag4");
		}
	};
	public final static ArrayList<String> Archer_left_Img = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;

		{
			add(MainMenuPack);
			add("archer1");
			add("archer2");
		}
	};
	public final static ArrayList<String> ShieldSoldier_left_Img = new ArrayList<String>() {
		private static final long serialVersionUID = 5626720953104329290L;

		{
			add(MainMenuPack);
			add("shieldSoldier1");
			add("shieldSoldier2");
		}
	};

	public final static ArrayList<String> ShieldSoldier3_left_Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(MainMenuPack);
			add("Yaripon");
			add("Yaripon1");
			add("Yaripon2");
			add("Yaripon4");
		}
	};

	// LevelStage
	public final static String BackgroundImg = "background.png";

	// Dialog
	public final static String DialogBg = "dialogBg.png";

	// Note
	public final static ArrayList<String> Note = new ArrayList<String>() {
		{
			add(MainMenuPack);
			add("note");
		}
	};

	public final static ArrayList<String> GameName1Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(MainMenuPack);
			add("GameName1");
		}
	};
	public final static ArrayList<String> GameName2Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(MainMenuPack);
			add("GameName2");
		}
	};
	public final static String Altar_Img = "altar.png";

	// HelpStage
	public final static String AboutUsImage = "about us.png";
	public final static String QuitImage = "quitButton.png";

	// Level1
	public final static ArrayList<String> Level1Layer1Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("GameLevel/Level1/Level1Pack");
			add("layer1");
		}
	};

	public final static ArrayList<String> Level1Layer2Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("GameLevel/Level1/Level1Pack");
			add("layer2");
		}
	};

	public final static ArrayList<String> Level1Layer3Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("GameLevel/Level1/Level1Pack");
			add("layer3");
		}
	};

	public final static ArrayList<String> Level1Layer4Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("GameLevel/Level1/Level1Pack");
			add("layer4");
		}
	};

	public final static ArrayList<String> Level1Layer5Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("GameLevel/Level1/Level1Pack");
			add("layer5");
		}
	};

	// Level2
	public final static ArrayList<String> Level2Layer1Img = new ArrayList<String>() {
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		{
			add("GameLevel/Level2/Level2Pack");
			add("layer1");
		}
	};

	public final static ArrayList<String> Level2Layer2Img = new ArrayList<String>() {
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		{
			add("GameLevel/Level2/Level2Pack");
			add("layer2");
		}
	};

	public final static ArrayList<String> Level2Layer3Img = new ArrayList<String>() {
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		{
			add("GameLevel/Level2/Level2Pack");
			add("layer3");
		}
	};

	// Level3
	public final static ArrayList<String> Level3Layer1Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("GameLevel/Level3/Level3Pack");
			add("layer1");
		}
	};

	public final static ArrayList<String> Level3Layer2Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("GameLevel/Level3/Level3Pack");
			add("layer2");
		}
	};

	public final static ArrayList<String> Level3Layer3Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("GameLevel/Level3/Level3Pack");
			add("layer3");
		}
	};

	public final static ArrayList<String> Level3Layer4Img = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		{
			add("GameLevel/Level3/Level3Pack");
			add("layer4");
		}
	};

	// controlButton
	public final static ArrayList<String> PataButton = new ArrayList<String>() {
		{
			add("controlButtonPack");
			add("pataButton");
		}
	};

	public final static ArrayList<String> PonButton = new ArrayList<String>() {
		{
			add("controlButtonPack");
			add("ponButton");
		}
	};

	public final static ArrayList<String> AboutUs = new ArrayList<String>() {
		{
			add("AboutUsPack");
			add("AboutUs");
		}
	};

	public final static ArrayList<String> CakaButton = new ArrayList<String>() {
		{
			add("controlButtonPack");
			add("cakaButton");
		}
	};

	public final static ArrayList<String> HeroPoint = new ArrayList<String>() {
		{
			add("heroChoose/heropointPack");
			add("1");
			add("2");
			add("3");
			add("4");
			add("5");
			add("6");
			add("7");
			add("8");
		}
	};
	public final static ArrayList<String> Hero1 = new ArrayList<String>() {
		{
			add("heroChoose/hero1Pack");
			add("normalHero");
			add("lowlightHero");
			add("highlightHero");

		}
	};
	public final static ArrayList<String> HeroCircle1 = new ArrayList<String>() {
		{
			add("heroChoose/hero1Pack");
			add("normal");
			add("lowlight");
			add("highlight");

		}
	};
	public final static ArrayList<String> Hero2 = new ArrayList<String>() {
		{
			add("heroChoose/hero2Pack");
			add("normalHero");
			add("lowlightHero");
			;
			add("highlightHero");

		}
	};
	public final static ArrayList<String> HeroCircle2 = new ArrayList<String>() {
		{
			add("heroChoose/hero2Pack");
			add("normal");
			add("lowlight");
			add("highlight");

		}
	};
	public final static ArrayList<String> Hero3 = new ArrayList<String>() {
		{
			add("heroChoose/hero3Pack");
			add("normalHero");
			add("lowlightHero");
			add("highlightHero");

		}
	};
	public final static ArrayList<String> HeroCircle3 = new ArrayList<String>() {
		{
			add("heroChoose/hero3Pack");
			add("normal");
			add("lowlight");
			add("highlight");

		}
	};

	public final static String SliderImage = "slider3.png";
	public final static String Slider2Image = "slider4.png";

	public final static String MainVolume = "mainvolume.png";
	public final static String MusicVolume = "musicvolume.png";
	public final static String SoundVolume = "soundvolume.png";

	public final static String SettingImage = "set.png";
	public final static String HelpImage = "help.png";
	
	public final static String WindLineImg = "line.png";

//	public static ArrayList<TextureRegion> GetTextureRegionsFromPacker(
//			ArrayList<String> str) {
//		 while (!m_texregionMap.containsKey(str)) {
//			 LoadTextureRegion(str);
//		 }
////		return ResourceLoader.loadTextureRegionFromPacker(str);
//		return m_texregionMap.get(str);
//	}
//
//	public static TextureRegion GetTextureRegionFromPacker(ArrayList<String> str) {
//		// DefaultLogger.getDefaultLogger().logWithSignature(TextureAssets.class,
//		// "加载资源： %s", str.toString());
//		if (GetTextureRegionsFromPacker(str).size() <= 0) {
//			DefaultLogger.getDefaultLogger().logWithSignature(
//					TextureAssets.class, "资源未加载：%s", str.toString());
//			return null;
//		}
//
//		return GetTextureRegionsFromPacker(str).get(0);
//	}
	
//	
//	
//	
//	public static ArrayList<TextureRegion> GetRegionsFromAtlas(TextureAtlas atlas,  ArrayList<String> str)
//	{
//
//		
//		ArrayList<TextureRegion> regions = new ArrayList<TextureRegion>();
//		//DefaultLogger.getDefaultLogger().logWithSignature(ResourceLoader.class, "资源：%s ", picNames.toString());
//
//		for( int i=1; i<str.size(); i++ )
//		{
//			TextureRegion region = atlas.findRegion( str.get(i) );
//			if( region==null )
//			{
//				DefaultLogger.getDefaultLogger().logWithSignature(TextureAssets.class, "不能从  %s 中 读取: %s ", atlas.toString(), str.get(i));
//			}
//			
//			regions.add( region );
//		}
//		if( regions.size()==0 )
//		{
//			DefaultLogger.getDefaultLogger().logWithSignature(ResourceLoader.class, "资源：%s 不存在", str.toString());
//			return regions;
//		}
//		TextureHandle.TextureFilterLinear(regions);
//		
//		return regions;
//	}
//	
//	public static ArrayList<TextureRegion> GetTextureRegionsFromPacker(
//			ArrayList<String> str) {
//		TextureAtlas atlas = GetTextureAtlas(str.get(0));
////		return ResourceLoader.loadTextureRegionFromPacker(str);
//		return GetRegionsFromAtlas(atlas, str);
//	}
//
//	public static TextureRegion GetTextureRegionFromPacker(ArrayList<String> str) {
//		// DefaultLogger.getDefaultLogger().logWithSignature(TextureAssets.class,
//		// "加载资源： %s", str.toString());
//		if (GetTextureRegionsFromPacker(str).size() <= 0) {
//			DefaultLogger.getDefaultLogger().logWithSignature(
//					TextureAssets.class, "资源未加载：%s", str.toString());
//			return null;
//		}
//
//		return GetTextureRegionsFromPacker(str).get(0);
//	}
//	
//
//	public static Texture GetTex(String texStr) {
////		 while(!m_texMap.containsKey(texStr)){
////			 LoadTexture(texStr);
////		 }
////		 return m_texMap.get(texStr);
//		
//
//		if( ResourceLoader.getTexture(texStr)==null )
//		{
//			LoadTextureAtlas(texStr);
//		}
//		
//		return ResourceLoader.getTexture(texStr);
//	}
//	
//	public static TextureAtlas GetTextureAtlas(String atlasStr)
//	{
////		while (!m_textureAtlasMap.containsKey(atlasStr)) {
////			 LoadTextureAtlas(atlasStr);
////		}		
////		
////		return m_textureAtlasMap.get(atlasStr);
//		
//		if( ResourceLoader.getTextureAtlas(atlasStr)==null )
//		{
//			LoadTextureAtlas(atlasStr);
//		}
//		
//		return ResourceLoader.getTextureAtlas(atlasStr);
//	}
//	
//	public static void LoadTextureAtlas(String str){
////		TextureAtlas atlas = ResourceLoader.getTextureAtlas(str);
////		
////		DefaultLogger.getDefaultLogger().logWithSignature(TextureAssets.class, "加载 TextureAtlas:  %s", str);
////		
////		m_textureAtlasMap.put(str, atlas);
//		ResourceLoader.loadTextureAtlas(str);
//	}
//
////	public static void LoadTextureRegion(ArrayList<String> str) {
////		ArrayList<TextureRegion> temp = ResourceLoader
////				.getTextureRegionFromPacker(str);
////		m_texregionMap.put(str, temp);
////	}
//
//	public static void LoadTexture(String texStr) {
////		Texture temp = ResourceLoader.getTexture(texStr);
////		m_texMap.put(texStr, temp);
//		ResourceLoader.loadTexture(texStr);
//
//	}
//
//	public static void LoadTexture(ArrayList<String> texStrs) {
//
//		for (String texStr : texStrs) {
//
//			// Texture temp = ResourceLoader.loadTexture(texStr);
//			// m_texMap.put(texStr, temp);
//
//			Texture temp = ResourceLoader.getTexture(texStr);
//			// m_texMap.put(texStr, temp);
//
//		}
//	}
	
//	public static void dispose()
//	{
//		DefaultLogger.getDefaultLogger().logWithSignature(TextureAssets.class, "dispose all texture!");
//		m_texMap.clear();
//		m_texregionMap.clear();
//		m_textureAtlasMap.clear();
//	}
}
