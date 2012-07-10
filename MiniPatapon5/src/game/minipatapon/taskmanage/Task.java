package game.minipatapon.taskmanage;

public interface Task<T,V> {
	public T doWork(V arg); 
}
