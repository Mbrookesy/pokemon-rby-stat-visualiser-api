package org.mbrookesy.pokemon.visualiser.entities.Moves;

import org.mbrookesy.pokemon.visualiser.entities.Pokemon.PokemonType;

public record Gen1TmLearnsetResponse(
        Long moveId,
        String moveName,
        String tmName,
        PokemonType type,
        String category,
        Integer power,
        Integer accuracy,
        Integer pp,
        Boolean yellowOnly
) {}