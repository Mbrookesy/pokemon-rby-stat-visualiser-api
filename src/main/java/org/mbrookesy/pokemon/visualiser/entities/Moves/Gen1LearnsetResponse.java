package org.mbrookesy.pokemon.visualiser.entities.Moves;

import org.mbrookesy.pokemon.visualiser.entities.Pokemon.PokemonType;

public record Gen1LearnsetResponse(
        Long moveId,
        String moveName,
        PokemonType type,
        String category,
        Integer power,
        Integer accuracy,
        Integer pp,
        Integer levelLearned,
        Boolean yellowOnly
) {}