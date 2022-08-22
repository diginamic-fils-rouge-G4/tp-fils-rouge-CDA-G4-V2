package dev.service;

import dev.controller.UtilisateurCtrl;
import dev.controller.dto.utilisateur.UtilisateurInscriptionDTO;
import dev.entite.Utilisateur;
import dev.repository.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UtilisateurService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurCtrl.class);
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public UtilisateurService(PasswordEncoder passwordEncoder, UtilisateurRepository utilisateurRepository) {
        this.passwordEncoder = passwordEncoder;
        this.utilisateurRepository = utilisateurRepository;
    }

    public UtilisateurService() {
    }

    public void creeUtilisateur(UtilisateurInscriptionDTO utilisateurInscriptionDTO){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMail(utilisateurInscriptionDTO.getEmail());
        utilisateur.setNom(utilisateurInscriptionDTO.getNom());
        utilisateur.setPrenom(utilisateurInscriptionDTO.getPrenom());
        utilisateur.setRole("ROLE_USER");
        utilisateur.setPassword(passwordEncoder.encode(utilisateurInscriptionDTO.getPassword()));
        LOGGER.info(utilisateur.toString());
        saveUtilisateur(utilisateur);
    }
    public Optional<Utilisateur> getByName(String nom){
        return utilisateurRepository.findByNom(nom);
    }
    public Optional<Utilisateur> getByid(Integer id){return utilisateurRepository.findById(id);}
    public Optional<Utilisateur> getByMail(String mail){
        return utilisateurRepository.findByMail(mail);}
    public Utilisateur saveUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

//    admin methods
    public List<Utilisateur> getAll(){
        return utilisateurRepository.findAll();
    }
    public Page<Utilisateur> getAll(int page, int size){
        return utilisateurRepository.findAll(PageRequest.of(page,size));
    }
    public void deleteUtilisateur(Utilisateur utilisateur){
        utilisateurRepository.delete(utilisateur);
    }
}