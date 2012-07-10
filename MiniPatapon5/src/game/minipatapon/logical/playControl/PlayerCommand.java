package game.minipatapon.logical.playControl;

public interface PlayerCommand {

	public void OnAttackCommand();
	public void OnDefenseCommand();
	public void OnForwardCommand();
	public void OnFailCommand();
}
