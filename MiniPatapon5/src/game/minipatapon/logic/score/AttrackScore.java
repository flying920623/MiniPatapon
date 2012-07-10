/**
 * 
 */
package game.minipatapon.logic.score;

/**
 * @author ZhangY
 * 
 */
public class AttrackScore extends BaseScore
{
	private int score;

	public AttrackScore()
	{
		this.score = 0;
	}

	/**
	 * 
	 * @param barrierCount
	 *            被摧毁障碍物数
	 * @param enemyCount
	 *            击毙普通怪物数
	 * @param level
	 *            当前关卡级别
	 * @param soldierCount
	 *            阵亡士兵数
	 */
	public void calcScore(int barrierCount, int enemyCount, int level, int soldierCount)
	{
		this.score = this.calcBarrierScore(barrierCount) + this.calcEnemyScore(enemyCount) + this.calcBossScore(level) + this.calcSoldierScore(soldierCount);
	}

	private int calcBarrierScore(int barrierCount)
	{
		return 50 * barrierCount;
	}

	private int calcEnemyScore(int enemyCount)
	{
		return 40 * enemyCount;
	}

	private int calcBossScore(int level)
	{
		return 200 * level;
	}

	private int calcSoldierScore(int soldierCount)
	{
		return -60 * soldierCount;
	}

	@Override
	public int getScore()
	{
		return this.score;
	}

}
