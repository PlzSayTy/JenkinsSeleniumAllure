package ru.Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.Steps.BaseStep;
public class BasePage {
    Actions builder;
    Wait<WebDriver> wait;
    JavascriptExecutor executor;
    WebDriver driver;

    public BasePage() {
        driver = BaseStep.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10, 1000);
        builder = new Actions(driver);
        executor = (JavascriptExecutor) driver;
    }

    public void click(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
        builder.click(driver.findElement(By.xpath(xpath))).perform();
    }

    public void fillField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
        try {
            wait.until(ExpectedConditions.attributeToBe(field, field.getAttribute("value"), value));
        }catch (TimeoutException te){
            field.clear();
            field.sendKeys(value+" \u20BD");
            if(field.getAttribute("value").equals("30 лет")){
                field.clear();
                field.sendKeys("15");
            }
        }
    }

    public boolean waittextToBePresentInElement(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
