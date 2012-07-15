package game.minipatapon.dataprocess.resourcemanage;

import game.minipatapon.datasource.assets.Assets;


public class LoadManage {
	
	public static void loadAll()
	{
		loadBackgroundStage();
		loadForegroundStage();
		loadStartAnimationStage();
		loadMainMenuStage();
		loadChooseHeroStage();
		loadChooseLevelStage();
		loadLevel3Stage();
	}
	
	public static void loadBackgroundStage(){
		TextureManage.loadBackgroundStage();
		MusicManage.loadBackgroundStage();
	}
	
	public static void loadForegroundStage()
	{
		TextureManage.loadForegroundStage();
		MusicManage.loadForegroundStage();
	}

	public static void loadStartAnimationStage() {
		TextureManage.loadStartAnimationStage();
		MusicManage.loadStartAnimationStage();
	}

	public static void loadMainMenuStage() {
		TextureManage.loadMainMenuStage();
		MusicManage.loadMainMenuStage();
	}

	public static void loadChooseHeroStage() {
		TextureManage.loadChooseHeroStage();
		MusicManage.loadChooseHeroStage();
	}
	
	public static void loadChooseLevelStage()
	{
		TextureManage.loadChooseLevelStage();
		MusicManage.loadChooseLevelStage();
	}

	public static void loadLevel3Stage() {
		TextureManage.loadLevel3Stage();
		MusicManage.loadLevel3Stage();
	}
	
	
	public static void dispose()
	{
		Assets.inst().dispose();
	}
}
