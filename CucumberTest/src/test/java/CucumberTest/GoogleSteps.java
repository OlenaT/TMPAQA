package CucumberTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GoogleSearchPage;
import utils.PropertiesFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

/**
 * The type Google steps.
 */
public class GoogleSteps {

    private String googleUrl = PropertiesFactory.getProperty("google.ui.url");

    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    /**
     * Open google search page.
     */
    @Given("Open Google search page")
    public void openGoogleSearchPage() {
        open(googleUrl);
    }

    /**
     * Search for cucumber.
     *
     * @param query the query
     */
    @When("Search for \"([^\"]*)\"")
    public void searchForCucumber(String query) {
        googleSearchPage.getSearchInput().shouldBe(visible).val(query);
        googleSearchPage.getSearchButton().click();
    }

    /**
     * Verify search results.
     */
    @Then("I should see search results")
    public void verifySearchResults() {
        googleSearchPage.getResultsLabel().shouldBe(visible);
        assertEquals("Search results are not equal!", "Приблизна кількість результатів: 120 000 000 (0,42 сек.)", googleSearchPage.getResultsLabel().getText());
    }
}
