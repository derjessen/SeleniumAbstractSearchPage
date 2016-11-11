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
public class SearchPageFailingTest {

    private WebDriver driver;
    private SearchPage page;

    @Parameterized.Parameters
    public static Collection<WebDriver> data() throws MalformedURLException {
        return WebdriverConfig.getAllDrivers();
    }

    public SearchPageFailingTest(WebDriver driver) {
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
        page.searchForTerm("Failing test");
        assertThat(page.getTitle(), containsString("Failing test") );
    }

}