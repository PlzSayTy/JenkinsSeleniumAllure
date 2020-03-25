package ru.Pages;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IpotekaPage extends BasePage {
    @FindBy(id = "iFrameResizer0")
    WebElement frame;
    @FindBy (id = "estateCost")
    WebElement estateCost;
    @FindBy(id = "initialFee")
    WebElement initialFee;
    @FindBy(id = "creditTerm")
    WebElement creditTerm;
    @FindBy(xpath = "//span[@data-test-id=\"amountOfCredit\"]")
    public static WebElement amountOfCredit;
    @FindBy(xpath = "//span[@data-test-id=\"monthlyPayment\"]")
    public static WebElement monthlyPayment;
    @FindBy(xpath = "//span[@data-test-id=\"requiredIncome\"]")
    public static WebElement requiredIncome;
    @FindBy(xpath = "//span[@data-test-id=\"rate\"]")

    public static WebElement rate;
    public void changeFrame() {
        executor.executeScript("window.scrollTo(0, 1600)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iFrameResizer0")));
        driver.switchTo().frame(frame);
    }

    public void fullFill(String fieldName, String value) {
        switch (fieldName){
            case  "Стоимость недвижимости":
                fillField(estateCost, value);
                break;
            case  "Первоначальный взнос":
                fillField(initialFee, value);
                break;
            case  "Срок кредита":
                fillField(creditTerm, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }


    public void waitUntilItChanges(String amountOfCredit, String mounthlyPayment, String requiredIncome, String rate) {
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@data-test-id, 'amountOfCredit')]"), amountOfCredit));
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@data-test-id, 'monthlyPayment')]"), mounthlyPayment));
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@data-test-id, 'requiredIncome')]"), requiredIncome));
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@data-test-id, 'rate')]"), rate));
    }

    public void JSclick(String xpath) {
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
    }

    public void assertAllOfThem() {
        Assertions.assertAll("Тест упал из-за процента", (Executable) () ->{
            Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@data-test-id, 'amountOfCredit')]")).getText().equals("2 122 000 \\u20BD"));
            Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@data-test-id, 'monthlyPayment')]")).getText().equals("17 535 \\u20BD"));
            Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@data-test-id, 'requiredIncome')]")).getText().equals("29 224 \\u20BD"));
            Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@data-test-id, 'rate')]")).getText().equals("9,4 %"));
        });
    }
    public void clickWaitAndAssert(String clickAfterWait){
        Assert.assertTrue(driver.findElement(By.xpath(clickAfterWait)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(clickAfterWait)).isEnabled());
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(clickAfterWait)));
        click(clickAfterWait);
    }
    public static WebElement getValue(String field){
        switch (field){
            case "Сумма кредита":
                return amountOfCredit;
            case "Ежемесячный платеж":
                return monthlyPayment;
            case "Необходимый доход":
                return requiredIncome;
            case "Процентная ставка":
                return rate;
            default: throw new AssertionError("Нет такого параметра");
        }
    }
    public void checkFields(String field, String money){
        if(field.equals("сумма кредита")){
            Assert.assertTrue(amountOfCredit.getText().equals(money));
        }else{
            throw new AssertionError("Нет такого параметра");
        }
    }
    public void pressChosen(String chosenButton){
        switch (chosenButton){
            case "Молодая семья":
                new IpotekaPage().JSclick("//input[@data-test-id=\"youngFamilyDiscount\"]");
            case "зарплатная карта Сбербанка":
                new IpotekaPage().clickWaitAndAssert("//input[contains(@data-test-id, 'paidToCard')]/parent::label/parent::div");
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[contains(@data-test-id, 'canConfirmIncome')]/parent::label/parent::div"))));
            case "возможность подтвердить доход":
                 new IpotekaPage().JSclick("//input[contains(@data-test-id, 'canConfirmIncome')]/parent::label/parent::div");
           // default: throw new AssertionError("Нет такого параметра");
        }
    }
}
