package game.minipatapon.effectpresent.actor;

import game.minipatapon.application.MiniPataponManager;
import game.minipatapon.event.gamecmd.GameState;
import game.minipatapon.event.gamecmd.GameStateArg;
import game.minipatapon.event.gamecmd.NavLayeredScreenStageArg;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.stage.base.BaseStage;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class NavigateImage extends LevelImage {

	public NavigateImage(String name, TextureRegion region, float x, float y,
			Stage stage, Class<? extends BaseStage> stageCls) {
		super(name, region, x, y, stage, stageCls);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void touchUp(float x, float y, int pointer) {
		if (MiniPataponManager.getInstance().GetLayeredScreen().getMidScreen().isGameScreen) {

			MiniPataponManager.getInstance().GetLayeredScreen().getMidScreen().isGameScreen = false;

			GameStateArg arg = new GameStateArg(GameState.GameEnd);
			arg.EventArgSent();
		}

		DefaultLogger.getDefaultLogger().log(0, "e ", "e ");
		NavLayeredScreenStageArg arg2 = new NavLayeredScreenStageArg(0,
				this.m_leveStage);
		arg2.EventArgSent();
	}

}
