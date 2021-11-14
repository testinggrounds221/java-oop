package reference;

import java.util.logging.*;

public class TestSimpleLogger {
	// Invoke the factory method to get a new Logger or return the existing Logger
	// of the fully-qualified class name.
	// Set to static as there is one logger per class.
	private static final Logger logger = Logger.getLogger(TestSimpleLogger.class.getName());

	public static void main(String[] args) {
		logger.info("Logging begins..."); // log INFO-level message

		try {
			// Simulating an Exception
			throw new Exception("Simulating an exception");
		}

		catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}
		logger.info("Done...");
	}
}