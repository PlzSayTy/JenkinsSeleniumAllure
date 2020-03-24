package ru.Steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.Utils.TestProperties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseStep {
        protected static WebDriver driver;
        protected static String baseUrl;
        public static Properties properties = TestProperties.getInstance().getProperties();
        public static Properties propertiesOfBrowser = new Properties();
        public static WebDriver getDriver(){
            return driver;
        }
        @Before
        public static void setUp() throws Exception {
            propertiesOfBrowser.load(new FileInputStream(new File("./target/test-classes/" + System.getProperty("browser", "browser") + ".properties")));
            System.out.println(propertiesOfBrowser.getProperty("browser"));
            switch (propertiesOfBrowser.getProperty("browser")){
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    System.out.println("case = chrome");
                    System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                    driver = new ChromeDriver();
                    break;
                default:
                    System.out.println("case = default(chrome)");
                    System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                    driver = new ChromeDriver();
            }
            baseUrl = properties.getProperty("app.url");
            System.out.println(baseUrl);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(baseUrl);
        }
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot() {
        return ((TakesScreenshot) BaseStep.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
        @After
        public static void tearDown(Scenario sc) throws Exception {
            if(sc.isFailed()) saveScreenshot();
            driver.quit();
        }
}
