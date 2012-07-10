package game.minipatapon.effectpresent.action;

import com.badlogic.gdx.scenes.scene2d.Action;

public class OnActionCompleted implements com.badlogic.gdx.scenes.scene2d.OnActionCompleted{

	Action secondAction = null;
	
	public OnActionCompleted( Action  secondAction)
	{
		this.secondAction = secondAction;
	}
	
	@Override
	public void completed(Action action) {
		// TODO Auto-generated method stub
		
		if( secondAction!=null && action!=null && action.getTarget()!=null )
		{
			action.getTarget().action( this.secondAction );
		}
		
	}

}
