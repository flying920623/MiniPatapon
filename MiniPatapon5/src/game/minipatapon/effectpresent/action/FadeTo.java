package game.minipatapon.effectpresent.action;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.ActionResetingPool;
import game.minipatapon.logger.DefaultLogger;

public class FadeTo extends com.badlogic.gdx.scenes.scene2d.actions.FadeTo
		implements PathAction {

	private static final ActionResetingPool<FadeTo> pool = new ActionResetingPool<FadeTo>(
			4, 100) {
		@Override
		protected FadeTo newObject() {
			return new FadeTo();
		}
	};

	public static FadeTo $(float alpha, float duration) {
		FadeTo action = pool.obtain();
		action.toAlpha = Math.min(Math.max(alpha, 0.0f), 1.0f);
		action.duration = duration;
		action.invDuration = 1 / duration;
		return action;
	}

	public static FadeTo $(float alpha) {
		return FadeTo.$(alpha, 0f);
	}

	public float duration() {
		return this.duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
		this.invDuration = 1 / this.duration;
	}

	public void reSetTarget(Actor actor) {
		this.target = actor;
	}

	public void setTargetToEndState() {
		this.target.color.a = this.toAlpha;

		DefaultLogger.getDefaultLogger().logWithSignature(this,
				"startA:%f, endA:%f", this.startAlpha, this.toAlpha);
	}

	public String toString() {
		return super.toString() + "  startAlpha: " + this.startAlpha
				+ " toAlpha:  " + this.toAlpha;
	}
	
	public Action copy () {
		FadeTo fadeTo = $(toAlpha, duration);
		if (interpolator != null) fadeTo.setInterpolator(interpolator.copy());
		return fadeTo;
	}

}
