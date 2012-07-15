package game.minipatapon.stage.midground;

import game.minipatapon.datasource.assets.MusicAssets;
import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.effectpresent.actor.FlatImage;
import game.minipatapon.effectpresent.actor.Image;
import game.minipatapon.effectpresent.actor.LevelImage;
import game.minipatapon.effectpresent.actor.NavigateImage;
import game.minipatapon.effectpresent.animation.AnimateImage;
import game.minipatapon.effectpresent.audioplayer.MusicManage;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.screen.ContentScreen;
import game.minipatapon.stage.base.BaseStage;

import java.util.ArrayList;

import org.ietf.jgss.Oid;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Quad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleTo;

public class MainMenuStage extends BaseStage implements ActorLoader {

	private float scaleX = 0.3f;
	private float scaleY = 0.3f;

	private float moveTime = 2f;

	private float actorDistance = 5f;

	private AnimateImage standardBearer_right_Img;
	private AnimateImage shieldSoldier_right_Img;
	private AnimateImage swordman_right_Img;
	private AnimateImage swordman2_right_Img;

	private AnimateImage shieldSoldier_left_Img;
	private AnimateImage standardBearer_left_Img;
	private AnimateImage shieldSoldier3_left_Img;
	private AnimateImage archer_left_Img;

	private Image altarImg; // 祭坛


	private TextureRegion textureRegion = new TextureRegion(
			ResourceLoader.getTexture(TextureAssets.StartMenuImg));
	private NavigateImage startImage = new NavigateImage("start",
			textureRegion, 1.0f, 1.0f, this, ChooseHeroStage.class);

	private Image backImage = new Image("backgroud",
			ResourceLoader.getTexture(TextureAssets.BackgroundImg));

	private NavigateImage helpImage;
	private NavigateImage settingImage;

	@SuppressWarnings("unused")
	private ContentScreen contentScreen;

	Music music = ResourceLoader.getMusic(MusicAssets.mainStageMusicStr);

	private Image colorTitleImage;

	TweenManager tweenManager = new TweenManager();

	public MainMenuStage(float width, float height, boolean stretch) {
		super(width, height, stretch);
		// TODO Auto-generated constructor stub
		
		this.init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		MusicManage.setLoopingMusic(music, true);
		MusicManage.playMusic(music);
		
		backImage.width = width;
		backImage.height = height;
		this.addActor(backImage);

		scaleY = Gdx.graphics.getHeight() / 240 * 0.3f;
		scaleX = scaleY;

		this.loadAltarImg();

		this.initStartMenu();

		this.loadShieldSoldier3_left_Img();
		this.loadShieldSoldier_left_Img();
		this.loadArcher_left_Img();
		this.loadStandardBearer_left_Img();

		this.loadSwordman2_right_Img();
		this.loadSwordman_right_Img();
		this.loadShieldSoldier_right_Img();
		this.loadStandardBearer_right_Img();

		// this.loadGameName1Img();
		// this.loadGameName2Img();

		// this.InitAction();

		initColorTitle();

		this.loadHelpImage();
		this.loadSettingImage();
	}


	void initStartMenu() {
		startImage.width = width / 6;
		startImage.height = height / 10;

		startImage.x = width / 2 - startImage.width / 2;
		startImage.y = height / 2;

		this.addActor(startImage);
	}

	void initColorTitle() {
		this.colorTitleImage = new Image("",
				ResourceLoader.getTexture(TextureAssets.ColorTitleImg));
		this.addActor(colorTitleImage);

		colorTitleImage.width = width / 3.5f;
		colorTitleImage.height = height / 3.5f;

		colorTitleImage.x = width / 2 - colorTitleImage.width / 2;
		colorTitleImage.y = height;

		Timeline.createSequence()

				.pushPause(2f)
				.push(Tween.to(colorTitleImage, ActorAccessor.POS_XY, 1f)
						.targetRelative(0, -height / 3))

				.setCallback(new TweenCallback() {

					@Override
					public void onEvent(int type, BaseTween<?> source) {
						// TODO Auto-generated method stub
						Timeline.createParallel()
								.push(Tween
										.to(colorTitleImage,
												ActorAccessor.SCALE_XY, 0.15f)
										.targetRelative(0.1f, 0.15f)
										.ease(Quad.OUT)).repeatYoyo(-1, 0.1f)

								.start(tweenManager);
					}

				})

				.start(tweenManager);

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		tweenManager.update(Gdx.graphics.getDeltaTime());

		super.draw();

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		// MusicManage.pauseMusic(music);
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		MusicManage.stopMusic(music);
	}

	private void loadStandardBearer_left_Img() {
		ArrayList<String> picNames = TextureAssets.StandardBearer_left_Img;
		ArrayList<TextureRegion> regions = ResourceLoader
				.getRegionsFromPacker(picNames);

		this.standardBearer_left_Img = new AnimateImage(regions, -100f, 0f,
				this, 0.5f);

		this.standardBearer_left_Img.scaleX = scaleX;
		this.standardBearer_left_Img.scaleY = scaleY;

		float movex = this.actorDistance * 4
				+ this.shieldSoldier3_left_Img.getScaledWidth()
				+ this.shieldSoldier_left_Img.getScaledWidth()
				+ this.archer_left_Img.getScaledWidth();

		// this.standardBearer_left_Img.action(MoveTo.$(movex, 0f, 4f));

		Tween.to(standardBearer_left_Img, ActorAccessor.POS_XY, moveTime)
				.target(movex, 0f).start(tweenManager);

	}

	private void loadArcher_left_Img() {
		ArrayList<String> picNames = TextureAssets.Archer_left_Img;
		ArrayList<TextureRegion> regions = ResourceLoader
				.getRegionsFromPacker(picNames);

		this.archer_left_Img = new AnimateImage(regions, -100f, 0f, this, 0.5f);

		this.archer_left_Img.scaleX = scaleX;
		this.archer_left_Img.scaleY = scaleY;

		float movex = this.actorDistance * 3
				+ this.shieldSoldier3_left_Img.getScaledWidth()
				+ this.shieldSoldier_left_Img.getScaledWidth();

		// this.archer_left_Img.action(MoveTo.$(movex, 0f, 4f));

		Tween.to(archer_left_Img, ActorAccessor.POS_XY, moveTime)
				.target(movex, 0f).start(tweenManager);

	}

	private void loadShieldSoldier_left_Img() {
		ArrayList<String> picNames = TextureAssets.ShieldSoldier_left_Img;

		ArrayList<TextureRegion> regions = ResourceLoader.getRegionsFromPacker(picNames);

		this.shieldSoldier_left_Img = new AnimateImage(regions, -100f, 0f,
				this, 0.5f);

		this.shieldSoldier_left_Img.scaleX = scaleX;
		this.shieldSoldier_left_Img.scaleY = scaleY;

		float movex = this.actorDistance * 2
				+ this.shieldSoldier3_left_Img.getScaledWidth();

		// this.shieldSoldier_left_Img.action(MoveTo.$(movex, 0f, 4f));
		Tween.to(shieldSoldier_left_Img, ActorAccessor.POS_XY, moveTime)
				.target(movex, 0f).start(tweenManager);

	}

	private void loadShieldSoldier3_left_Img() {
		ArrayList<String> picNames = TextureAssets.ShieldSoldier3_left_Img;

		ArrayList<TextureRegion> regions = ResourceLoader
				.getRegionsFromPacker(picNames);

		this.shieldSoldier3_left_Img = new AnimateImage(regions, -100f, 0f,
				this, 0.5f);

		this.shieldSoldier3_left_Img.scaleX = scaleX;
		this.shieldSoldier3_left_Img.scaleY = scaleY;

		float movex = this.actorDistance;

		// this.shieldSoldier3_left_Img.action(MoveTo.$(movex, 0f, 4f));

		Tween.to(shieldSoldier3_left_Img, ActorAccessor.POS_XY, moveTime)
				.target(movex, 0f).start(tweenManager);

	}

	private void loadStandardBearer_right_Img() {
		ArrayList<String> picNames = TextureAssets.StandardBearer_right_Img;
		ArrayList<TextureRegion> regions = ResourceLoader
				.getRegionsFromPacker(picNames);

		this.standardBearer_right_Img = new AnimateImage(regions,
				Gdx.graphics.getWidth(), 0f, this, 0.5f);

		this.standardBearer_right_Img.scaleX = this.scaleX;
		this.standardBearer_right_Img.scaleY = this.scaleY;

		float movex = this.actorDistance * 4
				+ this.swordman2_right_Img.getScaledWidth()
				+ this.swordman_right_Img.getScaledWidth()
				+ this.shieldSoldier_right_Img.getScaledWidth()
				+ this.standardBearer_right_Img.getScaledWidth();

		// this.standardBearer_right_Img.action(MoveTo.$(Gdx.graphics.getWidth()
		// - movex, -standardBearer_right_Img.height/35, 4f));

		Tween.to(standardBearer_right_Img, ActorAccessor.POS_XY, moveTime)
				.target(Gdx.graphics.getWidth() - movex, 0f)
				.start(tweenManager);

	}

	private void loadShieldSoldier_right_Img() {
		ArrayList<String> picNames = TextureAssets.ShieldSoldier_left_Img;
		ArrayList<TextureRegion> regions = ResourceLoader
				.getRegionsFromPacker(picNames);

		this.shieldSoldier_right_Img = new AnimateImage(regions,
				Gdx.graphics.getWidth(), 0f, this, 0.5f);

		this.shieldSoldier_right_Img.scaleX = this.scaleX;
		this.shieldSoldier_right_Img.scaleY = this.scaleY;

		float movex = this.actorDistance * 3
				+ this.swordman2_right_Img.getScaledWidth()
				+ this.swordman_right_Img.getScaledWidth()
				+ this.shieldSoldier_right_Img.getScaledWidth();

		// this.shieldSoldier_right_Img.action(MoveTo.$(Gdx.graphics.getWidth()
		// - movex, 0f, 4f));

		Tween.to(shieldSoldier_right_Img, ActorAccessor.POS_XY, moveTime)
				.target(Gdx.graphics.getWidth() - movex, 0f)
				.start(tweenManager);
	}

	private void loadSwordman_right_Img() {
		ArrayList<String> picNames = TextureAssets.Swordman_right_Img;
		ArrayList<TextureRegion> regions = ResourceLoader
				.getRegionsFromPacker(picNames);

		this.swordman_right_Img = new AnimateImage(regions,
				Gdx.graphics.getWidth(), 0f, this, 0.5f);

		this.swordman_right_Img.scaleX = this.scaleX;
		this.swordman_right_Img.scaleY = this.scaleY;

		float movex = this.actorDistance * 2
				+ this.swordman2_right_Img.getScaledWidth()
				+ this.swordman_right_Img.getScaledWidth();

		// this.swordman_right_Img.action(MoveTo.$(
		// Gdx.graphics.getWidth() - movex, 0f, 4f));

		Tween.to(swordman_right_Img, ActorAccessor.POS_XY, moveTime)
				.target(Gdx.graphics.getWidth() - movex, 0f)
				.start(tweenManager);
	}

	private void loadSwordman2_right_Img() {
		ArrayList<String> picNames = TextureAssets.Swordman2_right_Img;
		ArrayList<TextureRegion> regions = ResourceLoader
				.getRegionsFromPacker(picNames);

		this.swordman2_right_Img = new AnimateImage(regions,
				Gdx.graphics.getWidth(), 0f, this, 0.5f);

		this.swordman2_right_Img.scaleX = this.scaleX;
		this.swordman2_right_Img.scaleY = this.scaleY;

		float movex = this.actorDistance
				+ this.swordman2_right_Img.getScaledWidth();

		// this.swordman2_right_Img.action(MoveTo.$(Gdx.graphics.getWidth()
		// - movex, 0f, 4f));

		Tween.to(swordman2_right_Img, ActorAccessor.POS_XY, moveTime)
				.target(Gdx.graphics.getWidth() - movex, 0f)
				.start(tweenManager);

	}

	private void loadAltarImg() {

		Texture maskTexture = ResourceLoader.getTexture(TextureAssets.Altar_Img);
		this.altarImg = new FlatImage(maskTexture, 0, -100f, this);

		DefaultLogger.getDefaultLogger().logWithSignature(this, "%f  %f",
				width, height);

		altarImg.width = this.width * 4 / 5;
		altarImg.height = this.height * 4 / 5;

		//
		// this.altarImg.scaleX = this.scaleX;
		// this.altarImg.scaleY = this.scaleY;

		// this.altarImg.action(MoveTo.$(width/2 - altarImg.width/2, 0f, 2f));

		Tween.to(altarImg, ActorAccessor.POS_XY, moveTime)
				.target(width / 2 - altarImg.width / 2, 0f).start(tweenManager);
	}



	private void loadHelpImage() {
		Texture texture = ResourceLoader.getTexture(TextureAssets.HelpImage);
		TextureRegion textureRegion = new TextureRegion(texture);
		this.helpImage = new NavigateImage("help", textureRegion, 1.0f, 1.0f,
				this, HelpStage.class);

		this.helpImage.width = height / 10;
		this.helpImage.height = height / 10;

		this.helpImage.x = this.width - this.helpImage.width * 1.1f;
		this.helpImage.y = this.height - this.helpImage.height * 1.1f;
		this.addActor(this.helpImage);
	}

	private void loadSettingImage() {
		Texture texture = ResourceLoader.getTexture(TextureAssets.SettingImage);
		TextureRegion textureRegion = new TextureRegion(texture);
		this.settingImage = new NavigateImage("setting", textureRegion, 1.0f,
				1.0f, this, SettingStage.class);

		this.settingImage.width = height / 10;
		this.settingImage.height = height / 10;

		this.settingImage.x = this.width - this.settingImage.width * 1.1f;
		this.settingImage.y = this.height - this.settingImage.height * 2.2f;
		this.addActor(this.settingImage);
	}

}
