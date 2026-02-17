package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	
	//constructor
	public AccountRegistrationPage(WebDriver driver ) {
		super(driver);
		
	}
	
	//locators
	@FindBy(xpath="//input[@name='firstname']") 
	WebElement txtfirstName;
	
	@FindBy(xpath="//input[@name='lastname']") 
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@name='email']") 
	WebElement txtemail;
	
	@FindBy(xpath="//input[@name='telephone']") 
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@name='password']") 
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='confirm']") 
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']") 
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@type='submit']") 
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//methods
	
	public void setFirstName(String fname) {
		txtfirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String cpwd) {
		txtConfirmPassword.sendKeys(cpwd);
	}
	
	public void setPrivacyPolicy() {
		chkPolicy.click();
	}
	
	public void clickButton() {
		btnContinue.click();
	}
    public String getConfirmMeggase() {
    	try {
    		return(msgConfirmation.getText());
    	} catch(Exception e) {
    		return(e.getMessage());
    	}
    }
	
    
    
    //Your Account Has Been Created!
	
	
	
	

}
