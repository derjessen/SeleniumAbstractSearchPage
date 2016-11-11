import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.net.MalformedURLException;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * @author Torben Jessen
 * Selenium Test using Page Objects
 */

public abstract class AbstractSearchPage{
    private SearchPage page;

    @Before
    public void openTheBrowser() throws MalformedURLException {
        page = PageFactory.initElements(getDriver(), SearchPage.class);
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

    public abstract WebDriver getDriver() throws MalformedURLException;
}