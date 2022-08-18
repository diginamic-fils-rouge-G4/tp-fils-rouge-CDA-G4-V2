package dev.controller;


import dev.controller.dto.ErrorDTO;
import dev.controller.dto.StationDTO;
import dev.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("stations") // /clients
public class StationCtrl {
    private StationService stationService;

    public StationCtrl( StationService stationService ) {
        this.stationService = stationService;
    }

/*    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody @Validated StationDTO stationDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDTO(List.of("Les informations saisies ne sont pas valides")));
        } else {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(stationService.ajouterStationToUtilisateur(stationDto));
        }
    }*/



    @PostMapping("metEnFavoris/{id}")
    public ResponseEntity<?> createClient( @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(stationService.ajouterStationEnFavoris(id));
    }



}
