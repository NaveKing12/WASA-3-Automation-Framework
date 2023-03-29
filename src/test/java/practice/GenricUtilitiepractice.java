package practice;

import java.io.IOException;

import vTiger.GenericUtilities.PropertieFileUtilite;

public class GenricUtilitiepractice {

	public static void main(String[] args) throws IOException {
		PropertieFileUtilite pfu=new PropertieFileUtilite();
		String Url=pfu.readDataFromPropertiesFile("url");
		System.out.println(Url);
	}

}
