package dev.service;

import dev.controller.dto.RubriqueDTO;
import dev.entite.forum.Rubrique;
import dev.repository.RubriqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubriqueService {
    private RubriqueRepository rubriqueRepository;

    public RubriqueService(RubriqueRepository rubriqueRepository) {
        this.rubriqueRepository = rubriqueRepository;
    }

    public Rubrique create(RubriqueDTO rubriqueDTO) {
        Rubrique rubrique = new Rubrique();
        rubrique.setLibelle(rubriqueDTO.getLibelle());
        return rubriqueRepository.save(rubrique);
    }

    public List<Rubrique> findAll() {
        return rubriqueRepository.findAll();
    }
}
