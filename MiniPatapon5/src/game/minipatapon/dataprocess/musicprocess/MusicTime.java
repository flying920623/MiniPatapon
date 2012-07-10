package game.minipatapon.dataprocess.musicprocess;

import game.minipatapon.logger.DefaultLogger;

public class MusicTime {

	public String time =null;
	public MusicTime(String _time){
		time = _time;
		
	}
	public void SetValue(float ft){
		time = String.valueOf(ft);
	}
	
	public MusicTime(float _time){
		if(_time>MusicSpot.deltaMusicSound)
			_time = _time%MusicSpot.deltaMusicSound;
		time = String.valueOf(_time);
		
	}
	
	public void addTime(float deltaTime)
	{
		float temp =  deltaTime + Float.valueOf(time);
	//	DefaultLogger.getDefaultLogger().log(0, " addtime temp"+String.valueOf(temp), "");
		if(temp>MusicSpot.deltaMusicSound)
		    temp = temp%MusicSpot.deltaMusicSound;
		time = String.valueOf(temp);
	//	DefaultLogger.getDefaultLogger().log(0, " addtime"+String.valueOf(time), "");
	}
	
	public MusicTime Compare(MusicTime timer)
	{
		float temp = Math.abs(Float.valueOf(timer.time)-Float.valueOf(this.time));
		if(temp>MusicSpot.deltaMusicSound/2)
			temp = MusicSpot.deltaMusicSound-temp;
		
		return new MusicTime(temp);
	}
	
}
