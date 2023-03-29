package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//Step 1: open the file in java readable
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\commandata.properties");
		
		//Step 2: Create object of properties from java.util.package
		Properties pobj=new Properties();
		
		//Step 3: Load fileInputStream into Properties
		pobj.load(fis);
		
		//Step 4: Access the value with keys
		String Url=pobj.getProperty("url");
		String Username=pobj.getProperty("username");
		
		System.out.println(Url);
		System.out.println(Username);
	}

}
