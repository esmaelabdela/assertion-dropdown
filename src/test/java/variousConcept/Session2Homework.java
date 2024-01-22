package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Session2Homework {

	
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://qa.codefios.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}	
		
	@Test
	public void loginAndForm() throws InterruptedException  {

		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("demo1@codefios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@id='login_submit']")).click();
        Thread.sleep(3000);
        
//		driver.findElement(By.xpath("//span[text()='Bank & Cash']")).click();
//		driver.findElement(By.cssSelector("a[href$='https://techfios.com/billing/?ng=accounts/add/']")).click();
//
//		// filling the form
//		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Sitra yeshaw");
//		driver.findElement(By.xpath("//input[@id='description'and @type='text']")).sendKeys("checking");
//		driver.findElement(By.xpath("//input[@id='balance']")).sendKeys("888888");
//		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys("987654");
//		driver.findElement(By.cssSelector("input#contact_person")).sendKeys("mohammed");
//		driver.findElement(By.cssSelector("input[id='contact_phone']")).sendKeys("9364328909");
//		driver.findElement(By.cssSelector("input#ib_url")).sendKeys("www.xyz.com");
//    //	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

	}
	
	
	
}
