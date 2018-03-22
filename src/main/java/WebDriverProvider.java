import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {
	private static WebDriver driver = new ChromeDriver();


	private  WebDriverProvider() {
	}
	public static WebDriver getDriver(){
		return driver;
	}
}
