package dev.controller;

import dev.entite.forum.Rubrique;
import dev.service.APIQualiteAirService;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Controller utilisé pour appeler les requêtes pour l'api sur la qualité de l'air <br/>
 *  Utilise le service : {@link dev.service.APIQualiteAirService}
 */
@CrossOrigin
@RestController
@RequestMapping("api")
public class APIQualiteAirCtrl {

    private APIQualiteAirService apiQualiteAirService;

    public APIQualiteAirCtrl(APIQualiteAirService apiQualiteAirService) {
        this.apiQualiteAirService = apiQualiteAirService;
    }

    /**
     * Récupère les informations de qualité de l'air d'une ville selon le nom de celle-ci
     * @param nom
     * @return
     */
    @GetMapping("ville/{nom}")
    @ResponseBody
    public String getFeedCityByName(@PathVariable String nom) {
        return apiQualiteAirService.getFeedCityByName(nom);
    }

    /**
     * Récupère toutes les stations et leurs informations de qualité de l'air en fonction <br/>
     * de deux ensembles de coordonnées géographiques
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    @GetMapping("latlng")
    @ResponseBody
    // A FAIRE. Utilisé un ResponseEntity
    public String getAllStations(@RequestParam String lat1,
                                 @RequestParam String lng1,
                                 @RequestParam String lat2,
                                 @RequestParam String lng2) {
        return apiQualiteAirService.getAllStations(lat1, lng1, lat2, lng2);
    }

    /**
     * Récupère une station et ses informations sur la qualité de l'air à l'aide de ses coordonnées <br/>
     * géographiques. Cette méthode est utilisée lorsque l'on click sur un marqueur représentant une <br/>
     * station
     * @param lat
     * @param lng
     * @return
     */
    @GetMapping("markerClick")
    @ResponseBody
    // A FAIRE. Utilisé un ResponseEntity
    public String getMarkerByClick(@RequestParam String lat,
                                   @RequestParam String lng) {
        return apiQualiteAirService.getMarkerByClick(lat, lng);
    }

    /**
     * Récupère une station et ses informations sur la qualité de l'air à l'aide de son nom
     * @param station
     * @return
     */
    @GetMapping("station/{station}")
    @ResponseBody
    // A FAIRE. Utilisé un ResponseEntity
    public JSONObject getStationByName(@PathVariable String station) {
        return apiQualiteAirService.getStationByName(station);
    }

}
