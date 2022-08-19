package dev.controller;

import dev.service.APIGeoService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("geo")
public class APIGeoCtrl {

    private APIGeoService apiGeoService;

    public APIGeoCtrl(APIGeoService apiGeoService) {
        this.apiGeoService = apiGeoService;
    }


    //example de request
    @GetMapping("latlng")
    @ResponseBody
    public Object getAllStations(@RequestParam String lat,
                                  @RequestParam String lon) {
        return apiGeoService.getCityByGeo(lat, lon);
    }

}
