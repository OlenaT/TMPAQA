package CucumberTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GitHubPage;
import utils.PropertiesFactory;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

/**
 * The type Git hub steps.
 */
public class GitHubSteps {

    private String gitHubUrl = PropertiesFactory.getProperty("github.ui.url");

    private GitHubPage gitHubPage = new GitHubPage();

    /**
     * Open git hub page.
     */
    @Given("Open GitHub page")
    public void openGitHubPage() {
        open(gitHubUrl);
    }

    /**
     * Click contact sales button.
     */
    @When("Click Contact Sales button")
    public void clickContactSalesButton() {
        gitHubPage.getContactSalesButton().should(exist).click();
    }

    /**
     * Verify search results.
     */
    @Then("Contact Sales form should be visible")
    public void verifyContactSalesForm() {
        gitHubPage.getContactSalesForm().shouldBe(visible);
        assertEquals("Form title is incorrect!", "Contact our Sales Team", gitHubPage.getFormTitle().getText());

    }

    /**
     * Open features tab.
     */
    @When("Open Features tab")
    public void openFeaturesTab() {
        gitHubPage.getFeaturesTab().click();
    }

    /**
     * Verify search results.
     */
    @Then("Features tab should be visible")
    public void verifyFeaturesTab() {
        gitHubPage.getFeaturesForm().shouldBe(visible);
        assertEquals("Form title is incorrect!", "How developers work", gitHubPage.getFeaturesFormTitle().getText());

    }
}
