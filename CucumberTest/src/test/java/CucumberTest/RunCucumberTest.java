package CucumberTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static utils.CustomWebDriverProvider.createDriverSelenoid;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber.html"})
public class RunCucumberTest {

    @BeforeClass
    public static void setup() {
        setWebDriver(createDriverSelenoid());
    }

    @AfterClass
    public static void tearDown() {
        getWebDriver().quit();
    }

}