package game.minipatapon.taskmanage;

public interface TaskContainer<M extends Task<?,?>> {
	public void push(M task);
	public void remove(M task);
	public M pop();
	public boolean isEmpty();
	public int size();
	public void clear();

}
