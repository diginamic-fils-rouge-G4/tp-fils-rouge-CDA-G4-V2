package dev.controller;
import dev.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("stations") // /clients
public class StationCtrl {
    private StationService stationService;
    public StationCtrl( StationService stationService ) {
        this.stationService = stationService;
    }
    @GetMapping("favories")
    public ResponseEntity<?> getFavories() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(stationService.getStationUtilisateur());
    }
    @PostMapping("favorie/{id}")
    public ResponseEntity<?> addFavorie( @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(stationService.addStationUtilisateur(id));
    }
    @GetMapping("favorie/{id}")
    public ResponseEntity<?> getFavorie( @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(stationService.getStationUtilisateurById(id));
    }
    @DeleteMapping("favorie/{id}")
    public ResponseEntity<?> deleteFavorie( @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(stationService.deleteStationUtilisateur(id));
    }
}
