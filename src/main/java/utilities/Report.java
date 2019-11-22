package utilities;

import org.apache.log4j.Logger;

public class Report {

	private static Logger logger = Logger.getLogger(Report.class);
	
	public static void info(String message)
	{
		logger.info(message);
	}
	
	public static void error(String message)
	{
		logger.error(message);
	}
}
