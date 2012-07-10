package game.minipatapon.stage.foreground;

import org.w3c.dom.css.Counter;

import aurelienribon.tweenengine.Tween;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.effectpresent.actor.FlatImage;
import game.minipatapon.effectpresent.actor.Image;
import game.minipatapon.effectpresent.actor.InputImage;
import game.minipatapon.effectpresent.actor.NavigateImage;
import game.minipatapon.effectpresent.dialog.TimerDialog;
import game.minipatapon.effectpresent.widget.NoteImage;
import game.minipatapon.event.EventListener;

import game.minipatapon.event.music.MatchMusicType;
import game.minipatapon.event.music.MusicRythmRecArg;

import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.logger.Loggable;
import game.minipatapon.logical.GameRule.GameStateListener;
//import game.minipatapon.service.ResourceLoader;
import game.minipatapon.stage.base.BaseStage;
import game.minipatapon.stage.midground.ChooseLevelStage;
import game.minipatapon.stage.midground.GameStage;
import game.minipatapon.stage.midground.MainMenuStage;
import game.minipatapon.stage.midground.TestSpriterImport;

public class ForegroundStage extends BaseStage {

	InputImage pataButton;
	InputImage ponButton;
	InputImage cakaButton;
	

	
	TimerDialog timerDialog;
	SpriteBatch spriteBatch;
	ParticleEffect particle;
	Loggable logger;
	Sound slipSound;
	Sound clickSound;
	float soundDelta;
	float w;
	float h;
	final float minSoundDelta = 0.5f;
	final float minDistance = 50;
	private int startX = 0;
	private int startY = 0;
	// TextureRegion texCourse;
	// TextureRegion texClickDown;
	// TextureRegion texClickNormal;
	// TextureRegion texDrag;

	Music testSound;

	private Vector2 coursePos = new Vector2(50, 50);

	public ForegroundStage(float width, float height, boolean stretch) {
		super(width, height, stretch);
		this.w = width;
		this.h = height;
		this.soundDelta = 0;

		initialize();
	}

	private void playTestSound() {

		testSound.setLooping(true);
		testSound.play();
	}

	private void playSlipSound() {
		if (this.soundDelta > this.minSoundDelta) {
			// this.slipSound.play();
			this.soundDelta = 0;
		}
	}

	private void playClickSound() {
		// this.clickSound.play();
	}

	private void initialize() {

		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
		initButton();
		initTimerDialog();
		logger = DefaultLogger.getDefaultLogger();
		spriteBatch = new SpriteBatch();
		particle = ResourceLoader.loadParticle("default.p", "");
		particle.setPosition(-100, -100);
		this.slipSound = ResourceLoader.loadSound("slip.ogg");
		// Texture course = ResourceLoader.loadTexture("hand_256_64.png");
		// this.texClickNormal = new TextureRegion(course, 0, 0, 41, 56);
		// this.texClickDown = new TextureRegion(course, 82, 0, 41, 56);
		// this.texDrag = new TextureRegion(course, 126, 0, 41, 56);
		// this.texCourse = this.texClickNormal;
		this.clickSound = ResourceLoader.loadSound("click_sound.ogg");
		this.testSound = ResourceLoader.loadMusic("drum_two_rhythm.mp3");

	}

	public void initButton() {

		pataButton = new InputImage(
				TextureAssets
						.GetTextureRegionFromPacker(TextureAssets.PataButton),
				0, 0, this, MatchMusicType.Pata);
		
		ponButton = new InputImage(
				TextureAssets
						.GetTextureRegionFromPacker(TextureAssets.PonButton),
				0, 0, this, MatchMusicType.Pon);
		cakaButton = new InputImage(
				TextureAssets
						.GetTextureRegionFromPacker(TextureAssets.CakaButton),
				0, 0, this, MatchMusicType.Chaka);

		
		pataButton.height = ponButton.height = cakaButton.height = height / 10;
		pataButton.width = ponButton.width = cakaButton.width = pataButton.height;

//		pataButton.setPosition(pataButton.width / 2, height - pataButton.height
//				* 2f);
//		ponButton.setPosition(ponButton.width / 2, pataButton.y
//				- pataButton.height * 5 / 4);
//		cakaButton.setPosition(cakaButton.width / 2, ponButton.y
//				- pataButton.height * 5 / 4);
//		
		pataButton.setPosition((float)(this.width-3.6*pataButton.width), 0f);
		ponButton.setPosition((float)(this.width-2.4*ponButton.width), 0f);
		cakaButton.setPosition((float)(this.width-1.2*cakaButton.width), 0f);
		cakaButton.hide();
		ponButton.hide();
		pataButton.hide();

	}
	public void showActor(){
		timerDialog.show(-1);
		pataButton.show();
		ponButton.show();
		cakaButton.show();
	}

	public void hideActor(){
		timerDialog.hide();
		pataButton.hide();
		ponButton.hide();
		cakaButton.hide();
	}
	public void initTimerDialog() {
		timerDialog = new TimerDialog("timerDialog", this);
		//timerDialog.show(-1);

		timerDialog.start(270);
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		this.startX = x;
		this.startY = y;
		this.soundDelta = this.minSoundDelta;
		float screen_x = x * w / width();
		float screen_y = h - y * h / height();
		this.particle.setPosition(x * w / width(), h - y * h / height());
		this.particle.start();
		this.coursePos.set(screen_x, screen_y);
		// this.texCourse = this.texClickDown;
	//	this.playClickSound();
	//	this.playTestSound();

		super.touchDown(x, y, pointer, button);
		
//		if(cakaButton.touchDown(x, y, pointer))
//			return false;
//		if(pataButton.touchDown(x, y, pointer))
//			return false;
//		if(ponButton.touchDown(x, y, pointer))
//			return false;
		//new NoteImage(1, 1, this);
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		this.particle.setPosition(-100, -100);
		this.particle.start();
		// this.texCourse = this.texClickNormal;
		super.touchUp(x, y, pointer, button);
		
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int keyType) {
		float screen_x = x * w / width();
		float screen_y = h - y * h / height();
		this.particle.setPosition(x * w / width(), h - y * h / height());
		this.particle.start();
		this.coursePos.set(screen_x, screen_y);
		if (isMoved(x, y)) {
			this.playSlipSound();
			this.startX = x;
			this.startY = y;
		}
		
		super.touchDragged(x, y, keyType);
		
		// this.texCourse = this.texDrag;
		return false;
	}

	private boolean isMoved(int x, int y) {
		return this.getDistance(this.startX, this.startY, x, y) > this.minDistance;
	}

	private float getDistance(float x1, float y1, float x2, float y2) {
		return (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	@Override
	public void draw() {
		float dt = Gdx.graphics.getDeltaTime();
		spriteBatch.begin();
		// this.spriteBatch.draw(texCourse, this.coursePos.x-2,
		// this.coursePos.y - 36);
		particle.draw(spriteBatch, dt);
		spriteBatch.end();
		this.soundDelta += dt;
		super.draw();
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
		this.height = height;
		this.width = width;

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.coursePos.set(this.width() * 2 / 3, this.height() / 2);

	}

	
	
	




}
