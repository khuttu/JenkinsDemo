package organizationTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.GenericUtility.BaseClass;
import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.JavaUtility;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrgCreatePage;
import vTiger.ObjectRepository.OrgVerifyPage;
import vTiger.ObjectRepository.OrganizationPage;

public class ToCreateOrganizationTest extends BaseClass {

	@Test(groups="regression")
	public void tocreateOrgTest() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateorgicon().click();
		OrgCreatePage ocp = new OrgCreatePage(driver);
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtility jutil = new JavaUtility();
		String orgname = eutil.toReadDatafromExcelFile("Organization", 1, 2)+jutil.toGetRandomNumber();
	   ocp.getOrgname().sendKeys(orgname);
	   ocp.getSave().click();
	   OrgVerifyPage ovp = new OrgVerifyPage(driver);
	   String ORGNAME = ovp.getVerifyOrgName().getText();
	   Assert.assertTrue(ORGNAME.contains(orgname));
	}
}
