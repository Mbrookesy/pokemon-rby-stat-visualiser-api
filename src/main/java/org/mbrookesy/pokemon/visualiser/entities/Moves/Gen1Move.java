package org.mbrookesy.pokemon.visualiser.entities.Moves;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mbrookesy.pokemon.visualiser.entities.Pokemon.PokemonType;

@Entity
@Table(name = "gen1_moves")
@Getter
@Setter
@NoArgsConstructor
public class Gen1Move {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PokemonType type;

    private String category;
    private Integer power;
    private Integer accuracy;
    private Integer pp;
    private Boolean yellowOnly;
}