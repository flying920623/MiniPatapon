/** 
 * @description	: log for debug console 
 * @author		: 黄攀
 * @created		: 2012-1-3
 */

package game.minipatapon.logger;

import com.sun.opengl.impl.Debug;

public class DebugLogger extends LoggerBase{

	@Override
	protected void writeMessage(String msg) {
		Debug.debug(msg);
	}
}
