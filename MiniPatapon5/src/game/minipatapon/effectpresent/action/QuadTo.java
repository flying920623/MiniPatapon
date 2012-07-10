package game.minipatapon.effectpresent.action;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.ActionResetingPool;
import game.minipatapon.util.MathHelper;

public class QuadTo extends MoveTo implements PathAction{

	private static final ActionResetingPool<QuadTo> pool = new ActionResetingPool<QuadTo>(4, 100) {
		@Override
		protected QuadTo newObject () {
			return new QuadTo();
		}
	};


	protected float controlX;
	protected float controlY;


	public static QuadTo $ (float x, float y, float controlX, float controlY, float duration) {
		QuadTo action = pool.obtain();
		action.x = x;
		action.y = y;
		action.controlX = controlX;
		action.controlY = controlY;
		action.duration = duration;
		action.invDuration = 1 / duration;
		return action;
	}
	
	public static QuadTo $(Vector2 point, Vector2 controlPoint, float duration)
	{
		return QuadTo.$(point.x, point.y, controlPoint.x, controlPoint.y, duration);
	}
	
	public static QuadTo $ (float x, float y, float controlX, float controlY) {
		return QuadTo.$(x, y, controlX, controlY, 0);
	}

	@Override
	public void setTarget (Actor actor) {
		this.target = actor;
		this.startX = target.x;
		this.startY = target.y;
		this.deltaX = x - target.x;
		this.deltaY = y - target.y;
		this.taken = 0;
		this.done = false;
	}

	@Override
	public void act (float delta) {
		float alpha = createInterpolatedAlpha(delta);
		if (done) {
			target.x = x;
			target.y = y;
		} else {
			
			Vector2 vector = MathHelper.getQuadCurve(new Vector2(startX, startY), 
					new Vector2(controlX, controlY), new Vector2(x, y), alpha);
			
			target.x = vector.x;
			target.y = vector.y;
		}
	}

	@Override
	public void finish () {
		super.finish();
		pool.free(this);
	}

	@Override
	public Action copy () {
		QuadTo QuadTo = $(x, y, controlX, controlY, duration);
		if (interpolator != null) QuadTo.setInterpolator(interpolator.copy());
		return QuadTo;
	}
}
