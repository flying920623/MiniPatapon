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
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleTo;

public class MainMenuStage extends BaseStage implements ActorLoader {

	private float scaleX = 0.5f;
	private float scaleY = 0.5f;

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

	private FlatImage gameName1Img;
	private FlatImage gameName2Img;
	
	private TextureRegion textureRegion = new TextureRegion(TextureAssets.GetTex(TextureAssets.StartMenuImg));
	private NavigateImage startImage = new NavigateImage("start", textureRegion,1.0f,1.0f,this,ChooseHeroStage.class);

	private Image backImage = new Image("backgroud",
			TextureAssets.GetTex(TextureAssets.BackgroundImg));
	

	
	private NavigateImage helpImage;
	private NavigateImage settingImage;
	
	@SuppressWarnings("unused")
	private ContentScreen contentScreen;
	
	Music music = ResourceLoader.loadMusic(MusicAssets.mainStageMusicStr);
	
	
	private Image colorTitleImage;
	
	TweenManager tweenManager = new TweenManager();

	public MainMenuStage(float width, float height, boolean stretch) {
		super(width, height, stretch);
		// TODO Auto-generated constructor stub
		MusicManage.setLoopingMusic(music, true);
		MusicManage.playMusic(music);
		this.init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

		backImage.width = width;
		backImage.height = height;
		this.addActor(backImage);
		
		this.loadAltarImg();
		
		startImage.width = width/6;
		startImage.height = height/10;
		
		startImage.x = width/2 - startImage.width/2;
		startImage.y = height/2;
		
		this.addActor( startImage );

		this.loadShieldSoldier3_left_Img();
		this.loadShieldSoldier_left_Img();
		this.loadArcher_left_Img();
		this.loadStandardBearer_left_Img();

		this.loadSwordman2_right_Img();
		this.loadSwordman_right_Img();
		this.loadShieldSoldier_right_Img();
		this.loadStandardBearer_right_Img();

		//this.loadGameName1Img();
		//this.loadGameName2Img();

		//this.InitAction();

		initColorTitle();
		
		this.loadHelpImage();
		this.loadSettingImage();
	//	image = new FlatImage(TextureAssets.GetTextureRegionFromPacker(TextureAssets.PonImg), 200, 200, this);
	//	 this.addActor(image);
	}

	//
	// /** Renders the stage */
	// @Override
	// public void draw () {
	// camera.update();
	// batch.setProjectionMatrix(camera.combined);
	// batch.begin();
	// root.draw(batch, 1);
	// //batch.draw(archerImg.region, 100, 100, 0, 0, archerImg.width,
	// archerImg.height, archerImg.scaleX, archerImg.scaleY, 0);
	// batch.end();
	//
	//
	// }
	
	
	void initColorTitle() {
		this.colorTitleImage = new Image("",
				TextureAssets.GetTex(TextureAssets.ColorTitleImg));
		this.addActor(colorTitleImage);

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
	public void draw()
	{
		// TODO Auto-generated method stub
		tweenManager.update(Gdx.graphics.getDeltaTime());
		
		super.draw();
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		MusicManage.pauseMusic(music);
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
	public void dispose()
	{
		// TODO Auto-generated method stub
		super.dispose();
		MusicManage.stopMusic(music);
	}

	private void loadStartMenuImg()
	{
		
	}

	private void loadStandardBearer_left_Img() {
		ArrayList<String> picNames = TextureAssets.StandardBearer_left_Img;
		ArrayList<TextureRegion> regions = TextureAssets
				.GetTextureRegionsFromPacker(picNames);

		this.standardBearer_left_Img = new AnimateImage(regions, -100f, 0f,
				this, 0.5f);

		this.standardBearer_left_Img.scaleX = scaleX;
		this.standardBearer_left_Img.scaleY = scaleY;

		float movex = this.actorDistance * 4
				+ this.shieldSoldier3_left_Img.getScaledWidth()
				+ this.shieldSoldier_left_Img.getScaledWidth()
				+ this.archer_left_Img.getScaledWidth();

		this.standardBearer_left_Img.action(MoveTo.$(movex, 0f, 4f));

	}

	private void loadArcher_left_Img() {
		ArrayList<String> picNames = TextureAssets.Archer_left_Img;
		ArrayList<TextureRegion> regions = TextureAssets
				.GetTextureRegionsFromPacker(picNames);

		this.archer_left_Img = new AnimateImage(regions, -100f, 0f, this, 0.5f);

		this.archer_left_Img.scaleX = scaleX;
		this.archer_left_Img.scaleY = scaleY;

		float movex = this.actorDistance * 3
				+ this.shieldSoldier3_left_Img.getScaledWidth()
				+ this.shieldSoldier_left_Img.getScaledWidth();

		this.archer_left_Img.action(MoveTo.$(movex, 0f, 4f));

	}

	private void loadShieldSoldier_left_Img() {
		ArrayList<String> picNames = TextureAssets.ShieldSoldier_left_Img;

		ArrayList<TextureRegion> regions = TextureAssets
				.GetTextureRegionsFromPacker(picNames);

		this.shieldSoldier_left_Img = new AnimateImage(regions, -100f, 0f,
				this, 0.5f);

		this.shieldSoldier_left_Img.scaleX = scaleX;
		this.shieldSoldier_left_Img.scaleY = scaleY;

		float movex = this.actorDistance * 2
				+ this.shieldSoldier3_left_Img.getScaledWidth();

		this.shieldSoldier_left_Img.action(MoveTo.$(movex, 0f, 4f));
	}

	private void loadShieldSoldier3_left_Img() {
		ArrayList<String> picNames = TextureAssets.ShieldSoldier3_left_Img;

		ArrayList<TextureRegion> regions = TextureAssets
				.GetTextureRegionsFromPacker(picNames);

		this.shieldSoldier3_left_Img = new AnimateImage(regions, -100f, 0f,
				this, 0.5f);

		this.shieldSoldier3_left_Img.scaleX = scaleX;
		this.shieldSoldier3_left_Img.scaleY = scaleY;

		float movex = this.actorDistance;

		this.shieldSoldier3_left_Img.action(MoveTo.$(movex, 0f, 4f));
	}

	private void loadStandardBearer_right_Img() {
		ArrayList<String> picNames = TextureAssets.StandardBearer_right_Img;
		ArrayList<TextureRegion> regions = TextureAssets
				.GetTextureRegionsFromPacker(picNames);

		this.standardBearer_right_Img = new AnimateImage(regions,
				Gdx.graphics.getWidth(), 0f, this, 0.5f);

		this.standardBearer_right_Img.scaleX = this.scaleX;
		this.standardBearer_right_Img.scaleY = this.scaleY;

		float movex = this.actorDistance * 4
				+ this.swordman2_right_Img.getScaledWidth()
				+ this.swordman_right_Img.getScaledWidth()
				+ this.shieldSoldier_right_Img.getScaledWidth()
				+ this.standardBearer_right_Img.getScaledWidth();

		this.standardBearer_right_Img.action(MoveTo.$(Gdx.graphics.getWidth()
				- movex, 0f, 4f));
		this.standardBearer_right_Img.action(ScaleTo.$(scaleX, scaleY, 0f));
	}

	private void loadShieldSoldier_right_Img() {
		ArrayList<String> picNames = TextureAssets.ShieldSoldier_left_Img;
		ArrayList<TextureRegion> regions = TextureAssets
				.GetTextureRegionsFromPacker(picNames);

		this.shieldSoldier_right_Img = new AnimateImage(regions,
				Gdx.graphics.getWidth(), 0f, this, 0.5f);

		this.shieldSoldier_right_Img.scaleX = this.scaleX;
		this.shieldSoldier_right_Img.scaleY = this.scaleY;

		float movex = this.actorDistance * 3
				+ this.swordman2_right_Img.getScaledWidth()
				+ this.swordman_right_Img.getScaledWidth()
				+ this.shieldSoldier_right_Img.getScaledWidth();

		this.shieldSoldier_right_Img.action(MoveTo.$(Gdx.graphics.getWidth()
				- movex, 0f, 4f));
		this.shieldSoldier_right_Img.action(ScaleTo.$(scaleX, scaleY, 0f));
	}

	private void loadSwordman_right_Img() {
		ArrayList<String> picNames = TextureAssets.Swordman_right_Img;
		ArrayList<TextureRegion> regions = TextureAssets
				.GetTextureRegionsFromPacker(picNames);

		this.swordman_right_Img = new AnimateImage(regions,
				Gdx.graphics.getWidth(), 0f, this, 0.5f);

		this.swordman_right_Img.scaleX = this.scaleX;
		this.swordman_right_Img.scaleY = this.scaleY;

		float movex = this.actorDistance * 2
				+ this.swordman2_right_Img.getScaledWidth()
				+ this.swordman_right_Img.getScaledWidth();

		this.swordman_right_Img.action(MoveTo.$(
				Gdx.graphics.getWidth() - movex, 0f, 4f));
	}

	private void loadSwordman2_right_Img() {
		ArrayList<String> picNames = TextureAssets.Swordman2_right_Img;
		ArrayList<TextureRegion> regions = TextureAssets
				.GetTextureRegionsFromPacker(picNames);

		this.swordman2_right_Img = new AnimateImage(regions,
				Gdx.graphics.getWidth(), 0f, this, 0.5f);

		this.swordman2_right_Img.scaleX = this.scaleX;
		this.swordman2_right_Img.scaleY = this.scaleY;

		float movex = this.actorDistance
				+ this.swordman2_right_Img.getScaledWidth();

		this.swordman2_right_Img.action(MoveTo.$(Gdx.graphics.getWidth()
				- movex, 0f, 4f));

	}

	private void loadAltarImg() {

		Texture maskTexture = TextureAssets.GetTex(TextureAssets.Altar_Img);
		this.altarImg = new FlatImage(maskTexture, 0, -100f, this);

		DefaultLogger.getDefaultLogger().logWithSignature(this, "%f  %f", width, height);
		
		altarImg.width = this.width*4/5;
		altarImg.height = this.height*4/5;
		
		//
		// this.altarImg.scaleX = this.scaleX;
		// this.altarImg.scaleY = this.scaleY;

		this.altarImg.action(MoveTo.$(width/2 - altarImg.width/2, 0f, 2f));
	}

	private void loadGameName1Img() {

		ArrayList<TextureRegion> regions = TextureAssets
				.GetTextureRegionsFromPacker(TextureAssets.GameName1Img);

		this.gameName1Img = new FlatImage(regions.get(0),
				Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 2, this);

		this.gameName1Img.scaleX = 0.5f;
		this.gameName1Img.scaleY = 0.5f;

	}

	private void loadGameName2Img() {

		ArrayList<TextureRegion> regions = TextureAssets
				.GetTextureRegionsFromPacker(TextureAssets.GameName2Img);
		this.gameName2Img = new FlatImage(regions.get(0),
				Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 2, this);

		this.gameName2Img.scaleX = 0.5f;
		this.gameName2Img.scaleY = 0.5f;
	}

	private void InitAction() {
		float gameNameWIdth = this.gameName1Img.getScaledWidth()
				+ this.gameName2Img.getScaledWidth();

		Action action = MoveTo.$(Gdx.graphics.getWidth() / 2 - gameNameWIdth
				/ 2, this.gameName1Img.y, 3f);
		action.setCompletionListener(gameName2Img);

		this.gameName1Img.action(action);

		this.gameName2Img.setActionOncompleted(action, MoveTo.$(
				Gdx.graphics.getWidth() / 2 - gameNameWIdth / 2
						+ this.gameName1Img.getScaledWidth(),
				this.gameName2Img.y, 0.5f));

		// this.gameName2Img.action( MoveTo.$(Gdx.graphics.getWidth()/2 -
		// gameNameWIdth/2 + this.gameName1Img.getScaledWidth(),
		// this.gameName2Img.y, 3f) );
	}
	private void loadHelpImage()
	{
		Texture texture = ResourceLoader.loadTexture("help.png");
		TextureRegion textureRegion = new TextureRegion(texture);
		this.helpImage = new NavigateImage("help", textureRegion, 1.0f, 1.0f, this, HelpStage.class);
		this.helpImage.x = this.width-70;
		this.helpImage.y = this.height-70;
		this.addActor(this.helpImage);
	}
	private void loadSettingImage()
	{
		Texture texture = ResourceLoader.loadTexture("set.png");
		TextureRegion textureRegion = new TextureRegion(texture);
		this.settingImage = new NavigateImage("setting", textureRegion, 1.0f, 1.0f, this, SettingStage.class);
		this.settingImage.x = this.width-70;
		this.settingImage.y = this.height-140;
		this.addActor(this.settingImage);
	}
	
}