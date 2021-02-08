package ec.com.dinersclub.dddmodules.application.logs;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.quarkiverse.loggingjson.providers.KeyValueStructuredArgument.kv;

@ApplicationScoped
public class Logging implements ILogging {
	
	private static final Logger logger = LoggerFactory.getLogger(Logging.class);
	
	public void debug(String message, Object data) {
		logger.debug(message, kv("custom", data));
	}
	
	public void info(String message, Object data) {
		logger.info(message, kv("custom", data));
	}

	@Override
	public void warn(String message, Object data) {
		logger.warn(message, kv("custom", data));
		
	}

	@Override
	public void error(String message, Object data) {
		logger.error(message, kv("custom", data));
	}
}
