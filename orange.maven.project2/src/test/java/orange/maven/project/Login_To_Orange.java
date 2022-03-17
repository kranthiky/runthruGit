package orange.maven.project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.orangeHRM.BaseClass.Base_Orange;

public class Login_To_Orange extends Base_Orange{

	public String appUrl = "https://opensource-demo.orangehrmlive.com"; 
	
	@Test(enabled = true, priority =1)
	public void launchApplication() {
		setup_Browser();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(enabled = true, priority =2)
	public void loginToApplication() throws InterruptedException {
		String userName = "Admin";
		String password = "admin123";
		
		WebElement elm_userName = driver.findElement(By.id("txtUsername"));
		WebElement elm_password = driver.findElement(By.id("txtPassword"));
		WebElement btn_Login = driver.findElement(By.id("btnLogin"));		
				
		elm_userName.sendKeys(userName);
		elm_password.sendKeys(password);
		btn_Login.click();
		
		Thread.sleep(3000);
		Assert.assertEquals(appUrl+"/index.php/dashboard", driver.getCurrentUrl(),"something wrong logging in..!");
				
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(appUrl+"/index.php/leave/applyLeave", driver.getCurrentUrl(),"Apply leave is NOT launched..!");

	}
	
}
