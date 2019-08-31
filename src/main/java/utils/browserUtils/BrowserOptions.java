package utils.browserUtils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserOptions {

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        return options;
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        return options;
    }

    //ToDo: I guess I should support edge
//    public static EdgeOptions getEdgeOptions() {
//        EdgeOptions options = new EdgeOptions();
//        return options;
//    }
}
