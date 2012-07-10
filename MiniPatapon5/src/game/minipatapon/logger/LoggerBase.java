/** 
 * @description	: LoggerBase for simplify the devolopment of loggers
 * @author		: 黄攀
 * @created		: 2012-1-3
 */

package game.minipatapon.logger;

public abstract class LoggerBase implements Loggable {

	@Override
	public void log(String patten, Object... args) {
		this.logWithSignature(null, 0, patten, args);
	}

	@Override
	public void log(int level, String patten, Object... args) {
		this.logWithSignature(null, level, patten, args);
	}

	@Override
	public void logWithSignature(Object sender, String patten, Object... args) {
		this.logWithSignature(sender, 0, patten, args);
	}

	@Override
	public void logWithSignature(Object sender, int level, String patten,
			Object... args) {
		String msg = String.format(patten, args);
		String senderName;
		if (sender == null)
			senderName = "null";
		else if (sender.getClass() == String.class)
			senderName = (String) sender;
		else
			senderName = sender.getClass().getSimpleName();

		String out = String.format("level:%2$d\t%1$s:\t%3$s", senderName,
				level, msg);
		this.writeMessage(out);
	}

	protected abstract void writeMessage(String msg);

}
