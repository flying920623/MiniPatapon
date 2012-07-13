package game.minipatapon.effectpresent.actor;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.OnActionCompleted;
import com.badlogic.gdx.scenes.scene2d.Stage;

import game.minipatapon.effectpresent.action.Parallel;
import game.minipatapon.effectpresent.action.QuadTo;
import game.minipatapon.effectpresent.action.ScaleTo;
import game.minipatapon.effectpresent.animation.HeroAnimateImage;
import game.minipatapon.logger.DefaultLogger;

public class RotateGroup extends Group {

	Stage stage = null;

	Vector2[] points = new Vector2[3];
	Vector2[] controlVectors = new Vector2[3];

	float[] scales = new float[3];
	float[] originScales = new float[3];

	float highScale = 1.4f;
	float lowScale = 1f;

	Actor highLightActor = null;

	HighlightItemChangeListener itemChangeListener = null;

	HashMap<Actor, Integer> stateMap = new HashMap<Actor, Integer>();
	
	float downX = 0;
	float upX = 0;
	
	public Actor[] focusedActor = new Actor[20];

	public RotateGroup(Stage stage, Actor... actors) {
		super();

		this.stage = stage;

		this.addActors(actors);
		this.setScale();
		this.setPoint();

		for (int i = 0; i < children.size(); i++) {
			DefaultLogger.getDefaultLogger().log(children.get(i).toString());
			setState(children.get(i), false, i);
			stateMap.put(children.get(i), i);
	//		DefaultLogger.getDefaultLogger().logWithSignature(this, "%f, %f",
	//				children.get(i).x, children.get(i).y);
		}

		highLightActor = children.get(0);
	}

	public RotateGroup(String arg, Stage stage, Actor... actors) {
		super(arg);

		this.stage = stage;

		this.addActors(actors);
		this.setScale();
		this.setPoint();

		for (int i = 0; i < children.size(); i++) {
			setState(children.get(i), true, i);
		}

		highLightActor = children.get(0);
	}
	
	
	public boolean touchDown (float x, float y, int pointer) {
		
		downX = x;
		DefaultLogger.getDefaultLogger().log(0, "%f, %f ", x, y);
		


		int len = children.size() - 1;
		for (int i = len; i >= 0; i--) {
			Actor child = children.get(i);
			if (!child.touchable) continue;

			toChildCoordinates(child, x, y, point);
			if (child.hit(point.x, point.y) == null) continue;
			if (child.touchDown(point.x, point.y, pointer)) {

				if (focusedActor[pointer] == null) {
					focus(child, pointer);
				}
				lastTouchedChild = child;
				return true;
			}
		}

		return this.touchable;
	}
	
	public void touchUp (float x, float y, int pointer) {
		
		upX = x;
		
		DefaultLogger.getDefaultLogger().log(0, "%f, %f ", x, y);
		
		for (int i = 0; i < children.size(); i++) {
			FlatImage actor = (FlatImage) children.get(i);
			if (!actor.actionDone()) {
				//DefaultLogger.getDefaultLogger().log(0, "test1 ");
				return;
			}
		}

		if (downX > upX) {
			rotateRight();
		} else if (downX < upX) {
			rotateLeft();
		}
		else{
			if (!touchable) return;
			point.x = x;
			point.y = y;
			Actor actor = focusedActor[pointer];
			if (actor != this) {
				actor.toLocalCoordinates(point);
				actor.touchUp(point.x, point.y, pointer);
			}
			// If the focused actor hasn't changed and hasn't already lost focus, remove its focus.
			if (focusedActor[pointer] == actor && actor != null) focus(null, pointer);
		}

		itemChangeListener.onItemChange(highLightActor);
		
	}
	
	public void focus (Actor actor, int pointer) {
		Actor existingActor = focusedActor[pointer];
		if (existingActor != null) {
			// An actor already has focus. Remove the focus if it is not a child of this group, because the focused actor could be
			// further down in the hiearchy.
			focusedActor[pointer] = null;
			if (existingActor.parent != this) existingActor.parent.focus(null, pointer);
		}
		if (debug) Gdx.app.log("Group", "focus: " + (actor == null ? "null" : actor.name));
		focusedActor[pointer] = actor;
	}
	
//	
//	public boolean keyDown(int keycode) {
//
////		DefaultLogger.getDefaultLogger().logWithSignature(this, "keycode: %d",
////				keycode);
//		//DefaultLogger.getDefaultLogger().log(0, "test0 ");
//		for (int i = 0; i < children.size(); i++) {
//			FlatImage actor = (FlatImage) children.get(i);
//			if (!actor.actionDone()) {
//				//DefaultLogger.getDefaultLogger().log(0, "test1 ");
//				return false;
//			}
//		}
//
//		if (keycode == 21) {
//			rotateLeft();
//		} else if (keycode == 22) {
//			rotateRight();
//		}
//
//		itemChangeListener.onItemChange(highLightActor);
//
//		return super.keyDown(keycode);
//	}
	
	protected void rotateLeft()
	{
		for (int i = 0; i < children.size(); i++) {
			Actor actor = children.get(i);
			int index = stateMap.get(actor);

			setState(actor, true, index);

			if (stateMap.get(actor) == 0) {
				highLightActor = actor;
				//DefaultLogger.getDefaultLogger().log(0, "test2 ");
			}

		}
	}
	
	protected void rotateRight()
	{
		for (int i = 0; i < children.size(); i++) {
			Actor actor = children.get(i);
			int index = stateMap.get(actor);

			setState(actor, false, index);

			if (stateMap.get(actor) == 0) {
				highLightActor = actor;
				//DefaultLogger.getDefaultLogger().log(0, "test2 ");
			}

		}
	}
	

	@SuppressWarnings("unused")
	public void setPoint() {

		HeroAnimateImage image = (HeroAnimateImage) children.get(0);
		float highScaleWidth = image.getScaledWidth();
		float highScaleHeight = image.getScaledHeight();

		image = (HeroAnimateImage) children.get(1);
		float loewScaleWidth = image.getScaledWidth();
		float loewScaleHeight = image.getScaledHeight();

		float space = 1f / 10f;

		points[0] = new Vector2(stage.width() / 2 - highScaleWidth / 2,
				stage.height() * space);
		points[1] = new Vector2(stage.width() * space, stage.height()
				* (1 - space) - loewScaleHeight);
		points[2] = new Vector2(stage.width() * (1 - space) - loewScaleWidth,
				stage.height() * (1 - space) - loewScaleHeight);

		float controlDistance = 120f;

		controlVectors[0] = new Vector2(points[1].x, points[0].y);
		controlVectors[1] = new Vector2(points[2].x / 2 + points[1].x / 2,
				points[1].y + controlDistance);
		controlVectors[2] = new Vector2(points[2].x, points[0].y);

		// points[0] = new Vector2(stage.width() / 2 - highScaleWidth / 2, 10);
		// points[1] = new Vector2(10, 10);
		// points[2] = new Vector2(stage.width() - loewScaleWidth-10, 10);

		// DefaultLogger.getDefaultLogger().logWithSignature(this,
		// "%f, %f, %f, %f", image.scaleX, image.width, stage.width(),
		// scaleWidth);
	}

	public void setScale() {

		
		if( children.get(0) instanceof HeroAnimateImage )
		{
			HeroAnimateImage image = null;
			image = (HeroAnimateImage)children.get(0);
			
			highScale = Gdx.graphics.getHeight()/1.1f/image.getHeight();
			lowScale = Gdx.graphics.getHeight()/2/image.getHeight();
		}
		
		
		
		for (int i = 0; i < children.size(); i++) {
			if (i == 0) {
				children.get(i).scaleX = highScale;
				children.get(i).scaleY = highScale;
			} else {
				children.get(i).scaleX = lowScale;
				children.get(i).scaleY = lowScale;
			}

		}

		scales[0] = highScale;
		scales[1] = lowScale;
		scales[2] = lowScale;
	}

	public void addActors(Actor[] actors) {
		for (int i = 0; i < actors.length; i++) {
			this.addActor(actors[i]);
//			actors[i].width=Gdx.graphics.getHeight()/3;
//			actors[i].height=Gdx.graphics.getHeight()/3;
		}
		
		
	}

	public void setState(Actor actor, boolean left, int i) {
		
		actor.clearActions();
		HeroAnimateImage temp = (HeroAnimateImage)actor;
	//	DefaultLogger.getDefaultLogger().log(temp.toString());
		int nextIndex = 0;

		int controlI = i;

		if (!left) {
			nextIndex = i + 1;
			
			temp.indexTexture =2;
			if(nextIndex ==2)
			{
				temp.indexTexture =1;
//			DefaultLogger
//			.getDefaultLogger().log(0, " change");
			}
			if (nextIndex >= points.length) {
				nextIndex = 0;
				
				
			}
						
			controlI = i;
		} else {
			nextIndex = i - 1;
			
			temp.indexTexture =2;
			if(nextIndex ==2)
				temp.indexTexture =1;
			if (nextIndex < 0) {
				nextIndex = points.length - 1;
			}
			
			controlI = nextIndex;

		}
		OnActionCompleted listener = new ActionListener(this,temp);  
		//actor.action()
		Action a =Parallel.$(ScaleTo.$(scales[nextIndex], scales[nextIndex],
				1f), QuadTo.$(points[nextIndex], controlVectors[controlI], 1f)).setCompletionListener(listener);
		
		temp.action(a);

		
        
       //   if(nextIndex==0)
				//temp.indexTexture=2;
			//else {
		//		temp.indexTexture=1;
		//	}                   
			                         
		
		stateMap.put(actor, nextIndex);
	}

	public void setCurrentItemChangeListener(
			HighlightItemChangeListener listener) {
		this.itemChangeListener = listener;
	}
}
