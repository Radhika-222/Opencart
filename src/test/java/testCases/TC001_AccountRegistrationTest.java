package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.Logs;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration() {
		
		logger.info("**** Starting TC001_AccountingRegistartionTest ****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on myAccount link");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage ap=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		ap.setFirstName(randomString().toUpperCase());
		ap.setLastName(randomString().toUpperCase());
		ap.setEmail(randomString()+"@gmail.com");
		
		ap.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		ap.setPassword(password);
		ap.setConfirmPassword(password);
		
		ap.setPrivacyPolicy();
		ap.clickButton();
		
		logger.info("Validating expected message");
		String confmsg=ap.getConfirmMeggase();
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		logger.info("**** Finished TC001_AccountingRegistartionTest ****");
	}
	
	
}
