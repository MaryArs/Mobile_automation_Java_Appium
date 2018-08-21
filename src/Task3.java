import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Task3 {
    private AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/marsitova/Desktop/MobileAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSearch() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find Searc Wikipedia input",
                5);
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "Cannot find search input",
                5);
        waitForElementPresent(
                By.xpath("//android.widget.LinearLayout[@index='0']"),
                "Cannot find  several articles",
                5);
        waitForElementPresent(
                By.xpath("//android.widget.LinearLayout[@index='1']"),
                "Cannot find  several articles",
                5);
        waitForElementPresent(
                By.xpath("//android.widget.LinearLayout[@index='2']"),
                "Cannot find  several articles",
                5);
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cancel search",
                5);
        WebElement search_text = waitForElementPresent(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find text 'Search…'",
                5);
        String search_field_text = search_text.getAttribute("text");
        Assert.assertEquals(
                "We do not see text 'Search…'",
                "Search…",
                search_field_text);
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }
}
