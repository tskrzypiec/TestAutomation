package pl.soflab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends AbstractPage {

	//private final By signInButton = By.xpath("//a[@title='Log in to your customer account']");
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public LogInPage navigateToLogInButton() {
			driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();	
		return new LogInPage(driver);
	}

}