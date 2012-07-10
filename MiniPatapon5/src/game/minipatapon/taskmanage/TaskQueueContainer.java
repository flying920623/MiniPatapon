package game.minipatapon.taskmanage;

import java.util.LinkedList;

public class TaskQueueContainer<M extends Task<?, ?>> implements
		TaskContainer<M> {

	LinkedList<M> tasks;

	public TaskQueueContainer() {
		tasks = new LinkedList<M>();
	}

	@Override
	public void push(M task) {
		tasks.add(task);
	}

	@Override
	public void remove(M task) {
		tasks.remove(task);

	}

	@Override
	public M pop() {
		return tasks.remove();
	}

	@Override
	public boolean isEmpty() {
		return tasks.isEmpty();
	}

	@Override
	public int size() {
		return tasks.size();
	}

	@Override
	public void clear() {
		tasks.clear();
	}

}
