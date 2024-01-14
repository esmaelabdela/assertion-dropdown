package variousConcept;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class LearnDropdown {

	WebDriver driver;

	// Store WebElemenet BY CLASS
	By USERNAME_FIELD = By.xpath("//input[@id='user_name']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGNIN_BUTTON_FIELD = By.xpath("//button[@id='login_submit']");
	By DASHBOARD_HEADER_FIELD = By.xpath("//span[contains(text() ,'Dashboard')]");
	By CUSTOMER_MENUE_FIELD = By.xpath("//span[text()='Customers']");
	By ADD_CUSTOMER_FIELD = By.xpath("//span[text() = 'Add Customer']");
	By NEW_CUSTOMER_HEAD_FIELD = By.xpath("//strong[contains(text(), 'New Customer')]");
	By FULL_NAME_FIELD = By.xpath("//input[@name='name']");
	By COMPANY_NAME_DROPDOWN_FIELD = By.xpath("//select[@name='company_name']");
	By EMAIL_FIELD = By.xpath("//input[@name='email']");
	By PHONE_FIELD = By.xpath("//input[@id='phone']");
	By ADDRESS_FIELD = By.xpath("//input[@name='address']");
	By CITY_FIELD = By.xpath("//input[@name='city']");
	By ZIP_CODE_FIELD = By.xpath("//input[@id='port']");
	By COUNTRY_NAME_DROPDOWN_FIELD = By.xpath("//select[@name='country']");
	By GROUP_NAME_DROPDOWN_FIELD = By.xpath("//select[@id='customer_group']");
	By SAVE_BUTTON_FIELD = By.xpath("//button[@id='save_btn']");

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest2() {
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();

		// validation
		Assert.assertTrue("dashboard is not available", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
		
//		Assert.assertEquals("dashboard is not available", "Codefios", driver.getTitle());
//		System.out.println(driver.getTitle());
//		
//	    Assert.assertEquals("dashboard is not available", "Dashboard", driver.findElement(DASHBOARD_HEADER_FIELD).getText());

	}

	//@Test
	public void addCustomer() throws InterruptedException {
		loginTest2();
		driver.findElement(CUSTOMER_MENUE_FIELD).click();
		driver.findElement(ADD_CUSTOMER_FIELD).click();
		Assert.assertTrue("add customer page not available", driver.findElement(NEW_CUSTOMER_HEAD_FIELD).isDisplayed());
		Assert.assertEquals("add customer page not available", "New Customer", driver.findElement(NEW_CUSTOMER_HEAD_FIELD).getText());
		Thread.sleep(2000);
		driver.findElement(FULL_NAME_FIELD).sendKeys("ESMAEL ABDELA");

		Select sel = new Select(driver.findElement(COMPANY_NAME_DROPDOWN_FIELD));
		sel.selectByVisibleText("Techfios");
		
		//To Print ALL dropDown Lists
		List<WebElement> availableCompanys = sel.getOptions();
		for (WebElement e : availableCompanys ) {
		System.out.println(e.getText());
		}
 
		driver.findElement(EMAIL_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PHONE_FIELD).sendKeys("9363548264");
		driver.findElement(ADDRESS_FIELD).sendKeys("3551 wilshire way");
		driver.findElement(CITY_FIELD).sendKeys("Richardson");
		driver.findElement(ZIP_CODE_FIELD).sendKeys("75082");

		Select sel1 = new Select(driver.findElement(COUNTRY_NAME_DROPDOWN_FIELD));
		sel1.selectByVisibleText("United States of America");

		Select sel2 = new Select(driver.findElement(GROUP_NAME_DROPDOWN_FIELD));
		sel2.selectByVisibleText("Selenium");
	}
		// driver.findElement(SAVE_BUTTON_FIELD).click();

		

//	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
