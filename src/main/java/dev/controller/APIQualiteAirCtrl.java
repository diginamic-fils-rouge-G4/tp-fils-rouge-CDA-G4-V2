package dev.controller;

import dev.entite.forum.Rubrique;
import dev.service.APIQualiteAirService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class APIQualiteAirCtrl {

    private APIQualiteAirService apiQualiteAirService;

    public APIQualiteAirCtrl(APIQualiteAirService apiQualiteAirService) {
        this.apiQualiteAirService = apiQualiteAirService;
    }

    @GetMapping("ville/{nom}")
    @ResponseBody
    public String getFeedCityByName(@PathVariable String nom) {
        return apiQualiteAirService.getFeedCityByName(nom);
    }

    @GetMapping("latlng")
    @ResponseBody
    public String getAllStations(@RequestParam String lat1,
                                 @RequestParam String lng1,
                                 @RequestParam String lat2,
                                 @RequestParam String lng2) {
        return apiQualiteAirService.getAllStations(lat1, lng1, lat2, lng2);
    }

    @GetMapping("markerClick")
    @ResponseBody
    public String getMarkerByClick(@RequestParam String lat,
                                   @RequestParam String lng) {
        return apiQualiteAirService.getMarkerByClick(lat, lng);
    }

    @GetMapping("station/{station}")
    @ResponseBody
    // !!! Le fait de return un string pose des problèmes dans le front où un JSONArray est nécessaire
    public String getStationByName(@PathVariable String station) {
        return apiQualiteAirService.getStationByName(station);
    }



}
