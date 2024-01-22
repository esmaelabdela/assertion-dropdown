package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnLocator {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://objectspy.space/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testLocators() {

		driver.findElement(By.id("sex-1")).click();
		driver.findElement(By.name("firstname")).sendKeys("selenium");

		// To upload File
		// if the tag is INPUT use sendkeys()
		// any other tag than INPUT use Robot class
		// we need location path including fileName with its extension
		driver.findElement(By.className("input-file")).sendKeys("C:\\Users\\sitra\\Documents\\session11\\data1\\myExcel.xlsx");
		// link Text element locator
		driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
		// to go back to the page we have been
		driver.navigate().back();
		// Partial link Text element locator
		driver.findElement(By.partialLinkText("OS-API")).click();
		driver.navigate().back();
		// cssSelector element locator method-1
		// TagName#Value
		driver.findElement(By.cssSelector("input#profession-1")).click();
		// cssSelector method-2.
		// TagName.Value

		// cssSelector method-3.
		// TagName[attribute= 'value']
		driver.findElement(By.cssSelector("input[id=tool-2]")).click();
		// cssSelector method-4.
		// TagName.class[attribute = 'value']
		driver.findElement(By.cssSelector("input[name=tool][id=tool-2]")).click();
		// cssSelector method-5.
		// TagName[href$='value']
		//driver.findElement(By.cssSelector("a[href$='http://www.objectspy.space']")).click();

		////// Absolute xpath method
		driver.findElement(By.xpath("html/body/div/div[2]/div[2]/form/div[10]/input")).sendKeys("yesuf");

		///// Relative xpath methods ========  //Tag[@Attribute Node='Value']
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("1234");
//
//		// Tag[@ Attribute Node ='Value' and @ Attribute Node ='Value' ]
//		driver.findElement(By.xpath("//input[@name='Password'and@type='password']")).sendKeys("abcd33333333");
//
//		// Xpath for links/text-1:   //Tag[text()='Value"]
//		driver.findElement(By.xpath("//strong[text()='Link Test : Page Change']")).click();
		
//		// Xpath for links/text-2: //   Tag[contains(text(), 'Value')]
//		// driver.findElement(By.xpath("//strong[contains(text(),'Link Test : Page Change')]")).click();

	}

}
