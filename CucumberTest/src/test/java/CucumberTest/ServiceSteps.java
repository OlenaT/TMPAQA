package CucumberTest;

import api.ServiceClient;
import entities.WeatherInfo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

/**
 * The type Service steps.
 */
public class ServiceSteps {

    private static final String DATA_FIELD = "TEMPERATURE";
    private Supplier<ServiceClient> serviceClient = ServiceClient::new;
    private WeatherInfo weatherInfo;
    private Map<String, Object> data;

    @Given("I send request to the service")
    public void sendRequest(){
        data = serviceClient.get().getData();
    }

    /**
     * Send request.
     */
    @When("I recieve the response")
    public void receiveResponse(){
        weatherInfo = new WeatherInfo();
        weatherInfo.setTemperature((Double) data.get(DATA_FIELD));
    }

    /**
     * Verify data.
     */
    @Then("Verify returned temperature is ([+-]?\\d*\\.?\\d+)")
    public void verifyData(double expectedTemperature){
        assertEquals("Temperature is incorrect!", expectedTemperature, weatherInfo.getTemperature(), 0.0);
    }
}
