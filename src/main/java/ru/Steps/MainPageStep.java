package ru.Steps;

import io.qameta.allure.Step;
import ru.Pages.MainPage;


public class MainPageStep {
    @Step("Выполнено наведение на Ипотека и выбор Ипотека на готовое жилье")
    public void getMouseToIpoteka(){
        new MainPage().goToAndWait();
    }
}
