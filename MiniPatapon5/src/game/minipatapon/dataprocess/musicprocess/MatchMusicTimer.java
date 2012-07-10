package game.minipatapon.dataprocess.musicprocess;

import game.minipatapon.event.EventBase;

import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.logical.GameRule.GameStateListener;

import java.util.Timer;
import java.util.TimerTask;

public class MatchMusicTimer implements GameStateListener {

	public Timer m_timer;
	public MusicTime m_currentMusicTimer;

	public MatchMusicTimer(){
		m_timer =new Timer();
		m_currentMusicTimer = new MusicTime(0);
		
		
	}
	public void start(){
		
		m_timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				m_currentMusicTimer.addTime(10f);
				//DefaultLogger.getDefaultLogger().log(0, "timer"+String.valueOf(m_currentMusicTimer.time), "");
			}
		},  1000,10);
	}
	public void pause(){
		m_timer.cancel();
	}
	
	public void clear(){
		m_timer.cancel();
		m_currentMusicTimer.SetValue(0);
	}
	@Override
	public void OnGameStart() {
		// TODO Auto-generated method stub
		this.start();
	}
	@Override
	public void OnGameEnd() {
		// TODO Auto-generated method stub
		this.clear();
	}
	
	
	
}
