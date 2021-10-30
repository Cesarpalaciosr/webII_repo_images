package cp.helpers;

import java.io.InputStream;
import java.util.Properties;
	
public class PropertiesReader {
		
		Properties prop = new Properties();
		
		public PropertiesReader() {
			System.out.println(getClass().getClassLoader().getResourceAsStream("config.properties"));
			try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties")) {
				prop.load(is);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public String getValue(String value) {
			return prop.getProperty(value);
		}
}
