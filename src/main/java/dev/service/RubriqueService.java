package dev.service;

import dev.exception.controller.dto.RubriqueDTO;
import dev.entite.forum.Rubrique;
import dev.repository.RubriqueRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class RubriqueService {
    private RubriqueRepository rubriqueRepository;

    public RubriqueService(RubriqueRepository rubriqueRepository) {
        this.rubriqueRepository = rubriqueRepository;
    }

    public Rubrique create(@Valid RubriqueDTO rubriqueDTO) {
        Rubrique rubrique = new Rubrique();
        rubrique.setLibelle(rubriqueDTO.getLibelle());
        return rubriqueRepository.save(rubrique);
    }

    public List<Rubrique> findAll() {
        return rubriqueRepository.findAll();
    }

    public Optional<Rubrique> findByLibelle(String libelle) {
        return rubriqueRepository.findByLibelle(libelle);
    }

    public Optional<Rubrique> getByid(Integer id){
        return rubriqueRepository.findById(id);
    }

    public void deleteRubrique(Rubrique rubrique) {
        rubriqueRepository.delete(rubrique);
    }
}
