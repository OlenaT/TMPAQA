package CucumberTest;

import api.ServiceClient;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * The type Service steps.
 */
public class ServiceSteps {

    private ServiceClient serviceClient = new ServiceClient();
    private Map<String, Object> data;

    /**
     * Send request.
     */
    @When("Send request")
    public void sendRequest(){
        data = serviceClient.getData();
    }

    /**
     * Verify data.
     */
    @Then("Verify returned data is correct")
    public void verifyData(){
        assertEquals(24.2, data.get("TEMPERATURE"));
    }
}
