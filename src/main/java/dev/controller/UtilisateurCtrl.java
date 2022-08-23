package dev.controller;

import dev.controller.dto.utilisateur.*;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller utilisé pour la gestion des Utilisateurs, leurs connexions et  <br/>
 * Utilise le service : {@link dev.service.UtilisateurService}
 */
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

    /**
     * Permet d'inscription d'un nouveau utilisateur
     * @param utilisateurInscriptionDTO
     * @return
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UtilisateurInscriptionDTO utilisateurInscriptionDTO, HttpServletRequest req ){
        utilisateurService.creeUtilisateur(utilisateurInscriptionDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Utilisateur créé");
    }

    /**
     * Permet la connexion d'un utilisateur
     * @param utilisateurConnexionDTO
     * @return
     */
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

    // Admin methods

    /**
     * Récupère la totalité des utilisateurs
     * @return
     */
    @GetMapping("/utilisateurs")
    public ResponseEntity<?> getAll() {
        List<UtilisateurExportDTO> utilisateurs = utilisateurService.getAll().stream().map(UtilisateurExportDTO::new).toList();
        if(!utilisateurs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(utilisateurs);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Il n'y a aucun utilisateur d'enregistré");
        }
    }

    /**
     * Récupère la totalité des utilisateurs du coté de l'admin
     * @return
     */
    @GetMapping("/admin/utilisateurs")
    public ResponseEntity<?> adminGetAll() {
        List<UtilisateurAdminExportDTO> utilisateurs = utilisateurService.getAll().stream().map(UtilisateurAdminExportDTO::new).toList();
        System.out.println();
        if(!utilisateurs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(utilisateurs);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Il n'y a aucun utilisateur d'enregistré");
        }
    }

    /**
     * Récupère un utilisateur en fonction de son id
     * @param id
     * @return
     */
    @GetMapping("/utilisateurs/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {

        Optional<Utilisateur> utilisateur = utilisateurService.getByid(id);
        if(utilisateur.isPresent()) {

            return ResponseEntity.status(HttpStatus.OK).body(new UtilisateurExportDTO(utilisateur.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Il n'y a aucun utilisateur d'enregistré");
        }
    }

    /**
     * Récupère les utilisateurs et les affiches en multiple page de 30 utilisateurs
     * @param page
     * @return
     */
    @GetMapping("/utilisateurs/pages/{page}")
    public ResponseEntity<?> getAllBetween(@PathVariable int page) {
        List<UtilisateurExportDTO> utilisateurPage = utilisateurService.getAll(page,30).stream().map(UtilisateurExportDTO::new).toList();
        if(!utilisateurPage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(utilisateurPage);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Il n'y a aucun utilisateur d'enregistré");
        }
    }

    /**
     * Met à jour le rôle d'un utilisateur
     * @param utilisateurRoleDTO
     * @return
     */
    @PatchMapping("/utilisateurs")
    public ResponseEntity<Utilisateur> updateRole(@RequestBody UtilisateurRoleDTO utilisateurRoleDTO){
        Optional<Utilisateur> utilisateur = utilisateurService.getByid(utilisateurRoleDTO.getId());
        if (utilisateur.isPresent()){
            Utilisateur current = utilisateur.get();
            current.setRole(utilisateurRoleDTO.getRole());
            return ResponseEntity.ok(utilisateurService.saveUtilisateur(current));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * Supprime un utilisateur en fonction de son id
     * @param id
     * @return
     */
    @DeleteMapping("/utilisateurs/{id}")
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