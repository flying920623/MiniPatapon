package game.minipatapon.event.gamecmd;

import game.minipatapon.event.EventAggregator;
import game.minipatapon.event.EventArg;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.logical.GameRule.GameLogic;

public class GameStateArg extends EventArg{
	public GameState state;
	public GameStateArg(GameState _state){
		state = _state;
		init();
	}
	public void init(){
		try {
			EventAggregator.getInstance().getEvent(GameStateEvent.class).subscribe(GameLogic.Getinstance());
	//		DefaultLogger.getDefaultLogger().log(0, "Nav success init" , "good ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void EventArgSent() {
		// TODO Auto-generated method stub
		try {
			EventAggregator.getInstance().getEvent(GameStateEvent.class).EventArgRec(this);
		//	DefaultLogger.getDefaultLogger().log(0, "Nav success sent" , "good ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
