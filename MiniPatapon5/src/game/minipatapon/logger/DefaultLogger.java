/** 
 * @description	: default logger getter and setter, thread not safety!
 * @author		: 黄攀
 * @created		: 2012-1-3
 */

package game.minipatapon.logger;

public class DefaultLogger implements Loggable {

	private static DefaultLogger defaultLogger;
	private static boolean enable = true;

	public static Loggable getDefaultLogger() {
		if (defaultLogger == null) {
			defaultLogger = new DefaultLogger();
			setInnerLogger(DefaultLogger.getInnerLogger());
			setEnable(true);
		}
	//	defaultLogger.log(0, " defaultLogger is on", " ");
		return defaultLogger;
	}

	private static Loggable innerLogger;

	public static Loggable getInnerLogger() {
		return innerLogger;
	}

	public static void setInnerLogger(Loggable logger) {
		innerLogger = logger;
	}

	private DefaultLogger() {

	}

	public static boolean isEnable() {
		return enable;
	}

	public static void setEnable(boolean enable) {
		DefaultLogger.enable = enable;
	}

	@Override
	public void log(String patten, Object... args) {
		if (DefaultLogger.isEnable() && DefaultLogger.getInnerLogger() != null) {
			DefaultLogger.getInnerLogger().log(patten, args);
		}
	}

	@Override
	public void log(int level, String patten, Object... args) {
		if (DefaultLogger.isEnable() && DefaultLogger.getInnerLogger() != null) {
			DefaultLogger.getInnerLogger().log(level, patten, args);
		}

	}

	@Override
	public void logWithSignature(Object sender, int level, String patten,
			Object... args) {
		if (DefaultLogger.isEnable() && DefaultLogger.getInnerLogger() != null) {
			DefaultLogger.getInnerLogger().logWithSignature(sender, patten,
					level, args);
		}

	}

	@Override
	public void logWithSignature(Object sender, String patten, Object... args) {
		if (DefaultLogger.isEnable() && DefaultLogger.getInnerLogger() != null) {
			DefaultLogger.getInnerLogger().logWithSignature(sender, patten,
					args);

		}
	}
}
