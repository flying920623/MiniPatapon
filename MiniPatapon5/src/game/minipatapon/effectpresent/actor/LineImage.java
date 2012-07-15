package game.minipatapon.effectpresent.actor;

import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.stage.midground.GameStage;
import game.minipatapon.util.MathHelper;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class LineImage extends FlatImage {

	TweenManager manager = new TweenManager();
	
	Timeline timeline = null;

	public LineImage(Stage stage) {

		this("", stage);

		init();
	}

	public LineImage(String name, TextureRegion region, Stage stage) {
		super(name, region, 0, 0, stage);
		// TODO Auto-generated constructor stub
		init();
	}
	
	public LineImage(String name, Stage stage) {
		super(name, new TextureRegion(ResourceLoader.getTexture(TextureAssets.WindLineImg)), 0, 0, stage);
		// TODO Auto-generated constructor stub
		init();
	}

	public void init() {

		timeline = createTimeline();
		timeline.start(manager);
	}

	public Timeline createTimeline() {
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
//		GameStage gameStage = (GameStage) stage;

		Stage gameStage = stage;
		
//		float cameraX = gameStage.getGameCamera().position.x;
		float cameraX = gameStage.width()/2;
		float startX = cameraX + stage.width() / 2;
		float startY = MathUtils.random(gameStage.height() * 2 / 3,
				gameStage.height() / 3);
		float endY = MathUtils.random(gameStage.height() * 2 / 3,
				gameStage.height() / 3);
		float endX= MathUtils.random(cameraX-gameStage.width()/2, cameraX);
		
		float randomLifeTime = MathUtils.random(2f, 2.5f);
		float randomPauseTime = MathUtils.random(0.5f, 2f);
		
		float scale = MathUtils.random(stage.width()/region.getRegionWidth()/2, 1);

		
		//rotation = MathHelper.angleOfPoints(startX, startY, endX, endY)*360;
		
		//Tween.setWaypointsLimit(1);
		
		Timeline timeline = Timeline.createSequence()

		.push(Tween.set(this, ActorAccessor.OPACITY).target(0))
		.push(Tween.set(this, ActorAccessor.POS_XY).target(
				startX, startY))
		.push(Tween.set(this, ActorAccessor.SCALE_XY).target(scale, 1))
						
		.pushPause(randomPauseTime)
		
		.beginParallel()
		
		.beginSequence()
		.push(Tween.to(this, ActorAccessor.OPACITY,randomLifeTime/2).target(0.7f))
		.push(Tween.to(this, ActorAccessor.OPACITY,randomLifeTime/2).target(0))
		.end()
		
		.push(Tween.to(this, ActorAccessor.POS_XY, randomLifeTime)
				.target(endX, endY)
				)
		
		.end()		
		;

		return timeline;
	}

	public void draw(SpriteBatch batch, float parentAlpha) {

		manager.update(Gdx.graphics.getDeltaTime());

		if(  timeline!=null && timeline.isFinished() )
		{
			manager.killAll();
			timeline = createTimeline();
			timeline.start(manager);
		}
		
		super.draw(batch, parentAlpha);
	}
}
