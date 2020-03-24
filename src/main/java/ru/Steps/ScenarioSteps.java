package ru.Steps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class ScenarioSteps {
    MainPageStep mainPageStep = new MainPageStep();
    IpotekaPageStep ipotekaPageStep = new IpotekaPageStep();
    @When("Выполнено наведение на Ипотека и выбор Ипотека на готовое жилье")
    public void getMouseToIpotekaStep(){
        mainPageStep.getMouseToIpoteka();
    }
    @Then ("выполняется смена фрейма")
    public void changeFrame(){
        ipotekaPageStep.changeFrame();
    }
    @When ("Заполняется поле Стоимость недвижимости")
    public void fullFillCost(){
        ipotekaPageStep.fullFillCost();
    }
    @Then("Делаю лишнюю проверку из за лагающей менюшки")
    public void uselessChecking(){
        ipotekaPageStep.uselessCheck();
    }
    @Then ("Проверяется изменение полей справа 1")
    public void firstCheck(){
        ipotekaPageStep.firstCheck();
    }
    @When("Заполняется поле Первоначальный взнос")
    public void fullFillFirtPay(){
        ipotekaPageStep.fullFillFirtPay();
    }
    @Then ("Проверяется изменение полей справа 2")
    public void secondCheck(){
        ipotekaPageStep.secondCheck();
    }
    @When ("Заполняется поле Срок")
    public void fullFillTime(){
        ipotekaPageStep.fullFillTime();
    }
    @Then ("Проверяется изменение полей справа 3")
    public void thirdCheck(){
        ipotekaPageStep.thirdCheck();
    }
    @When ("Выключаю зарплатныю карту Сбербанка")
    public void turnOffSberCard(){
        ipotekaPageStep.turnOffSberCard();
    }
    @Then ("Проверяется изменение полей справа 4")
    public void fourthCheck(){
        ipotekaPageStep.fourthCheck();
    }
    @When ("Выключаю возможность подтверждения")
    public void turnPosibilityOff(){
        ipotekaPageStep.turnPosibilityOff();
    }
    @Then ("Проверяется изменение полей справа 5")
    public void fivethCheck(){
        ipotekaPageStep.fivethCheck();
    }
    @When ("Включаю молодую семью")
    public void turnYoungFamilyOn(){
        ipotekaPageStep.turnYoungFamilyOn();
    }
    @Then ("Проверяется изменение полей справа 6")
    public void sixsCheck(){
        ipotekaPageStep.sixsCheck();
    }
    @When ("Включаю возможность подтвердить доход")
    public void tunrPosibilityOn(){
        ipotekaPageStep.turnPosibilityOff();
    }
    @Then("Итоговая проверка по всем пунктам справа")
    public void lastChecklist(){
        ipotekaPageStep.lastChecklist();
    }

}
