package game.minipatapon.logger;

public class WatcherLogger extends LoggerBase {

	String[] ignoredClassNames = null;
	


	public WatcherLogger() {
		// TODO Auto-generated constructor stub
		
		this.ignoredClassNames = new String[2];
		this.ignoredClassNames[0] = "LoggerBase";
		this.ignoredClassNames[1] = "DefaultLogger";
		
		
	}

	
	@Override
	protected void writeMessage(String msg) {
		// TODO Auto-generated method stub
		
		WatcherLogger.log( ignoredClassNames, msg );
		
	}
	
	
	/**
	 * Get string signature of current executing line.
	 * 
	 * @return
	 */
	public static String getSignature() {
		StackTraceElement trace = getCaller(null);
		String signature = getSignature(trace);
		return signature;
	}

	/**
	 * Get the signature of stack trace conforming to eclipse error parser.
	 * 
	 * @return
	 */
	protected static String getSignature(StackTraceElement trace) {
		String classNameParts[] = trace.getClassName().split("\\.");
		String className = classNameParts[classNameParts.length - 1];
		String signature = className + "." + trace.getMethodName();
		signature += "(" + trace.getFileName() + ":" + trace.getLineNumber()
				+ ")";
		return signature;
	}

	/**
	 * Get the caller by scanning the stack trace. Ignores this class and
	 * classes provided by caller.
	 * 
	 * @return
	 */
	protected static StackTraceElement getCaller(String pIgnoredClassNames[]) {
		String thisClassName = WatcherLogger.class.getSimpleName();
		StackTraceElement[] traces = new Throwable().getStackTrace();
		for (StackTraceElement trace : traces) {
			String traceClassName = trace.getClassName();
			//if( pIgnoredClassNames == null )
			//	System.out.println( traceClassName );
			boolean found = isTargetTrace(traceClassName, thisClassName,
					pIgnoredClassNames);
			if (found)
				return trace;
		}
		return null;
	}

	/**
	 * Part of trace scanning to determine if the trace is to be ignored.
	 * 
	 * @param traceClassName
	 * @param pWatcherName
	 * @param pIgnoredClassNames
	 * @return
	 */
	private static boolean isTargetTrace(String traceClassName,
			String pWatcherName, String pIgnoredClassNames[]) {
		if (traceClassName.endsWith(pWatcherName) == true)
			return false;
		if (traceClassName.contains("$") == true)
			return false;
		if (pIgnoredClassNames == null)
		{
			return true;
		}
			
		for (String ignoredClassName : pIgnoredClassNames) {
			
			if (traceClassName.endsWith(ignoredClassName) == true)
				return false;
		}
		return true;
	}

	/**
	 * log executing class name, method name and line number.
	 */
	public static void log() {
		log(null);
		System.err.println();
	}

	/**
	 * log a message with executing class name, method name and line number.
	 * 
	 * @param pMessage
	 */
	public static void log(String pMessage) {
		log(null, pMessage);
	}

	/**
	 * Log a message ignoring a number of classes in the stack.
	 * 
	 * @param pIgnoredClassNames
	 * @param pMessage
	 */
	public static void log(String pIgnoredClassNames[], String pMessage) {
		StackTraceElement trace = getCaller(pIgnoredClassNames);
		String signature = getSignature(trace);
		System.err.print(signature);
		if (pMessage == null)
			return;
		System.err.println(" [" + pMessage + "]");
	}

}
