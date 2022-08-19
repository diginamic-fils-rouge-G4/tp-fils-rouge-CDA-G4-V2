package dev.service;

import dev.entite.donneeApiQualiteAir.ApiGeo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class APIGeoService {

    private RestTemplate restTemplate;
    private final String token_api = "7802a0de66c1782d81dadaced12330c8";

    public APIGeoService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<ApiGeo[]> getCityByGeo(String lat , String lon) {
        String url = "http://api.openweathermap.org/geo/1.0/reverse?lat="+lat+"&lon="+lon+"&limit=5&appid="+this.token_api ;

        /*this.restTemplate.getForObject(url, JSONArray.class);*/
        return restTemplate.getForEntity( url,ApiGeo[].class);
    }

}
