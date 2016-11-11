package de.torbenjessen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.net.MalformedURLException;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * @author Torben Jessen
 * Selenium Test using Page Objects
 */
@RunWith(Parameterized.class)
public class SearchPageSuccessTest {

    private static String baseUrl = "http://10.49.1.123:4444/wd/hub/";
    private WebDriver driver;
    private SearchPage page;

    @Parameterized.Parameters
    public static Collection<WebDriver> data() throws MalformedURLException {
        return WebdriverConfig.getAllDrivers();
    }

    public SearchPageSuccessTest(WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void openTheBrowser() {
        page = PageFactory.initElements(driver, SearchPage.class);
        page.open("http://www.google.de/");
    }

    @After
    public void closeTheBrowser() {
        page.close();
    }

    @Test
    public void userSearchForFlensburgTest() {
        page.searchForTerm("google");
        assertThat(page.getTitle(), containsString("Google") );
    }

}