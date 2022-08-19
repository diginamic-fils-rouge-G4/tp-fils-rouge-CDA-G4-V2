package dev.service;

import dev.controller.dto.StationDTO;
import dev.entite.api.ApiGeo;
import dev.entite.api.ApiResponse;
import dev.entite.lieu.Departement;
import dev.entite.lieu.Station;
import dev.entite.lieu.Ville;
import dev.entite.qualite.Polluant;
import dev.repository.StationRepository;
import dev.repository.UtilisateurRepository;
import org.json.simple.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StationService {

    private StationRepository stationRepository;
    private VilleService villeService;
    private DepartementService departementService;
    private UtilisateurRepository utilisateurRepository;
    private APIGeoService apiGeoService;
    private APIQualiteAirService apiQualiteAirService;
    private PolluantService polluantService;

    public StationService(StationRepository stationRepository, VilleService villeService, DepartementService departementService, UtilisateurRepository utilisateurRepository, APIGeoService apiGeoService, APIQualiteAirService apiQualiteAirService, PolluantService polluantService) {
        this.stationRepository = stationRepository;
        this.villeService = villeService;
        this.departementService = departementService;
        this.utilisateurRepository = utilisateurRepository;
        this.apiGeoService = apiGeoService;
        this.apiQualiteAirService = apiQualiteAirService;
        this.polluantService = polluantService;
    }

    public Station obtenirStationParNom (String nom){
        return stationRepository.findByNom(nom);
    }

    public Station createStation (Station station){
        return stationRepository.save(station);
    }
    public Station obtenirStationParID (int id){
        return stationRepository.findByIdx(String.valueOf(id));
    }

    public Station ajouterStationEnFavoris(String id){

        //We have to check if this station exists in the database, if it exists then we just add this station to the Users Favorites.
        //If not, we have to create the station.
        //While creating the station, we have to check if the city exists in the database, if it exists, then we just add the station to the city.
        //if not, we have to create the city.

        ApiResponse data = apiQualiteAirService.getStationById(id);

        Station station =obtenirStationParID(Math.round(data.getData().getIdx()));

        if (station == null){

            station = new Station();
            station.setIdx(String.valueOf(data.getData().getIdx()) );
            station.setNom(data.getData().getCity().getName());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            Polluant H = new Polluant();
            H.setType("H");
            H.setQualite(String.valueOf(data.getData().getIaqi().getH().getV()));
            H.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));

            station.getPolluants().add(H);

            Polluant P = new Polluant();
            P.setType("P");
            P.setQualite(String.valueOf(data.getData().getIaqi().getP().getV()));
            P.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));

            station.getPolluants().add(P);

            Polluant Pm25 = new Polluant();
            Pm25.setType("Pm25");
            Pm25.setQualite(String.valueOf(data.getData().getIaqi().getPm25().getV()));
            Pm25.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));

            station.getPolluants().add(Pm25);

            Polluant T = new Polluant();
            T.setType("T");
            T.setQualite(String.valueOf(data.getData().getIaqi().getT().getV()));
            T.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));

            station.getPolluants().add(T);

            Polluant W = new Polluant();
            W.setType("W");
            W.setQualite(String.valueOf(data.getData().getIaqi().getW().getV()));
            W.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));

            station.getPolluants().add(W);

            Polluant Wg = new Polluant();
            Wg.setType("Wg");
            Wg.setQualite(String.valueOf(data.getData().getIaqi().getWg().getV()));
            Wg.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));

            station.getPolluants().add(Wg);

            ResponseEntity<ApiGeo[]> ListVille = apiGeoService.getCityByGeo(data.getData().getCity().getGeo().get(0).toString(), data.getData().getCity().getGeo().get(1).toString());
            Ville ville = villeService.obtenirVilleParNom(ListVille.getBody()[0].getName());

            for (Polluant polluant : station.getPolluants()) {
                polluantService.createPolluant(polluant);
            }

            this.createStation(station);

            if (ville == null){
                ville = new Ville();
                ville.getStations().add(station);
                ville.setPopulation(0);
                ville.setNom(ListVille.getBody()[0].getName());
                villeService.createVille(ville);
                ville.getStations().add(station);
                return station;
            }else {
                ville.getStations().add(station);
                return station;
            }
        }else {
            return station;
        }
    }
    public Station ajouterStationToUtilisateur(String id){

        Station station = this.ajouterStationEnFavoris(id);
        return station;

    }
}
