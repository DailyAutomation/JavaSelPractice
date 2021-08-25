package selenium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class CookiesExample {

	@Test
	public void myFunction() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.co.in");
		Set<Cookie> cookies = driver.manage().getCookies();

		if (cookies.size() == 0) { // To support FF and IE
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String cookiesString = (String) js.executeScript("return document.cookie");
			cookies = parseBrowserCookies(cookiesString);
		}

		System.out.println(cookies.toString());
		driver.quit();
	}

	private Set<Cookie> parseBrowserCookies(String cookiesString) {
		final Set<Cookie> cookies = new HashSet<>();

		if (cookiesString.isEmpty()) {
			return cookies;
		}

		Arrays.asList(cookiesString.split("; ")).forEach(cookie -> {
			String[] splitCookie = cookie.split("=", 2);
			cookies.add(new Cookie(splitCookie[0], splitCookie[1], "/"));
		});

		return cookies;
	}

}
