package ec.com.dinersclub.dddmodules.application.logs;

public interface ILogging {
	
	void info(String message, Object data);
	void warn(String message, Object data);
	void error(String message, Object data);

}
