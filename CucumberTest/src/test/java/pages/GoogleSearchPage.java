package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

/**
 * The type Google search page.
 */
public class GoogleSearchPage {

    /**
     * Get search input selenide element.
     *
     * @return the selenide element
     */
    private SelenideElement getSearchInput(){
        return $("#lst-ib");
    }

    /**
     * Get search button selenide element.
     *
     * @return the selenide element
     */
    private SelenideElement getSearchButton(){
        return $(xpath("//input[@name='btnK']"));
    }

    /**
     * Get results label selenide element.
     *
     * @return the selenide element
     */
    private SelenideElement getResultsLabel(){
        return $("#resultStats");
    }

    /**
     * Input value to search form.
     *
     * @param query the query
     */
    public void inputValueToSearchForm(String query){
        getSearchInput().shouldBe(visible).val(query);
    }

    /**
     * Click search button.
     */
    public void clickSearchButton(){
        getSearchButton().click();
    }

    /**
     * Get results label text string.
     *
     * @return the string
     */
    public String getResultsLabelText(){
        getResultsLabel().shouldBe(visible);
        return getResultsLabel().getText();
    }
}
