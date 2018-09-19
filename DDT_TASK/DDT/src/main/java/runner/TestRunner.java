package runner;

import api.RestClient;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelParser;
import utils.PropertiesFactory;

import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * The type Test runner.
 */
public class TestRunner {

    private RestClient restClient = new RestClient();
    private String filePath = PropertiesFactory.getProperty("file.path");
    private String sheetName = PropertiesFactory.getProperty("sheet.name");

    /**
     * Get data object [ ] [ ].
     *
     * @return the object [ ] [ ]
     * @throws Exception the exception
     */
    @DataProvider(name = "DataProvider")
    public Object[][] getDataSet() throws Exception{
        ExcelParser excelParser = new ExcelParser();
        return excelParser.getTableArray(filePath,sheetName);
    }

    /**
     * Verify weather info.
     *
     * @param field the field
     * @param value the value
     */
    @Test(dataProvider = "DataProvider")
    public void verifyWeatherInfo(String field, String value) {
        Map<String, Object> data = restClient.getData();
        assertEquals(data.get(field).toString(), value, "");
    }

}
