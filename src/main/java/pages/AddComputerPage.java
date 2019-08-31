package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.helpers.Do;
import utils.helpers.DataGen;

public class AddComputerPage extends BasePage {

    public AddComputerPage(WebDriver driver) { super(driver);}

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "introduced")
    private WebElement introField;

    @FindBy(id = "discontinued")
    private WebElement discontField;

    @FindBy(id = "company")
    private WebElement companyDropdown;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement createBtn;

    @FindBy(xpath = "//a[text()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//section//h1")
    private WebElement h1;

    @FindBy(xpath = "//*[@class='clearfix error']")
    private WebElement validationBox;

    public HomePage addComputerNameOnly(String name) {
        Do.sendKeys(nameField, name);
        Do.click(createBtn);
        return PageFactory.initElements(driver, HomePage.class);
    }

    public HomePage addNewComputer() {
        Do.sendKeys(nameField, DataGen.getName());
        Do.sendKeys(introField, DataGen.getIntroDate());
        Do.sendKeys(discontField, DataGen.getDiscontDate());
        Do.select(companyDropdown, DataGen.getCompanyName());
        Do.click(createBtn);
        return PageFactory.initElements(driver, HomePage.class);
    }

    public AddComputerPage addComputerWithoutName() {
        Do.sendKeys(introField, DataGen.getIntroDate());
        Do.sendKeys(discontField, DataGen.getDiscontDate());
        Do.select(companyDropdown, DataGen.getCompanyName());
        Do.click(createBtn);
        return PageFactory.initElements(driver, AddComputerPage.class);
    }

    public String getH1() { return h1.getText(); }

    public Boolean validationBoxDisplayed() {
        return validationBox.isDisplayed();
    }

    public UpdateComputerPage inputName() {
        Do.sendKeys(nameField, DataGen.getName());
        return PageFactory.initElements(driver, UpdateComputerPage.class);
    }

    public HomePage clickCreate() {
        Do.click(createBtn);
        return PageFactory.initElements(driver, HomePage.class);
    }
}
