package game.minipatapon.dataprocess.musicprocess;



public class MusicSpot {

	MusicTime timers;
	public static final long deltaMusicSound=530;
	
	public MusicSpot()
	{
		timers =new MusicTime((float)0.04*1000);
		
	}
	public MusicTime GetTimer(){
		return timers;
		
	}

	
}
