package ru.Steps;

import io.qameta.allure.Step;
import ru.Pages.IpotekaPage;

public class IpotekaPageStep {
    @Step("выполняется смена фрейма")
    public void changeFrame(){
        new IpotekaPage().changeFrame();
    }
    @Step ("Заполняется поле Стоимость недвижимости")
    public void fullFillCost(){
        new IpotekaPage().fullFill("//*[@id=\"estateCost\"]", "5180000");
    }
    @Step ("Делаю лишнюю проверку из за лагающей менюшки")
    public void uselessCheck(){
        new IpotekaPage().assertChangeFirstTime("4 403 000 \u20BD");
    }
    @Step ("Проверяется изменение полей справа 1")
    public void firstCheck(){
        new  IpotekaPage().waitUntilItChanges("4 403 000 \u20BD","46 244 \u20BD", "66 062 \u20BD", "9,6 %");
    }
    @Step ("Заполняется поле Первоначальный взнос")
    public void fullFillFirtPay(){
        new IpotekaPage().fullFill("//input[contains(@id, 'initialFee')]", "3058000");
    }
    @Step ("Проверяется изменение полей справа 2")
    public void secondCheck(){
        new  IpotekaPage().waitUntilItChanges("2 122 000 \u20BD","21 776 \u20BD", "36 294 \u20BD", "9,2 %");
    }
    @Step ("Заполняется поле Срок")
    public void fullFillTime(){
        new IpotekaPage().fullFill("//input[contains(@id, 'creditTerm')]", "30");
    }
    @Step ("Проверяется изменение полей справа 3")
    public void thirdCheck(){
        new  IpotekaPage().waitUntilItChanges("2 122 000 \u20BD","17 381 \u20BD", "28 968 \u20BD", "9,2 %");
    }
    @Step ("Выключаю зарплатныю карту Сбербанка")
    public void turnOffSberCard(){
        new IpotekaPage().click("//input[contains(@data-test-id, 'paidToCard')]/parent::label/parent::div");
    }
    @Step ("Проверяется изменение полей справа 4")
    public void fourthCheck(){
        new IpotekaPage().waitUntilItChanges("2 122 000 \u20BD","18 154 \u20BD", "30 256 \u20BD", "9,7 %");
    }
    @Step ("Выключаю возможность подтверждения")
    public void turnPosibilityOff(){
        new IpotekaPage().clickWaitAndAssert("//input[contains(@data-test-id, 'canConfirmIncome')]/parent::label/parent::div");
    }
    @Step ("Проверяется изменение полей справа 5")
    public void fivethCheck(){
        new IpotekaPage().waitUntilItChanges("2 122 000 \u20BD","18 623 \u20BD", "31 037 \u20BD", "10,0 %");
    }
    @Step ("Включаю молодую семью")
    public void turnYoungFamilyOn(){
        new IpotekaPage().JSclick("//input[@data-test-id=\"youngFamilyDiscount\"]");
    }
    @Step ("Проверяется изменение полей справа 6")
    public void sixsCheck(){
        new IpotekaPage().waitUntilItChanges("2 122 000 \u20BD","17 998 \u20BD", "29 997 \u20BD", "9,6 %");
    }
    @Step ("Включаю возможность подтвердить доход")
    public void tunrPosibilityOn(){
        new IpotekaPage().clickWaitAndAssert("//input[contains(@data-test-id, 'canConfirmIncome')]/parent::label/parent::div");
    }
    @Step("Итоговая проверка по всем пунктам справа")
    public void lastChecklist(){
        new IpotekaPage().assertAllOfThem();
    }


}
