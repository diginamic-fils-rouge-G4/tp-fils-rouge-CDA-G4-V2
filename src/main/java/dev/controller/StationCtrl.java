package dev.controller;
import dev.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller utilisé pour la gestion des Stations et favories
 */
@CrossOrigin
@RestController
@RequestMapping("stations") // /clients
public class StationCtrl {
    private StationService stationService;
    public StationCtrl( StationService stationService ) {
        this.stationService = stationService;
    }

    /**
     * Récupère la totalité des favoris d'un utilisateur
     * @return
     */
    @GetMapping("favories")
    public ResponseEntity<?> getFavories() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(stationService.getStationUtilisateur());
    }

    /**
     * Ajout d'une station favorite à l'aide de l'idx de celle-ci
     * @param id
     * @return
     */
    @PostMapping("favorie/{id}")
    public ResponseEntity<?> addFavorie( @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(stationService.addStationUtilisateur(id));
    }

    /**
     * ???
     * @param id
     * @return
     */
    @GetMapping("favorie/{id}")
    public ResponseEntity<?> getFavorie( @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(stationService.getStationUtilisateurById(id));
    }

    /**
     * Supprime un favori en fonction de son id
     * @param id
     * @return
     */
    @DeleteMapping("favorie/{id}")
    public ResponseEntity<?> deleteFavorie( @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(stationService.deleteStationUtilisateur(id));
    }
}
