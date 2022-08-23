package dev.controller.dto.topic;

/**
 * DTO de Topic utilisée pour changer la "Rubrique" où ce trouve le topic
 */
public class TopicModifDTO {
    private Integer id;
    private Integer rubrique;
    private String libelle;

    // Constructor
    public TopicModifDTO() {
    }

    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRubrique() {
        return rubrique;
    }

    public void setRubrique(Integer rubrique) {
        this.rubrique = rubrique;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "topicModifDTO{" +
                "id=" + id +
                ", rubrique_id=" + rubrique +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
