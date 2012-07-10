package game.minipatapon.effectpresent.spriter.action;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.effectpresent.spriter.SpriterObject;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.stage.midground.GameStage;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.equations.Back;
import aurelienribon.tweenengine.equations.Quad;

public class MoveAction {

	static float JumpHeight = Gdx.graphics.getHeight()/10;
	
	public static Timeline simpleMove(SpriterObject spriterObject,float distance) {
		Tween tween = null;

		float time = MathUtils.random(1.7f, 2);
		
		tween = Tween.to(spriterObject, SpriterObjectAccessor.POS_XY, time)
				.targetRelative(distance, 0);
		tween.setCallback(new TweenCallback() {

			@Override
			public void onEvent(int type, BaseTween<?> source) {
				// TODO Auto-generated method stub
				DefaultLogger.getDefaultLogger().logWithSignature(this,
						"animation end");
			}

		});
		return Timeline.createSequence().push(tween);
	}

	public static Timeline repeatMove(SpriterObject spriterObject,float distance, int repeat) {
		Tween tween = null;

		tween = Tween.to(spriterObject, SpriterObjectAccessor.POS_XY, 1f)
				.targetRelative(distance, 0)
				.repeatYoyo(repeat, 0.3f);

		return Timeline.createSequence().push(tween);
	}

	public static Timeline moveAttack(final SpriterObject spriterObject, SpriterObject enemy) {
		Tween tween = null;
		
		tween = Tween.to(spriterObject, ActorAccessor.POS_XY, 0.9f)
				.target(enemy.x , GameStage.blackGroundHeight)
				.repeatYoyo(1, 0.2f)
				.setCallback(new TweenCallback() {
					
					@Override
					public void onEvent(int type, BaseTween<?> source) {
						// TODO Auto-generated method stub
						spriterObject.currentAnimation = "move";
					}
				});
		
		return Timeline.createSequence().push(tween);
	}

	public static Timeline throwAttack(final SpriterObject spriterObject, SpriterObject enemy) {
		Timeline timeline = null;
		
		timeline = 
				Timeline.createSequence()
				
				.push(Tween.to(spriterObject, SpriterObjectAccessor.POS_XY, 0.9f)
				.targetRelative(0, JumpHeight).ease(Quad.OUT)
				
				.setCallback(new TweenCallback() {
					
					@Override
					public void onEvent(int type, BaseTween<?> source) {
						// TODO Auto-generated method stub
						spriterObject.currentAnimation = "attack";
					}
				}))
				
				.push(Tween.to(spriterObject, SpriterObjectAccessor.POS_XY, 0.9f).targetRelative(0, -JumpHeight)
				.setCallback(new TweenCallback() {
					
					@Override
					public void onEvent(int type, BaseTween<?> source) {
						// TODO Auto-generated method stub
						spriterObject.currentAnimation = "move";
					}
				}));
		
				
		return timeline;
	}

	public static Timeline defense(final SpriterObject spriterObject,float distance) {
		Timeline timeline = Timeline.createSequence()
				.push(Tween.to(spriterObject, ActorAccessor.POS_XY, 0.7f).targetRelative(distance, 0)
						.setCallback(new TweenCallback() {
							
							@Override
							public void onEvent(int type, BaseTween<?> source) {
								// TODO Auto-generated method stub
								spriterObject.currentAnimation = "defense";
								spriterObject.repeatAnimation = false;
							}
						}))
				.pushPause(0.6f).setCallback(new TweenCallback() {
					
					@Override
					public void onEvent(int type, BaseTween<?> source) {
						// TODO Auto-generated method stub
						spriterObject.currentAnimation = "move";
						spriterObject.repeatAnimation = true;
					}
				})
				.push(Tween.to(spriterObject, ActorAccessor.POS_XY, 0.7f).targetRelative(-distance, 0)) ;
		
		return timeline;
	}
	
	public static Timeline jump(SpriterObject spriterObject,float height)
	{
		Tween tween = null;
		tween = Tween.to(spriterObject, SpriterObjectAccessor.POS_XY, 0.5f)
				.targetRelative(0, height).ease(Quad.OUT)
				.repeatYoyo(1, 0.1f);
		
		return Timeline.createSequence().push(tween);
	}
	
	public static Timeline stop(SpriterObject spriterObject) {
		Tween tween = null;
		return Timeline.createSequence().push(tween);
	}

	
}
