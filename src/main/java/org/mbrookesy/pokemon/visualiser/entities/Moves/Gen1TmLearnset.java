package org.mbrookesy.pokemon.visualiser.entities.Moves;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mbrookesy.pokemon.visualiser.entities.Pokemon.Pokemon;

@Entity
@Table(name = "gen1_tm_learnsets")
@Getter
@Setter
@NoArgsConstructor
@SuppressWarnings("unused")
public class Gen1TmLearnset {

    @EmbeddedId
    private Gen1TmLearnsetId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pokemonId")
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tmId")
    @JoinColumn(name = "tm_id")
    private Gen1Tm tm;
}