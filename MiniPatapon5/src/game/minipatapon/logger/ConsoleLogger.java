/** 
 * @description	: log for console 
 * @author		: 黄攀
 * @created		: 2012-1-3
 */

package game.minipatapon.logger;

public class ConsoleLogger extends LoggerBase {

	@Override
	protected void writeMessage(String msg) {
		System.out.println(msg);
	}

}
