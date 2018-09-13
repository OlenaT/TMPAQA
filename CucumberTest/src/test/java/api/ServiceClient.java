package api;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import utils.PropertiesFactory;

import java.util.Map;

public class ServiceClient {

    private String restUri = PropertiesFactory.getProperty("rest.url");

    /**
     * Get boxscore rest response json wrapper.
     *
     * @return the rest response json wrapper
     */
    public Map<String, Object> getData(){
        String uri = restUri + "/getAemetStation/aeropuertopalma/lastdata";
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
