package de.chrissx.GameEngine.Logging;

import java.util.logging.Logger;

public class GameLogger {

	private LogType type;
	
	private Logger logger;
	
	public GameLogger(LogType type) {
		this.type = type;
		if(type == LogType.WINDOW) {
			logger = Logger.getLogger("de.chrissx.GameEngine.logging.LogWindow");
			logger.addHandler(WindowHandler.getInstance());
		}
	}
	
	public void log(String s) {
		if(type == LogType.WINDOW) {
			logger.info(s);
		}else {
			System.out.println(s);
		}
	}
	
	public void warn(String s) {
		if(type == LogType.WINDOW) {
			logger.warning(s);
		}else {
			System.out.println(s);
		}
	}
}
