package game.minipatapon.effectpresent.dialog;

import java.util.Timer;
import java.util.TimerTask;

import game.minipatapon.event.gamecmd.GameState;
import game.minipatapon.event.gamecmd.GameStateArg;
import game.minipatapon.logger.DefaultLogger;


public class TimerCounter {

	public static int time = 0;
	public static boolean stop = true;
	
	protected String timeString = "";

	protected int[] t = new int[4];

	protected int p1 = 0;
	protected int p2 = 0;

	protected final String gap = ":";

	Timer timer = new Timer();

	public TimerCounter(int time)
	{
		TimerCounter.time = time;
		setTime(time);
		//DefaultLogger.getDefaultLogger().logWithSignature(this, getTime());
	}
	
	public void initTimer() {
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if( !TimerCounter.stop )
				{
					TimerCounter.time--;
				}
				
			}}, 0,1000);
		
	}

	public String getTime() {

		setTime(TimerCounter.time);
		
		String s1 ="0" + String .valueOf(p1);
		String s2 ="0" + String.valueOf(p2);
		
		if( p1>=10 )
		{
			s1 = String .valueOf(p1);
		}
		
		if(p2>=10)
		{
			s2 = String.valueOf(p2);
		}
		return s2 + gap + s1;
	}

//	// 从左往右
//	public void setTime(int p1, int p2) {
//		this.p1 = p1;
//		this.p2 = p2;
//	}

	public void setTime(int time) {

		if( time<0 )
		{
//			GameStateArg arg =new GameStateArg(GameState.GameEnd);
//			arg.EventArgSent();
			return;
		}
		
		p1 = time % 60;
		p2 = time/60;
	}

//	public void addTime() {
//
//		p1 = (++p1) % 60;
//		if (p1 == 0) {
//			p2 = (++p2) % 60;
//			if (p2 == 0) {
//				p1=0;
//			}
//		}
//	}
//	
//	public void reduceTime() {
//
//		p1 = (--p1) % 60;
//		if (p1 == 0) {
//			
//			if( p2!=0 )
//			{
//				p2 = (--p2) % 60;
//				if (p2 == 0) {
//					p1=59;
//				}
//			}else{
//				//时间结束
//			}				
//			
//			
//		}
//	}

	public void reSet() {
		
		TimerCounter.time = 0;
		p1 = p2 = 0;
	}

	public void start(int time)
	{
		stop = false;
		setTime(time);
		TimerCounter.time = time;
		initTimer();
	}
	
	public void pause()
	{
		stop = true;
	}
	
	public void continueTimer()
	{
		stop = false;
	}
	
	public void clearTimer()
	{
		timer.cancel();
	}
}
