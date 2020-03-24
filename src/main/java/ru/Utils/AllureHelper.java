package ru.Utils;
import io.qameta.allure.Allure;
public class AllureHelper {
    public static void addTextAttach(String text) {

        Allure.addAttachment(text, "text/plain");

    }
    public void testFailure(){


    }



    public static void addTestDescription(String text) {

        Allure.addDescription(text);

    }


    public static void addHtmlDescription(String text) {

        Allure.addDescriptionHtml(text);

    }
}
