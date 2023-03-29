package vtiger.ContactsTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRopository.ContactsInfoPage;
import vTiger.ObjectRopository.ContactsPage;
import vTiger.ObjectRopository.CreateNewContactPage;
import vTiger.ObjectRopository.CreateNewOrgnizationPage;
import vTiger.ObjectRopository.HomePage;
import vTiger.ObjectRopository.OrganizationInfoPage;
import vTiger.ObjectRopository.OrganizationsPage;

public class ContactsCreateWithOrganzation extends BaseClass {
        
	@Test(groups = { "SmokeSuite","Regration"})
	public void ContactsCreateWithOrganzationTest() throws IOException
	{
		

		/* Read data from excel sheet - Test data */
		String ORGNAME = efu.getDataFromExcelSheet("Contects", 4, 2) + ju.getRandom();
		String LASTNAME = efu.getDataFromExcelSheet("Contects", 4, 3);

		// Step 4: Click on Organizations link
		HomePage hp=new HomePage(driver);
		hp.clickOnorganizationlnk();
		Reporter.log(" Click on Organizations link Successful");
		
		// Step 5: Click on Create Organization look up image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickonCreateOrgLookupImg();
		Reporter.log("Click on Create Organization look up image Successful");

		// Step 6: Create Organization with mandatory details
		CreateNewOrgnizationPage cop=new CreateNewOrgnizationPage(driver);
		cop.createOrganization(ORGNAME);
		Reporter.log("Create Organization with mandatory details Successful");


		// Step 8: Validate for Organization
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String  orgHeader = oip.getOrgHeder();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader+"----Organization created----");
		
		// Step 9: Navigate to contacts Link
		hp.clickOncontactlnk();
		Reporter.log("Navigate to contacts Link Successful");
		
		// Step 10:Click on create contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookupImg();
		Reporter.log("Click on create contact look up image Successful");
		
		// Step 11: Create contact with mandatory fields and save
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.CreateNewContact(driver, LASTNAME, ORGNAME);
		Reporter.log("Click on create contact and Save Successful");

		
		// Step 16: Validate for Contacts
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		 String ContactHeader = cip.ContactHeaderText();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader+"----Contact created----");
	    
	}
	

}
