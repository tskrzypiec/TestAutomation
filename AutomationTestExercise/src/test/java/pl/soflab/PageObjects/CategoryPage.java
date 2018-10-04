package pl.soflab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CategoryPage extends AbstractPage {

	public CategoryPage(WebDriver driver) {
		super(driver);
	}

	public ProductPage chooseQuantityAndSize() throws InterruptedException {
		
		 Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
			// Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("2");
			// Thread.sleep(2000);
			Select sizePick = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
			Thread.sleep(2000);
			sizePick.selectByValue("3");
		
		return new ProductPage(driver);
	}
	
}

	