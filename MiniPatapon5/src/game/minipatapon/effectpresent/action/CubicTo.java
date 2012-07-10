package game.minipatapon.effectpresent.action;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.ActionResetingPool;
import game.minipatapon.util.MathHelper;

public class CubicTo extends MoveTo implements PathAction{

	private static final ActionResetingPool<CubicTo> pool = new ActionResetingPool<CubicTo>(4, 100) {
		@Override
		protected CubicTo newObject () {
			return new CubicTo();
		}
	};


	protected float controlX;
	protected float controlY;
	protected float control2X;
	protected float control2Y;


	public static CubicTo $ (float x, float y, float controlX, float controlY, float control2X, float control2Y, float duration) {
		CubicTo action = pool.obtain();
		action.x = x;
		action.y = y;
		action.controlX = controlX;
		action.controlY = controlY;
		action.control2X = control2X;
		action.control2Y = control2Y;
		action.duration = duration;
		action.invDuration = 1 / duration;
		return action;
	}
	
	public static CubicTo $(float x, float y, float controlX, float controlY, float control2X, float control2Y)
	{
		return CubicTo.$(x, y, controlX, controlY, control2X, control2Y, 0);
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
			
			Vector2 vector = MathHelper.getCubicCurve(new Vector2(startX, startY), 
					new Vector2(controlX, controlY), new Vector2(control2X, control2Y), new Vector2(x, y), alpha);
			
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
		CubicTo CubicTo = $(x, y, controlX, controlY, control2X, control2Y, duration);
		if (interpolator != null) CubicTo.setInterpolator(interpolator.copy());
		return CubicTo;
	}
}
