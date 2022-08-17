package dev.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIQualiteAirService {

    private RestTemplate restTemplate;
    private final String token_api = "dbbd6bd16593d05023748919d281d871c3f79a33";

    public APIQualiteAirService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getFeedCityByName(String city) {
        String url = "https://api.waqi.info/feed/" + city + "/?token=" + token_api;
        return this.restTemplate.getForObject(url, String.class);
    }

    public String getAllStations(String lat1, String lng1, String lat2, String lng2) {
        String url = "https://api.waqi.info/map/bounds?latlng=" +
                lat1 + "," + lng1 + "," +
                lat2 + "," + lng2 + "&networks=all&token=" + this.token_api;
        return this.restTemplate.getForObject(url, String.class);
    }

    public String getMarkerByClick(String lat, String lng) {
        String url = "https://api.waqi.info/feed/geo:" + lat + ";" + lng + "/?token=" + this.token_api;
        return this.restTemplate.getForObject(url, String.class);
    }

    public String getStationByName(String station) {
        String url = "https://api.waqi.info/search/?keyword=" + station + "/?token=" + token_api;
        return this.restTemplate.getForObject(url, String.class);
    }


}
