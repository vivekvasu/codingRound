package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtils {

	/**
	 * This method is to read the properties file
	 * 
	 * @param filePath - Path of the property file
	 * @return - The property file
	 */
	public static Properties readPropertyFile(String filePath)
	{
		Report.info("Entered method::readPropertyFile with '" + filePath + "'");
		FileInputStream input = null;
		Properties properties = null;
		try {
			input = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(input);
			input.close();
		}
		catch (Exception e) {
			Report.info("Exception: " + e.getMessage());
		}
		return properties;
	}
}
