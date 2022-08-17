package dev.service;

import dev.entite.lieu.Ville;
import dev.repository.StationRepository;
import dev.repository.VilleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VilleService {

    private VilleRepository villeRepository;

    public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    public Ville obtenirVilleParNom(String nom){
        return this.villeRepository.findByNom(nom);
    }

}
