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
public class Gen1TmLearnsetId implements Serializable {

    @Column(name = "pokemon_id")
    private Long pokemonId;

    @Column(name = "tm_id")
    private Long tmId;

    @Column(name = "is_yellow_only")
    private Boolean isYellowOnly;

    public Gen1TmLearnsetId(Long pokemonId, Long tmId, Boolean isYellowOnly) {
        this.pokemonId = pokemonId;
        this.tmId = tmId;
        this.isYellowOnly = isYellowOnly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gen1TmLearnsetId that)) return false;
        return Objects.equals(pokemonId, that.pokemonId)
                && Objects.equals(tmId, that.tmId)
                && Objects.equals(isYellowOnly, that.isYellowOnly);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemonId, tmId, isYellowOnly);
    }
}
