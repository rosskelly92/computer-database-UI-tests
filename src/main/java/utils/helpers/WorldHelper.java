package utils.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AddNewComputerPage;
import pages.BasePage;
import pages.HomePage;
import pages.UpdateComputerPage;
import utils.browserUtils.DriverFactory;

public class WorldHelper {

    private WebDriver driver;
    private static BasePage basePage;
    private static HomePage homePage;
    private static AddNewComputerPage addNewComputerPage;
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

    public AddNewComputerPage getAddNewComputerPage() {
        if (addNewComputerPage != null) return addNewComputerPage;
        driver = DriverFactory.getDriver();
        return PageFactory.initElements(driver, AddNewComputerPage.class);
    }

    public UpdateComputerPage getUpdateComputerPage() {
        if (updateComputerPage != null) return updateComputerPage;
        return PageFactory.initElements(driver, UpdateComputerPage.class);
    }
}
