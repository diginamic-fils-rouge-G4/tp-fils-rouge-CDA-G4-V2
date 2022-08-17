package dev.service;

import dev.entite.lieu.Departement;
import dev.entite.lieu.Station;
import dev.repository.DepartementRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartementService {

    private DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public Departement obtenirDepartementParNom (String nom){
        return departementRepository.findByNom(nom);
    }

}
