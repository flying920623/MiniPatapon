package game.minipatapon.effectpresent.action;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.ActionResetingPool;

public class Parallel extends com.badlogic.gdx.scenes.scene2d.actions.Parallel
		implements PathAction {

	static final ActionResetingPool<Parallel> pool = new ActionResetingPool<Parallel>(
			4, 100) {
		@Override
		protected Parallel newObject() {
			return new Parallel();
		}
	};

	protected float duration = 0f;

	public static Parallel $(Action... actions) {
		Parallel parallel = pool.obtain();
		parallel.actions.clear();
		if (parallel.finished == null
				|| parallel.finished.length < actions.length)
			parallel.finished = new boolean[actions.length];
		int len = actions.length;
		for (int i = 0; i < len; i++)
			parallel.finished[i] = false;
		len = actions.length;
		for (int i = 0; i < len; i++)
			parallel.actions.add(actions[i]);
		return parallel;
	}

	@Override
	public float duration() {
		// TODO Auto-generated method stub

		float duration = 0f;

		for (int i = 0; i < actions.size(); i++) {
			PathAction action = (PathAction) actions.get(i);

			float d = action.duration();
			if (d > duration) {
				duration = d;
			}
		}

		return duration;
	}

	@Override
	public void setDuration(float duration) {
		// TODO Auto-generated method stub

		this.duration = duration;

		for (int i = 0; i < actions.size(); i++) {
			PathAction action = (PathAction) actions.get(i);

			action.setDuration(duration);
		}
	}

	public void reSetTarget(Actor actor) {
		for (int i = 0; i < actions.size(); i++) {
			PathAction pa = (PathAction) actions.get(i);
			pa.reSetTarget(actor);
		}
	}

	public void setTargetToEndState() {
		for (int i = 0; i < actions.size(); i++) {
			PathAction action = (PathAction) actions.get(i);
			action.setTargetToEndState();
		}
	}
	
	public Action copy () {
		Parallel parallel = pool.obtain();
		parallel.actions.clear();
		if (parallel.finished == null || parallel.finished.length < actions.size())
			parallel.finished = new boolean[actions.size()];
		int len = actions.size();
		for (int i = 0; i < len; i++)
			parallel.finished[i] = false;
		len = actions.size();
		for (int i = 0; i < len; i++)
			parallel.actions.add(actions.get(i).copy());
		return parallel;
	}

}
