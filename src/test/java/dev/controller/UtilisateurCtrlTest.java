package dev.controller;

import dev.config.KeyConfig;
import dev.controller.dto.utilisateur.UtilisateurConnexionDTO;
import dev.controller.dto.utilisateur.UtilisateurExportDTO;
import dev.entite.Utilisateur;
import dev.repository.UtilisateurRepository;
import dev.service.UtilisateurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest({UtilisateurCtrl.class, KeyConfig.class})
class UtilisateurCtrlTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    PasswordEncoder passwordEncoder;
    @MockBean
    UtilisateurService utilisateurService;

    @WithMockUser(value = "spring")
    //role = "USER"
    @Test
    void getAll() throws Exception {
        List<Utilisateur> utilisateurList = new ArrayList<>();
        Utilisateur user = new Utilisateur();
        user.setMail("heiudhfbize");
        user.setRole("user");
        user.setId(1);
        user.setNom("nom");
        user.setPrenom("prenom");
        user.setPassword("mdp");
        utilisateurList.add(user);
        Mockito.when(utilisateurService.getAll()).thenReturn(utilisateurList);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/utilisateurs"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(utilisateurService).getAll();
    }
}