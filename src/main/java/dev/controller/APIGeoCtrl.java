package dev.controller;

import dev.service.APIGeoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAllStations(@RequestParam String lat,
                                            @RequestParam String lon) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(apiGeoService.getCityByGeo(lat, lon));
    }

}
