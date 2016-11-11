import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Torben Jessen
 * Selenium Test using Page Objects
 */
public class SearchPageTestChrome extends AbstractSearchPage{

    private String baseUrl = "http://10.49.1.123:4444/wd/hub/";

    public WebDriver getDriver() throws MalformedURLException {

        DesiredCapabilities chrome = DesiredCapabilities.chrome();
        chrome.setPlatform(Platform.WINDOWS);

        return new RemoteWebDriver(new URL(baseUrl), chrome);
    }
}