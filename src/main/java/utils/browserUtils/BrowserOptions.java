package utils.browserUtils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserOptions {

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setAcceptUntrustedCertificates(true);
//        profile.setAssumeUntrustedCertificateIssuer(false);
        //Set Firefox profile to capabilities
//        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--incognito");
//        options.addArguments("--start-maximised");
//        options.addArguments("--ignore-certificate-errors");
//        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--fast-start");
        return options;
    }

//    public static EdgeOptions getEdgeOptions() {
//        //ToDo: I guess
//        EdgeOptions options = new EdgeOptions();
//        return options;
//    }
}
