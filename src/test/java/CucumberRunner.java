import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import io.qameta.allure.Attachment;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.Steps.BaseStep;

@RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"src/test/resources/"},
            glue = {"ru.Steps"},
            plugin = {
                    "io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm",
            }
    )
    public class CucumberRunner {
        @Attachment(value = "Page screenshot", type = "image/png")
        public static byte[] saveScreenshot() {
            return ((TakesScreenshot) BaseStep.getDriver()).getScreenshotAs(OutputType.BYTES);
        }
        public void fail(Scenario scenario){
            if (scenario.isFailed()){
                saveScreenshot();
            }
        }
    }
