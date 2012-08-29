package au.com.uptick.gwt.maven.sample.test.stack;

// No se puede modificar esta clase
public class LogEntry {
	
	private final int timestamp;
	
	private final String methodName;
	
	private final boolean starting;

	public LogEntry(int timestamp, String methodName, boolean starting) {
		this.timestamp = timestamp;
		this.methodName = methodName;
		this.starting = starting;
	}
	
	public int getTimestamp() {
		return timestamp;
	}
	
	public boolean isStarting() {
		return starting;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
}
