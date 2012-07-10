package game.minipatapon.event.music;

import game.minipatapon.dataprocess.datafactory.MusicHandle;

import game.minipatapon.dataprocess.musicprocess.MusicMatch;
import game.minipatapon.event.EventAggregator;
import game.minipatapon.event.EventArg;
import game.minipatapon.logger.DefaultLogger;

public class MusicRythmRecArg extends EventArg{

	public MatchMusicType m_muType;
	public MatchMusicLevel m_mulevel;
	public MusicRythmRecArg(MatchMusicType type, MatchMusicLevel level){
		m_mulevel = level;
		m_muType  = type;
		Init();
	}
	
	public void Init()
	{
		try {
			EventAggregator.getInstance().getEvent(MusicRythmRecEvent.class).subscribe(MusicHandle.GetInstance());
		//	DefaultLogger.getDefaultLogger().log(0, "music success init" , "good ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void EventArgSent() {
		// TODO Auto-generated method stub
		try {
			EventAggregator.getInstance().getEvent(MusicRythmRecEvent.class).EventArgRec(this);
		//	DefaultLogger.getDefaultLogger().log(0, "music success sent" , "good ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
