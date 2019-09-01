package utils.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.browserUtils.DriverFactory;

import java.util.List;

public class Do {

    private static WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);

    public static boolean waitForDisplay(WebElement element) {
        wait.until(presenceOfElement(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public static void waitForClickable(WebElement element) {
        wait.until(presenceOfElement(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static ExpectedCondition<WebElement> presenceOfElement(WebElement element) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element;
            }

            public String toString() {
                return "presence of element: " + element;
            }
        };
    }

    public static void click(WebElement element) {
        waitForClickable(element);
        element.click();
    }

    public static void click(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public static void sendKeys(WebElement element, String input) {
        waitForClickable(element);
        element.clear();
        element.sendKeys(input);
    }

    public static void select(WebElement element, String option) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(option);
    }

    public static void waitForAllMatch(List<WebElement> elements, String text) {
        wait.until(textToBePresentInAllElements(elements, text));
    }

    public static ExpectedCondition<Boolean> textToBePresentInAllElements(List<WebElement> elements, String text) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return elements.stream().allMatch(e -> e.getText().contains(text));
                } catch (StaleElementReferenceException var3) {
                    return null;
                }
            }

            public String toString() {
                return String.format("text ('%s') to be present in elements %s", text, elements);
            }
        };
    }

    public static String jsGetValue (WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return arguments[0].value;", element).toString();
    }

    public static void checkPageReady(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until((ExpectedCondition<Boolean>) wd ->
                js.executeScript("return document.readyState").equals("complete"));
    }
}
