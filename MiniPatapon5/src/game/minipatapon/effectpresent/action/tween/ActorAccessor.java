package game.minipatapon.effectpresent.action.tween;


import game.minipatapon.logger.DefaultLogger;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;

import aurelienribon.tweenengine.TweenAccessor;

public class ActorAccessor implements TweenAccessor<Actor> {

	public static final int POS_XY = 1;
	public static final int CPOS_XY = 2;
	public static final int SCALE_XY = 3;
	public static final int ROTATION = 4;
	public static final int OPACITY = 5;
	public static final int TINT = 6;
	public static final int SIZE = 7;

	@Override
	public int getValues(Actor target, int tweenType, float[] returnValues) {
		//DefaultLogger.getDefaultLogger().logWithSignature(this, "%d", tweenType);
		switch (tweenType) {
		case POS_XY:
			returnValues[0] = target.x;
			returnValues[1] = target.y;
			
			return 2;

		case CPOS_XY:
			returnValues[0] = target.x + target.width / 2;
			returnValues[1] = target.x + target.height / 2;
			return 2;

		case SCALE_XY:
			returnValues[0] = target.scaleX;
			returnValues[1] = target.scaleY;
			return 2;

		case ROTATION:
			returnValues[0] = target.rotation;
			return 1;
		case OPACITY:
			returnValues[0] = target.color.a;
			return 1;

		case TINT:
			returnValues[0] = target.color.r;
			returnValues[1] = target.color.g;
			returnValues[2] = target.color.b;
			return 3;
		case SIZE:
			returnValues[0] = target.width;
			returnValues[1] = target.height;
			return 2;

		default:
			assert false;
			return -1;
		}
	}

	@Override
	public void setValues(Actor target, int tweenType, float[] newValues) {
		//DefaultLogger.getDefaultLogger().logWithSignature(this, "%d, %f", tweenType, newValues[0]);
		switch (tweenType) {
		case POS_XY:
			target.x = newValues[0];
			target.y = newValues[1];
//			DefaultLogger.getDefaultLogger().logWithSignature(this, "%s:  %f, %f", target.name, newValues[0], newValues[1]);

			break;
		case CPOS_XY:
			target.x = newValues[0] - target.width / 2;
			target.y = newValues[1] - target.height / 2;

			break;
		case SCALE_XY:
			target.scaleX = newValues[0];
			target.scaleY = newValues[1];
//			DefaultLogger.getDefaultLogger().logWithSignature(this, "%s:  %f, %f", target.name, target.scaleX, target.scaleY);
			break;
		case ROTATION:
			target.rotation = newValues[0];

			break;

		case OPACITY:
			Color c = target.color;
			c.set(c.r, c.g, c.b, newValues[0]);
			target.color.set(c);
			break;

		case TINT:
			c = target.color;
			c.set(newValues[0], newValues[1], newValues[2], c.a);

			target.color.set(c);
			break;
		case SIZE:
			target.width = newValues[0];
			target.height = newValues[1];

		default:
			assert false;
		}
	}

}
