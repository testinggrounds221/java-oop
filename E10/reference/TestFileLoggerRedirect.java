package reference;

import java.io.*;
import java.util.logging.*;
 
public class TestFileLoggerRedirect {
   private static final Logger logger = Logger.getLogger(TestFileLoggerRedirect.class.getName());
 
   public static void main(String[] args) throws IOException {
      // Construct a default FileHandler.
      Handler fh = new FileHandler("test1.log", true);  // append is true
      fh.setFormatter(new SimpleFormatter());  // Set the log format
      // Add the FileHander to the logger.
      logger.addHandler(fh);
      // Set the logger level to produce logs at this level and above.
      logger.setLevel(Level.FINE);
 
      // Redirecting System.out and System.err
      PrintStream outPS = new PrintStream(new BufferedOutputStream(
            new FileOutputStream("test1.log", true)));  // append is true
      System.setErr(outPS);    // redirect System.err
      System.setOut(outPS);
 
      try {
         // Simulating Exceptions
         throw new Exception("Simulating an exception");
      } catch (Exception ex){
         logger.log(Level.SEVERE, ex.getMessage(), ex);
      }
      logger.info("This is a info-level message");
      logger.config("This is a config-level message");
      logger.fine("This is a fine-level message");
      logger.finer("This is a finer-level message");
      logger.finest("This is a finest-level message");  // below the logger's level
 
      System.out.println("Writing to System.out");
      System.err.println("Writing to System.err");
   }
}