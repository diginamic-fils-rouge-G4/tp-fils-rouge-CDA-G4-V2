/*package dev.controller;

import dev.controller.dto.utilisateur.UtilisateurInscriptionDTO;
import dev.service.UtilisateurService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UtilisateurCtrl.class)
public class UtilisateurCtrlUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UtilisateurService utilisateurService;

    @Test
    void testUtilisateurLogin() {

    }

    // CA FONCTIONNE PAS
    @Test
    void testUtilisateurSignup() {
        String nom = "McTest";
        String prenom = "George";
        String mail = "mailoriginal@mail";
        String role = "ROLE_USER";

//        Utilisateur utilisateur = new Utilisateur();
//        utilisateur.setNom(nom);
//        utilisateur.setPrenom(prenom);
//        utilisateur.setMail(mail);
//        utilisateur.setRole(role);
//
//        Mockito.when(utilisateurService.saveUtilisateur(utilisateur))
//                .thenReturn(utilisateur);

        UtilisateurInscriptionDTO utilisateurInscriptionDTO = new UtilisateurInscriptionDTO();
        utilisateurInscriptionDTO.setNom(nom);
        utilisateurInscriptionDTO.setPrenom(prenom);
        utilisateurInscriptionDTO.setEmail(mail);
        utilisateurInscriptionDTO.setRole(role);

        Mockito.verify(utilisateurService).creeUtilisateur(utilisateurInscriptionDTO);

    }

}
*/
