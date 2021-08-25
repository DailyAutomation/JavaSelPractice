package selenium;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class getClipboardContents {
	@Test
	public void myFunctionToReadClipboardContents() throws UnsupportedFlavorException, IOException {
		String result = "google.com";
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.co.in/");
		String copy = Keys.chord(Keys.CONTROL, Keys.chord("c"));
		driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("google.com");
		driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys(copy);

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
		System.out.println(x);
		int a = result.length();
		int b = x.length();
		System.out.println(a);
		System.out.println(b);
		if (a <= b) {
			System.out.println("Matched Character length");
		} else {
			System.out.println("Issue In Character length");
		}
	}
}
