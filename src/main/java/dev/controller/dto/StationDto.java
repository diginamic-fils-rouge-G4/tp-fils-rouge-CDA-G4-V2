package dev.controller.dto;

import dev.entite.lieu.Ville;
import dev.entite.qualite.Polluant;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

public class StationDto {

    private String nom;

    private Ville ville;

    private List<Polluant> polluants = new ArrayList<>();


}
