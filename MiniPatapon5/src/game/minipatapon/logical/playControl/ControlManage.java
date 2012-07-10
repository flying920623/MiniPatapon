package game.minipatapon.logical.playControl;

import game.minipatapon.event.EventBase;
import game.minipatapon.event.EventListener;
import game.minipatapon.event.gamecmd.GameCommandArg;
import game.minipatapon.logger.DefaultLogger;


public class ControlManage implements EventListener<GameCommandArg> {
	private static ControlManage instance = null;
	public PlayerCommand playCmdCommand = null;
	
	public static ControlManage Getinstance(){
		if(instance == null)
			instance = new ControlManage();
		return instance;
	}

	private ControlManage(){
		
	}

	@Override
	public void onEventReceived(
			GameCommandArg arg) {
		// TODO Auto-generated method stub
	//	DefaultLogger.getDefaultLogger().log(0, "  start!","");

		switch(arg.command)
		{
		     case Attack:
		    	 playCmdCommand.OnAttackCommand();
		    	 break;
		     case Defense:
		    	 playCmdCommand.OnDefenseCommand();
		    	 break;
		     case Forward:
		    	 playCmdCommand.OnForwardCommand();
		    	 break;
		     case Fail:
		    	 playCmdCommand.OnFailCommand();
		
		}
	}
}
