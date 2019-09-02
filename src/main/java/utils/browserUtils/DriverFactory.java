package utils.browserUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger log = Logger.getLogger(DriverFactory.class);

    public synchronized  static void setDriver (String browser) {
        log.info("Browser is: " + browser);
        if(browser.equals("chrome")) {
            driver = ThreadLocal.withInitial(() -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(BrowserOptions.getChromeOptions());
                });
            }
        else if(browser.equals("firefox")) {
            driver = ThreadLocal.withInitial(() -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(BrowserOptions.getFirefoxOptions());
                });
        } else {
            log.info("Browser selection not recognised. Expected: chrome or firefox. Actual: " + browser);
        }

    }

    public synchronized static WebDriver getDriver() {
        return driver.get();
    }
}
