package vtiger.OrgnizationTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRopository.CreateNewOrgnizationPage;
import vTiger.ObjectRopository.HomePage;
import vTiger.ObjectRopository.OrganizationInfoPage;
import vTiger.ObjectRopository.OrganizationsPage;
@Listeners(vTiger.GenericUtilities.ListenersImplementation.class)
public class CreateOrgnization extends BaseClass{
     
	@Test(groups = "SmokeSuite")
	public void CreateOrgnizationTest () throws IOException{
		
		String ORGNAME = efu.getDataFromExcelSheet("Orgnization", 4, 2)+ju.getRandom();		
		
		HomePage hp=new HomePage(driver);
		hp.clickOnorganizationlnk();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickonCreateOrgLookupImg();
		
		CreateNewOrgnizationPage cnop=new CreateNewOrgnizationPage(driver);
		cnop.createOrganization(ORGNAME);
		
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeder();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader+"---Orgnization created---");
	}
	@Test
	public void Demo() {
		HomePage hp=new HomePage(driver);
		hp.clickOnorganizationlnk();
		
	}
}
