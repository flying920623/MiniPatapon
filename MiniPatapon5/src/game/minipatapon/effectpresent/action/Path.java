package game.minipatapon.effectpresent.action;

import java.util.ArrayList;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.CompositeAction;
import com.badlogic.gdx.scenes.scene2d.actions.ActionResetingPool;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class Path extends CompositeAction {

	static final ActionResetingPool<Path> pool = new ActionResetingPool<Path>(
			4, 100) {
		@Override
		protected Path newObject() {
			return new Path();
		}
	};

	Actor vActor = null;

	protected boolean[] finished;
	protected Actor target = null;

	public float pathLength = 0f;

	public float startX = 0f;
	public float startY = 0f;

	public float duration = 0f;

	public static Path $(Vector2 start, float duration, Action... actions) {

		Path Path = pool.obtain();
		Path.actions.clear();

		Path.startX = start.x;
		Path.startY = start.y;

		Path.duration = duration;

		if (Path.finished == null || Path.finished.length < actions.length)
			Path.finished = new boolean[actions.length];
		int len = actions.length;
		for (int i = 0; i < len; i++)
			Path.finished[i] = false;

		//Action lastMoveAction = null;
		len = actions.length;

		ArrayList<Action> pActions = new ArrayList<Action>();

		for (int i = 0; i < len; i++) {

			pActions.add(actions[i]);

			if (isMoveAction(actions[i])) {
				//lastMoveAction = actions[i];

				if (pActions.size() != 0) {
					Action[] as = new Action[pActions.size()];
					for (int k = 0; k < as.length; k++) {
						as[k] = pActions.get(k);
					}

					Path.actions.add(Parallel.$(as));

					if (Path.actions.size() > 1) {
						Path.setActionAfterAction(
								Path.actions.get(Path.actions.size() - 2),
								Path.actions.get(Path.actions.size() - 1));
					}

					pActions.clear();
				}

			}

		}

		if (pActions.size() != 0) {
			Action[] as = new Action[pActions.size()];
			for (int k = 0; k < as.length; k++) {
				as[k] = pActions.get(k);
			}
			Path.actions.add(Parallel.$(as));

			pActions.clear();
		}

		return Path;
	}

	@Override
	public void setTarget(Actor actor) {
		this.target = actor;

		this.vActor = new Image("");
		
		vActor.color.a = actor.color.a;
		vActor.rotation = actor.rotation;
		vActor.scaleX = actor.scaleY;
		vActor.scaleY = actor.scaleY;
		vActor.x = actor.x;
		vActor.y = actor.y;

		int len = actions.size();

		for (int i = 0; i < len; i++) {

			Parallel p = (Parallel) actions.get(i);

			for (int k = 0; k < p.getActions().size(); k++) {
				// DefaultLogger.getDefaultLogger().log(p.getActions().get(k).getClass().toString());
				// DefaultLogger.getDefaultLogger().log("target start state:%f, %f, %f, %f, %f, %f",
				// vActor.color.a, vActor.rotation, vActor.x, vActor.y,
				// vActor.scaleX, vActor.scaleY);

				p.getActions().get(k).setTarget(vActor);
				PathAction pa = (PathAction) p.getActions().get(k);
				pa.setTargetToEndState();

				// DefaultLogger.getDefaultLogger().log( pa.toString() );

				// DefaultLogger.getDefaultLogger().log("target end state:%f, %f, %f, %f, %f, %f",
				// vActor.color.a, vActor.rotation, vActor.x, vActor.y,
				// vActor.scaleX, vActor.scaleY);
				// DefaultLogger.getDefaultLogger().log("target start state:%f, %f, %f, %f, %f, %f",
				// vActor.color.a, vActor.rotation, vActor.x, vActor.y,
				// vActor.scaleX, vActor.scaleY);

			}

		}

		

		setPathDistance(actor);
		setPathActionDuration();

		

		for (int i = 0; i < len; i++) {
			PathAction pa = (PathAction) actions.get(i);
			pa.reSetTarget(actor);
		}
		
	}

	@Override
	public void act(float delta) {
		int len = actions.size();
		boolean allDone = true;
		Action action;

		for (int i = 0; i < len; i++) {
			action = actions.get(i);

			if (!action.isDone()) {
				action.act(delta);

				allDone = false;
				break;
			}

		}

		if (allDone)
			callActionCompletedListener();

	}

	@Override
	public boolean isDone() {
		int len = actions.size();
		for (int i = 0; i < len; i++)
			if (actions.get(i).isDone() == false)
				return false;
		return true;
	}

	@Override
	public void finish() {
		pool.free(this);
		int len = actions.size();
		for (int i = 0; i < len; i++) {
			if (!finished[i])
				actions.get(i).finish();
		}
		super.finish();
	}

	@Override
	public Action copy() {
		Path Path = pool.obtain();
		Path.actions.clear();
		if (Path.finished == null || Path.finished.length < actions.size())
			Path.finished = new boolean[actions.size()];
		int len = actions.size();
		for (int i = 0; i < len; i++)
			Path.finished[i] = false;
		len = actions.size();
		for (int i = 0; i < len; i++)
			Path.actions.add(actions.get(i).copy());
		return Path;
	}

	@Override
	public Actor getTarget() {
		return target;
	}

	public static boolean isMoveAction(Action action) {
		if (action instanceof MoveTo) {
			return true;
		}

		return false;
	}

	void setActionAfterAction(Action action, Action action2) {
		action.setCompletionListener(new OnActionCompleted(action2));
	}

	void setPathDistance(Actor actor) {
		int len = actions.size();

		// MoveTo lastMt = null;

		for (int i = 0; i < len; i++) {

			Parallel parallel = (Parallel) actions.get(i);

			for (int k = 0; k < parallel.getActions().size(); k++) {

				Action action = parallel.getActions().get(k);

				if (!isMoveAction(action)) {

					continue;
				}

				MoveTo mt = (MoveTo) action;

				// if (lastMt == null) {
				//
				// mt.setStartPoint(actor.x, actor.y);
				//
				// } else {
				// mt.setStartPoint(lastMt.x(), lastMt.y());
				// }

				// lastMt = mt;

				this.pathLength += mt.deltaDistance();

				// Vector2 v1 = null;
				// Vector2 v2 = null;
				// v1 = new Vector2(mt.startX(), mt.startY());
				// v2 = new Vector2(mt.x(), mt.y());
				//
				// DefaultLogger.getDefaultLogger().logWithSignature(this,
				// "Point1: %s, Point2: %s", v1.toString(), v2.toString());
				//
				// this.pathLength += MathHelper.getDistance(v1, v2);
			}

		}

//		DefaultLogger.getDefaultLogger().logWithSignature(this, "path 距离为：%f",
//				pathLength);
	}

	void setPathActionDuration() {
		for (int i = 0; i < actions.size(); i++) {

			Parallel parallel = (Parallel) actions.get(i);

			for (int k = 0; k < parallel.getActions().size(); k++) {

				Action action = parallel.getActions().get(k);

				if (!isMoveAction(action)) {
					continue;
				}

				MoveTo mt = (MoveTo) action;

				// Vector2 v1 = null;
				// Vector2 v2 = null;
				// v1 = new Vector2(mt.startX(), mt.startY());
				// v2 = new Vector2(mt.x(), mt.y());
				//
				// DefaultLogger.getDefaultLogger().logWithSignature(this,
				// "Point1: %s, Point2: %s", v1.toString(), v2.toString());

				float d = mt.deltaDistance() / pathLength * duration;

//				DefaultLogger.getDefaultLogger().logWithSignature(this,
//						"Parallel[%d] 距离为：%f,时间为：%f", i, mt.deltaDistance(), d);

				if (parallel.duration() < d) {
					if( mt.duration()==0 )
					{
						parallel.setDuration(d);
					}
					
				}

//				DefaultLogger.getDefaultLogger().logWithSignature(this,
//						"MoveTo[%d] 时间为：%f", k, mt.duration());

			}

		}
	}
}