package selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EquitySearch {

	public static void main(String[] args) throws InterruptedException {

		List<String> webURLsList = new ArrayList<>(
				Arrays.asList("https://in.investing.com/equities/niit-technologies-ltd-chart",
						"https://in.investing.com/equities/infosys-chart",
						"https://in.investing.com/equities/divis-laboratories-chart",
						"https://in.investing.com/equities/tata-steel-chart",
						"https://in.investing.com/equities/apollo-hospitals-chart",
						"https://in.investing.com/equities/jubilant-foodworks-chart",
						"https://in.investing.com/equities/gland-pharma-chart",
						"https://in.investing.com/equities/tata-consultancy-services-chart",
						"https://in.investing.com/equities/bajaj-auto-chart",
						"https://in.investing.com/equities/asian-paints-chart",
						"https://in.investing.com/equities/mphasis-chart",
						"https://in.investing.com/equities/indian-railway-catering-and-tourism-chart",
						"https://in.investing.com/equities/hindustan-unilever-chart",
						"https://in.investing.com/equities/eicher-motors-chart",
						"https://in.investing.com/equities/deepak-nitrite-ltd-chart",
						"https://in.investing.com/equities/boc-india-chart",
						"https://in.investing.com/equities/reliance-industries-chart",
						"https://in.investing.com/equities/polycab-india-ltd-chart",
						"https://in.investing.com/equities/shriram-city-union-finance-ltd-chart",
						"https://in.investing.com/equities/indigo-paints-pvt-chart",
						"https://in.investing.com/equities/colgate-palmolive-(india)-chart",
						"https://in.investing.com/equities/larsen---toubro-chart",
						"https://in.investing.com/equities/godrej-properties-chart",
						"https://in.investing.com/equities/icici-bank-ltd-chart",
						"https://in.investing.com/equities/rbl-bank-ltd-chart",
						"https://in.investing.com/equities/hdfc-bank-ltd-chart",
						"https://in.investing.com/equities/indusind-bank-chart",
						"https://in.investing.com/equities/kotak-mahindra-bank-chart",
						"https://in.investing.com/equities/hcl-technologies-chart",
						"https://in.investing.com/equities/au-small-finance-bank-ltd-chart",
						"https://in.investing.com/equities/havells-india-chart",
						"https://in.investing.com/equities/dr-reddys-laboratories-chart",
						"https://in.investing.com/equities/tata-consultancy-services-chart",
						"https://in.investing.com/equities/mindtree-chart",
						"https://in.investing.com/equities/hero-motocorp-chart",
						"https://in.investing.com/equities/titan-industries-chart",
						"https://in.investing.com/equities/piramal-healthcare-chart",
						"https://in.investing.com/equities/route-mobile-ltd-chart",
						"https://in.investing.com/equities/clean-science-and-technology-chart",
						"https://in.investing.com/equities/multi-commodity-exchange-of-india",
						"https://in.investing.com/equities/happiest-minds-technologies-ltd-chart",
						"https://in.investing.com/equities/pvrl-chart"
						));

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
		WebDriver driver = new ChromeDriver(options);

		driver.get(webURLsList.get(0));
		((JavascriptExecutor) driver).executeScript("return document.readyState");

		List<WebElement> links = driver.findElements(By.tagName("iframe"));
		for (WebElement e : links) {
			System.out.println(e.getAttribute("src"));
			if (e.getAttribute("src").contains("https://tvc4.investing.com/init.php?pair_ID=")) {
				driver.get(e.getAttribute("src"));
				break;
			}
		}

		for (int i = 1; i < webURLsList.size(); i++) {
			((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
		}

		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		for (int i = 1; i < webURLsList.size(); i++) {
			driver.switchTo().window(tabs.get(i));
			driver.get(webURLsList.get(i));
			((JavascriptExecutor) driver).executeScript("return document.readyState");

			List<WebElement> lnks = driver.findElements(By.tagName("iframe"));
			for (WebElement e : lnks) {
				System.out.println(e.getAttribute("src"));
				if (e.getAttribute("src").contains("https://tvc4.investing.com/init.php?pair_ID=")) {
					driver.get(e.getAttribute("src"));
					break;
				}
			}

		}
	}

}
