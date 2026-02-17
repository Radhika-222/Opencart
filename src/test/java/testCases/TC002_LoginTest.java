package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity", "Master"})
	public void verify_login() {
		
		logger.info("****Starting tc002_LoginTest****");
		
		try {
		//homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login page
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clkLogin();
		
		//My account page
		MyAccountPage mp=new MyAccountPage(driver);
		boolean targetPage=mp.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true);
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("****Finished tc002_LoginTest****");
		
		
	}

}
