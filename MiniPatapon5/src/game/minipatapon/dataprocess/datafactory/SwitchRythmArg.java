package game.minipatapon.dataprocess.datafactory;

import game.minipatapon.event.music.MusicRythm;

public class SwitchRythmArg {

	private MusicRythm arg;
	public MusicRythm GetArg(){
		return arg;
	}
	public SwitchRythmArg(MusicRythm _arg)
	{
		arg= _arg;
	}
}
