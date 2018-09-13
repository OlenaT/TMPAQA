package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * The type Git hub page.
 */
public class GitHubPage {

    /**
     * Instantiates a new Git hub page.
     */
    public GitHubPage() {
    }

    /**
     * Get contact sales button selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getContactSalesButton(){
        return $(".mb-3 a.btn-mktg");
    }

    /**
     * Get contact sales form selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getContactSalesForm(){
        return $(".featurette.featurette-single");
    }

    /**
     * Get form title selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getFormTitle(){
        return $(".display-heading-2.mb-3");
    }

    /**
     * Get features tab selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getFeaturesTab(){
        return $(".ml-lg-2 a");
    }

    /**
     * Get features form selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getFeaturesForm(){
        return $(".container-lg.p-responsive.position-relative.text-center");
    }

    /**
     * Get features form title selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getFeaturesFormTitle(){
        return $(".h00-mktg.lh-condensed.mb-3.text-white");
    }

}
