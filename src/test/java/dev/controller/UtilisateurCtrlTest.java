package dev.controller;

import dev.controller.dto.utilisateur.UtilisateurExportDTO;
import dev.repository.UtilisateurRepository;
import dev.service.UtilisateurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurCtrlTest {

    UtilisateurRepository utilisateurRepository;

    UtilisateurService utilisateurService;

    @BeforeEach
    void setUp() {
        utilisateurRepository = Mockito.mock(UtilisateurRepository.class);
        utilisateurService = new UtilisateurService(utilisateurRepository);
    }

    @Test
    void getAll() {
        List<UtilisateurExportDTO> utilisateurExportDTOList = new ArrayList<>();
        UtilisateurExportDTO utilisateurExportDTO = new UtilisateurExportDTO();
        utilisateurExportDTO.setNom("tutu");
        utilisateurExportDTO.setPrenom("lulu");
        utilisateurExportDTOList.add(utilisateurExportDTO);
        Mockito.when(utilisateurService.getAll().stream().map(UtilisateurExportDTO::new).toList()).thenReturn(utilisateurExportDTOList);
    }
}