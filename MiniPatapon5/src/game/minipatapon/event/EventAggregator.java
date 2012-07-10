/** 
 * @description	: a container for events
 * @author		: 黄攀
 * @created		: 2012-1-5
 */
package game.minipatapon.event;

import game.minipatapon.logger.DefaultLogger;

import java.util.HashMap;
import java.util.Map;

//import game.minipatapon.logger.DefaultLogger;

public class EventAggregator {

	private static EventAggregator instance;

	public static EventAggregator getInstance() {
		if (instance == null)
			instance = new EventAggregator();
		return instance;
	}

	@SuppressWarnings("rawtypes")
	private EventAggregator() {
		this.dictionary = new HashMap<Class, EventBase>();
	}

	@SuppressWarnings("unchecked")
	public <T extends EventBase<?>> T getEvent(Class<? extends T> cls)
			throws Exception {
		try {
			if (!this.dictionary.containsKey(cls)) {
				this.dictionary.put(cls,
						(EventBase<?>) cls.getConstructors()[0]
								.newInstance());
				
			}

			//@SuppressWarnings("unchecked")
			return ((T) this.dictionary.get(cls));
		//	DefaultLogger.getDefaultLogger().log(0, " event");
			
		} catch (Exception ex) {
	//		DefaultLogger.getDefaultLogger().log(
//					"EventAggregator(getEvent):%1$s", ex.getMessage());
			throw ex;
		}

	}

	@SuppressWarnings("rawtypes")
	Map<Class, EventBase> dictionary;
}
