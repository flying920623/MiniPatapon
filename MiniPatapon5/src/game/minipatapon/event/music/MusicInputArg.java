package game.minipatapon.event.music;

import game.minipatapon.application.MiniPataponManager;
import game.minipatapon.dataprocess.musicprocess.MusicMatch;
import game.minipatapon.event.EventAggregator;
import game.minipatapon.event.EventArg;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.stage.base.BaseStage;

public class MusicInputArg extends EventArg{

	public MatchMusicType m_MusicType;

	
	public MusicInputArg(MatchMusicType musicType){
	    m_MusicType=musicType;
	     Init();
	}
	
	public void Init()
	{
		try {
			EventAggregator.getInstance().getEvent(MusicInputEvent.class).subscribe(MusicMatch.GetInstance());
		//	DefaultLogger.getDefaultLogger().log(0, "Nav success init" , "good ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void EventArgSent() {
		// TODO Auto-generated method stub
		try {
			EventAggregator.getInstance().getEvent(MusicInputEvent.class).EventArgRec(this);
		//	DefaultLogger.getDefaultLogger().log(0, "Nav success sent" , "good ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
