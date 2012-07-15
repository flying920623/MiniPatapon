package game.minipatapon.effectpresent.widget;

import java.util.ArrayList;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Quad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.event.music.MatchMusicLevel;
import game.minipatapon.event.music.MatchMusicType;
import game.minipatapon.logger.DefaultLogger;

public class NoteImage extends Actor {

	TweenManager manager = new TweenManager();

	TextureRegion region;
	MatchMusicType commandType;
	MatchMusicLevel fitDegree;

	float showTime = 1f;
	
	boolean show = true;

	public NoteImage(MatchMusicType commandType, MatchMusicLevel fitDegree, Stage stage) {
		this.commandType = commandType;
		this.fitDegree = fitDegree;

		initRegion();
		initSize();
		initPosition();
		initRotation();
		initAlpha();
		initAnimation();
		//DefaultLogger.getDefaultLogger().log(" OK");
		stage.addActor(this);
	}

	public void initRegion() {
//		ArrayList<String> strings = TextureAssets.Note;
//		strings.get(1).concat(String.valueOf(commandType));
//
//		region = TextureAssets
//				.GetTextureRegionFromPacker(TextureAssets.GameName1Img);
		if( commandType==MatchMusicType.Pata )
		{
			region = ResourceLoader.getRegionFromPacker(TextureAssets.PataNote);
			this.x=Gdx.graphics.getWidth()/10;
			this.y=MathUtils.random(Gdx.graphics.getHeight() / 3,
					Gdx.graphics.getHeight() / 1.3f);
		}
		else if( commandType==MatchMusicType.Pon )
		{
			region = ResourceLoader.getRegionFromPacker(TextureAssets.PonNote);
			this.x=9*Gdx.graphics.getWidth()/10;
			this.y=MathUtils.random(Gdx.graphics.getHeight() / 3,
					Gdx.graphics.getHeight() / 1.3f);
		}
		else if (commandType==MatchMusicType.Chaka) {
			region = ResourceLoader.getRegionFromPacker(TextureAssets.ChakeNote);
			this.x=MathUtils.random(Gdx.graphics.getWidth() / 3,
					Gdx.graphics.getWidth() / 1.3f);;
			this.y=9*Gdx.graphics.getHeight()/10;
		}
	}

	public void initSize() {
		this.width = Gdx.graphics.getWidth() / 14;
		this.height = width / region.getRegionWidth()
				* region.getRegionHeight();
	}

	public void initPosition() {
		///this.x = MathUtils.random(Gdx.graphics.getWidth() / 3f,
//				Gdx.graphics.getHeight()* 2 / 3f);
		//this.y = MathUtils.random(Gdx.graphics.getHeight() / 3,
//				Gdx.graphics.getHeight() / 1.3f);
	}

	public void initRotation() {
		float r = MathUtils.random(0f, 60f);
		this.rotation = r -30;
	}

	public void initAlpha() {
		if(this.fitDegree==MatchMusicLevel.Perfect)
		this.color.a = 1f;
		if(this.fitDegree==MatchMusicLevel.Fit)
			this.color.a = 0.5f;
		if(this.fitDegree==MatchMusicLevel.Miss)
			this.color.a=0f;
	}

	public void initAnimation() {
		
		Timeline.createSequence()
				.push(Tween.set(this, ActorAccessor.OPACITY).target(0))
				.pushPause(0.1f)

				.push(Tween.to(this, ActorAccessor.OPACITY, showTime / 5)
						.target(color.a).ease(Quad.IN))
				.pushPause(showTime *3/5)
				
				.beginParallel()
				.push(Tween.to(this, ActorAccessor.SCALE_XY, showTime / 5)
						.targetRelative(0.7f, 0.7f))				
				.push(Tween.to(this, ActorAccessor.OPACITY, showTime / 5)
						.target(0).ease(Quad.OUT))

				.pushPause(0.1f)
				.end()
				
				.setCallback( new TweenCallback(){

					@Override
					public void onEvent(int type, BaseTween<?> source) {
						// TODO Auto-generated method stub
						
						show = false;
					}
					
				})
				.start(manager);
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub

		if( !show )
			return;
		
		manager.update(Gdx.graphics.getDeltaTime());

		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		if (scaleX == 1 && scaleY == 1 && rotation == 0)
			batch.draw(region, x, y, width, height);
		else
			batch.draw(region, x, y, originX, originY, width, height, scaleX,
					scaleY, rotation);
	}

	@Override
	public boolean touchDown(float x, float y, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void touchUp(float x, float y, int pointer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void touchDragged(float x, float y, int pointer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Actor hit(float x, float y) {
		// TODO Auto-generated method stub
		return null;
	}

}
