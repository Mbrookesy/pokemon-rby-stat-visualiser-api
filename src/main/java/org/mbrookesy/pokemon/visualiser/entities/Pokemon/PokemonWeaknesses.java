package org.mbrookesy.pokemon.visualiser.entities.Pokemon;

import java.util.List;

public record PokemonWeaknesses(List<PokemonType> weaknesses, List<PokemonType> doubleWeaknesses) { }