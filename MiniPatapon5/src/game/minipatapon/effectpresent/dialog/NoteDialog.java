package game.minipatapon.effectpresent.dialog;

import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Elastic;
import aurelienribon.tweenengine.equations.Quad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class NoteDialog extends Dialog{

	TweenManager manager = new TweenManager();
	
	public NoteDialog(String name, String text, float x, float y, Stage stage) {
		super(name, text, x, y, stage);
		// TODO Auto-generated constructor stub

	}
	public NoteDialog(String name, String text, TextureRegion region, float x, float y, Stage stage)
	{
		super(name, text, region, x, y, stage);
	}

	public void show(float time)
	{
		super.show(time+3);

		Timeline.createSequence()

				.push(Tween.set(this, ActorAccessor.OPACITY).target(0))
				.pushPause(3f)

				
				.push(Tween.to(this, ActorAccessor.OPACITY, time/4).target(1)
						.ease(Quad.OUT))
				.pushPause(time/2)
				.push(Tween.to(this, ActorAccessor.OPACITY, time/4).target(0)
						.ease(Quad.OUT))
				
				.pushPause(0.1f)
				.start(manager);
	}
	
	public void draw(SpriteBatch batch, float parentAlpha) {
		
		manager.update(Gdx.graphics.getDeltaTime());
		
		super.draw(batch, parentAlpha);
	
	}
	
}
