package game.minipatapon.effectpresent.spriter;


import game.minipatapon.effectpresent.spriter.action.MoveAction;

import game.minipatapon.effectpresent.spriter.util.SpriterDrawer;
import game.minipatapon.effectpresent.spriter.util.SpriterImporter;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.util.MathHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actors.Image;
import com.badlogic.gdx.utils.GdxRuntimeException;

/**
 * This class represents a spriter object with all its object parts and
 * animations. This object can be importer with the SpriterImporter and
 * afterwards manipulated manually or constructed on its own. Additionally its
 * possible to exchange the texture pathes on the fly. For example to switch the
 * weapon that is displayed. This class does not hold disposable objects i.e.
 * textures. For Drawing the Object, an instance of an SpriterDrawer should be
 * used.
 * 
 * @author cfinckle
 */
public class SpriterObject extends Actor {
	public static String moveAttack ="moveAttack";
	public static String throwAttack ="throwAttack";

	public float speed = 150f;

	public float initX = 0f;
	public float initY = 0f;

	// public float x = 0f;
	// public float y = 0f;

	// public float scaleX = 1f;
	// public float scaleY = 1f;

//	public float rotation = 0f;

	public float iniWidth = 0f;
	public float iniHeight = 0f;

	public Color color;

	public String currentAnimation;
	public String defaultAnimation;

	public String basePath;

	public TextureProvider textureProvider;

	protected float timeElapsed = 0f;

	public boolean repeatAnimation = true;

	public boolean doTweening = true;
	
	public boolean dead = false;

	protected TweenManager tweenManager = new TweenManager();

	private Map<String, SpriterObjectPart> objectParts;
	private Map<String, SpriterAnimation> animations;

	public SpriterSprite weapon = new SpriterSprite();

	public boolean attack = false;

	public Rectangle weaponRec = new Rectangle();
	
	public String attackModeStr = null;



	public SpriterObject(String name, String initAnimation) {
		super(name);

		this.objectParts = new HashMap<String, SpriterObjectPart>();
		this.animations = new HashMap<String, SpriterAnimation>();

		defaultAnimation = currentAnimation = initAnimation;
	}

	public SpriterObject(String initAnimation) {
		this("", initAnimation);
	}

	public Map<String, SpriterObjectPart> getObjectParts() {
		return Collections.unmodifiableMap(objectParts);

	}

	public void addObjectPart(SpriterObjectPart objectPart) {
		this.objectParts.put(objectPart.textureName, objectPart);
	}

	public Map<String, SpriterAnimation> getAnimations() {
		return Collections.unmodifiableMap(animations);
	}

	public void addAnimation(SpriterAnimation animation) {
		this.animations.put(animation.name, animation);
	}

	public void getAllTextures() {
		for (SpriterObjectPart spriterObjectPart : objectParts.values()) {
			textureProvider.getTexture(this.basePath
					+ spriterObjectPart.textureName);
		}
	}

	public void disposeAllTextures() {
		for (SpriterObjectPart spriterObjectPart : objectParts.values()) {
			textureProvider.disposeTexture(this.basePath
					+ spriterObjectPart.textureName);
		}
	}

	public void disposeAllRegions() {
		for (SpriterObjectPart spriterObjectPart : objectParts.values()) {
			textureProvider.disposeTextureRegion(this.basePath
					+ spriterObjectPart.textureName);
		}
	}

	@Override
	public String toString() {
		return "SpriterObject [objectParts=" + objectParts + ", animations="
				+ animations + "]";
	}

	public void action(Timeline timeline) {

		tweenManager.killAll();

		timeline.start(tweenManager);
	}

	// private void calculateOrinSize() {
	//
	// List<SpriterAnimationFrame> frames = getAnimations().get(
	// currentAnimation).getFrames();
	// for (int i = 0; i < frames.size(); i++) {
	// if (i == 0) {
	// SpriterFrame frame = frames.get(0).frame;
	// for (int k = 0; k < frame.sprites.size(); k++) {
	// SpriterSprite sprite = frame.sprites.get(k);
	// if (k == 0) {
	// initX = sprite.x - sprite.objectPart.originX / 2;
	// initY = sprite.y + sprite.objectPart.originY / 2;
	// } else {
	// if (sprite.x - sprite.objectPart.originX < initX)
	// initX = sprite.x - sprite.objectPart.originX;
	// if (sprite.y + sprite.objectPart.originY > initY)
	// initY = sprite.y + sprite.objectPart.originY;
	// }
	// }
	//
	// // DefaultLogger.getDefaultLogger().log("%s :x %f, y %f",
	// // file.name(), spriterObject.initX, spriterObject.initY);
	// }
	// }
	// }

	public Rectangle rect() {
		return new Rectangle(x, y, getWidth(), getHeith());
	}

	public float getWidth() {
		return iniWidth * scaleX;
	}

	public float getHeith() {
		return iniHeight * scaleY;
	}

	
	public void simpleMove(String aniName,float distance) {

		if (aniName != null) {
			currentAnimation = aniName;
		} else {
			currentAnimation = "move";
		}
		
		action(MoveAction.simpleMove(this, distance));

	}
	public void repeatMove(String aniName,float distance) {

		if (aniName != null) {
			currentAnimation = aniName;
		} else {
			currentAnimation = "move";
		}
		action(MoveAction.repeatMove(this, distance, 100));

	}

	public void defense(String aniName, float distance) {

		if (aniName != null) {
			currentAnimation = aniName;
		} else {
			currentAnimation = "defense";
		}
        action(MoveAction.defense(this, distance));

	}


	public void attack(String aniName, SpriterObject enemy) {
		
		if(attackModeStr =="moveAttack")
			action(MoveAction.moveAttack(this, enemy));
		else {
			action(MoveAction.throwAttack(this, enemy));
		}
		if (aniName != null) {
			currentAnimation = aniName;
		} else {
			currentAnimation = "attack";
		}

	}

	public void jump(String aniName, float height) {
		if (aniName != null) {
			currentAnimation = aniName;
		} else {
			currentAnimation = "jump";
		}
		action(MoveAction.jump(this, height));



	}

	public void motionless(String aniName) {
		if (aniName != null) {
			currentAnimation = aniName;
		} else {
			currentAnimation = "movetionless";
		}



	}

	public void stop(String aniName) {
		if (aniName != null) {
			currentAnimation = aniName;
		} else {
			currentAnimation = "stop";
		}
        MoveAction.stop(this);
	}


	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub

		// DefaultLogger.getDefaultLogger().logWithSignature(this,"%s",
		// enemies.toString());

		
		
		timeElapsed += Gdx.graphics.getDeltaTime();

		tweenManager.update(Gdx.graphics.getDeltaTime());

		float keyTime = speed * timeElapsed;

		SpriterAnimation spriterAnimation = getAnimations().get(
				currentAnimation);
		if (spriterAnimation == null) {
			spriterAnimation = getAnimations().get(defaultAnimation);
//			DefaultLogger.getDefaultLogger().logWithSignature(
//					this,
//					"The given animationname:" + currentAnimation
//							+ " does not exist in the animation");
		}

		if (keyTime > spriterAnimation.animationLength && repeatAnimation) {
			keyTime = keyTime % spriterAnimation.animationLength;
		}

		// calculate current animation and the next frame depending on the
		// current time
		List<SpriterAnimationFrame> frames = spriterAnimation.getFrames();
		SpriterAnimationFrame currentFrame = null;
		SpriterAnimationFrame nextFrame = null;
		float curTime = 0;
		float tweenFactor = 0;
		for (int i = 0; i < frames.size(); i++) {
			SpriterAnimationFrame animationFrame = frames.get(i);

			if (curTime <= keyTime
					&& curTime + animationFrame.duration > keyTime) {
				currentFrame = animationFrame;
				if (i < frames.size() - 1) {
					nextFrame = frames.get(i + 1);
				} else {
					nextFrame = animationFrame;
				}
				tweenFactor = (keyTime - curTime) / (animationFrame.duration);
				break;
			}
			curTime += animationFrame.duration;
		}
		if (currentFrame == null) {
			currentFrame = frames.get(frames.size() - 1);
			nextFrame = frames.get(frames.size() - 1);
		}

		// iterate through all sprites and draw them
		List<SpriterSprite> sprites1 = currentFrame.frame.getSprites();
		for (int i = 0; i < sprites1.size(); i++) {
			SpriterSprite sprite1 = sprites1.get(i);

			final SpriterSprite tweenedSprite = new SpriterSprite();
			// perform tweening, if sprite occurs in next frame too
			SpriterSprite sprite2 = nextFrame.frame
					.getSpriteByObjectPart(sprite1.objectPart);
			if (!doTweening || sprite2 == null) {// no tweening possible
				tweenedSprite.setValues(sprite1);
			} else {
				tweenedSprite.setTweenedValues(sprite1, sprite2, tweenFactor);
			}

			Rectangle rectangle = MathHelper.spriterToGdx(tweenedSprite, this);

			if (sprite1.objectPart.name.endsWith("weapon")) {
				weapon.setValues(tweenedSprite);

				// DefaultLogger.getDefaultLogger().logWithSignature(this,
				// rectangle.toString());
			}

			// tweenedSprite.x = tweenedSprite.x /*-
			// sprite1.objectPart.originX*/
			// + 1 / scaleX * x;
			// tweenedSprite.y = tweenedSprite.y - tweenedSprite.height /*-
			// sprite1.objectPart.originY*/
			// + 1 / scaleY * y;
			//
			// float endX = ((int) tweenedSprite.x
			// - tweenedSprite.objectPart.originX - initX);
			// float endY = ((int) tweenedSprite.y
			// + tweenedSprite.objectPart.originY + initY);

			batch.setColor(tweenedSprite.colorRed, tweenedSprite.colorGreen,
					tweenedSprite.colorBlue, tweenedSprite.opacity);

			if (SpriterDrawer.drawerProvider != null) {
				SpriterDrawer.drawerProvider.draw(batch, this, tweenedSprite);
				continue;
			}

			if (scaleX == 1 && scaleY == 1 && rotation == 0) {
				batch.draw(
						textureProvider.getTextureRegion(basePath
								+ tweenedSprite.objectPart.textureName),
						(int) tweenedSprite.x
								- tweenedSprite.objectPart.originX - initX,
						(int) tweenedSprite.y
								+ tweenedSprite.objectPart.originY + initY,
						tweenedSprite.objectPart.originX,
						(int) tweenedSprite.height
								- tweenedSprite.objectPart.originY,
						(int) tweenedSprite.width, tweenedSprite.height, 1f,
						1f, tweenedSprite.angle);
			} else {

				Matrix4 originMatrix4 = new Matrix4(batch.getProjectionMatrix());

				Matrix4 matrix4 = new Matrix4(originMatrix4);
				matrix4.scale(scaleX, scaleY, 1);
				batch.setProjectionMatrix(matrix4);

				batch.draw(
						textureProvider.getTextureRegion(basePath
								+ tweenedSprite.objectPart.textureName),
						rectangle.x, rectangle.y,
						tweenedSprite.objectPart.originX,
						(int) tweenedSprite.height
								- tweenedSprite.objectPart.originY,
						(int) tweenedSprite.width, tweenedSprite.height, 1f,
						1f, tweenedSprite.angle);

				batch.setProjectionMatrix(originMatrix4);
			}
		}

		batch.setColor(1, 1, 1, 1);

	}

	public Rectangle getWeaponRec() {
		Rectangle rectangle = new Rectangle();

		if (weapon == null)
			return rectangle;

		rectangle.x = weapon.x + scaleX * x;
		rectangle.y = weapon.y - weapon.height + scaleY * y;

		rectangle.x = rectangle.x - weapon.objectPart.originX - initX;
		rectangle.y = rectangle.y + weapon.objectPart.originY + initY;

		rectangle.width = weapon.width;
		rectangle.height = weapon.height;

		return rectangle;
	}

	public static void spriterToGdxCoordinate(SpriterSprite sprite) {
		sprite.y = -sprite.y;
	}

	public static SpriterObject initSpriterObject(String objectName,
			String filename, String iniAni, float x, float y, float scaleX,
			float scaleY, Stage stage, String attackMode) {

		SpriterObject object = null;
		

		try {
			object = SpriterImporter
					.importFile(
							objectName,
							Gdx.files.internal("data/images/AnimationActor/"
									+ filename), iniAni);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		object.x = x;
		object.y = y;
		object.attackModeStr=attackMode;
		if (scaleX == 1 && scaleY == 1) {
			object.scaleX = Gdx.graphics.getWidth() / 13 / object.iniWidth;
			object.scaleY = object.scaleX;
		} else {
			object.scaleX = scaleX;
			object.scaleY = scaleY;
		}

		object.width = object.iniWidth * scaleX;
		object.height = object.iniHeight * scaleY;

	//	object.setActionListener(actionListener);

		stage.addActor(object);
		return object;
	}

	public void setCurrentState(Timeline action, String animation) {
		this.action(action);
		this.currentAnimation = animation;
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
