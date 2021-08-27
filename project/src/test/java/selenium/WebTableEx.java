package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTableEx {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");
		
		String tableText = driver.findElement(By.xpath("//table[@id='example']")).getText();
		tableText = tableText.replaceAll("\\<.*?>", "");     
		tableText = tableText.replaceAll("\\p{Punct}", "");  //Punctuation: One of !"#$%&'()*+,-./:;<=>?@[]^_`{|}~
		tableText = tableText.replaceAll("\\r|\\n", "");
		System.out.println(tableText);
		
		driver.quit();
	}

}
