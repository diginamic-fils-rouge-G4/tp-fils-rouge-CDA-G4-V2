package dev.controller;

import dev.config.KeyConfig;
import dev.controller.dto.station.StationDTO;
import dev.controller.dto.utilisateur.UtilisateurExportDTO;
import dev.controller.dto.ville.VilleDTO;
import dev.service.StationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest({StationCtrl.class  , KeyConfig.class})
public class StationCtrlTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    StationService stationService;

    @Test
    @WithMockUser(value = "spring")
    void getStationDeUtilisateur() throws Exception{

        StationDTO stationDTO = new StationDTO();
        stationDTO.setIdx("1");
        stationDTO.setNom("tutu");
        VilleDTO villeDTO = new VilleDTO();
        villeDTO.setName("tete");
        villeDTO.getStations().add(stationDTO);

        Mockito.when(stationService.getStationUtilisateur()).thenReturn(List.of(villeDTO));
        mockMvc.perform(MockMvcRequestBuilders.get("/stations/favories")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
