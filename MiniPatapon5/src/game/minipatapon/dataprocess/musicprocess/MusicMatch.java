package game.minipatapon.dataprocess.musicprocess;

import game.minipatapon.application.MiniPataponManager;
import game.minipatapon.effectpresent.widget.NoteImage;
import game.minipatapon.event.EventBase;
import game.minipatapon.event.EventListener;

import game.minipatapon.event.music.MatchMusicLevel;
import game.minipatapon.event.music.MusicInputArg;
import game.minipatapon.event.music.MusicRythmRecArg;
import game.minipatapon.logger.DefaultLogger;


public class MusicMatch implements EventListener<MusicInputArg>{

	private static  MusicMatch instance = null;
	public  MatchMusicTimer timer;
	public  MusicSpot m_musicSpot;
	private MusicMatch(){
		timer = new MatchMusicTimer();
		m_musicSpot = new MusicSpot();
		//timer.start();
	}
	public static MusicMatch GetInstance(){
		if(null == instance)
			instance = new MusicMatch();
		return instance;
	}
	@Override
	public  void onEventReceived(
			MusicInputArg arg) {
		// TODO Auto-generated method stub
	   MusicTime delta =  timer.m_currentMusicTimer.Compare(m_musicSpot.GetTimer());
	   MatchMusicLevel level = ValueLevel(delta);
	   
	   MusicRythmRecArg arg2 = new MusicRythmRecArg(arg.m_MusicType, level);
	   arg2.EventArgSent();
	   new NoteImage(arg2.m_muType, arg2.m_mulevel, MiniPataponManager.getInstance().GetLayeredScreen().getForeScreen().stage);
	 //  DefaultLogger.getDefaultLogger().log(0, " correct", "");
	}                                                                                 
	
	
	public MatchMusicLevel ValueLevel(MusicTime delta){
		
	//	if(delta)
		MatchMusicLevel temp;
		float tempLevel = (float)Float.valueOf(delta.time)/MusicSpot.deltaMusicSound;
		if(tempLevel <0.2)
		{
			temp = MatchMusicLevel.Perfect;
		   // DefaultLogger.getDefaultLogger().log(0, " sent perfect");
		} 
		else 
		{
			if(tempLevel <0.4)		
			{
			temp = MatchMusicLevel.Fit;
			// DefaultLogger.getDefaultLogger().log(0, " sent fit");
			}
			else {
			temp = MatchMusicLevel.Miss;
			// DefaultLogger.getDefaultLogger().log(0, " sent miss");
			}
		}
		temp=MatchMusicLevel.Perfect;
		return temp;
		
	}
	
	

	
}
