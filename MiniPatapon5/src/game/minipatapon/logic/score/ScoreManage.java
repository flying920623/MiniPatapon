package game.minipatapon.logic.score;

import game.minipatapon.dataprocess.musicprocess.MusicTime;

import java.util.ArrayList;

public class ScoreManage
{
	private static ScoreManage _instance;

	private MatchMusicScore matchMusicScore;
	private AttrackScore attrackScore;

	private ScoreManage()
	{
		this.matchMusicScore = new MatchMusicScore();
		this.attrackScore = new AttrackScore();
	}

	public static ScoreManage GetInstance()
	{
		if (_instance == null)
		{
			_instance = new ScoreManage();
		}
		return _instance;
	}

	private int getAttrackScore(int barrierCount, int enemyCount, int level, int soldierCount)
	{
		attrackScore.calcScore(barrierCount, enemyCount, level, soldierCount);
		return attrackScore.getScore();
	}

	private int getMatchMusicScore(ArrayList<MusicTime> deltas)
	{
		for (MusicTime musicTime : deltas)
		{
			matchMusicScore.calcMusicLevelScore(musicTime);
		}

		return matchMusicScore.getScore();
	}

	public int getScore(ArrayList<MusicTime> deltas, int barrierCount, int enemyCount, int level, int soldierCount)
	{
		int score = this.getMatchMusicScore(deltas) + this.getAttrackScore(barrierCount, enemyCount, level, soldierCount);
		if (score >= 0)
		{
			return score;
		} else
		{
			return 0;
		}
	}
}
