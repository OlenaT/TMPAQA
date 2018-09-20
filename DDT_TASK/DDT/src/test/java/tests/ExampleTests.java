package tests;

import api.RestClient;
import org.testng.annotations.*;
import utils.ExcelParser;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static utils.PropertiesFactory.getProperty;

/**
 * The type Test tests.
 */
public class ExampleTests {

    private String temperature;
    private String pressure;
    private String latitude;
    private String longitude;
    private Map<String, Object> data;

    /**
     * Instantiates a new Example tests.
     */
    public ExampleTests() {
    }

    /**
     * Instantiates a new Example tests.
     *
     * @param temperature the temperature
     * @param pressure    the pressure
     * @param latitude    the latitude
     * @param longitude   the longitude
     */
    @Factory(dataProvider = "dataProvider")
    public ExampleTests(String temperature, String pressure, String latitude, String longitude){
        this.temperature = temperature;
        this.pressure = pressure;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Get data object [ ] [ ].
     *
     * @return the object [ ] [ ]
     * @throws Exception the exception
     */
    @DataProvider
    public Object[][] dataProvider() throws Exception{
        return new ExcelParser().getTableArray(getProperty("file.path"), getProperty("sheet.name"));
    }

    @BeforeMethod
    public void getDataFromService(){
        data = new RestClient().getData();
    }

    /**
     * Verify temperature.
     */
    @Test
    public void verifyTemperature() {
        assertEquals(data.get("TEMPERATURE").toString(), temperature, "Temperature is incorrect!");
    }

    /**
     * Verify pressure.
     */
    @Test
    public void verifyPressure() {
        assertEquals(data.get("PRESSURE").toString(), pressure, "Pressure is incorrect!");
    }

    /**
     * Verify latitude.
     */
    @Test
    public void verifyLatitude() {
        assertEquals(data.get("LATITUDE").toString(), latitude, "Latitude is incorrect!");
    }

    /**
     * Verify longitude.
     */
    @Test
    public void verifyLongitude() {
        assertEquals(data.get("LONGITUDE").toString(), longitude, "Longitude is incorrect!");
    }

}
