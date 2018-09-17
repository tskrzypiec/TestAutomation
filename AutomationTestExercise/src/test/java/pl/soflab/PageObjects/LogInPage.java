package pl.soflab.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import cucumber.api.DataTable;

public class LogInPage extends AbstractPage{
	

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	public LogInPage setEmailAndPassword(DataTable tableThree) 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<List<String>> dataLog = tableThree.raw();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(dataLog.get(1).get(1));
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(dataLog.get(2).get(1));
		return new LogInPage(driver);
	}
	
	public LogInPage setEmail(DataTable tableOne) {
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<List<String>> dataEmail = tableOne.raw();
		driver.findElement(By.id("email_create")).sendKeys(dataEmail.get(1).get(1));
		return new LogInPage(driver);
	}
	
	public CreateAnAccountPage clickOnCreateButton() {
		
		driver.findElement(By.id("email_create")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CreateAnAccountPage(driver);
	}
	public ConfirmAccountPage clickSignInButton()
	{
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		return new ConfirmAccountPage(driver);
	}
	
	
}
