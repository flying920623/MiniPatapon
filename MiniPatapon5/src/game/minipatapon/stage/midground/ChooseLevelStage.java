package game.minipatapon.stage.midground;

import game.minipatapon.application.MiniPataponManager;
import game.minipatapon.dataprocess.resourcemanage.TextureManage;
import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.effectpresent.actor.FlatImage;
import game.minipatapon.effectpresent.actor.HighlightItemChangeListener;
import game.minipatapon.effectpresent.actor.Image;
import game.minipatapon.effectpresent.actor.LevelImage;
import game.minipatapon.effectpresent.actor.NavigateImage;
import game.minipatapon.effectpresent.actor.PathViewGroup;
import game.minipatapon.effectpresent.actor.PathViewGroup2;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.screen.ContentScreen;
import game.minipatapon.stage.base.BaseStage;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;

public class ChooseLevelStage extends BaseStage implements ActorLoader {


	private LevelImage level1;
	private LevelImage level2;
	private LevelImage level3;
	private LevelImage level4;
	private LevelImage level5;
	private LevelImage level6;
	
	private LevelImage quitImage;
	
	
	TweenManager tweenManager = new TweenManager();
	
	private Image backImage;

	public ChooseLevelStage( float width, float height,
			boolean stretch) {
		super(width, height, stretch);
		// TODO Auto-generated constructor stub

		init();
	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	public void init() {

		initImage();
		initAction();
	}
	
	public void initImage()
	{
		backImage = new Image("backgroud",
				TextureAssets.GetTex(TextureAssets.BackgroundImg));
		backImage.width = width;
		backImage.height = height;
		this.addActor(backImage);
		
		
		
		level1 = new LevelImage("level1", TextureAssets.GetTex("Level/level1.png"), -1000, 0, this, Level1Stage.class, 1);
		level2 = new LevelImage("level2", TextureAssets.GetTex("Level/level2.png"), -1000, 0, this, Level2Stage.class, 2);
		level3 = new LevelImage("level3", TextureAssets.GetTex("Level/level3.png"), -1000, 0, this, Level3Stage.class, 3);
		level4 = new LevelImage("level4", TextureAssets.GetTex("Level/level4_locked.png"), -1000, 0, this);
		level5 = new LevelImage("level5", TextureAssets.GetTex("Level/level5.png"), -1000, 0, this);
		level6 = new LevelImage("level6", TextureAssets.GetTex("Level/level6.png"), -1000, 0, this);
				
		
		level1.setSize(height/3, height/3);
		level2.setSize(height/3, height/3);
		level3.setSize(height/3, height/3);
		level4.setSize(height/3, height/3);
		level5.setSize(height/3, height/3);
		level6.setSize(height/3, height/3);
		
		
    	quitImage = new NavigateImage("quit", new TextureRegion(TextureAssets.GetTex("Level/quitButton.png")), 0, 0, this,MainMenuStage.class);
    	quitImage.setSize(height/10, height/10);

	}
	
	public void initAction()
	{
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
		Timeline.createSequence()
		
		.pushPause(2f)
		
		.push(Tween.set(level1, ActorAccessor.POS_XY)
				.target(width, height/2 + level1.height/10))
		.push(Tween.set(level2, ActorAccessor.POS_XY)
				.target(width, height/2 + level1.height/10))
		.push(Tween.set(level3, ActorAccessor.POS_XY)
				.target(width, height/2 + level1.height/10))
		.push(Tween.set(level4, ActorAccessor.POS_XY)
				.target(width, height/2 - level1.height* 1.1f))
		.push(Tween.set(level5, ActorAccessor.POS_XY)
				.target(width, height/2 - level1.height* 1.1f))
		.push(Tween.set(level6, ActorAccessor.POS_XY)
				.target(width, height/2 - level1.height* 1.1f))

		.beginParallel()
			.push(Tween.to(level1, ActorAccessor.POS_XY, 0.6f)
				.target(width/4 - level1.width/2, height/2 + level1.height/10))
			.push(Tween.to(level2, ActorAccessor.POS_XY, 0.8f)
				.target(width/2-level2.width/2, height/2 + level1.height/10))
		    .push(Tween.to(level3, ActorAccessor.POS_XY, 1f)
				.target(width*3/4-level3.width/2, height/2 + level1.height/10))
		    .push(Tween.to(level4, ActorAccessor.POS_XY, 1.2f)
				.target(width/4 - level1.width/2, height/2 - level1.height* 1.1f))
			.push(Tween.to(level5, ActorAccessor.POS_XY, 1.4f)
				.target(width/2-level2.width/2, height/2 - level1.height* 1.1f))
			.push(Tween.to(level6, ActorAccessor.POS_XY, 1.6f)
				.target(width*3/4-level3.width/2, height/2 - level1.height* 1.1f))
		
		.end()
				
		.start(tweenManager);
		
		quitImage.setPosition(width-quitImage.width*2, height/20);
		quitImage.setOrigin(quitImage.width/2, quitImage.height/2);
		Tween.to(quitImage, ActorAccessor.ROTATION, 1f).target(360).repeat(-1, 0).start(tweenManager);
	
	}

	public void draw()
	{
		tweenManager.update(Gdx.graphics.getDeltaTime());
		
		super.draw();
	}
}
