import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyEventListner extends AbstractWebDriverEventListener {

	private static final Logger log = LoggerFactory.getLogger(MyEventListner.class);

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		log.info("clicking at "+ elementDescription(element) );
	}
	private String elementDescription(WebElement element) {
		String description = "tag:" + element.getTagName();
		if (element.getAttribute("id") != null) {
			description += " id: " + element.getAttribute("id");
		}
		else if (element.getAttribute("name") != null) {
			description += " name: " + element.getAttribute("name");
		}

		description += " ('" + element.getText() + "')";

		return description;
	}
}
