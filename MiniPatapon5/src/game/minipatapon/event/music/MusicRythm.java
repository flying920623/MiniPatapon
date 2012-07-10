package game.minipatapon.event.music;



public class MusicRythm {
	public MatchMusicLevel musicLevel;
	public MatchMusicType  musicType;
	
	public MusicRythm(MatchMusicLevel level, MatchMusicType type){
		musicLevel = level;
		musicType = type;
	}

	public MusicRythm(MusicRythmRecArg arg){
		musicLevel = arg.m_mulevel;
		musicType = arg.m_muType;
	}
	
}
