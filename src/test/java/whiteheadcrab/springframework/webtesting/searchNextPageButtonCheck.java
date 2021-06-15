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

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class searchNextPageButtonCheck
{
    @Autowired
    private static WebDriver webDriver;

    @BeforeAll
    public static void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\e-pointTesting\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkNextPageFunctionality() throws InterruptedException
    {
        //Opening Page
        this.webDriver.get("https://www.e-point.pl/");
        webDriver.findElement(By.xpath("//*[@id=\"component_1531088\"]/div[1]/span")).click();
        //Inputting required text
        webDriver.findElement(By.id("query")).sendKeys("test");
        //Selecting submit button
        webDriver.findElement(By.id("query")).sendKeys(Keys.ENTER);
        //Selecting next page button
        webDriver.findElement(By.xpath("//*[@id=\"eps_site_search_1_27062019\"]/div[1]/div/div/div/div[2]/div/div/div/div/div[11]/div/div/div[2]")).click();

        //Checking that Url for this page has "/wyniki-wyszukiwania?q=test"
        Boolean checkPage = webDriver.getCurrentUrl().contains("/wyniki-wyszukiwania?q=test");
        Assert.assertEquals(checkPage,true);

        //Checking which request has been performed
        //Selected checking by url ,due to fact that HTML architecture did not contact any values connected with inputted String value
        Boolean checkSeacrhRequest = webDriver.getCurrentUrl().contains("/wyniki-wyszukiwania?q=test");
        Assert.assertEquals(checkSeacrhRequest,true);

        //Checking values between first page and second page
        //Add sleep function to avoid gathering results form page 1
        TimeUnit.SECONDS.sleep(5);
        String checkValueReqest = webDriver.findElement(By.xpath("//*[@id=\"eps_site_search_1_27062019\"]/div[1]/div/div/div/div[2]/div/div/div/div/div[1]/div/table/tbody/tr/td/div[1]/a")).getText();
        String previousValue = "Jak TDD obniża koszty: case study | e-point SA";
        Assert.assertNotEquals(checkValueReqest,previousValue);
    }
}
