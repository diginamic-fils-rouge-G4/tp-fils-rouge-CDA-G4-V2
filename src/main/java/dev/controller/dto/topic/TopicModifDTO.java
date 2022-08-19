package dev.controller.dto.topic;

public class TopicModifDTO {
    private Integer id;
    private Integer rubrique;
    private String libelle;

    public TopicModifDTO() {
    }

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
