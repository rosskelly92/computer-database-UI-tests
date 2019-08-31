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

    public String getNameValue() { return Do.jsGetValue(nameField); }
    public String getIntroDateValue() { return Do.jsGetValue(introField); }
    public String getDiscontDateValue() { return Do.jsGetValue(discontField); }
    public String getCompanyNameValue() { return selectedDropdownField.getText(); }
}
