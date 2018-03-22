import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {
	private static WebDriver driver;


	private  WebDriverProvider() {
		driver = new ChromeDriver();
	}
	public static WebDriver getDriver(){
		return driver;
	}
}
