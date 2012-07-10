package game.minipatapon.effectpresent.action;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.ActionResetingPool;
import game.minipatapon.util.MathHelper;

public class MoveTo extends com.badlogic.gdx.scenes.scene2d.actions.MoveTo
		implements PathAction {

	private static final ActionResetingPool<MoveTo> pool = new ActionResetingPool<MoveTo>(
			4, 100) {
		@Override
		protected MoveTo newObject() {
			return new MoveTo();
		}
	};

	public float duration() {
		return this.duration;
	}

	// setDuration只能在给 actor 调用 action() 函数之前 设置。
	public void setDuration(float duration) {
		this.duration = duration;
		this.invDuration = 1/this.duration;
	}

	public float deltaX() {
		return this.deltaX;
	}

	public float deltaY() {
		return this.deltaY;
	}

	public float deltaDistance() {
		deltaX = x - startX;
		deltaY = y - startY;

		return MathHelper.getDistance(deltaX, deltaY);
	}

	public void setStartPoint(float startX, float startY) {
		this.startX = startX;
		this.startY = startY;
	}

	public float x() {
		return x;
	}

	public float y() {
		return y;
	}

	public float startX() {
		return startX;
	}

	public float startY() {
		return startY;
	}

	public static MoveTo $(float x, float y, float duration) {
		MoveTo action = pool.obtain();
		action.x = x;
		action.y = y;
		action.duration = duration;
		action.invDuration = 1 / duration;
		return action;
	}

	public static MoveTo $(float x, float y) {
		return MoveTo.$(x, y, 0f);
	}
	
	public void reSetTarget(Actor actor)
	{
		this.target = actor;
	}
	
	public void setTargetToEndState()
	{
		this.target.x = this.x;
		this.target.y = this.y;
	}
}
