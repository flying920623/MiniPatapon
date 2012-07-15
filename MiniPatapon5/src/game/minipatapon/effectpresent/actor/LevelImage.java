package game.minipatapon.effectpresent.actor;


import game.minipatapon.application.MiniPataponManager;
import game.minipatapon.event.gamecmd.GameState;
import game.minipatapon.event.gamecmd.GameStateArg;
import game.minipatapon.event.gamecmd.NavLayeredScreenStageArg;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.stage.base.BaseStage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.RotateTo;

public class LevelImage extends FlatImage{
	protected Class<? extends BaseStage> m_leveStage =null;

	public int level;
	public LevelImage(String name, TextureRegion region, float x, float y,
			Stage stage) {
		super(name, region, x, y, stage);
		this.touchable =true;
		// TODO Auto-generated constructor stub
	}
	public LevelImage(String name, TextureRegion region, float x, float y,
			Stage stage, Class<? extends BaseStage> stageCls) {
		super(name, region, x, y, stage);
		this.touchable =true;
		m_leveStage = stageCls;
		// TODO Auto-generated constructor stub
	}
	public LevelImage(String name, Texture texture, float x, float y, Stage stage, Class<? extends BaseStage> stageCls, int levelInt) 
	{
		
		super(name, texture, x, y, stage);
		this.touchable =true;
		m_leveStage = stageCls;
		
		level = levelInt;
	}
	
	public LevelImage(String name, Texture texture, float x, float y, Stage stage ) 
	{
		
		super(name, texture, x, y, stage);
		this.touchable =true;
	}
	@Override
	public boolean touchDown(float x, float y, int pointer) {
		return touchable;
	}

	@Override
	public void touchUp(float x, float y, int pointer) {
		DefaultLogger.getDefaultLogger().log(0, "e ","e ");
		MiniPataponManager.getInstance().GetLayeredScreen().getMidScreen().isGameScreen=true;
		MiniPataponManager.getInstance().GetLayeredScreen().getMidScreen().level =level;
		NavLayeredScreenStageArg arg2 =new NavLayeredScreenStageArg(0, m_leveStage);
		arg2.EventArgSent();
		GameStateArg arg = new GameStateArg(GameState.GameStart);
		arg.EventArgSent();
	}

	@Override
	public void touchDragged(float x, float y, int pointer) {
		
	}
	
}
