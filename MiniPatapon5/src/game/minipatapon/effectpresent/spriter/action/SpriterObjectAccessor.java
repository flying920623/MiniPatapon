package game.minipatapon.effectpresent.spriter.action;

import com.badlogic.gdx.graphics.Color;

import game.minipatapon.effectpresent.spriter.SpriterObject;
import aurelienribon.tweenengine.TweenAccessor;


public class SpriterObjectAccessor implements TweenAccessor<SpriterObject>{

	public static final int POS_XY = 1;
	public static final int CPOS_XY = 2;
	public static final int SCALE_XY = 3;
	public static final int ROTATION = 4;
	public static final int OPACITY = 5;
	public static final int TINT = 6;
	
	@Override
	public int getValues(SpriterObject target, int tweenType,
			float[] returnValues) {
		// TODO Auto-generated method stub
		switch (tweenType) {
		case POS_XY:
			returnValues[0] = target.x;
			returnValues[1] = target.y;
			
			return 2;

		case CPOS_XY:
			returnValues[0] = target.x + target.iniWidth / 2;
			returnValues[1] = target.x + target.iniHeight / 2;
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

		default:
			assert false;
			return -1;
		}
	}

	@Override
	public void setValues(SpriterObject target, int tweenType, float[] newValues) {
		// TODO Auto-generated method stub
		switch (tweenType) {
		case POS_XY:
			target.x = newValues[0];
			target.y = newValues[1];

			break;
		case CPOS_XY:
			target.x = newValues[0] - target.iniWidth / 2;
			target.y = newValues[1] - target.iniHeight / 2;

			break;
		case SCALE_XY:
			target.scaleX = newValues[0];
			target.scaleY = newValues[1];
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

		default:
			assert false;
		}
	}

}
