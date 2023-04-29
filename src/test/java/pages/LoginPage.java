package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver pagedriver;
	
	@FindBy(id="user-name")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="login-button")
	WebElement Login;
	
	public LoginPage(WebDriver driver) {
		
		this.pagedriver = driver;
		PageFactory.initElements(pagedriver, this);
	}
	
	public void LoginFunction(String UserNameVal , String PwdVal) {
		
		UserName.sendKeys(UserNameVal);
		Password.sendKeys(PwdVal);
		Login.click();
	}

}
