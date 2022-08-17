package dev.service;

import dev.controller.dto.StationDto;
import dev.entite.lieu.Station;
import dev.repository.FavorisRepository;
import dev.repository.StationRepository;
import dev.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    private StationRepository stationRepository;
    private UtilisateurRepository utilisateurRepository;
    private FavorisRepository favorisRepository;


    public StationService(StationRepository stationRepository, UtilisateurRepository utilisateurRepository, FavorisRepository favorisRepository) {
        this.stationRepository = stationRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.favorisRepository = favorisRepository;
    }



    public Station addStationToUtilisateur(StationDto clientDto){
        Client nouveauClient  = new Client();
        nouveauClient .setNom(clientDto.getNom());
        nouveauClient .setPrenoms(clientDto.getPrenoms());
        nouveauClient.setNumero("C" + UUID.randomUUID());
        return this.clientRepository.save(nouveauClient);
    }

}
