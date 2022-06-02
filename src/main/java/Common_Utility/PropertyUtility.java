package Common_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility {

	public static Properties p;
	public static void intitalizeProperty(String path) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		p = new Properties();
		p.load(fis);
	}

	public static String getProperty(String key) {
		String value=p.getProperty(key);
		return value;
	}
	

}
