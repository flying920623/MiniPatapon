package game.minipatapon.effectpresent.action;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.ActionResetingPool;

public class ScaleTo extends  com.badlogic.gdx.scenes.scene2d.actions.ScaleTo implements PathAction{
	
	private static final ActionResetingPool<ScaleTo> pool = new ActionResetingPool<ScaleTo>(4, 100) {
		@Override
		protected ScaleTo newObject () {
			return new ScaleTo();
		}
	};
	
	public static ScaleTo $ (float scaleX, float scaleY, float duration) {
		ScaleTo action = pool.obtain();
		action.scaleX = scaleX;
		action.scaleY = scaleY;
		action.duration = duration;
		action.invDuration = 1 / duration;
		return action;
	}
	
	public float duration()
	{
		return this.duration;
	}
	
	public void setDuration(float duration)
	{
		this.duration = duration;
		this.invDuration = 1/this.duration;
	}
	
	public static ScaleTo $(float scaleX, float scaleY)
	{
		return ScaleTo.$(scaleX, scaleY, 0f);
	}
	
	public void reSetTarget(Actor actor)
	{
		this.target = actor;
	}
	
	public void setTargetToEndState()
	{
		this.target.scaleX = this.scaleX;
		this.target.scaleY = this.scaleY;
	}

	public Action copy () {
		ScaleTo scaleTo = $(scaleX, scaleY, duration);
		if (interpolator != null) scaleTo.setInterpolator(interpolator.copy());
		return scaleTo;
	}
}
