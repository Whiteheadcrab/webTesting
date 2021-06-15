package whiteheadcrab.springframework.webtesting;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class searchIconCheck
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
    public void getSearchPage()
    {
        this.webDriver.get("https://www.e-point.pl/");
        webDriver.findElement(By.xpath("//*[@id=\"component_1531088\"]/div[1]/span")).click();
        boolean checkSeacrh = webDriver.findElement(By.xpath("/html/body/div[1]/div")).isDisplayed();
        Assert.assertEquals(checkSeacrh,true);
    }
}
