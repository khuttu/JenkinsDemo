package contactTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtility.BaseClass;
import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.ObjectRepository.ContactsCreatePage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.ContactsVerifyPage;
import vTiger.ObjectRepository.HomePage;
@Listeners(vTiger.GenericUtility.ListenersImplementation.class)
public class ToCreateContactTest extends BaseClass {
    @Test(groups="smoke")
	public void toCreateContactTest_001() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontactsicon().click();
		
		ExcelFileUtility eutil = new ExcelFileUtility();
		String lastname = eutil.toReadDatafromExcelFile("Contacts", 1, 2);
		
		ContactsCreatePage ccp = new ContactsCreatePage(driver);
		ccp.getLastname().sendKeys(lastname);
		ccp.getSave().click();
		//fail
		Assert.fail();//to take screenshot if TC fails
		ContactsVerifyPage cvp = new ContactsVerifyPage(driver);
		String LASTNAME = cvp.getContacttitle().getText();
		if(LASTNAME.contains(lastname)) {
			System.out.println(lastname+" ---passed");
		}
		else System.out.println(lastname+"-- failed");
		
	}
}
