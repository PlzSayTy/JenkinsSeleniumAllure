package ru.Utils;
import io.qameta.allure.Allure;
public class ReportHelper {
    public static void addTextAttach(String text) {

        Allure.addAttachment(text, "text/plain");

    }

    public void testFailure() {


    }
}
