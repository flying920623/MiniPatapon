/**
 * 
 */
package game.minipatapon.logic.score;

/**
 * @author ZhangY
 * 
 */
public class BaseScore
{
	private int score = 0;

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	
	public int addScore(int _score)
	{
		return score+_score;
	}
	public int subScore(int _score)
	{
		return score-_score;
	}
}
