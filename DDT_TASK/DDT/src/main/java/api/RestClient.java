package api;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import utils.PropertiesFactory;

import java.util.Map;

/**
 * The type Rest client.
 */
public class RestClient {

    private String restUri = PropertiesFactory.getProperty("rest.url");

    /**
     * Get data map.
     *
     * @return the map
     */
    public Map<String, Object> getData(){
        String uri = restUri + "/getAemetStation/aeropuertopalma/lastdata";
        ResponseEntity<String> data = new RestTemplate().getForEntity(uri, String.class);
        JSONObject obj = new JSONObject(data.getBody());
        return obj.toMap();
    }

}
