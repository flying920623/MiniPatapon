package game.minipatapon.effectpresent.action.tween;

import com.badlogic.gdx.graphics.Color;

import game.minipatapon.effectpresent.background.PLParallaxLayer;
import aurelienribon.tweenengine.TweenAccessor;


public class PLParallaxLayerAccessor implements TweenAccessor<PLParallaxLayer> {
	public static final int SCALE_XY = 1;

	@Override
	public int getValues(PLParallaxLayer target, int tweenType, float[] returnValues) {
		// TODO Auto-generated method stub
		
		switch (tweenType) {

		case SCALE_XY:
			returnValues[0] = target.scale.x;
			returnValues[1] = target.scale.y;
			return 2;

		default:
			assert false;
			return -1;
		}
		
	}

	@Override
	public void setValues(PLParallaxLayer target, int tweenType, float[] newValues) {
		// TODO Auto-generated method stub
		
		switch (tweenType) {

		case SCALE_XY:
			target.scale.x = newValues[0];
			target.scale.y = newValues[1];
			break;
	
		default:
			assert false;
		}
		
	}
	
	
	
}
