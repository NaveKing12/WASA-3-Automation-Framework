package vTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;
/**
 * This class contains all the generic method related to Java
 * @author Naveen
 *
 */
public class JavaUtility {
	
	/**
	 * 
	 * @return
	 */
	public String getSystemDate() {
		Date d=new Date();
		return d.toString();
	}
	
	/**
	 * This method will provide the system date in specific format
	 * @return
	 */
	public String getSystemInFormat() {
		
		Date d=new Date();
		String date[]=d.toString().split("");
		String month=date[1];
		String date1=date[2];
		String time=date[3].replace(":", "-");
		String year=date[5];
		
		String finaldate=date1+" "+month+" "+year+" "+time;
		return finaldate;
	}
	public int getRandom() {
		Random r=new Random();
		return r.nextInt(1000);
	}
}
