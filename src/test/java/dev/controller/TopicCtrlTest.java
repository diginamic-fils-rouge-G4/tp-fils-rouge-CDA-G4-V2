package dev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.config.KeyConfig;
import dev.controller.TopicCtrl;
import dev.controller.dto.rubrique.RubriqueDTO;
import dev.controller.dto.topic.TopicDTO;
import dev.controller.dto.topic.TopicExportDTO;
import dev.entite.Utilisateur;
import dev.entite.donneeApiQualiteAir.polluant.P;
import dev.entite.forum.Post;
import dev.entite.forum.Rubrique;
import dev.entite.forum.Topic;
import dev.service.RubriqueService;
import dev.service.TopicService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@WebMvcTest({TopicCtrl.class, KeyConfig.class})
public class TopicCtrlTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PasswordEncoder passwordEncoder;

    @MockBean
    TopicService topicService;

    @Autowired
    ObjectMapper mapper;

    @WithMockUser(value="userTest", roles = "ADMIN")
    @Test
    void createTopicValid() throws Exception {
        String libelle = "libelleRubrique";

        Topic topic = new Topic();
        topic.setLibelle(libelle);

        TopicDTO topicDTO = new TopicDTO();
        topicDTO.setLibelle(libelle);

        Mockito.when(topicService.create(topicDTO)).thenReturn(topic);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/topics")
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(topicDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        // Vérifie que la méthode "create" de "RubriqueService" a été appelé exactement une fois
        Mockito.verify(topicService).create(topicDTO);
    }
    @WithMockUser(value="userTest", roles = "ADMIN")
    @Test
    void getAllTopics() throws Exception {
        String libelle = "libelleRubrique";
        List<Topic> topicList = new ArrayList<>();

        Utilisateur u=new Utilisateur();
        u.setId(1);

        Post p = new Post();
        p.setId(1);
        p.setUtilisateur(u);

        List<Post> listPost= new ArrayList<>();
        listPost.add(p);

        Topic topic1 = new Topic();

        topic1.setLibelle(libelle+0);
        topic1.setPosts(listPost);
        topic1.setUtilisateur(u);

        topicList.add(topic1);


        Mockito.when(topicService.findAll()).thenReturn(topicList);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/topics"))

                .andExpect(MockMvcResultMatchers.status().isOk());

        // Vérifie que la méthode "create" de "RubriqueService" a été appelé exactement une fois
        Mockito.verify(topicService).findAll();
    }
}
