package de.torbenjessen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Torben Jessen
 * Page Object model of Google's search page
 */

public class SearchPage {

    protected WebDriver driver;
    private WebElement q;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void close() {
        driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void searchForTerm(String searchTerm) {
        q.sendKeys(searchTerm);
        q.submit();
    }
}