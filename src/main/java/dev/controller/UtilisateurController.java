package dev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.config.KeyConfig;
import dev.controller.dto.UtilisateurConnexionDTO;
import dev.controller.dto.UtilisateurInscriptionDTO;
import dev.entite.Utilisateur;
import dev.service.UtilisateurService;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UtilisateurController {
    @Value("${jwt.expires_in}")
    private Integer EXPIRES_IN;
    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;
    @Value("${jwt.secret}")
    private String SECRET;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SecretKey secretKey;


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
       return utilisateurService.getByMail(utilisateurConnexionDTO.getEmail())
               .filter(utilisateur -> passwordEncoder.matches(utilisateurConnexionDTO.getPassword(),utilisateur.getPassword()))
               .map(utilisateur -> {
                   Map<String, Object> infosSupplementaireToken = new HashMap<>();
                   infosSupplementaireToken.put("roles",utilisateur.getRole());
                   String tokenJwt = Jwts.builder()
                           .setSubject(utilisateur.getMail())
                           .addClaims(infosSupplementaireToken)
                           .setExpiration(new Date(System.currentTimeMillis()+EXPIRES_IN*1000))
                           .signWith(secretKey, SignatureAlgorithm.HS512)
                           .compact();
                   ResponseCookie tokenCookie = ResponseCookie.from(TOKEN_COOKIE,tokenJwt).httpOnly(true)
                           .maxAge(EXPIRES_IN*1000)
                           .path("/")
                           .build();
                   return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,tokenCookie.toString()).build();
               }).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}