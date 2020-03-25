package ru.Steps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;

import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.Steps.IpotekaPageStep;
import ru.Steps.MainPageStep;

import java.util.Map;

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
    @When("^заполняются поля:$")
    public void заполняются_поля(DataTable fields){
        Map<String,String> dataMap = fields.asMap(String.class, String.class);
        dataMap.forEach((field, value) -> { ipotekaPageStep.fullFill(field, value); });
    }
    @Then("^Выполнено нажатие на кнопку =\"(.+)\"$")
    public void pressCanConfirm(String buttonName){
        ipotekaPageStep.pressChosen(buttonName);
    }
    @Then("^Выполнено нажатие на кнопку -\"(.+)\"$")
    public void pressCardKeeper(String buttonName){
        ipotekaPageStep.pressChosen(buttonName);
    }
    @Then("^Выполнено нажатие на кнопку ==\"(.+)\"$")
    public void pressYoungFamily(String buttonName){
        ipotekaPageStep.pressChosen(buttonName);
    }
    @Then("^Выполнено нажатие на кнопку --\"(.+)\"$")
    public void pressCanConfirmOneMore(String buttonName){
        ipotekaPageStep.pressChosen(buttonName);
    }
    @Then("Итоговая проверка по всем пунктам справа")
    public void lastChecklist(){
        ipotekaPageStep.lastChecklist();
    }

}
