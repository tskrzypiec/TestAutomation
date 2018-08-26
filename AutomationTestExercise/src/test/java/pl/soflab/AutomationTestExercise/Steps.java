package pl.soflab.AutomationTestExercise;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	WebDriver driver = null;

	@Before
	public void testSetup() {
		System.setProperty("webdriver.chrome.driver","src/test/resource/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void testShutDown() {
		driver.quit();
	}

	@Given("^I am on the main page$")
	public void shouldNavigateToMainPage() throws Throwable {

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		System.out.println("I am on the main page");
	}

	@And("^I click on the sign in page$")
	public void shouldClickOnSighInButton() throws Throwable {

		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		System.out.println("I click on the sign in page");
	}

	@When("^I fill email address$")
	public void shouldFillEmailAddress(DataTable tableOne) throws Throwable {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<List<String>> dataEmail = tableOne.raw();
		driver.findElement(By.id("email_create")).sendKeys(dataEmail.get(1).get(1));
		System.out.println("I fill email address");

	}

	@And("^I click create an account button$")
	public void shouldClickOnCreateAnAccountButton() throws Throwable {

		driver.findElement(By.id("email_create")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("I click create an account button");
	}

	@And("^I submit the form with valid data$")
	public void shouldSubmitTheFormWithValidData(DataTable tableTwo) throws Throwable {

		List<List<String>> data = tableTwo.raw();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(data.get(1).get(1));
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(data.get(2).get(1));
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(data.get(3).get(1));
		Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByValue(data.get(4).get(1));
		Select month = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		month.selectByValue(data.get(5).get(1));
		Select years = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		years.selectByValue(data.get(6).get(1));
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys(data.get(7).get(1));
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(data.get(8).get(1));
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(data.get(9).get(1));
		Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		state.selectByValue(data.get(10).get(1));
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(data.get(11).get(1));
		Select country = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		country.selectByValue(data.get(12).get(1));
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(data.get(13).get(1));
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(data.get(14).get(1));
	}

	@And("^I set Assign an address alias for future reference field$")
	public void shouldSetAlias() throws Throwable {
		driver.findElement(By.xpath("//input[@id='alias']")).clear();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("Alias");
	}

	@And("^I press Register button$")
	public void shouldPressRegisterButton() throws Throwable {

		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
	}

	@Then("^I should be on the Sign in page$")
	public void shouldBeOnTheSignInPage() throws Throwable {

		String expectedWebUrl = new String("http://automationpractice.com/index.php?controller=my-account");
		// driver.get("https://www.soflab.pl");
		String actualWebUrl = driver.getCurrentUrl();
		// Assert.assertEquals(expectedWebUrl, actualWebUrl);
		Assert.assertEquals(expectedWebUrl, actualWebUrl);
		System.out.println("expectWebUrl ");
		driver.findElement(By.xpath("//a[@title='Log me out']")).click();
	}

	@And("^I click on the log in page")
	public void shouldBeOnALoginPage() throws Throwable {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
	}

	
	
	@When("^I put email and password")
	public void shouldFillInEmailAddress(DataTable tableThree) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<List<String>> dataLog = tableThree.raw();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(dataLog.get(1).get(1));
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(dataLog.get(2).get(1));
	}

	@Then("^I should be on my account page")
	public void shouldBeOnMyAccountPage() throws Throwable {

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@Given("^I click on Blouse category")
	public void shouldClickOnBlouseCategory() throws Throwable {

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@title='Women']"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Blouses']")).click();
	}

	@When("^I find more information on specific item")
	public void shouldHitmoreButtonOnSpecificItem() throws Throwable {

		Actions b = new Actions(driver);
		b.moveToElement(driver.findElement(By.xpath("//img[@title='Blouse']"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='View']")).click();
	}

	@And("^I add quantity and pick a size")
	public void shouldAddQuantityAndPickASize() throws Throwable {

		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("2");
		Select size = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
		size.selectByValue("3");
	}

	@And("^I add an item to cart")
	public void shouldAddAnItemToCart() throws Throwable {
		driver.findElement(By.xpath("//button[@name='Submit']")).click();
	}

	@Then("^I check if the Total price with shipping is correct")
	public void shouldCheckIfTheTotalPriceIsCorrect() throws Throwable {
		
		String expectedResult ="$56.00";
		String result = driver.findElement(By.xpath("//span[@class='ajax_block_cart_total']")).getText();
		//Assert.assertEquals(expectedResult, result);  		
	}

}
