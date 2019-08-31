package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.fileUtils.Props;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//header//a")
    public WebElement headerLink;

    public HomePage loadHomePage() {
        driver.get(Props.getConfig("url"));
        return PageFactory.initElements(driver, HomePage.class);
    }
}
