package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnAssersion {

	WebDriver driver;

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
	public void loginTest() {

		// store WebElement
//		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@id='user_name']"));
//		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
//		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@id='login_submit']"));
//		
//        
//		USERNAME_ELEMENT.sendKeys("demo@codefios.com");
//		PASSWORD_ELEMENT.sendKeys("abc123");
//		SIGNIN_BUTTON_ELEMENT.click();

		// store BY CLASS
		By USERNAME_FIELD = By.xpath("//input[@id='user_name']");
		By PASSWORD_FIELD = By.xpath("//input[@id='password']");
		By SIGNIN_BUTTON_FIELD = By.xpath("//button[@id='login_submit']");
		By DASHBOARD_HEADER_FIELD = By.xpath("//strong[text()='Dashboard']");

		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();

//		boolean DashboardHeaderSatatus;
//		try {
//			WebElement DASHBOARD_HEADER_ELEMENT = driver
//				.findElement(By.xpath("//strong[text()='Dashboard']"));
//			DashboardHeaderSatatus = true;
//		} catch (Exception e) {
//			DashboardHeaderSatatus = false;
//			e.printStackTrace();
//		}
//		 Assert.assertTrue("DashBoard Page NOt Found!!", DashboardHeaderSatatus);
		
        	WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(DASHBOARD_HEADER_FIELD);
            Assert.assertTrue("DashBoard Page NOt Found!!", DASHBOARD_HEADER_ELEMENT.isDisplayed());
		

	}
}
