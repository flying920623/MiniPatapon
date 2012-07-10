/**
 * 
 */
package game.minipatapon.logic.score;


import game.minipatapon.dataprocess.musicprocess.MusicMatch;
import game.minipatapon.dataprocess.musicprocess.MusicTime;
import game.minipatapon.event.music.MatchMusicLevel;

/**
 * @author ZhangY
 * 
 */
public class MatchMusicScore extends BaseScore
{
	private int score;
	// private MusicMatch musicMatch;
	private int count; // 连击次数

	public MatchMusicScore()
	{
		super();
		this.score = 0;
		this.count = 0;
		// this.musicMatch = MusicMatch.GetInstance();
	}

	public void calcMusicLevelScore(MusicTime delta)
	{
//
//		if (MusicMatch.GetInstance().ValueLevel(delta) == MatchMusicLevel.Perfect)
//		{
//			this.score += 40;
//			this.count++;
//		} else if (MusicMatch.GetInstance().ValueLevel(delta) == MatchMusicLevel.Fit)
//		{
//			this.score += 20;
//			if (this.count >= 3) // 清零连击次数前，计算额外奖励分
//			{
//				this.score += this.getExtraScore(this.count);
//			}
//			this.count = 0;
//		} else if (MusicMatch.GetInstance().ValueLevel(delta) == MatchMusicLevel.Miss)
//		{
//			if (this.count >= 3)
//			{
//				this.score += getExtraScore(this.count);
//			}
//			this.count = 0;
//		} else
//		{
//			//
//		}
	}

	/**
	 * 
	 * @param count
	 *            连击次数
	 * @return 额外奖励分
	 */
	private int getExtraScore(int count)
	{
		return 5 * count;
	}

	@Override
	public int getScore()
	{
		// TODO Auto-generated method stub
		return this.score;
	}

}
