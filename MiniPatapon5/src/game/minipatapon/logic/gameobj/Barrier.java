package game.minipatapon.logic.gameobj;

public class Barrier
{
	public int hp;
	public int defValue;

	private boolean isLive;

	public Barrier()
	{
		super();
		this.hp = 600;
		this.defValue = 10;
		this.isLive = true;
	}

	public Barrier(int hp, int defValue)
	{
		super();
		this.hp = hp;
		this.defValue = defValue;
		this.isLive = true;
	}

	public void subHP(int atkValue)
	{
		int hurt = atkValue - this.defValue;
		if ((this.hp - hurt) >= 0)
		{
			this.hp -= hurt;
		} else
		{
			this.hp = 0;
		}
	}

	public boolean checkAlive()
	{
		if (this.hp == 0)
		{
			isLive = false;
		}
		return isLive;
	}

}
