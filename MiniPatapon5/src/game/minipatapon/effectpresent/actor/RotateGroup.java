package game.minipatapon.effectpresent.actor;

import java.util.HashMap;
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
	float lowScale = 0.7f;

	Actor highLightActor = null;

	HighlightItemChangeListener itemChangeListener = null;

	HashMap<Actor, Integer> stateMap = new HashMap<Actor, Integer>();

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
	

	public boolean keyDown(int keycode) {

//		DefaultLogger.getDefaultLogger().logWithSignature(this, "keycode: %d",
//				keycode);
		//DefaultLogger.getDefaultLogger().log(0, "test0 ");
		for (int i = 0; i < children.size(); i++) {
			FlatImage actor = (FlatImage) children.get(i);
			if (!actor.actionDone()) {
				//DefaultLogger.getDefaultLogger().log(0, "test1 ");
				return false;
			}
		}

		for (int i = 0; i < children.size(); i++) {
			Actor actor = children.get(i);
			int index = stateMap.get(actor);

			// if (keycode == 22) {
			// if (index == 0) {
			// setState(actor, false, children.size() - 1);
			// stateMap.put(actor, children.size() - 1);
			// } else {
			// setState(actor, false, index - 1);
			// stateMap.put(actor, index - 1);
			// }
			// } else if (keycode == 21) {
			// if (index == children.size() - 1) {
			// setState(actor, true, 0);
			// stateMap.put(actor, 0);
			// } else {
			// setState(actor, true, index + 1);
			// stateMap.put(actor, index + 1);
			// }
			// }

			if (keycode == 21) {
				setState(actor, true, index);
			} else if (keycode == 22) {
				setState(actor, false, index);
			}

			if (stateMap.get(actor) == 0) {
				highLightActor = actor;
				//DefaultLogger.getDefaultLogger().log(0, "test2 ");
			}

		}

		itemChangeListener.onItemChange(highLightActor);

		return true;
	}

	@SuppressWarnings("unused")
	public void setPoint() {

		FlatImage image = (FlatImage) children.get(0);
		float highScaleWidth = image.getScaledWidth();
		float highScaleHeight = image.getScaledHeight();

		image = (FlatImage) children.get(1);
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
