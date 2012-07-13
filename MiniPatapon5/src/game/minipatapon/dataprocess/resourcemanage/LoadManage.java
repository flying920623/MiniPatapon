package game.minipatapon.dataprocess.resourcemanage;

import game.minipatapon.datasource.assets.TextureAssets;

public class LoadManage {

	public static void loadStartAnimationStage() {
		TextureManage.loadStartAnimationStage();
	}

	public static void loadMainMenuStage() {
		TextureManage.loadMainMenuStage();
	}

	public static void loadChooseHeroStage() {
		TextureManage.loadChooseHeroStage();
	}

	public static void loadLevel3Stage() {
		TextureManage.loadLevel3Stage();
	}
	
	
	public static void dispose()
	{
		TextureManage.dispose();
		MusicManage.dispose();
	}
}
