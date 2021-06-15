package whiteheadcrab.springframework.webtesting;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class searchFunctionalityCheck
{
	@Autowired
	private static WebDriver webDriver;

	@BeforeAll
	public static void setup()
	{
		//Setting up property for launching
		System.setProperty("webdriver.chrome.driver", "C:\\Projects\\e-pointTesting\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void checkSearchFunctionality()
	{
		this.webDriver.get("https://www.e-point.pl/");
		//Opening Page
		webDriver.findElement(By.xpath("//*[@id=\"component_1531088\"]/div[1]/span")).click();
		//Inputting required text
		webDriver.findElement(By.id("query")).sendKeys("test");
		//Selecting submit button
		webDriver.findElement(By.id("query")).sendKeys(Keys.ENTER);

		//Checking that Url for this page has "/wyniki-wyszukiwania?q=test"
		Boolean checkPage = webDriver.getCurrentUrl().contains("/wyniki-wyszukiwania?q=test");
		Assert.assertEquals(checkPage,true);

		//Checking which request has been performed
		//Selected checking by url ,due to fact that HTML architecture did not contact any values connected with inputted String value
		Boolean checkSeacrhRequest = webDriver.getCurrentUrl().contains("/wyniki-wyszukiwania?q=test");
		Assert.assertEquals(checkSeacrhRequest,true);

		//Check that search result appeared
		Boolean checkSearchResult  = webDriver.findElement(By.xpath("//*[@id=\"eps_site_search_1_27062019\"]/div[1]/div/div/div/div[2]/div/div/div")).isDisplayed();
		Assert.assertEquals(checkSeacrhRequest,true);


	}

}
