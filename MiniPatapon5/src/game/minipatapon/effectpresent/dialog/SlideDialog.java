package game.minipatapon.effectpresent.dialog;

import game.minipatapon.effectpresent.action.tween.ActorAccessor;
import game.minipatapon.effectpresent.spriter.SpriterObject;
import game.minipatapon.logger.DefaultLogger;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquation;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Back;
import aurelienribon.tweenengine.equations.Elastic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class SlideDialog extends Dialog {

	TweenManager manager = new TweenManager();

	public String currentText = "";

	public boolean drawText = false;

	Actor target;
	
	

	public SlideDialog(String name, String text, Actor target, Stage stage) {
		super(name, text, target.x, target.y, stage);
		// TODO Auto-generated constructor stub

	}
	
	public SlideDialog(String name, String text, Stage stage) {
		super(name, text, 0, 0, stage);
		// TODO Auto-generated constructor stub
	}
	
	public SlideDialog( String text, Actor target, Stage stage, float time)
	{
		this("", text, target, stage);
		
		show(target, time);
	}

	// public SlideDialog(String name, String text, Actor target, float width,
	// float height, Stage stage) {
	// this(name, text, target, stage);
	//
	// this.width = width;
	// this.height = height;
	// }

	public void show(float time) {

		//manager.killAll();
		super.show(time);

		
		
		Timeline.createSequence()

				.push(Tween.set(this, ActorAccessor.SCALE_XY).target(
						0, 0))
				.push(Tween.set(this, ActorAccessor.OPACITY).target(0))
				.pushPause(0.1f)

				.beginParallel()
				.setCallback(new TweenCallback() {

					@Override
					public void onEvent(int type, BaseTween<?> source) {
						// TODO Auto-generated method stub
						drawText = true;
					}

				})
				.push(Tween.to(this, ActorAccessor.OPACITY, 0).target(1))
				.push(Tween.to(this, ActorAccessor.SCALE_XY, showTime/4)
						.target(1, 1).ease(Elastic.OUT)).end()
				.pushPause(0.1f).start(manager);
		
		
	}

	public void show(Actor target, float time) {
		this.target = target;
		this.x = target.x;
		this.y = target.y;
		show(time);
		
		DefaultLogger.getDefaultLogger().logWithSignature(this, "%f, %f, %f, %s, %f", target.x, target.y,  time, String.valueOf(show), this.color.a);
	}

	public void hide() {

		//manager.killAll();
		
		drawText = false;
		
		Timeline.createSequence()

				.pushPause(0.1f)

				.beginParallel()
				.push(Tween.to(this, ActorAccessor.SCALE_XY, 1f).target(0, 0)
						.ease(Elastic.OUT)).end()
				.setCallback(new TweenCallback() {

					@Override
					public void onEvent(int type, BaseTween<?> source) {
						// TODO Auto-generated method stub
						show = false;
					}

				}).pushPause(0.1f).start(manager);
	}

	public boolean visible() {
		return show;

	}

	public void draw(SpriteBatch batch, float parentAlpha) {

		if (!show) {
			return;
		}

		if (showLimit) {
			timeElapse += Gdx.graphics.getDeltaTime();
			if (timeElapse > showTime) {
				hide();
			}

		}

		manager.update(Gdx.graphics.getDeltaTime());

		if (region.getTexture() != null) {
			batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
			if (scaleX == 1 && scaleY == 1 && rotation == 0)
				batch.draw(region, x, y, width, height);
			else
				batch.draw(region, x, y, originX, originY, width, height,
						scaleX, scaleY, rotation);
		}

		
		
		SpriterObject object = (SpriterObject) target;

		x = object.x + object.getWidth() / 2 - width / 2;
		y = object.y + object.getHeith() * 2 / 3;

		float fontY = y + height - paddingTop;
		float fontX = x + paddingLeft;

		if (currentText.length() != text.length() && drawText) {
			currentText += text.substring(currentText.length(),
					currentText.length() + 1);
			// DefaultLogger.getDefaultLogger().logWithSignature(this,
			// currentText);
		}
		
		if( !drawText )
			return;

		bitmapFont.drawWrapped(batch, currentText, fontX, fontY, width
				- paddingLeft - paddingRight, alignment);

	}

}
