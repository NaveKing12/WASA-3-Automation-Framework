package practice;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRopository.CreateNewOrgnizationPage;
import vTiger.ObjectRopository.HomePage;
import vTiger.ObjectRopository.OrganizationInfoPage;
import vTiger.ObjectRopository.OrganizationsPage;

public class CreateMultipleWithOrgIndustryTest extends BaseClass {
	
	@Test(dataProvider="getData")
	public void createMultipleOrg(String Orgname, String industryType) {
		
		String ORGNAME = Orgname+ju.getRandom();

	    HomePage hp=new HomePage(driver);
		hp.clickOnorganizationlnk();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickonCreateOrgLookupImg();
		
		CreateNewOrgnizationPage cnop=new CreateNewOrgnizationPage(driver);
		cnop.createOrganization(ORGNAME, industryType);
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeder = oip.getOrgHeder();
		Assert.assertTrue(orgHeder.contains(ORGNAME));
		
		
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
	    Object[][] data=efu.readMultipleData("Multiple");
		return data;
	}
}



