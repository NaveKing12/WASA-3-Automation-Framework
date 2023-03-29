package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProiversPractic {
	
	@Test(dataProvider="Phones")
	public void dataProviders(String phone,int price)
	{
		System.out.println(phone+"-----"+price);
	}
	@DataProvider(name="Phones")
	public Object[][] getData()
	{                           //row,cell
		Object[][] data=new Object[3][2];
		
		data[0][0]="Iphone";
		data[0][1]=20000;
		
		data[1][0]="Realme";
		data[1][1]=10000;
		
		data[2][0]="Sumsung";
		data[2][1]=15000;
		
		return data;
	}
}
