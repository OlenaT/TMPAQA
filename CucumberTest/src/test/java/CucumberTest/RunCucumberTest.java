package CucumberTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static java.lang.System.setProperty;
import static utils.Constants.CHROME_DRIVER;
import static utils.Constants.GECKO_DRIVER;
import static utils.CustomWebDriverProvider.createDriver;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber.html"})
public class RunCucumberTest {

    @BeforeClass
    public static void setup() {
        setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        setProperty("webdriver.gecko.driver", GECKO_DRIVER);
        setWebDriver(createDriver());
    }

    @AfterClass
    public static void tearDown() {
        getWebDriver().quit();
    }

}