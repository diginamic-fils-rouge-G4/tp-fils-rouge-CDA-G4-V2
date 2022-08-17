package dev.controller;

import dev.controller.dto.UtilisateurConnexionDTO;
import dev.controller.dto.UtilisateurInscriptionDTO;
import dev.service.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurController.class);
    @Autowired
    private UtilisateurService utilisateurService;
    @PostMapping("/sinup")
    public void sinup(@RequestBody UtilisateurInscriptionDTO utilisateurInscriptionDTO){
        utilisateurService.creeUtilisateur(utilisateurInscriptionDTO);
    }
    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<?> login(@RequestBody UtilisateurConnexionDTO utilisateurConnexionDTO){
       return utilisateurService.connection(utilisateurConnexionDTO);
    }
}