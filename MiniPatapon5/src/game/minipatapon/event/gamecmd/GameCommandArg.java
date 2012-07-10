package game.minipatapon.event.gamecmd;

import game.minipatapon.dataprocess.musicprocess.MusicMatch;
import game.minipatapon.event.EventAggregator;
import game.minipatapon.event.EventArg;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.logical.playControl.ControlManage;


import javax.naming.InitialContext;

public class GameCommandArg extends EventArg{

	public GameCommand command;
	public GameCommandArg(GameCommand cmd){
		command = cmd;
		init();
	}
	public void init(){
		try {
			EventAggregator.getInstance().getEvent(GameCommandEvent.class).subscribe(ControlManage.Getinstance());
			DefaultLogger.getDefaultLogger().log(0, "Nav success init" , "good ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void EventArgSent() {
		// TODO Auto-generated method stub
		try {
			EventAggregator.getInstance().getEvent(GameCommandEvent.class).EventArgRec(this);
			DefaultLogger.getDefaultLogger().log(0, "Nav success sent" , "good ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
