package ru.Steps;

import io.qameta.allure.Step;
import ru.Pages.IpotekaPage;
import ru.Pages.BasePage;
import static org.junit.Assert.assertTrue;

public class IpotekaPageStep{
    @Step("выполняется смена фрейма")
    public void changeFrame(){
        new IpotekaPage().changeFrame();
    }
    @Step ("Поле {0} заполняется значением {1}")
    public void fullFill(String field, String value){
        new IpotekaPage().fullFill(field,value);
    }
    @Step("^Выполнено нажатие на кнопку \"(.+)\"$")
    public void pressChosen(String chosenButton){
        new IpotekaPage().pressChosen(chosenButton);
    }
    @Step("Итоговая проверка по всем пунктам справа")
    public void lastChecklist(){
        new IpotekaPage().assertAllOfThem();
    }


}
