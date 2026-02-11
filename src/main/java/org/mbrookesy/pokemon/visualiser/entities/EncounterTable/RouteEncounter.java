package org.mbrookesy.pokemon.visualiser.entities.EncounterTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "gen1_encounter_table")
@Getter
@Setter
@NoArgsConstructor
public class RouteEncounter{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long encounter_id;

    private Long location_id;
    private Long pokemonId;
    private List<String> games;
    private String environment;
    private Float encounter_percentage;
    private int level_min;
    private int level_max;
    private String area;

    public RouteEncounter(Long encounter_id, Long location_id, Long pokemonId, List<String> games, String environment,
                          Float encounter_percentage, int level_min, int level_max, String area) {
        this.encounter_id = encounter_id;
        this.location_id = location_id;
        this.pokemonId = pokemonId;
        this.games = games;
        this.environment = environment;
        this.encounter_percentage = encounter_percentage;
        this.level_min = level_min;
        this.level_max = level_max;
        this.area = area;
    }

    public Boolean isInRedVersion() {
        return games.contains("Red");
    }

    public Boolean isInBlueVersion() {
        return games.contains("Blue");
    }

    public Boolean isInYellowVersion() {
        return games.contains("Yellow");
    }
}
