package game.minipatapon.effectpresent.action;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.ActionResetingPool;

public class RotateTo extends com.badlogic.gdx.scenes.scene2d.actions.RotateTo implements PathAction{
	
	private static final ActionResetingPool<RotateTo> pool = new ActionResetingPool<RotateTo>(4, 100) {
		@Override
		protected RotateTo newObject () {
			return new RotateTo();
		}
	};
	
	public static RotateTo $ (float rotation, float duration) {
		RotateTo action = pool.obtain();
		action.rotation = rotation;
		action.duration = duration;
		action.invDuration = 1 / duration;
		return action;
	}
	
	public static RotateTo $ (float rotation) {
		
		return RotateTo.$(rotation, 0);
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
	
	public void reSetTarget(Actor actor)
	{
		this.target = actor;
	}
	
	public void setTargetToEndState()
	{
		this.target.rotation = this.rotation;
		this.target.rotation = this.rotation;
	}
	
	public Action copy () {
		RotateTo rotateTo = $(rotation, duration);
		if (interpolator != null) rotateTo.setInterpolator(interpolator.copy());
		return rotateTo;
	}
}
