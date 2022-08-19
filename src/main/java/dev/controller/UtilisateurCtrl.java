package dev.controller;

import dev.controller.dto.UtilisateurConnexionDTO;
import dev.controller.dto.UtilisateurInscriptionDTO;
import dev.controller.dto.UtilisateurRoleDTO;
import dev.entite.Utilisateur;
import dev.service.UtilisateurService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.*;

@RestController
public class UtilisateurCtrl {
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


    private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurCtrl.class);
    @Autowired
    private UtilisateurService utilisateurService;
    @PostMapping("/signup")
    // A FAIRE. Utilisé un ResponseEntity
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
                           .setExpiration(new Date(System.currentTimeMillis() + EXPIRES_IN * 1000))
                           .signWith(secretKey, SignatureAlgorithm.HS512)
                           .compact();
                   ResponseCookie tokenCookie = ResponseCookie.from(TOKEN_COOKIE,tokenJwt).httpOnly(true)
                           .maxAge(EXPIRES_IN*1000)
                           .path("/")
                           .build();
                   return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,tokenCookie.toString()).build();
               }).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    //admin methods
    @GetMapping("/utilisateur/all")
    // A FAIRE. Utilisé un ResponseEntity
    public List<Utilisateur> getAll(){return utilisateurService.getAll();}
    @GetMapping("/utilisateur/all/{page}")
    // A FAIRE. Utilisé un ResponseEntity
    public Page<Utilisateur> getAllBetween(@PathVariable int page){return utilisateurService.getAll(page,30);}

    @PatchMapping("/utilisateur")
    public ResponseEntity<Utilisateur> updateRole(@RequestBody UtilisateurRoleDTO utilisateurRoleDTO){
        Optional<Utilisateur> utilisateur = utilisateurService.getByid(utilisateurRoleDTO.getId());
        if (utilisateur.isPresent()){
            Utilisateur current = utilisateur.get();
            current.setRole(utilisateurRoleDTO.getRole());
            return ResponseEntity.ok(utilisateurService.saveUtilisateur(current));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @DeleteMapping("/utilisateur/{id}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable Integer id){
        Optional<Utilisateur> utilisateur = utilisateurService.getByid(id);
        if (utilisateur.isPresent()){
            Utilisateur current = utilisateur.get();
            utilisateurService.deleteUtilisateur(current);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}