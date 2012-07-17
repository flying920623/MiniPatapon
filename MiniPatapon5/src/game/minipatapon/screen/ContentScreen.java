/** 
 * @description	: the content layer of the screen
 * @author		: 黄攀
 * @created		: 2012-1-4
 */

package game.minipatapon.screen;

//import game.minipatapon.stage.midground.MainMenuStage;
//import game.minipatapon.stage.midground.StartMenuStage;
import game.minipatapon.effectpresent.actor.GameLevel;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.stage.midground.ChooseHeroStage;
import game.minipatapon.stage.midground.ChooseLevelStage;
import game.minipatapon.stage.midground.HelpStage;
import game.minipatapon.stage.midground.Level1Stage;
import game.minipatapon.stage.midground.Level3Stage;
import game.minipatapon.stage.midground.LevelOneStage;
import game.minipatapon.stage.midground.MainMenuStage;
import game.minipatapon.stage.midground.PrestrainStage;
import game.minipatapon.stage.midground.SettingStage;
import game.minipatapon.stage.midground.StartAnimationStage;
import game.minipatapon.stage.midground.TestSpriterImport;

public class ContentScreen extends NavigateScreen {

	public static int level = 0;
	
	public boolean isGameScreen=false;
	public ContentScreen() {
		this.setLayer(ScreenLayer.CONTENT);

		DefaultLogger.getDefaultLogger().logWithSignature(this,
				"enter ContentScreen");
		
	}

	@Override
	public void show() {
		DefaultLogger.getDefaultLogger().logWithSignature(this,
				"enter ContentScreen.show()");

		super.show();
		// this.navigate(new StartMenuStage(this, getWidth(), getHeight(),
		// truer));
//		 this.navigate(new MainMenuStage( getWidth(), getHeight(), true));
//		 this.navigate(new ChooseLevelStage( getWidth(), getHeight(), true));
// 		this.navigate(new StartAnimationStage(getWidth(), getHeight(), true));
 		this.navigate(new PrestrainStage(getWidth(), getHeight(), true, "loadAll", StartAnimationStage.class) );
//		this.navigate(new TestSpriterImport(getWidth(), getHeight(), true));
//		this.navigate(new Level3Stage(getWidth(), getHeight(), true, 3));
//		 this.navigate(new ChooseHeroStage(getWidth(), getHeight(), true));
//		 this.navigate(new SettingStage(getWidth(), getHeight(), true));
//		 this.navigate(new HelpStage(getWidth(), getHeight(), true));
//		this.navigate(new LevelOneStage(getWidth(), getHeight(), true, GameLevel.LevelOneStage));
	}
}
