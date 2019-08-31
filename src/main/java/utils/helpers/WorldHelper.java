package utils.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AddComputerPage;
import pages.BasePage;
import pages.HomePage;
import pages.UpdateComputerPage;
import utils.browserUtils.DriverFactory;

public class WorldHelper {

    private WebDriver driver;
    private static BasePage basePage;
    private static HomePage homePage;
    private static AddComputerPage addComputerPage;
    private static UpdateComputerPage updateComputerPage;

    public BasePage getBasePage() {
        if (basePage != null) return basePage;
        driver = DriverFactory.getDriver();
        return PageFactory.initElements(driver, BasePage.class);
    }

    public HomePage getHomePage() {
        if (basePage != null) return homePage;
        driver = DriverFactory.getDriver();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public AddComputerPage getAddComputerPage() {
        if (addComputerPage != null) return addComputerPage;
        driver = DriverFactory.getDriver();
        return PageFactory.initElements(driver, AddComputerPage.class);
    }

    public UpdateComputerPage getUpdateComputerPage() {
        if (updateComputerPage != null) return updateComputerPage;
        return PageFactory.initElements(driver, UpdateComputerPage.class);
    }
}
