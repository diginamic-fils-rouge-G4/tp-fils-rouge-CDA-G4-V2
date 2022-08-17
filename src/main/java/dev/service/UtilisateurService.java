package dev.service;

import dev.controller.UtilisateurController;
import dev.controller.dto.UtilisateurConnexionDTO;
import dev.controller.dto.UtilisateurInscriptionDTO;
import dev.entite.Utilisateur;
import dev.repository.UtilisateurRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurController.class);
    @Autowired
    private UtilisateurRepository utilisateurRepository;




    public void creeUtilisateur(UtilisateurInscriptionDTO utilisateurInscriptionDTO){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMail(utilisateurInscriptionDTO.getEmail());
        utilisateur.setNom(utilisateurInscriptionDTO.getNom());
        utilisateur.setPrenom(utilisateurInscriptionDTO.getPrenom());
        utilisateur.setPassword(passwordEncoder.encode(utilisateurInscriptionDTO.getPassword()));
        LOGGER.info(utilisateur.toString());
        utilisateurRepository.save(utilisateur);
    }
    public Optional<Utilisateur> getByName(String nom){
        return utilisateurRepository.findByNom(nom);
    }public Optional<Utilisateur> getByMail(String mail){
        return utilisateurRepository.findByMail(mail);
    }
}