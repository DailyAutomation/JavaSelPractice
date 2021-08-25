package selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SortOrderCheck {
	@Test
	public void myFunction() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.co.in");
		// scrape price elements
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='find_prices']"));

		// extract the prices from the price elements and store in a List
		List<String> prices = new ArrayList<String>();
		for (WebElement e : price) {
			prices.add(e.getText());
		}

		// make a copy of the list
		List<String> sortedPrices = new ArrayList<String>(prices);

		// sort the list
		Collections.sort(sortedPrices);

		// true if the prices are sorted
		System.out.println(sortedPrices.equals(prices));
		driver.quit();
	}

}
