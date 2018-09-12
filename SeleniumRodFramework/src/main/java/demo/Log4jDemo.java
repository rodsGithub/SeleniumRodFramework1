package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	// Create an instance for logger class:
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {

		System.out.println("\n Start *** \n");
		
		logger.trace("This is a trace message");
		logger.info("This is information message");
		logger.error("This is error message");
		logger.warn("This is warning message");
		logger.fatal("This is fatal message");
		
		System.out.println("\n Completed");

	}

}
