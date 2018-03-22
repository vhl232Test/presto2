import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverProvider {
	private static WebDriver driver;


	private  WebDriverProvider() {
	}
	public static WebDriver getDriver(){
		if(driver==null){
			driver = new EventFiringWebDriver(new ChromeDriver());
			((EventFiringWebDriver)driver).register(new MyEventListner());
		}
		return driver;
	}
}
