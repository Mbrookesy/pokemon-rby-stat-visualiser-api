package org.mbrookesy.pokemon.visualiser.entities.Moves;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Gen1LearnsetId implements Serializable {

    @Column(name = "pokemon_id")
    private Long pokemonId;

    @Column(name = "move_id")
    private Long moveId;

    @Column(name = "level_learned")
    private Integer levelLearned;

    @Column(name = "is_yellow_only")
    private Boolean isYellowOnly;

    public Gen1LearnsetId(Long pokemonId, Long moveId, Integer levelLearned, Boolean isYellowOnly) {
        this.pokemonId = pokemonId;
        this.moveId = moveId;
        this.levelLearned = levelLearned;
        this.isYellowOnly = isYellowOnly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gen1LearnsetId that)) return false;
        return Objects.equals(pokemonId, that.pokemonId)
                && Objects.equals(moveId, that.moveId)
                && Objects.equals(levelLearned, that.levelLearned)
                && Objects.equals(isYellowOnly, that.isYellowOnly);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemonId, moveId, levelLearned, isYellowOnly);
    }
}
