/** 
 * @description	: loggers' interface
 * @author		: 黄攀
 * @created		: 2012-1-3
 */

package game.minipatapon.logger;

public interface Loggable {

	void log(String patten, Object... args);

	void log(int level, String patten, Object... args);

	void logWithSignature(Object sender,int level, String patten, Object... args);
	
	void logWithSignature(Object sender,String patten, Object... args);
}
