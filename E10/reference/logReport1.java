package reference;

import java.util.logging.*;

class logReport1 {
	public static void main(String args[]) {
		try {
			LogManager lm = LogManager.getLogManager();
			LogManager lm2 = LogManager.getLogManager();

			Logger logger = Logger.getLogger("LoggingExample1");
			Logger logger2 = Logger.getLogger("LoggingExample1");

			FileHandler fh = new FileHandler("log_test.txt");

			lm.addLogger(logger);
			lm2.addLogger(logger2);

			logger.setLevel(Level.INFO);
			logger2.setLevel(Level.INFO);

			logger.addHandler(fh);
			logger2.addHandler(new FileHandler("log_tezt2.log"));

			fh.setFormatter(new XMLFormatter());

			logger.log(Level.INFO, "test 1");
			logger.log(Level.INFO, "test 2");
			logger.log(Level.INFO, "test 3");
			logger.log(Level.SEVERE, "TEST4");
			logger2.log(Level.INFO, "INFO msg");
			fh.close();
		} catch (Exception e) {
			System.out.println("Exception thrown: " + e);
		}
	}
}
