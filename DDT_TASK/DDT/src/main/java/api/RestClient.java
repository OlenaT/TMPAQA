package api;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import utils.PropertiesFactory;

import java.util.Map;

import static utils.PropertiesFactory.getProperty;

/**
 * The type Rest client.
 */
public class RestClient {

    private static final String GET_AEMET_STATION = "/getAemetStation/aeropuertopalma/lastdata";

    /**
     * Get data map.
     *
     * @return the map
     */
    public Map<String, Object> getData(){
        String uri = getProperty("rest.url") + GET_AEMET_STATION;
        ResponseEntity<String> data = new RestTemplate().getForEntity(uri, String.class);
        JSONObject obj = new JSONObject(data.getBody());
        return obj.toMap();
    }

}
