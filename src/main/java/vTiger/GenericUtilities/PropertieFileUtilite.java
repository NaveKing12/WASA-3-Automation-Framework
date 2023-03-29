package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class conceder of Generic method to read data from properties file
 * @author Naveen
 *
 */
public class PropertieFileUtilite {
	/**
	 * This method will read data from properties file
	 * @param key
	 * @return
	 * @throws IOException 
	 * @throw IOException
	 */
	public String readDataFromPropertiesFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream(IConstentsUtilitie.propertiesFilepath);
	Properties pobj=new Properties();
	pobj.load(fis);
	String value=pobj.getProperty(key);
	return value;
	}
}