package dev.controller;

import dev.entite.forum.Rubrique;
import dev.service.APIQualiteAirService;
import org.json.simple.JSONObject;
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
    // A FAIRE. Utilisé un ResponseEntity
    public String getAllStations(@RequestParam String lat1,
                                 @RequestParam String lng1,
                                 @RequestParam String lat2,
                                 @RequestParam String lng2) {
        return apiQualiteAirService.getAllStations(lat1, lng1, lat2, lng2);
    }

    @GetMapping("markerClick")
    @ResponseBody
    // A FAIRE. Utilisé un ResponseEntity
    public String getMarkerByClick(@RequestParam String lat,
                                   @RequestParam String lng) {
        return apiQualiteAirService.getMarkerByClick(lat, lng);
    }

    @GetMapping("station/{station}")
    @ResponseBody
    // A FAIRE. Utilisé un ResponseEntity
    public JSONObject getStationByName(@PathVariable String station) {
        return apiQualiteAirService.getStationByName(station);
    }



}
