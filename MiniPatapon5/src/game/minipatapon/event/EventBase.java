/** 
 * @description	: all events should derived from this class
 * @author		: 黄攀
 * @created		: 2012-1-5
 */

package game.minipatapon.event;

import java.util.ArrayList;
import java.util.List;

public class EventBase<T extends EventArg> {
	
	private List<EventListener<T>> listeners;
   
	//public T arg = null;
	
	public void EventArgRec(T arg)
	{
		
		publish(arg);
	}
		
	public EventBase() {
		listeners = new ArrayList<EventListener<T>>();
	}	
	public void subscribe(EventListener<T> listener){
		if(!listeners.contains(listener))
			
		this.listeners.add(listener);
	}
	public void unSubscribe(EventListener<T> listener){
		this.listeners.remove(listener);
	}
	public void publish(T arg){
		for(EventListener<T> listener:listeners){
			listener.onEventReceived(arg);
		}
	}
	
	
}
