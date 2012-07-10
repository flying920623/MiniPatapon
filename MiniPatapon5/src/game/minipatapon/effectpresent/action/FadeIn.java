package game.minipatapon.effectpresent.action;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class FadeIn extends com.badlogic.gdx.scenes.scene2d.actions.FadeIn implements PathAction{
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
		this.target.color.a = 1;
	}
}
