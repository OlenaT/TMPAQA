package api;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static utils.PropertiesFactory.getProperty;

public class ServiceClient {

    private static final String GET_AEMET_STATION = "/getAemetStation/aeropuertopalma/lastdata";

    /**
     * Get boxscore rest response json wrapper.
     *
     * @return the rest response json wrapper
     */
    public Map<String, Object> getData(){
        String uri = getProperty("rest.url") + GET_AEMET_STATION;
        ResponseEntity<String> data = getRestTemplate().getForEntity(uri, String.class);
        JSONObject obj = new JSONObject(data.getBody());
        return obj.toMap();
    }

    private RestTemplate getRestTemplate(){
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return rt;
    }
}
