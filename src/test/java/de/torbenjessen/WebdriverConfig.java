package de.torbenjessen;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs-flensburg01 on 11/11/16.
 */
public class WebdriverConfig {

    private static String baseUrl = "http://10.49.1.123:4444/wd/hub/";

    public static List<WebDriver> getAllDrivers() throws MalformedURLException {
        List<WebDriver> drivers = new ArrayList<>();
        DesiredCapabilities chrome = DesiredCapabilities.chrome();
        chrome.setPlatform(Platform.WINDOWS);
        drivers.add(new RemoteWebDriver(new URL(baseUrl), chrome));
        DesiredCapabilities firefox = DesiredCapabilities.firefox();
        firefox.setPlatform(Platform.WINDOWS);
        drivers.add(new RemoteWebDriver(new URL(baseUrl), firefox));
        return drivers;
    }
}
