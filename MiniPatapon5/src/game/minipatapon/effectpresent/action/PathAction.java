package game.minipatapon.effectpresent.action;

import com.badlogic.gdx.scenes.scene2d.Actor;


interface  PathAction {
	
	public float duration();
	public void setDuration(float duration);
	public void reSetTarget(Actor actor);
	public void setTargetToEndState();
}
