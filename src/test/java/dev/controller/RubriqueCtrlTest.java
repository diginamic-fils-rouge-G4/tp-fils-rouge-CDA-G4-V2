package dev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.config.KeyConfig;
import dev.controller.dto.rubrique.RubriqueDTO;
import dev.entite.forum.Rubrique;
import dev.service.RubriqueService;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;


@WebMvcTest({RubriqueCtrl.class, KeyConfig.class})
public class RubriqueCtrlTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PasswordEncoder passwordEncoder;

    @MockBean
    RubriqueService rubriqueService;

    @Autowired
    ObjectMapper mapper;


    // Test la possibilité de créé une rubrique avec de bonne valeur
    @WithMockUser(value="userTest", roles = "ADMIN")
    @Test
    void createRubriqueValid() throws Exception {
        String libelle = "libelleRubrique";
        Rubrique rubrique = new Rubrique();
        rubrique.setLibelle(libelle);

        RubriqueDTO rubriqueDTO = new RubriqueDTO();
        rubriqueDTO.setLibelle(libelle);

        Mockito.when(rubriqueService.create(rubriqueDTO)).thenReturn(rubrique);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/rubriques")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(rubriqueDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        // Vérifie que la méthode "create" de "RubriqueService" a été appelé exactement une fois
        Mockito.verify(rubriqueService).create(rubriqueDTO);
    }

    // Test la possibilité de créé une rubrique avec une mauvaise valeur,
    // la mauvaise valeur est un "libelle" null
//    @WithMockUser(value="userTest", roles = "ADMIN")
//    @Test
//    void createRubriqueInvalid() throws Exception {
////        String libelle = "";
//        Rubrique rubrique = new Rubrique();
////        rubrique.setLibelle(libelle);
//
//        RubriqueDTO rubriqueDTO = new RubriqueDTO();
////        rubriqueDTO.setLibelle(libelle);
//
//        Mockito.when(rubriqueService.create(rubriqueDTO)).thenReturn(rubrique);
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post("/rubriques")
//                                .with(csrf())
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(mapper.writeValueAsString(rubriqueDTO)))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//
////        Mockito.verify(rubriqueService).create(rubriqueDTO);
//    }

    // Test si les rubriques sont récupéré
    @WithMockUser(value="userTest", roles = "ADMIN")
    @Test
    void getAllRubrique() throws Exception {
        List<Rubrique> rubriqueList = new ArrayList<>();
        Rubrique rub1 = new Rubrique();
        Rubrique rub2 = new Rubrique();
        Rubrique rub3 = new Rubrique();

        rub1.setLibelle("rub1");
        rub2.setLibelle("rub2");
        rub3.setLibelle("rub3");

        rubriqueList.add(rub1);
        rubriqueList.add(rub2);
        rubriqueList.add(rub3);

        Mockito.when(rubriqueService.findAll()).thenReturn(rubriqueList);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/rubriques"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                // [{"id":null,"libelle":"rub1","nbreTopics":0},
                // {"id":null,"libelle":"rub2","nbreTopics":0},
                // {"id":null,"libelle":"rub3","nbreTopics":0}]
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].libelle").value("rub1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].libelle").value("rub2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].libelle").value("rub3"));

        Mockito.verify(rubriqueService).findAll();
    }

}
