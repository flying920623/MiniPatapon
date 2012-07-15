package game.minipatapon.dataprocess.resourcemanage;

import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.TextureAssets;



public class TextureManage {

	public static void loadBackgroundStage(){
		ResourceLoader.loadTextureAtlas("GameLevel/Level1/Level1Pack");
	}
	
	public static void loadForegroundStage()
	{
		ResourceLoader.loadTextureAtlas("notePack");
		ResourceLoader.loadTextureAtlas("controlButtonPack");
	}
	
	//StartAnimationStage Texture	
	public static void loadStartAnimationStage()
	{
		ResourceLoader.loadTextureAtlas("StartAnimation/StartAnimationPack");
	}
	
	public static void loadMainMenuStage()
	{
		ResourceLoader.loadTextureAtlas(TextureAssets.MainMenuPack);
		ResourceLoader.loadTextureAtlas("MainMenu/StartMenuPack");
		ResourceLoader.loadTexture(TextureAssets.ColorTitleImg);
		ResourceLoader.loadTexture(TextureAssets.Altar_Img);
		ResourceLoader.loadTexture(TextureAssets.BackgroundImg);
		ResourceLoader.loadTexture(TextureAssets.StartMenuImg);
		ResourceLoader.loadTexture(TextureAssets.HelpImage);
		ResourceLoader.loadTexture(TextureAssets.SettingImage);
	}
	
	public static void loadChooseHeroStage(){
		ResourceLoader.loadTextureAtlas(TextureAssets.Hero1.get(0));
		ResourceLoader.loadTextureAtlas(TextureAssets.Hero2.get(0));
		ResourceLoader.loadTextureAtlas(TextureAssets.Hero3.get(0));

		ResourceLoader.loadTextureAtlas(TextureAssets.HeroCircle1.get(0));
		ResourceLoader.loadTextureAtlas(TextureAssets.HeroCircle2.get(0));
		ResourceLoader.loadTextureAtlas(TextureAssets.HeroCircle3.get(0));
		
		ResourceLoader.loadTextureAtlas(TextureAssets.HeroPoint.get(0));
	}
	
	public static void loadChooseLevelStage(){
		ResourceLoader.loadTexture(TextureAssets.Level1Img);
		ResourceLoader.loadTexture(TextureAssets.Level2Img);
		ResourceLoader.loadTexture(TextureAssets.Level3Img);
		ResourceLoader.loadTexture(TextureAssets.Level4LockedImg);
		ResourceLoader.loadTexture(TextureAssets.Level5Img);
		ResourceLoader.loadTexture(TextureAssets.Level6Img);
		
		ResourceLoader.loadTexture(TextureAssets.QuitImage);
	}
	
	public static void loadLevel3Stage(){
		ResourceLoader.loadTextureAtlas("AnimationActor/flag/pack");
		ResourceLoader.loadTextureAtlas("AnimationActor/sword/pack");
		ResourceLoader.loadTextureAtlas("AnimationActor/blueHeroImages/pack");
		ResourceLoader.loadTextureAtlas("AnimationActor/knightImages/pack");
		ResourceLoader.loadTextureAtlas("AnimationActor/infantry/pack");
		ResourceLoader.loadTextureAtlas("AnimationActor/move_bird/pack");
		ResourceLoader.loadTextureAtlas("AnimationActor/bird/pack");
		ResourceLoader.loadTextureAtlas("AnimationActor/axe/pack");
		ResourceLoader.loadTextureAtlas("AnimationActor/toxotae/pack");
		ResourceLoader.loadTextureAtlas("AnimationActor/monster/pack");
		
		ResourceLoader.loadTextureAtlas("missionPack");

		ResourceLoader.loadTexture(TextureAssets.DialogBg);
		ResourceLoader.loadTexture(TextureAssets.WindLineImg);
		
	}
	

}
