package whiteheadcrab.springframework.webtesting;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;


@SpringBootTest
public class siteCheck
{
    @Autowired
    private static WebDriver webDriver;

    @BeforeAll
    public static void setup()
    {
        //Setting up property for launching webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\e-pointTesting\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test()
    public void getHomePage()
    {
        this.webDriver.get("https://www.e-point.pl/");
        String title = webDriver.getTitle();
        //Checking opening
        Assert.assertEquals(title,"Strona główna | e-point SA");
    }
}
