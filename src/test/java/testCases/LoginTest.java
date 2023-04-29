package testCases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void InvalidLogin(Method method) throws FilloException {
		
		Recordset rs = connection.executeQuery("Select * from data where TestName='" + method.getName() + "'" );
		rs.next();
		
		String UserName = rs.getField("UserName");
		String Password = rs.getField("Password");
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);
		
		WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
		String ActualError = error.getText();
		String ExpectedError = "Epic sadface: Username and password do not match any user in this service";
		
		Assert.assertEquals(ActualError, ExpectedError);
		
		
	}
	
	@Test
	public void ValidLogin(Method method) throws FilloException, InterruptedException {
		
		Recordset rs = connection.executeQuery("Select * from data where TestName='" + method.getName() + "'" );
		rs.next();
		
		String UserName = rs.getField("UserName");
		String Password = rs.getField("Password");
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);
		
		Thread.sleep(1000);
		
		
		
	}
	
	
	
	

}
