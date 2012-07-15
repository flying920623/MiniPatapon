package game.minipatapon.stage.midground;

import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.effectpresent.actor.Image;
import game.minipatapon.effectpresent.actor.LevelImage;
import game.minipatapon.effectpresent.actor.NavigateImage;
import game.minipatapon.stage.base.BaseStage;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

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

	public ChooseLevelStage(float width, float height, boolean stretch) {
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

	public void initImage() {
		backImage = new Image("backgroud",
				ResourceLoader.getTexture(TextureAssets.BackgroundImg));
		backImage.width = width;
		backImage.height = height;
		this.addActor(backImage);

		level1 = new LevelImage("level1",
				ResourceLoader.getTexture(TextureAssets.Level1Img), -1000, 0,
				this, Level1Stage.class, 1);
		level2 = new LevelImage("level2",
				ResourceLoader.getTexture(TextureAssets.Level2Img), -1000, 0,
				this, Level2Stage.class, 2);
		level3 = new LevelImage("level3",
				ResourceLoader.getTexture(TextureAssets.Level3Img), -1000, 0,
				this, Level3Stage.class, 3);
		level4 = new LevelImage("level4",
				ResourceLoader.getTexture(TextureAssets.Level4LockedImg),
				-1000, 0, this);
		level5 = new LevelImage("level5",
				ResourceLoader.getTexture(TextureAssets.Level5Img), -1000, 0,
				this);
		level6 = new LevelImage("level6",
				ResourceLoader.getTexture(TextureAssets.Level6Img), -1000, 0,
				this);

		level1.setSize(height / 3, height / 3);
		level2.setSize(height / 3, height / 3);
		level3.setSize(height / 3, height / 3);
		level4.setSize(height / 3, height / 3);
		level5.setSize(height / 3, height / 3);
		level6.setSize(height / 3, height / 3);

		quitImage = new NavigateImage("quit", new TextureRegion(
				ResourceLoader.getTexture(TextureAssets.QuitImage)), 0, 0,
				this, MainMenuStage.class);
		quitImage.setSize(height / 10, height / 10);

	}

	public void initAction() {
		Tween.registerAccessor(Actor.class, new ActorAccessor());

		Timeline.createSequence()

				.pushPause(0.5f)

				.push(Tween.set(level1, ActorAccessor.POS_XY).target(width,
						height / 2 + level1.height / 10))
				.push(Tween.set(level2, ActorAccessor.POS_XY).target(width,
						height / 2 + level1.height / 10))
				.push(Tween.set(level3, ActorAccessor.POS_XY).target(width,
						height / 2 + level1.height / 10))
				.push(Tween.set(level4, ActorAccessor.POS_XY).target(width,
						height / 2 - level1.height * 1.1f))
				.push(Tween.set(level5, ActorAccessor.POS_XY).target(width,
						height / 2 - level1.height * 1.1f))
				.push(Tween.set(level6, ActorAccessor.POS_XY).target(width,
						height / 2 - level1.height * 1.1f))

				.beginParallel()
				.push(Tween.to(level1, ActorAccessor.POS_XY, 0.6f).target(
						width / 4 - level1.width / 2,
						height / 2 + level1.height / 10))
				.push(Tween.to(level2, ActorAccessor.POS_XY, 0.8f).target(
						width / 2 - level2.width / 2,
						height / 2 + level1.height / 10))
				.push(Tween.to(level3, ActorAccessor.POS_XY, 1f).target(
						width * 3 / 4 - level3.width / 2,
						height / 2 + level1.height / 10))
				.push(Tween.to(level4, ActorAccessor.POS_XY, 1.2f).target(
						width / 4 - level1.width / 2,
						height / 2 - level1.height * 1.1f))
				.push(Tween.to(level5, ActorAccessor.POS_XY, 1.4f).target(
						width / 2 - level2.width / 2,
						height / 2 - level1.height * 1.1f))
				.push(Tween.to(level6, ActorAccessor.POS_XY, 1.6f).target(
						width * 3 / 4 - level3.width / 2,
						height / 2 - level1.height * 1.1f))

				.end()

				.start(tweenManager);

		quitImage.setPosition(width - quitImage.width * 2, height / 20);
		quitImage.setOrigin(quitImage.width / 2, quitImage.height / 2);
		Tween.to(quitImage, ActorAccessor.ROTATION, 1f).target(360)
				.repeat(-1, 0).start(tweenManager);

	}

	public void draw() {
		tweenManager.update(Gdx.graphics.getDeltaTime());

		super.draw();
	}
}
