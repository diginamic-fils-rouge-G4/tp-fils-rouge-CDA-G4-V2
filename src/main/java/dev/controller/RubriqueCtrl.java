package dev.controller;

import dev.controller.dto.RubriqueDTO;
import dev.entite.forum.Rubrique;
import dev.service.RubriqueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("rubrique")
public class RubriqueCtrl {
    private RubriqueService rubriqueService;

    public RubriqueCtrl(RubriqueService rubriqueService) {
        this.rubriqueService = rubriqueService;
    }

    @GetMapping
    public List<Rubrique> getAllRubrique() {
        return rubriqueService.findAll();
    }

    @PostMapping
    public Rubrique create(@RequestBody RubriqueDTO rubriqueDTO) {
        return rubriqueService.create(rubriqueDTO);
    }
}
