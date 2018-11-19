package standardClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class LoadProperties {
	   public static Properties stripeApiProperties = loadProperties("resources/properties/stripe-api-properties.properties");  
	   private static Properties loadProperties(String filePath) {  
	     Properties properties = new Properties();  
	     try {  
	       FileInputStream f = new FileInputStream(filePath);  
	       properties.load(f);  
	     } catch (FileNotFoundException e) {  
	       e.printStackTrace();  
	     } catch (IOException e) {  
	       e.printStackTrace();  
	     }  
	     return properties;  
	   }  
	   public static String getPropertyValue(String path, String key) {  
	     Properties p = loadProperties(path);  
	     String result = "";  
	     Set<String> values = p.stringPropertyNames();  
	     for (String value : values) {  
	       if (StringUtils.equalsIgnoreCase(value, key)) {  
	         result = p.getProperty(value);  
	         break;  
	       }  
	     }  
	     return result;  
	   } 
}
