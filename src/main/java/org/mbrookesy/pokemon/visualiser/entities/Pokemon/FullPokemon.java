package org.mbrookesy.pokemon.visualiser.entities.Pokemon;

public record FullPokemon(
        Pokemon pokemon,
        PokemonWeaknesses weaknesses,
        PokemonResistances resistances
) {}
