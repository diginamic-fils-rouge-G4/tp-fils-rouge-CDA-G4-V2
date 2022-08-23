package dev.controller;

import dev.controller.dto.rubrique.RubriqueDTO;
import dev.controller.dto.rubrique.RubriqueExportDTO;
import dev.controller.dto.rubrique.RubriqueLibelleDTO;
import dev.entite.forum.Rubrique;
import dev.service.RubriqueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *  Controller utilisé pour la gestion des Rubriques <br/>
 *  Utilise le service : {@link dev.service.APIQualiteAirService}
 */
@CrossOrigin
@RestController
@RequestMapping("rubriques")
public class RubriqueCtrl {
    private RubriqueService rubriqueService;
    private static final Logger LOGGER = LoggerFactory.getLogger(RubriqueCtrl.class);

    public RubriqueCtrl(RubriqueService rubriqueService) {
        this.rubriqueService = rubriqueService;
    }

    /**
     * Récupère la totalité des Rubriques
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getAllRubrique() {
        List<Rubrique> rubriques = rubriqueService.findAll();
        if(!rubriques.isEmpty()) {
            List<RubriqueExportDTO> rubriqueExportDTOS=rubriques.stream().map(RubriqueExportDTO::new).toList();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(rubriqueExportDTOS);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("Il n'y a aucune rubrique d'enregistré");
        }
    }

    /**
     * Récupère une rubrique à l'aide de son id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getRubrique(@PathVariable Integer id) {
        Optional<Rubrique> rubriques = rubriqueService.getByid(id);
        if(rubriques.isPresent()) {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new RubriqueExportDTO(rubriques.get()));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("Il n'y a aucune rubrique d'enregistré");
        }
    }

    /**
     * Créé une rubrique
     * @param rubriqueDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody RubriqueDTO rubriqueDTO) {
        Rubrique rubrique = rubriqueService.create(rubriqueDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(rubrique);
    }

    /**
     * Supprime une rubrique à l'aide de son id
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteRubrique(@PathVariable Integer id) {
        Optional<Rubrique> rubrique = rubriqueService.getByid(id);
        if (rubrique.isPresent()) {
            Rubrique currentRubrique = rubrique.get();
            rubriqueService.deleteRubrique(currentRubrique);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    /**
     * Met à jour le libelle d'une rubrique
     * @param rubriqueLibelleDTO
     * @return
     */
    @PatchMapping
    public ResponseEntity<Rubrique> updateRubrique(@RequestBody RubriqueLibelleDTO rubriqueLibelleDTO) {
        Optional<Rubrique> rubrique = rubriqueService.getByid(rubriqueLibelleDTO.getId());
        if (rubrique.isPresent()) {
            Rubrique currentRubrique = rubrique.get();
            currentRubrique.setLibelle(rubriqueLibelleDTO.getLibelle());
            return ResponseEntity.ok(rubriqueService.saveRubrique(currentRubrique));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
