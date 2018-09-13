package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

/**
 * The type Google search page.
 */

public class GoogleSearchPage {

    public GoogleSearchPage() {
    }

    /**
     * Get search input selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getSearchInput(){
        return $("#lst-ib");
    }

    /**
     * Get search button selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getSearchButton(){
        return $(xpath("//input[@name='btnK']"));
    }

    /**
     * Get results label selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getResultsLabel(){
        return $("#resultStats");
    }
}
