package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utils.helpers.Do;

import java.util.List;

public class HomePage extends BasePage {

    Logger log = LogManager.getLogger(HomePage.class);

    public HomePage (WebDriver driver) { super(driver);}

    @FindBy (id = "add")
    private WebElement addComputerBtn;

    @FindBy(xpath = "//*[@class='alert-message warning']")
    private WebElement saveSuccessMsg;

    @FindBy(id = "searchbox")
    private WebElement filterInput;

    @FindBy(id = "searchsubmit")
    private WebElement filterBtn;

    @FindBy(xpath = "//section//h1")
    private WebElement tableResultsHeader;

    @FindBys ({@FindBy(xpath = "//tbody//a")})
    private List<WebElement> tableLinks;

    @FindBys ({@FindBy(xpath = "//tbody//tr")})
    private List<WebElement> tableRows;

    @FindBy (xpath = "//em")
    private WebElement noResultsTable;

    public String getTitle() {
        Do.waitForDisplay(headerLink);
        return driver.getTitle();
    }

    public AddComputerPage clickOnAddComputer() {
        Do.click(addComputerBtn);
        return PageFactory.initElements(driver, AddComputerPage.class);
    }

    public boolean saveWasSuccessful() {
        return Do.waitForDisplay(saveSuccessMsg);
    }

    public String getSaveMessage() {
        return saveSuccessMsg.getText();
    }

    public HomePage applyNameFilter(String name) {
        Do.sendKeys(filterInput, name);
        Do.click(filterBtn);
        if(tableResultsHeader.getText().contains("computers found")) Do.waitForAllMatch(tableLinks, name);
        return PageFactory.initElements(driver, HomePage.class);
    }

    public int numberOfComputersInTable() { return tableLinks.size(); }

    public UpdateComputerPage selectComputer() {
        if (numberOfComputersInTable() > 1) log.info(numberOfComputersInTable() + " table items, clicking the top computer");
        Do.click(tableLinks.get(0));
        return PageFactory.initElements(driver, UpdateComputerPage.class);
    }

    //ToDo: tidy this up. find column content from row context
    public String getDisplayedName() { return driver.findElement(By.xpath("//tbody//tr/td[1]")).getText(); }
    public String getDisplayedIntroDate() { return driver.findElement(By.xpath("//tbody//tr/td[2]")).getText(); }
    public String getDisplayedDiscontDate() { return driver.findElement(By.xpath("//tbody//tr/td[3]")).getText(); }
    public String getDisplayedCompany() { return driver.findElement(By.xpath("//tbody//tr/td[4]")).getText(); }

    public String getResultsHeader() { return tableResultsHeader.getText(); }
    public String emptyTableText() { return noResultsTable.getText(); }

    public HomePage addMultipleComputers(int numberToAdd) {
        int loops = 0;
        while (loops < numberToAdd) {
            AddComputerPage addComputerPage = clickOnAddComputer();
            addComputerPage.addNewComputer();
            loops++;
        }
        return PageFactory.initElements(driver, HomePage.class);
    }

    public UpdateComputerPage browserBackToEditPage() {
        driver.navigate().back();
        return PageFactory.initElements(driver, UpdateComputerPage.class);
    }
}
