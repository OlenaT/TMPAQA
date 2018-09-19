package CucumberTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GitHubPage;

import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static utils.PropertiesFactory.getProperty;

/**
 * The type Git hub steps.
 */
public class GitHubSteps {

    private Supplier<GitHubPage> gitHubPage = GitHubPage::new;

    /**
     * Open git hub page.
     */
    @Given("Open GitHub page")
    public void openGitHubPage() {
        open(getProperty("github.ui.url"));
    }

    /**
     * Click contact sales button.
     */
    @When("Click Contact Sales button")
    public void clickContactSalesButton() {
        gitHubPage.get().clickContactSalesButton();
    }

    /**
     * Verify search results.
     */
    @Then("Contact Sales form title should be \"([^\"]*)\"")
    public void verifyContactSalesForm(String expectedTitle) {
        assertEquals("Form title is incorrect!", expectedTitle, gitHubPage.get().getFormTitleText());

    }

    /**
     * Open features tab.
     */
    @When("Open Features tab")
    public void openFeaturesTab() {
        gitHubPage.get().clickFeaturesTab();
    }

    /**
     * Verify search results.
     *
     * @param expectedTitle the expected title
     */
    @Then("Features tab title should be \"([^\"]*)\"")
    public void verifyFeaturesTab(String expectedTitle) {
        assertEquals("Form title is incorrect!", expectedTitle, gitHubPage.get().getFeaturesFormTitleText());
    }
}
