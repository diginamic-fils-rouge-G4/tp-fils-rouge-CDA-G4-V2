package dev.service;

import dev.controller.dto.StationDTO;
import dev.entite.api.ApiResponse;
import dev.entite.lieu.Departement;
import dev.entite.lieu.Station;
import dev.entite.lieu.Ville;
import dev.entite.qualite.Polluant;
import dev.repository.StationRepository;
import dev.repository.UtilisateurRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class StationService {

    private StationRepository stationRepository;
    private VilleService villeService;
    private DepartementService departementService;
    private UtilisateurRepository utilisateurRepository;

    private APIQualiteAirService apiQualiteAirService;

    public StationService(StationRepository stationRepository, VilleService villeService, DepartementService departementService, UtilisateurRepository utilisateurRepository, APIQualiteAirService apiQualiteAirService) {
        this.stationRepository = stationRepository;
        this.villeService = villeService;
        this.departementService = departementService;
        this.utilisateurRepository = utilisateurRepository;
        this.apiQualiteAirService = apiQualiteAirService;
    }

    public Station obtenirStationParNom (String nom){
        return stationRepository.findByNom(nom);
    }
    public Station obtenirStationParID (int id){
        return stationRepository.findByIdx(String.valueOf(id));
    }

    public Station ajouterStationEnFavoris(String id){
        ApiResponse data = apiQualiteAirService.getStationById(id);

        Station station =obtenirStationParID(Math.round(data.getData().getIdx()));

        if (station == null){

            station = new Station();
            station.setIdx(String.valueOf(data.getData().getIdx()) );
            station.setNom(data.getData().getCity().getName());

            data.getData().getIaqi().getH();

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

            return station;
        }else {
            return station;
        }


    }


    public Station ajouterStationToUtilisateur(StationDTO stationDto){
        //We have to check if this station exists in the database, if it exists then we just add this station to the Users Favorites.
        //If not, we have to create the station.
        //While creating the station, we have to check if the city exists in the database, if it exists, then we just add the station to the city.
        //if not, we have to create the city.

        if (obtenirStationParNom(stationDto.getNom()) == null){
            Station station = new Station();
            station.setNom(stationDto.getNom());

            if (villeService.obtenirVilleParNom(stationDto.getVille().getNom()) == null){
                Ville ville = new Ville();
                ville.setNom(stationDto.getVille().getNom());
                ville.setCodePostal(stationDto.getVille().getCodePostal());
                ville.setPopulation(stationDto.getVille().getPopulation());

                System.out.println( "##################  hellllooooooooo =>"  +  stationDto.getVille().getDepartement().getNom());

                Departement departement = departementService.obtenirDepartementParNom(stationDto.getVille().getDepartement().getNom());

                System.out.println("################## =>"  +  departement);

                ville.setDepartement(departement);
                departement.getVilles().add(ville);
                station.setVille(ville);
            }else {
                Ville ville = villeService.obtenirVilleParNom(stationDto.getVille().getNom());
                station.setVille(ville);
            }

            return station;
        }else {
            return obtenirStationParNom(stationDto.getNom());
        }
    }
}
