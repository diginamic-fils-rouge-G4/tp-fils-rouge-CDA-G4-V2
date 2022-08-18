package dev.controller;

import dev.controller.dto.RubriqueDTO;
import dev.entite.forum.Rubrique;
import dev.service.RubriqueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("rubrique")
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class RubriqueCtrl {
    private RubriqueService rubriqueService;
    private static final Logger LOGGER = LoggerFactory.getLogger(RubriqueCtrl.class);

    public RubriqueCtrl(RubriqueService rubriqueService) {
        this.rubriqueService = rubriqueService;
    }

    @GetMapping
    public List<Rubrique> getAllRubrique() {
        Object test = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        LOGGER.info("" + test);
        return rubriqueService.findAll();
    }

    @PostMapping
    public Rubrique create(@RequestBody RubriqueDTO rubriqueDTO) {
        return rubriqueService.create(rubriqueDTO);
    }
}
