package dev.controller;

import dev.controller.dto.ErrorDto;
import dev.controller.dto.StationDto;
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


    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody @Validated StationDto stationDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDto(List.of("Les informations saisies ne sont pas valides")));
        } else {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(stationService.addStationToUser(stationDto));
        }
    }

}
