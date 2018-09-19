package CucumberTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GoogleSearchPage;

import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static utils.PropertiesFactory.getProperty;

/**
 * The type Google steps.
 */
public class GoogleSteps {

    private Supplier<GoogleSearchPage> googleSearchPage = GoogleSearchPage::new;

    /**
     * Open google search page.
     */
    @Given("Open Google search page")
    public void openGoogleSearchPage() {
        open(getProperty("google.ui.url"));
    }

    /**
     * Search for cucumber.
     *
     * @param query the query
     */
    @When("Search for \"([^\"]*)\"")
    public void searchForCucumber(String query) {
        googleSearchPage.get().inputValueToSearchForm(query);
        googleSearchPage.get().clickSearchButton();
    }

    /**
     * Verify search results.
     */
    @Then("I should see search results \"([^\"]*)\"")
    public void verifySearchResults(String expectedResultsText) {
        assertEquals("Search results are not equal!", expectedResultsText, googleSearchPage.get().getResultsLabelText());
    }
}
