package game.minipatapon.effectpresent.actor;

import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.util.MathHelper;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.TweenPaths;
import aurelienribon.tweenengine.equations.Back;
import aurelienribon.tweenengine.equations.Cubic;
import aurelienribon.tweenengine.equations.Quad;
import aurelienribon.tweenengine.equations.Quart;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PathViewGroup2 extends Group {

	private TweenManager tweenManager = new TweenManager();

	Stage stage = null;
	
	boolean initComplete = false;
	
	float childSpace = 20f;

	public PathViewGroup2(Stage stage) {
		super("");

		this.stage = stage;

		init();
	}

	public PathViewGroup2(Stage stage, Actor... actors) {
		super("");

		this.stage = stage;

		for (int i = 0; i < actors.length; i++) {
			this.addActor(actors[i]);
		}

		init();
	}

	public PathViewGroup2(String name, Stage stage) {
		super(name);

		this.stage = stage;

		init();
	}

	public PathViewGroup2(String name, Stage stage, Actor... actors) {
		super(name);

		this.stage = stage;

		for (int i = 0; i < actors.length; i++) {
			this.addActor(actors[i]);
		}

		init();
	}

	private void initZorder() {
		FlatImage image = null;
		for (int i = 0; i < children.size(); i++) {
			image = (FlatImage) children.get(i);
			image.setZorder(99 - i);
		}

		image.sortActor();
	}

	public void init() {

		initZorder();

		Tween.registerAccessor(Actor.class, new ActorAccessor());
		Tween.setWaypointsLimit(3);

		Actor lastActor = null;

		Vector2 controlPoint = new Vector2(0, stage.height());
		Vector2 startPoint = new Vector2(0, 0);
		Vector2 endPoint = new Vector2(stage.width() - 20f,
				stage.height() - 20f);
		
		float distance = 0f;
		
		float scaleWidth = 0f;

		for (int i = children.size() - 1; i >=0; i--) {
			Actor actor = children.get(i);
//			 if (lastActor == null) {
//				 lastActor = actor;
//			 } else {
//				 lastActor = children.get(i - 1);
//			 }
			
			

			Vector2 point = MathHelper.getQuadCurve(startPoint, controlPoint,
					endPoint, 0.5f);

			DefaultLogger.getDefaultLogger().logWithSignature(this,
					"quad curve: %s", point.toString());

			actor.x = 20;
			actor.y = 20;

			actor.width = 200f;
			actor.height = 200f;

			actor.originX = actor.width / 2;
			actor.originY = actor.height / 2;

			actor.color.a = 0f;
			
			float scale = -0.2f;
			
			scaleWidth = scaleWidth/2;

			distance += scaleWidth;
			
			if( scaleWidth ==0 )
			{
				scaleWidth = actor.width;
			}
			
			

			// Tween.to(actor, ActorAccessor.CPOS_XY, 3.0f)
			// .waypoint(stage.width()*4/6, stage.height()/2)
			// .waypoint(-1, -1)
			// .waypoint(2, 0)

			// .target(stage.width()-actor.width,
			// stage.height()-actor.height)
			// .ease(Quad.INOUT)
			// .path(TweenPaths.catmullRom)
			// .repeatYoyo(-1, 0.2f)
			// .delay(0.5f)
			// .start(tweenManager);

//			 Timeline
//			 .createSequence()
//			 .push(Tween.set(actor,
//			 ActorAccessor.POS_XY).target(stage.width()/2-actor.width*0.5f,
//			 stage.height()/2-actor.height*0.5f))
//			 .push(Tween.set(actor, ActorAccessor.SCALE_XY).target(2, 2))
//			
//			 .push(Tween.set(actor, ActorAccessor.ROTATION).target(0))
//			 .push(Tween.set(actor, ActorAccessor.OPACITY).target(1))
//			 .pushPause((float) (i+0.2))
//			 .beginParallel()
//			 .push(Tween.to(actor, ActorAccessor.OPACITY, 1.0f).target(1)
//			 .ease(Quart.INOUT))
//			 .push(Tween.to(actor, ActorAccessor.SCALE_XY, 1.0f)
//			 .target(1, 1).ease(Quart.INOUT))
//			 .end()
//			 .pushPause(-0.5f)
//			 .push(Tween.to(actor, ActorAccessor.POS_XY, 1.0f)
//			 .target(i*100, height-actor.height*0.5f)
//			 .ease(Back.OUT))
//			 .push(Tween.to(actor, ActorAccessor.ROTATION, 0.8f)
//			 .target(360).ease(Cubic.INOUT))
//			 .pushPause(2-i*0.2f)
//			 .beginParallel()
//			 .push(Tween.to(actor, ActorAccessor.SCALE_XY, 0.3f)
//			 .target(3, 3).ease(Quad.IN))
//			 .push(Tween.to(actor, ActorAccessor.OPACITY, 0.3f).target(0)
//			 .ease(Quad.IN))
//			 .end()
//			 .pushPause(0.1f)
//			 .start(tweenManager);
			
			Timeline timeline = Timeline.createSequence()
				.push(Tween.set(actor, ActorAccessor.POS_XY).target(stage.width()/2-actor.width/2, stage.height()/2-actor.height/2))
				.push(Tween.set(actor, ActorAccessor.OPACITY).target(0))
				.push(Tween.set(actor, ActorAccessor.SCALE_XY).target(3, 3))
			
			.delay(2f + i * 0.3f)
			.beginParallel()
			.push(Tween.to(actor, ActorAccessor.SCALE_XY, 1f).target(
					1f, 1f));
					
			if( i>children.size() - 4 )
			{
				timeline.push(Tween.to(actor, ActorAccessor.OPACITY, 1f).target(1f))
				.end()
				
				.beginParallel()
				.push(Tween.to(actor, ActorAccessor.POS_XY, (1f+0.1f*i)).targetRelative(
						distance  , 0))
						
				.push(Tween.to(actor, ActorAccessor.SCALE_XY, (1f+0.1f*i)).targetRelative(
						scale*(children.size()-i-1), scale*(children.size()-i-1)  ))
				.end();
			}
			
			
			timeline.start(tweenManager);
			
			
			
			
//			Timeline.createSequence()
//
//					.push(Tween.set(actor, ActorAccessor.POS_XY)
//							.targetRelative(0, 0))
//					.push(Tween.set(actor, ActorAccessor.SCALE_XY).target(3, 3))
//					.push(Tween.set(actor, ActorAccessor.OPACITY).target(0))
//					.delay(2f + i * 0.3f)
//
//					.beginParallel()
//					.push(Tween.to(actor, ActorAccessor.SCALE_XY, 1f).target(
//							1f, 1f))
//					.push(Tween.to(actor, ActorAccessor.OPACITY, 1f).target(1f))
//					.end()
//
//					.beginParallel()
//					.push(Tween
//							.to(actor, ActorAccessor.POS_XY, 2f)
//							.waypoint(stage.width() * 4 / 6, stage.height() / 2)
//							.target(stage.width() - actor.width - 20,
//									stage.height() - actor.height - 20)
//							.ease(Quad.INOUT))
//					.push(Tween.to(actor, ActorAccessor.SCALE_XY, 2f)
//							.target(0.5f, 0.5f).ease(Quad.INOUT)).end()
//
//					.start(tweenManager);

			//
			// actor.x = stage.width() / 2 - actor.width / 2;
			// actor.y = stage.height() / 2 - actor.height / 2;

			// Timeline.createSequence()
			// .push(Tween.set(actor, ActorAccessor.SCALE_XY).target(1, 1))
			// .push(Tween.set(actor, ActorAccessor.ROTATION).target(1))
			// .push(Tween.set(actor, ActorAccessor.OPACITY).target(0))
			//
			// .pushPause(2f + i * 0.2f)
			// .beginParallel()
			// .push(Tween.to(actor, ActorAccessor.OPACITY, 1.0f)
			// .target(1).ease(Quart.INOUT))
			// .push(Tween.to(actor, ActorAccessor.SCALE_XY, 1.0f)
			// .target(0.7f, 0.7f).ease(Quart.INOUT)).end()
			// .pushPause(0.5f).start(tweenManager);
		}

	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {

		if( children.get(0).color.a==1f )
		{
			this.initComplete = true;
		}
		
		tweenManager.update(Gdx.graphics.getDeltaTime());

		super.draw(batch, parentAlpha);
	}
}
