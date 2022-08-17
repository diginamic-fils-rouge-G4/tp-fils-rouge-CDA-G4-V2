package dev.service;

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
    @Value("${jwt.expires_in}")
    private Integer EXPIRES_IN;
    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;
    @Value("${jwt.secret}")
    private String SECRET;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurService.class);
    @Autowired
    PasswordEncoder passwordEncoder;
    public void creeUtilisateur(UtilisateurInscriptionDTO utilisateurInscriptionDTO){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setMail(utilisateurInscriptionDTO.getEmail());
        utilisateur.setNom(utilisateurInscriptionDTO.getNom());
        utilisateur.setPrenom(utilisateurInscriptionDTO.getPrenom());
        utilisateur.setPassword(passwordEncoder.encode(utilisateurInscriptionDTO.getPassword()));
        LOGGER.info(utilisateur.toString());
        utilisateurRepository.save(utilisateur);
    }
    public ResponseEntity<?> connection(UtilisateurConnexionDTO utilisateurConnexionDTO){
         return utilisateurRepository.findByMail(utilisateurConnexionDTO.getEmail())
                 .filter(utilisateur -> passwordEncoder.matches(utilisateurConnexionDTO.getPassword(),utilisateur.getPassword()))
                 .map(utilisateur -> {
                     Map<String, Object> infosSupplementaireToken = new HashMap<>();
                     infosSupplementaireToken.put("role",utilisateur.getRole());
                     String jetonjwt = Jwts.builder().setSubject(utilisateur.getPrenom())
                             .addClaims(infosSupplementaireToken)
                             .setExpiration(new Date(System.currentTimeMillis() + EXPIRES_IN * 1000))
                             .signWith(SignatureAlgorithm.HS512,SECRET).compact();
                     ResponseCookie tokenCookie = ResponseCookie.from(TOKEN_COOKIE, jetonjwt)
                             .httpOnly(true)
                             .maxAge(EXPIRES_IN * 1000)
                             .path("/")
                             .build();
                     return ResponseEntity.ok()
                             .header(HttpHeaders.SET_COOKIE, tokenCookie.toString())
                             .build();
                 }).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}