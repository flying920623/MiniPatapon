package game.minipatapon.effectpresent.action;

import com.badlogic.gdx.scenes.scene2d.Interpolator;
import game.minipatapon.logger.DefaultLogger;


public class EasingCurve implements Interpolator{

    EasingCurveType easingType;
    
    public EasingCurve(EasingCurveType easingType)
    {
    	this.easingType = easingType;
    }
	
	protected float  curveToFunc(EasingCurveType curveType, float t)
	{
		//if( curveType == EasingCurveType.Linear)
			
	    switch(curveType) {
	    case Linear:	    	
	        return Easing.easeNone (t);
	    case InQuad:
	    	return Easing.easeInQuad (t);
	    case OutQuad:
	    	return Easing.easeOutQuad (t);
	    case InOutQuad:
	    	return Easing.easeInOutQuad (t);
	    case OutInQuad:
	    	return Easing.easeOutInQuad (t);
	    case InCubic:
	    	return Easing.easeInCubic (t);
	    case OutCubic:
	    	return Easing.easeOutCubic (t);
	    case InOutCubic:
	    	return Easing.easeInOutCubic (t);
	    case OutInCubic:
	    	return Easing.easeOutInCubic (t);
	    case InQuart:
	    	return Easing.easeInQuart (t);
	    case OutQuart:
	    	return Easing.easeOutQuart (t);
	    case InOutQuart:
	    	return Easing.easeInOutQuart (t);
	    case OutInQuart:
	    	return Easing.easeOutInQuart (t);
	    case InQuint:
	    	return Easing.easeInQuint (t);
	    case OutQuint:
	    	return Easing.easeOutQuint (t);
	    case InOutQuint:
	    	return Easing.easeInOutQuint (t);
	    case OutInQuint:
	    	return Easing.easeOutInQuint (t);
	    case InSine:
	    	return Easing.easeInSine (t);
	    case OutSine:
	    	return Easing.easeOutSine (t);
	    case InOutSine:
	    	return Easing.easeInOutSine (t);
	    case OutInSine:
	    	return Easing.easeOutInSine (t);
	    case InExpo:
	    	return Easing.easeInExpo (t);
	    case OutExpo:
	    	return Easing.easeOutExpo (t);
	    case InOutExpo:
	    	return Easing.easeInOutExpo (t);
	    case OutInExpo:
	    	return Easing.easeOutInExpo (t);
	    case InCirc:
	    	return Easing.easeInCirc (t);
	    case OutCirc:
	    	return Easing.easeOutCirc (t);
	    case InOutCirc:
	    	return Easing.easeInOutCirc (t);
	    case OutInCirc:
	    	return Easing.easeOutInCirc (t);
	    // Internal for, compatibility with QTimeLine only ??
	    case InCurve:
	    	return Easing.easeInCurve (t);
	    case OutCurve:
	    	return Easing.easeOutCurve (t);
	    case SineCurve:
	    	return Easing.easeSineCurve (t);
	    case CosineCurve:
	    	return Easing.easeCosineCurve (t);
	    default:
	    	DefaultLogger.getDefaultLogger().logWithSignature(this, "%s 算式不存在", curveType.toString());
	    	return Easing.easeNone (t);
	    }
	}

	@Override
	public float getInterpolation(float input) {
		// TODO Auto-generated method stub
		
		float output = this.curveToFunc(this.easingType, input);
		
		//DefaultLogger.getDefaultLogger().log("input:%f, output:%f", input, output);
		
		return output;
	}

	@Override
	public void finished() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Interpolator copy() {
		// TODO Auto-generated method stub
		return null;
	}
}
