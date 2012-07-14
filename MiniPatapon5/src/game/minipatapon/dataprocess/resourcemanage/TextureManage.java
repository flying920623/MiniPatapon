package game.minipatapon.dataprocess.resourcemanage;

import game.minipatapon.datasource.assets.TextureAssets;



public class TextureManage {

	//StartAnimationStage Texture	
	public static void loadStartAnimationStage()
	{
		TextureAssets.LoadTextureAtlas("StartAnimation/StartAnimationPack");
	}
	
	public static void loadMainMenuStage()
	{
		TextureAssets.LoadTextureAtlas("MainMenuPack");
		TextureAssets.LoadTextureAtlas("MainMenu/StartMenuPack");
		TextureAssets.LoadTexture("MainMenu/colorTitle.png");
		TextureAssets.LoadTexture("altar.png");
		TextureAssets.LoadTexture("background.png");
	}
	
	public static void loadChooseHeroStage(){
		TextureAssets.LoadTextureAtlas("heroChoose/hero1Pack");
		TextureAssets.LoadTextureAtlas("heroChoose/hero2Pack");
		TextureAssets.LoadTextureAtlas("heroChoose/hero3Pack");
	}
	
	public static void loadLevel3Stage(){
		TextureAssets.LoadTextureAtlas("AnimationActor/flag/pack");
		TextureAssets.LoadTextureAtlas("AnimationActor/sword/pack");
		TextureAssets.LoadTextureAtlas("AnimationActor/blueHeroImages/pack");
		TextureAssets.LoadTextureAtlas("AnimationActor/knightImages/pack");
		TextureAssets.LoadTextureAtlas("AnimationActor/infantry/pack");
		TextureAssets.LoadTextureAtlas("AnimationActor/move_bird/pack");
		TextureAssets.LoadTextureAtlas("AnimationActor/bird/pack");
		TextureAssets.LoadTextureAtlas("AnimationActor/axe/pack");
		TextureAssets.LoadTextureAtlas("AnimationActor/toxotae/pack");
		TextureAssets.LoadTextureAtlas("AnimationActor/monster/pack");
		
		TextureAssets.LoadTextureAtlas("missionPack");
		TextureAssets.LoadTextureAtlas("notePack");
		TextureAssets.LoadTextureAtlas("controlButtonPack");
		
	}
	
	public static void dispose()
	{
		TextureAssets.dispose();
	}
}
