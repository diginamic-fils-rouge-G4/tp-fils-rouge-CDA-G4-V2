package dev.service;

import dev.exception.controller.dto.StationDTO;
import dev.entite.api.ApiResponse;
import dev.entite.lieu.Departement;
import dev.entite.lieu.Station;
import dev.entite.lieu.Ville;
import dev.repository.StationRepository;
import dev.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

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
    public Station obtenirStationParID (String id){
        return stationRepository.findByIdx(id);
    }

    public ApiResponse ajouterStationEnFavoris(String id){
        ApiResponse data = apiQualiteAirService.getStationById(id);
        System.out.println("#########################################################################");
        System.out.println("#########################################################################");
        System.out.println("#########################################################################");

        System.out.println(data.getData());

        System.out.println("#########################################################################");
        System.out.println("#########################################################################");
        System.out.println("#########################################################################");
        return data;
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
