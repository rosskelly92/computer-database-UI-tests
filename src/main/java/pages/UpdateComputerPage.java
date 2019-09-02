package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.helpers.DataGen;
import utils.helpers.Do;

public class UpdateComputerPage extends BasePage {

    public UpdateComputerPage(WebDriver driver) { super(driver);}

    @FindBy (id = "name")
    private WebElement nameField;

    @FindBy (id = "introduced")
    private WebElement introField;

    @FindBy (id = "discontinued")
    private WebElement discontField;

    @FindBy (id = "company")
    private WebElement companyDropdown;

    @FindBy (xpath = "//option[@selected]")
    private WebElement selectedDropdownField;

    @FindBy (xpath = "//input[@type='submit']")
    private WebElement createBtn;

    @FindBy (xpath = "//a[text()='Cancel']")
    private WebElement cancelBtn;

    @FindBy (xpath = "//input[contains(@value,'Delete')]")
    private WebElement deleteBtn;

    @FindBy(xpath = "//section//h1")
    private WebElement h1;

    @FindBy(xpath = "//*[@class='clearfix error']")
    private WebElement validationBox;

    public HomePage updateAllDetails() {
        Do.sendKeys(nameField, DataGen.getUpdatedName());
        Do.sendKeys(introField, DataGen.getUpdatedIntroDate());
        Do.sendKeys(discontField, DataGen.getUpdatedDiscontDate());
        Do.select(companyDropdown, DataGen.getUpdatedCompanyName());
        Do.click(createBtn);
        return PageFactory.initElements(driver, HomePage.class);
    }

    public HomePage deleteComputer() {
        Do.click(deleteBtn);
        return PageFactory.initElements(driver, HomePage.class);
    }

    public String getNameValue() { return Do.jsGetValue(driver, nameField); }
    public String getIntroDateValue() { return Do.jsGetValue(driver, introField); }
    public String getDiscontDateValue() { return Do.jsGetValue(driver, discontField); }
    public String getCompanyNameValue() { return selectedDropdownField.getText(); }

    public UpdateComputerPage updateNameToEmpty() {
        Do.sendKeys(nameField, "");
        Do.click(createBtn);
        return PageFactory.initElements(driver, UpdateComputerPage.class);
    }

    public String getH1() { return h1.getText(); }

    public Boolean validationBoxDisplayed() {
        return validationBox.isDisplayed();
    }

    public UpdateComputerPage inputName() {
        Do.sendKeys(nameField, DataGen.getUpdatedName());
        return PageFactory.initElements(driver, UpdateComputerPage.class);
    }

    public HomePage clickCreate() {
        Do.click(createBtn);
        return PageFactory.initElements(driver, HomePage.class);
    }

    public UpdateComputerPage clearNonMandatoryFields() {
        Do.sendKeys(introField, "");
        Do.sendKeys(discontField, "");
        Do.select(companyDropdown, "-- Choose a company --");
        Do.click(createBtn);
        return PageFactory.initElements(driver, UpdateComputerPage.class);
    }

    public HomePage updateFieldsAndCancel() {
        Do.sendKeys(nameField, DataGen.getUpdatedName());
        Do.sendKeys(introField, DataGen.getUpdatedIntroDate());
        Do.sendKeys(discontField, DataGen.getUpdatedDiscontDate());
        Do.select(companyDropdown, DataGen.getUpdatedCompanyName());
        Do.click(cancelBtn);
        return PageFactory.initElements(driver, HomePage.class);
    }

    public UpdateComputerPage updateIntroDate(String dateValue) {
        Do.sendKeys(introField, dateValue);
        Do.click(createBtn);
        return PageFactory.initElements(driver, UpdateComputerPage.class);
    }

    public UpdateComputerPage updateDiscontDate(String dateValue) {
        Do.sendKeys(discontField, dateValue);
        Do.click(createBtn);
        return PageFactory.initElements(driver, UpdateComputerPage.class);
    }

    public HomePage updateName(String strangeName) {
        Do.sendKeys(nameField, DataGen.getStrangeName());
        Do.click(createBtn);
        return PageFactory.initElements(driver, HomePage.class);
    }
}
