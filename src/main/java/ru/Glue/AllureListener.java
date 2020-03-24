package ru.Glue;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
//import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.Steps.BaseStep;

import java.io.File;
import java.io.IOException;

import static ru.Steps.BaseStep.setUp;
import static ru.Steps.BaseStep.tearDown;

public class AllureListener extends  org.junit.runner.notification.RunListener{
    }

