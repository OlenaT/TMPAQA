package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * The type Git hub page.
 */
public class GitHubPage {

    /**
     * Get contact sales button selenide element.
     *
     * @return the selenide element
     */
    private SelenideElement getContactSalesButton(){
        return $(".mb-3 a.btn-mktg");
    }

    /**
     * Get contact sales form selenide element.
     *
     * @return the selenide element
     */
    private SelenideElement getContactSalesForm(){
        return $(".featurette.featurette-single");
    }

    /**
     * Get form title selenide element.
     *
     * @return the selenide element
     */
    private SelenideElement getFormTitle(){
        return $(".display-heading-2.mb-3");
    }

    /**
     * Get features tab selenide element.
     *
     * @return the selenide element
     */
    private SelenideElement getFeaturesTab(){
        return $(".ml-lg-2 a");
    }

    private SelenideElement getBusinessTab(){
        return $$(".ml-lg-4 a").first();
    }

    /**
     * Get features form selenide element.
     *
     * @return the selenide element
     */
    private SelenideElement getFeaturesForm(){
        return $(".container-lg.p-responsive.position-relative.text-center");
    }

    private SelenideElement getBusinessForm(){
        return $(".container-lg.p-responsive.text-center.pb-5");
    }

    /**
     * Get features form title selenide element.
     *
     * @return the selenide element
     */
    private SelenideElement getFeaturesFormTitle(){
        return $(".h00-mktg.lh-condensed.mb-3.text-white");
    }

    /**
     * Click features tab.
     */
    public void clickFeaturesTab(){
        getFeaturesTab().click();
    }

    /**
     * Click business tab.
     */
    public void clickBusinessTab(){
        getBusinessTab().click();
    }

    /**
     * Click contact sales button.
     */
    public void clickContactSalesButton(){
        getContactSalesButton().should(exist).click();
    }

    /**
     * Get form title text string.
     *
     * @return the string
     */
    public String getFormTitleText(){
        getContactSalesForm().shouldBe(visible);
        return getFormTitle().getText();
    }

    /**
     * Get features form title text string.
     *
     * @return the string
     */
    public String getFeaturesFormTitleText(){
        getFeaturesForm().shouldBe(visible);
        return getFeaturesFormTitle().getText();
    }

    /**
     * Get business form title text string.
     *
     * @return the string
     */
    public String getBusinessFormTitleText(){
        getBusinessForm().shouldBe(visible);
        return getFeaturesFormTitle().getText();
    }

}
