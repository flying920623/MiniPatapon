package game.minipatapon.taskmanage;

import java.util.Stack;

public class TaskStackContainer<M extends Task<?, ?>> implements
		TaskContainer<M> {

	Stack<M> tasks;

	public TaskStackContainer() {
		tasks = new Stack<M>();
	}

	@Override
	public void push(M task) {
		this.tasks.push(task);
	}

	@Override
	public void remove(M task) {
		this.tasks.remove(task);
	}

	@Override
	public M pop() {
		return this.tasks.pop();
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
