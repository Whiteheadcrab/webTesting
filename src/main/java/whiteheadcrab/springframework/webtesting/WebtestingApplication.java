package whiteheadcrab.springframework.webtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class WebtestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebtestingApplication.class, args);
	}

	@Bean
	public WebDriver webDriver()
	{
		return new InternetExplorerDriver();
	}

}
